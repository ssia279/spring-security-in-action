package com.johnsonwang.ssia.service;

import com.johnsonwang.ssia.entities.Otp;
import com.johnsonwang.ssia.entities.User;
import com.johnsonwang.ssia.repositories.OtpRepository;
import com.johnsonwang.ssia.repositories.UserRepository;
import com.johnsonwang.ssia.utils.GenerateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpRepository otpRepository;

    public void addUser(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public void auth(User user) {
        Optional<User> o = this.userRepository.findUserByUsername(user.getUsername());

        if (o.isPresent()) {
            User u = o.get();
            if (this.passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                renewOtp(u);
            } else {
                throw new BadCredentialsException("Bad credentials.");
            }
        } else {
            throw new BadCredentialsException("Bad credentials.");
        }
    }

    private void renewOtp(User user) {
        String code = GenerateCodeUtil.generateCode();

        Optional<Otp> userOtp = this.otpRepository.findOtpByUsername(user.getUsername());

        if (userOtp.isPresent()) {
            Otp otp = userOtp.get();
            otp.setCode(code);
        } else {
            Otp otp = new Otp();
            otp.setUsername(user.getUsername());
            otp.setCode(code);
            this.otpRepository.save(otp);
        }
    }

    public boolean check(Otp otpToValidate) {
        Optional<Otp> userOtp = this.otpRepository.findOtpByUsername(otpToValidate.getUsername());

        if (userOtp.isPresent()) {
            Otp otp = userOtp.get();
            if (otpToValidate.getCode().equals(otp.getCode())) {
                return true;
            }
        }
        return false;
    }



}

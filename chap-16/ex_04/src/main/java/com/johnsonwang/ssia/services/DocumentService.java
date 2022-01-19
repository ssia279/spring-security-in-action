package com.johnsonwang.ssia.services;

import com.johnsonwang.ssia.model.Document;
import com.johnsonwang.ssia.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
    public Document getDocument(String code) {
        return this.documentRepository.findDocument(code);
    }
}

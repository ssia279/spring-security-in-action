package com.johnsonwang.ssia.model;

import lombok.Data;

@Data
public class Document {

    private String owner;

    public Document(String owner) {
        this.owner = owner;
    }
}

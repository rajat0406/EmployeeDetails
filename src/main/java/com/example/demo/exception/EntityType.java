package com.example.demo.exception;

public enum EntityType {
	USER("user"),
	ROLE("role");

    String value;

    EntityType(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
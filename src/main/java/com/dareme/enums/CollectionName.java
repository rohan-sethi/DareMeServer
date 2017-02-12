package com.dareme.enums;

public enum CollectionName {
    USER_DATA("user_data");

    private String value;
    CollectionName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

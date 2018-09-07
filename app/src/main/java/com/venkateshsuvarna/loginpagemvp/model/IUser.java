package com.venkateshsuvarna.loginpagemvp.model;

public interface IUser {
    String getEmail();
    String getPassword();
    boolean isValidData();
}

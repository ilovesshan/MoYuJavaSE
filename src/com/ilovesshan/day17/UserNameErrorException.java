package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/6
 * @description:
 */


public class UserNameErrorException extends RuntimeException {
    private String message;
    private int code;

    public UserNameErrorException() {
    }

    public UserNameErrorException(String message) {
        this.message = message;
    }

    public UserNameErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

class PasswordErrorException extends RuntimeException {
    private String message;
    private int code;

    public PasswordErrorException() {
    }

    public PasswordErrorException(String message) {
        this.message = message;
    }

    public PasswordErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

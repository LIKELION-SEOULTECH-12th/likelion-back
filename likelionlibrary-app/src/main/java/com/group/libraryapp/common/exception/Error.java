package com.group.libraryapp.common.exception;

import lombok.Getter;

@Getter
public enum Error {

    // User
    USER_NOT_FOUND("사용자를 찾을 수 없습니다.", 2000);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}

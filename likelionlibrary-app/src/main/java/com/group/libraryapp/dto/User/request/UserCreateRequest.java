package com.group.libraryapp.dto.User.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateRequest {

    private String name;
    private Integer age;
    /**
     * 1. 파라미터 만들기
     *
     * hint.
     * 기능명세서의 HTTP Body 참고
     *
     * hint 2.
     * int와 Integer의 차이
     * int: null 표현이 불가능한 기본 자료형
     * Integer: null 표현이 가능한 자료형
     */

    /**
     * 2. getter 메서드 구현
     */
}

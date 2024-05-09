package com.group.libraryapp.domain.user;

/**
 * UserController에서 "/user" url을 통해 저장된 정보들은
 * domain/User를 통해 저장됨
 */
public class User {
    private String name;
    private Integer age;

    // 이름 필드는 not null이라는 조건 예외처리를 이용해 생성자 코드 작성
    public User(String name, Integer age) {
    if (name == null || name.isBlank()){
        throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어 왓습니다.",name));
    // 어떤 값이 들어왔는지 보여줌
    }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

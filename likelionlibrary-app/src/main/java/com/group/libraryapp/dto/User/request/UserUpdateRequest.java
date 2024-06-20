package com.group.libraryapp.dto.User.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class UserUpdateRequest {
    // 이름만 수정하는 객체
    // 나이 필요 없음
    private Long id;
    private String name;
}

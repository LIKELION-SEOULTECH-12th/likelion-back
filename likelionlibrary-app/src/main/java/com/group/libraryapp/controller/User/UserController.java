package com.group.libraryapp.controller.User;

import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
1. 어노테이션
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    /**
     * 3. domain/User의 인스턴스를 저장하기 위한 리스트 선언
     */
    private final UserService userService;

    /**
     * 2. 도서관 사용자 등록 메서드
     * hint.
     *
     * @PostMapping("/user")
     */
    @PostMapping
    public ResponseEntity<Long> saveUser(
            @RequestBody UserCreateRequest userCreateRequest) {

        Long userId = userService.saveUser(userCreateRequest);
        return ResponseEntity.ok(userId);
    }

    /**
     * 4. 도서관 사용자 목록 조회
     * hint 1.
     *
     * @GetMapping("/user") hint 2.
     * 반환값은 List
     * id와
     */
    @GetMapping
    public ResponseEntity<UserResponse> getUser(
            @RequestParam Long userId) {

        return ResponseEntity.ok(userService.getUser(userId));
    }

    /**
     * 5-1. 리스트로 조회 (DB 적용 전)
     *
     * 5-2. jdbcTemplate을 이용한 조회
     */

    /**
     * 6. 도서관 사용자 이름 수정
     */
    @PutMapping
    public ResponseEntity<Long> updateUser(
            @RequestBody UserUpdateRequest updateRequest) {

        return ResponseEntity.ok(userService.updateUser(updateRequest));
    }

    /**
     * 7. 도서관 사용자 삭제
     */
    @DeleteMapping
    public ResponseEntity<Long> deleteUser(
            @RequestParam Long id
    ) {

        return ResponseEntity.ok(userService.deleteUser(id));
    }

}

package com.group.libraryapp.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * UserController에서 "/user" url을 통해 저장된 정보들은
 * domain/User를 통해 저장됨
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user")
@Getter
@SQLDelete(sql = "UPDATE user SET is_deleted = true WHERE member_id = ?")
@Where(clause = "is_deleted = false")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private Integer age;

    private Boolean isDeleted = Boolean.FALSE;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void updateUser(String name) {
        this.name = name;
    }

    public void deleteUser() {
        this.isDeleted = Boolean.TRUE;
    }

}

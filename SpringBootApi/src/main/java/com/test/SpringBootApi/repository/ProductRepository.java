package com.test.SpringBootApi.repository;

import com.test.SpringBootApi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 데이터베이스의 조회, 변경, 삭제 과정을 맡아 하는 역할
    // => JpaRepository를 상속받은 인터페이스 형태
    // < , > -> 첫 번째 인자에는 만든 객체, 두 번째 인자에는 id의 타입
}

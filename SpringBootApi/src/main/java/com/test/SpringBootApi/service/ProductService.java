package com.test.SpringBootApi.service;

// 인터페이스
// 구체적인 구현 코드가 없고
// 반환 타입, 이름, 파라미터만 정의된 설계도

import com.test.SpringBootApi.domain.Product;

import java.util.Optional;

public interface ProductService {
    public Product save(Product product);   // 저장 메서드.
                                            // return은 개별 객체 (product)

    public Optional<Product> findById(Long id); // id 기반으로 상품 조회.
                                                // Optional: 존재하지 않는 상품 조회시 null 알아서 처리

    public Product update(Long id, Product product);    // 수정
                                                        // id값으로 객체를 찾고, 새로 입력한 product로 수정
    public void delete(Long id);    // 삭제
                                    // id값을 찾아 삭제
}

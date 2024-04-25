package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 사용자 입력을 http 규칙에 맞춰 서비스를 호출할 수 있도록. 즉, rest를 이용가능하게 해줌
@RequestMapping("/api") // 어떤 경로로 사용자의 요청을 받을지 -> url
public class ProductController {

    @Autowired
    ProductServiceImpl productService;  // Service 객체 가져와 이용 (구현한 메서드들)

    @PostMapping("/products")   // api/products를 입력하고 post 방식으로 호출
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        // RequestBody: 실제 product 객체를 만들기 위해 데이터를 전달하는 부분
        // 이 부분은 api 테스트 할떄 (ex. postman..) json 형식으로 삽입
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)     // HTTP 통신에서의 결과물 반환 -> create 결과
                    .body(productService.save(product));    // 사용자에게 입력받은 값을 productService로 넘겨 db에 저장
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

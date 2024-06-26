package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // 사용자 입력을 http 규칙에 맞춰 서비스를 호출할 수 있도록. 즉, rest를 이용가능하게 해줌
@RequestMapping("/api") // 어떤 경로로 사용자의 요청을 받을지 -> url
public class ProductController {

    @Autowired
    ProductServiceImpl productService;  // Service 객체 가져와 이용 (구현한 메서드들)

    @GetMapping("/products/{id}")   // api/products/{id}로 작동. id는 변경 가능한 값
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") long id){
        try {
            return ResponseEntity.ok(productService.findById(id));
            // 응답 객체인 ResponseEntity가 정상적으로 호출이 됐음
            // id 값을 넘겨줘서 찾음.
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

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

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id,
            @RequestBody Product product
    ){
        try{
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.update(id, product));
                    // 사용자에게 입력받은 수정된 값을 productService로 넘겨 db에 저장
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id){
        try {
            productService.delete(id);  // 주소에서 넘겨받은 id를 지움
            ResponseEntity.noContent(); // ResponseEntity엔 데이터가 없다는 http 상태값 가져옴
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

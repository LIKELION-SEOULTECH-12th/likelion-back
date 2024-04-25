package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// ProductService 인터페이스 구현체
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        try {   // 정상적으로 저장할 경우
            return productRepository.save(
                    new Product(
                            product.getProductName(),
                            product.getPrice()
                    )   // Product의 이름과 가격을 "get"(가져와서)해서
                    // Product 객체에 "save"
            );
        } catch (Exception e) {   // 예외가 발생할 경우
            e.printStackTrace();    // 예외 로그 출력. 이 외에도 다양한 예외처리 방법 있음
        }
        return null;    // try-catch에서 반환할 객체가 없을 경우
    }

    @Override
    public Optional<Product> findById(Long id){
        try{
            Optional<Product> productData = productRepository.findById(id);
            // ProductRepository에서 id를 기반으로 찾아 productData 변수에 넣음.
            // 이때 Optional 타입은 null을 알아서 처리해줌.
            if(productData.isPresent()){    // product가 존재하면, productData 반환
                return productData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;    // 아무것도 없을 경우 null 반
    }

    @Override
    public Product update(Long id, Product product){
        // 수정(업데이트)의 경우, 조회 과정이 선행되어야 함.
        try{
            Optional<Product> productData = productRepository.findById(id);
            if(productData.isPresent()){    // 데이터를 조회 후 존재하는 경우,
                Product updatedProduct = productData.get();
                // 새로운 데이터(updatedProduct)에 기존 데이터 정보 주입

                updatedProduct.setProductName(product.getProductName());
                updatedProduct.setPrice(product.getPrice());
                // Set 함수 이용해 사용자가 입력한 새로운 정보 덮어씌우기

                productRepository.save(updatedProduct);
                // 수정된 객체 넘겨 save

                return updatedProduct;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id){
    }
}

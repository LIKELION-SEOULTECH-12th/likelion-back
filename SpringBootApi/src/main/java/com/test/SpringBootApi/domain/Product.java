package com.test.SpringBootApi.domain;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id // table의 primary key를 만들어주는 어노테이션
    @GeneratedValue(strategy = GenerationType.AUTO) // 별도의 설정 없이 자동으로 증가하는 수가 부여되게 설정
    private Long id;    // Long 데이터 형의 id 선언

    @Column(name = "product_name") // 데이터베이스 열 지정
    private String productName; // String 데이터 형의 product name 선언

    @Column(name = "price")
    private int price;  // int 데이터 형의 가격 선언

    public Product(String productName, int price) { // 매개변수가 있는 생성자: 객체 생성시 필수적인 데이터 제공 -> 바로 사용 가능한 객체 만듬
        this.productName = productName;             // public 접근 제어자를 통해 외부 클래스에서 생성자 이용 가능
        this.price = price;
    }

    public Product() {  // 기본 생성자: 특별한 초기값 없이 객체 생성 가능
                        // JPA는 엔티티 객체를 생성할 때 내부적으로 기본 생성자 사용
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

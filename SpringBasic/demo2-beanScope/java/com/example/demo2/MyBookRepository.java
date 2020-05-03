package com.example.demo2;

import org.springframework.stereotype.Repository;

//해당 타입의 빈이 여러개인 경우  - 1. @Primary로 우선순위 부여할 수 있음 (가장 추천하는 방법)
//@Repository @Primary
@Repository
public class MyBookRepository implements BookRepository {

}

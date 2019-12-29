package com.lhuk.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//스프링 부투의 자동설정, 스프링 빈 읽기와 생성을 모두 자동으로 설정
//해당 어노테이션 위치부터 설정을 읽어가기에 프로젝트츼 최상단에 위치해야 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        //SpringApplication.run을 통해 내장 was가 실행된다.
        SpringApplication.run(Application.class, args);
    }
}

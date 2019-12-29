package com.lhuk.book.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter//롬북, 겟터 자동생성
@NoArgsConstructor//롬북, 기본생성자 자동생성
@Entity//1. JPA, 테이블과 링크될 클래스임을 정의, 엔티티 클래스에서는 절대로 셋터를 만들지 않는다. 목적과 의도가 명확한 메소드를 만들어 셋터를 대신한다
public class Posts {//db테이블과 매칭될 클래스, entity class, 카멜케이스로 작성된 네이밍이 언더코더(_) 네이밍으로 테이블과 맵핑된다.

    @Id //PK를 나타낸다
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK생성규칙, 오토 인크리즈를 위한 설정
    private Long id;

    //굳이 선언하지 않아도 클래스의 필드는 모두 기본적으로 테이블의 컬럼으로 사용되지만,
    //기본 값 외에 컬럼 설정을 하고자 할 때 사용한다, ex) 문자의 경우 VARCHAR(255)가 기본이지만 사이즈를 500으로 늘리고 싶은 경우 등등
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//해당 클래스의 빌더 패턴 클래스 자동 생성, 아래와 같이 특정 생성자에 사용 시, 필드에 대한 빌더 클래스를 생성한다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

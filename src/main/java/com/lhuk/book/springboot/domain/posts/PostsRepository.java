package com.lhuk.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DAO를 대신하는 역할, 엔티티클래스와 PK를 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
//엔티티클래스와 Repository는 같은 위치에 있어야 한다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}

package com.lhuk.book.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)//spring 실행자, 스프링부트테스트와 Junit사이의 연결자
@WebMvcTest//@Contoller, ControllerAdvice 등을 사용할 수 있다, @Service, Component, Repository 는 사용 못함
public class HelloControllerTest {

    @Autowired//빈을 주입받음
    private MockMvc mvc;//이 클래스를 통해 http get, post 등에 대한 api 테스트 가능

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))//string 값만 허용되므로 변환
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))//jsonPath 으로 필드별로 값을 검증한다.
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}

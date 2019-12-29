package com.lhuk.book.springboot.doamin.posts;

import com.lhuk.book.springboot.domain.posts.Posts;
import com.lhuk.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest//별다른 설정없이 해당 어노테이션을 사용하면 H2데이터베이스를 자동으로 사용한다.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void loadContent(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //save는 update와 insert를 실행하며, id가 있을 경우 update 없을 경우 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("lhuk")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}

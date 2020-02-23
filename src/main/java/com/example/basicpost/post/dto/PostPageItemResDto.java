package com.example.basicpost.post.dto;

import com.example.basicpost.post.Post;
import lombok.Getter;

@Getter
public class PostPageItemResDto {

    private Long id;
    private String title;
    private String writer;

    public PostPageItemResDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.writer = post.getWriter();
    }
}

package com.example.basicpost.post.dto;

import com.example.basicpost.post.Post;
import lombok.Getter;

@Getter
public class PostResDto {

    private Long id;
    private String title;
    private String contents;
    private String writer;
    private String creationDateTime;
    private String modificationDateTime;

    public PostResDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.writer = post.getWriter();
        this.creationDateTime = post.getCreationDateTime().toString();
        this.modificationDateTime = post.getModificationDateTime().toString();
    }
}

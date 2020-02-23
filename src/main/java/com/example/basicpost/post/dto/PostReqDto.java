package com.example.basicpost.post.dto;

import com.example.basicpost.post.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostReqDto {

    private String title;
    private String contents;
    private String writer;

    public Post toNewPost() {
        return new Post(title, contents, writer);
    }

    public Post updatePost(Post post) {
        return post.modify(title, contents);
    }
}

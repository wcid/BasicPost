package com.example.basicpost.post.dto;

import com.example.basicpost.post.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostPageResDto {

    private List<PostPageItemResDto> posts;

    public PostPageResDto(List<Post> posts) {
        this.posts = posts.stream().map(PostPageItemResDto::new).collect(Collectors.toList());
    }
}

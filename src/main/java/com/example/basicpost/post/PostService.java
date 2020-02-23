package com.example.basicpost.post;

import com.example.basicpost.post.dto.PostReqDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(PostReqDto postReqDto) {
        return savePost(postReqDto.toNewPost());
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Post updatePost(Long id, PostReqDto postReqDto) {
        return savePost(postReqDto.updatePost(getPost(id)));
    }

    public Boolean deleteAll() {
        postRepository.deleteAll();
        return true;
    }

    public Boolean deletePost(Long id) {
        postRepository.deleteById(id);
        return true;
    }

    private Post savePost(Post post) {
        return postRepository.save(post);
    }
}

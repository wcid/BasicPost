package com.example.basicpost.post;

import com.example.basicpost.common.container.SimpleBooleanResponse;
import com.example.basicpost.common.exception.ValidationIllegalArgumentException;
import com.example.basicpost.post.dto.PostPageResDto;
import com.example.basicpost.post.dto.PostReqDto;
import com.example.basicpost.post.dto.PostResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostApiController {

    private PostService postService;
    private PostReqDtoValidator postReqDtoValidator;

    public PostApiController(PostService postService, PostReqDtoValidator postReqDtoValidator) {
        this.postService = postService;
        this.postReqDtoValidator = postReqDtoValidator;
    }

    @PostMapping
    public ResponseEntity<PostResDto> postPost(@RequestBody PostReqDto postReqDto,
                                               BindingResult bindingResult) {
        postReqDtoValidator.validate(postReqDto, bindingResult);
        if(bindingResult.hasErrors())
            throw new ValidationIllegalArgumentException(bindingResult);

        return ResponseEntity.ok(new PostResDto(postService.createPost(postReqDto)));
    }

    @GetMapping
    public ResponseEntity<PostPageResDto> getPostPage() {
        return ResponseEntity.ok(new PostPageResDto(postService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResDto> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(new PostResDto(postService.getPost(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResDto> putPost(@PathVariable Long id,
                                                @RequestBody PostReqDto postReqDto,
                                                BindingResult bindingResult) {
        postReqDtoValidator.validate(postReqDto, bindingResult);
        if(bindingResult.hasErrors())
            throw new ValidationIllegalArgumentException(bindingResult);

        return ResponseEntity.ok(new PostResDto(postService.updatePost(id, postReqDto)));
    }

    @DeleteMapping
    public ResponseEntity<SimpleBooleanResponse> deleteAllPosts() {
        return ResponseEntity.ok(new SimpleBooleanResponse(postService.deleteAll()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleBooleanResponse> deletePost(@PathVariable Long id) {
        return ResponseEntity.ok(new SimpleBooleanResponse(postService.deletePost(id)));
    }
}

package com.nr.securitycustomjwt.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(this.postService.getAllPosts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) throws IncorrectPostId {
        return ResponseEntity.ok(this.postService.getPostById(id));
    }

    @PostMapping()
    public ResponseEntity<Post> getPostById(@RequestBody PostRequestDto post) throws IncorrectPostId {
        return ResponseEntity.ok(this.postService.addPost(post));
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePostById(@PathVariable Integer id, @RequestBody PostRequestDto post) throws IncorrectPostId {
        return ResponseEntity.ok(this.postService.updatePost(id, post));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Integer id) throws IncorrectPostId {
        this.postService.deletePostById(id);
        return ResponseEntity.accepted().build();
    }
}

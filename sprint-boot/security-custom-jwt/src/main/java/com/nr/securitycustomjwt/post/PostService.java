package com.nr.securitycustomjwt.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PostService {

    private final List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        IntStream.range(1, 11)
                .forEach(i -> {
                    posts.add(
                            Post.builder()
                                    .id(i)
                                    .title("title_" + i)
                                    .content("content_" + i)
                                    .build()
                    );
                });
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPostById(Integer id) throws IncorrectPostId {
        if (id > posts.size() || id < 1) {
            throw new IncorrectPostId(MessageFormat.format("Post id : {0} is incorrect", id));
        }
        return posts.stream().filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new IncorrectPostId(MessageFormat.format("Post id : {0} is not found", id)));
    }

    public Post addPost(PostRequestDto post) {
        posts.add(Post.builder()
                .id(posts.size())
                .title(post.title())
                .content(post.content())
                .build());
        return posts.getLast();
    }

    public Post updatePost(Integer id, PostRequestDto post) throws IncorrectPostId {
        Post savedPost = getPostById(id);
        savedPost.setTitle(post.title());
        savedPost.setContent(post.content());
        return savedPost;
    }

    public void deletePostById(Integer id) {
        posts.removeIf(p -> p.getId() == id);
    }
}

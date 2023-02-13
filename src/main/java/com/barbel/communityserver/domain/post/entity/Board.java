package com.barbel.communityserver.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Document(collection = "board")
@Getter
@ToString
public class Board {
    @Id
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String location;

    @NotBlank
    private String userId;

    private long views;

    // 댓글 추가 List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(String title,String content,String location,String userId,long views)
    {
        this.title = title;
        this.content = content;
        this.location = location;
        this.userId = userId;
        this.views = views;
    }
}

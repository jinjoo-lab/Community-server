package com.barbel.communityserver.domain.post.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotBlank
  private String title;
  @NotBlank
  private String content;
  @NotBlank
  private String author;

  @Builder
  private Post(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}

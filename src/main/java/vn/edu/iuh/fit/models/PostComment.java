package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.LinkedHashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @Column(name = "title", length = 100)
    private String title;
    @Column(name = "published")
    private Boolean published;
    @Column(name = "content")
    private String content;
    @Column(name = "publishedAt")
    private Instant publishedAt;
    @Column(name = "createdAt")
    private Instant createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private PostComment parent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comments")
    private User user;
    @ManyToOne(mappedBy = "postComments")
    private Set<PostComment> postComments=new LinkedHashSet<>();
}

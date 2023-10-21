package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.LinkedHashSet;

@Entity
@Table(name ="post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="published", nullable = false)
    private  Boolean published;
    @Lob
    @Column(name="content")
    private String  content;
    @Column(name = "metaTile", length = 100)
    private String metaTile;
    @Column(name = "summary")
    private String summary;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "posts_id",nullable = false)
    private Post posts;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="parentId")
    private PostComment parent;
    @Column(name = "title", length = 75)
    private String title;
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;
    @Column(name = "updateAt")
    private Instant updateAt;
    @Column(name = "publishedAt")
    private Instant publishedAt;
    @OneToMany(mappedBy = "parent")
    private  Set<Post> posts= new LinkedHashSet<>();
    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments =new LinkedHashSet<>();
}

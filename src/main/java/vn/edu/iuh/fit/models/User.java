package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.LinkedHashSet;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name= "mobile", length = 15)
    private String mobile;
    @Column(name= "lastName", length = 50)
    private String lastName;
    @Column(name= "intro")
    private String intro;
    @Column(name= "ptofile")
    private String ptofile;
    @Column(name= "passwordHash", nullable = false, length = 32)
    private String passwordHash;
    @Column(name= "middleName", length = 50)
    private String middleName;
    @Column(name= "firstName", length = 50)
    private String firstName;
    @Column(name= "email", length = 50)
    private String email;
    @Column(name = "lastLogin")
    private Instant lastLogin;
    @Column(name = "registeredAt",nullable = false)
    private Instant registeredAt;
    @ManyToOne(mappedBy = "uesr")
    private Set<PostComment> postComments=new LinkedHashSet<>();
    @OneToMany(mappedBy = "author")
    private  Set<Post> posts= new LinkedHashSet<>();
}

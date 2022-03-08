package ir.maktab.uni.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    @Column(nullable = false)
    private String studentCode;
    private Date birthday;

    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers;

    @OneToMany
    private List<Address> addresses;
}

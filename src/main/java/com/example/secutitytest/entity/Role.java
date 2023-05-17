package com.example.secutitytest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "role", uniqueConstraints = @UniqueConstraint(columnNames = "name",name="unique_role_name"))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    @Column(name="name",length = 10)
    private String name;
    @Column (name= "user_name")
    private String Username;
    @Column (name= "Password")
    private String password;

}

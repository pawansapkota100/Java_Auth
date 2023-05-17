package com.example.secutitytest.entity;

import com.example.secutitytest.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "user_name",name = "unique_users"))
public class user implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="name",length = 20)
    private String name;
    @Column (name= "user_name")
    private String Username;
    @Column (name= "Password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;


    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name= "user_role",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_user")),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_role")))
    private List<Role> roles;

//    public Collection<? extends GrantedAuthority> getAuthorities()
//    {
//        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
//        for (Role role)
//
//    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

 @Override
 public Collection<? extends  GrantedAuthority> getAuthorities()
 {
     return this.roles.stream()
             .map(role -> new SimpleGrantedAuthority(role.getName()))
             .collect(Collectors.toList());
 }

   @Override
    public String getPassword()
   {
       return  this.getPassword();
   }
}

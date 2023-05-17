package com.example.secutitytest.repo;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * form user where user_name=?1"

    )
    org.springframework.security.core.userdetails.User getUserByUsername(String username);


}

package com.example.secutitytest.config;

import com.example.secutitytest.repo.RoleRepo;
import com.example.secutitytest.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import com.example.secutitytest.entity.Role;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class initDbConfig {

    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    @PostConstruct
    public  void  doEnteries()
    {
        if(roleRepo.findAll().size()==0){
            Role adminRole =new Role();
            adminRole.setName("Admin");
            roleRepo.save(adminRole);
            Role savedAdminRole = roleRepo.save(adminRole);


            Role userRole = new Role();
            userRole.setName("User");
            roleRepo.save(userRole);

            BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();


        }
    }

}

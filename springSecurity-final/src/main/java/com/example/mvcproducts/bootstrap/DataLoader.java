package com.example.mvcproducts.bootstrap;

import com.example.mvcproducts.domain.*;
import com.example.mvcproducts.services.ModificationService;
import com.example.mvcproducts.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final UserService userService;
  private final ModificationService modificationService;

  public DataLoader(UserService userService, ModificationService modificationService) {
    this.userService = userService;
    this.modificationService = modificationService;
  }

  @Override
  public void run(String... args) throws Exception {


    PasswordEncoder bcrypt = new BCryptPasswordEncoder();

    User user2=new User("user2",bcrypt.encode("user2"),"email@yahoo.com");
    user2.getRoles().add(Role.ROLE_USER);
    //System.out.println(user2.getRoles().get(0).toString());
    userService.save(user2);
    Modification honda = new Modification("honda",Type.ENGINE,10);
    modificationService.save(honda);
  }
}

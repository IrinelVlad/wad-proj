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
  public void run(String... args){


    PasswordEncoder bcrypt = new BCryptPasswordEncoder();

    User user2=new User("user2",bcrypt.encode("user2"),"email@yahoo.com");
    user2.getRoles().add(Role.ROLE_USER);
    //System.out.println(user2.getRoles().get(0).toString());
    userService.save(user2);
    Modification honda = new Modification("honda",Type.ENGINE,99);
    Modification mercedes = new Modification("mercedes",Type.ENGINE,93);
    Modification ferrari = new Modification("ferrari",Type.ENGINE,95);
    Modification renault = new Modification("renault",Type.ENGINE,89);

    Modification verstappen = new Modification("verstappen",Type.DRIVER,95);
    Modification checo = new Modification("checo",Type.DRIVER,90);
    Modification lewis = new Modification("lewis",Type.DRIVER,86);
    Modification russel = new Modification("russel",Type.DRIVER,88);
    Modification leclerc = new Modification("leclerc",Type.DRIVER,86);
    Modification carlos = new Modification("carlos",Type.DRIVER,80);
    Modification alonso = new Modification("alonso",Type.DRIVER,94);
    Modification stroll = new Modification("stroll",Type.DRIVER,82);
    Modification ocon = new Modification("ocon",Type.DRIVER,80);
    Modification gasly = new Modification("gasly",Type.DRIVER,78);
    Modification oscar = new Modification("oscar",Type.DRIVER,70);
    Modification lando = new Modification("lando",Type.DRIVER,87);
    Modification zhou = new Modification("zhou",Type.DRIVER,73);
    Modification bottas = new Modification("bottas",Type.DRIVER,82);
    Modification albon = new Modification("albon",Type.DRIVER,79);
    Modification logan = new Modification("logan",Type.DRIVER,69);
    Modification yuki = new Modification("yuki",Type.DRIVER,75);
    Modification devries = new Modification("devries",Type.DRIVER,68);
    Modification kmag = new Modification("kmag",Type.DRIVER,73);
    Modification hulk = new Modification("hulk",Type.DRIVER,71);

    Modification rbeng = new Modification("rbeng",Type.ENGINEER,95);
    Modification merceng = new Modification("merceng",Type.ENGINEER,93);
    Modification fereng = new Modification("fereng",Type.ENGINEER,88);
    Modification mcleng = new Modification("mcleng",Type.ENGINEER,91);

    Modification rblivery = new Modification("rblivery",Type.LIVERY,0);
    Modification merclivery = new Modification("merclivery",Type.LIVERY,0);
    Modification ferlivery = new Modification("ferlivery",Type.LIVERY,0);
    Modification mcllivery = new Modification("mcllivery",Type.LIVERY,0);
    Modification alplivery = new Modification("alplivery",Type.LIVERY,0);
    Modification amlivery = new Modification("amlivery",Type.LIVERY,0);
    Modification atlivery = new Modification("atlivery",Type.LIVERY,0);
    Modification willlivery = new Modification("willlivery",Type.LIVERY,0);



    modificationService.save(honda);
    modificationService.save(mercedes);
    modificationService.save(ferrari);
    modificationService.save(renault);
    modificationService.save(verstappen);
    modificationService.save(checo);
    modificationService.save(lewis);
    modificationService.save(russel);
    modificationService.save(leclerc);
    modificationService.save(carlos);
    modificationService.save(alonso);
    modificationService.save(stroll);
    modificationService.save(ocon);
    modificationService.save(gasly);
    modificationService.save(oscar);
    modificationService.save(lando);
    modificationService.save(zhou);
    modificationService.save(bottas);
    modificationService.save(albon);
    modificationService.save(logan);
    modificationService.save(yuki);
    modificationService.save(devries);
    modificationService.save(kmag);
    modificationService.save(hulk);
    modificationService.save(rbeng);
    modificationService.save(merceng);
    modificationService.save(fereng);
    modificationService.save(mcleng);
    modificationService.save(rblivery);
    modificationService.save(merclivery);
    modificationService.save(ferlivery);
    modificationService.save(mcllivery);
    modificationService.save(alplivery);
    modificationService.save(amlivery);
    modificationService.save(atlivery);
    modificationService.save(willlivery);

  }
}

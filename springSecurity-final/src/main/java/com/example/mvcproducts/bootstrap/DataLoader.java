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
    Modification honda = new Modification("Honda Engine",Type.ENGINE,99);
    Modification mercedes = new Modification("Mercedes Engine",Type.ENGINE,93);
    Modification ferrari = new Modification("Ferrari Engine",Type.ENGINE,95);
    Modification renault = new Modification("Renault Engine",Type.ENGINE,89);

    Modification verstappen = new Modification("Max Verstappen",Type.DRIVER,95);
    Modification checo = new Modification("Sergio Perez",Type.DRIVER,90);
    Modification lewis = new Modification("Lewis Hamilton",Type.DRIVER,86);
    Modification russel = new Modification("George Russell",Type.DRIVER,88);
    Modification leclerc = new Modification("Charles Leclerc",Type.DRIVER,86);
    Modification carlos = new Modification("Carlos Sainz",Type.DRIVER,80);
    Modification alonso = new Modification("Fernando Alonso",Type.DRIVER,94);
    Modification stroll = new Modification("Lance Stroll",Type.DRIVER,82);
    Modification ocon = new Modification("Esteban Ocon",Type.DRIVER,80);
    Modification gasly = new Modification("Pierre Gasly",Type.DRIVER,78);
    Modification oscar = new Modification("Oscar Piastri",Type.DRIVER,70);
    Modification lando = new Modification("Lando Norris",Type.DRIVER,87);
    Modification zhou = new Modification("Guanyu Zhou",Type.DRIVER,73);
    Modification bottas = new Modification("Valtteri Bottas",Type.DRIVER,82);
    Modification albon = new Modification("Alex Albon",Type.DRIVER,79);
    Modification logan = new Modification("Logan Sargeant",Type.DRIVER,69);
    Modification yuki = new Modification("Yuki Tsunoda",Type.DRIVER,75);
    Modification devries = new Modification("Nyck de Vries",Type.DRIVER,68);
    Modification kmag = new Modification("Kevin Magnussen",Type.DRIVER,73);
    Modification hulk = new Modification("Nico Hulkenberg",Type.DRIVER,71);

    Modification rbeng = new Modification("Red Bull Engineering Team",Type.ENGINEER,95);
    Modification merceng = new Modification("Mercedes Engineering Team",Type.ENGINEER,93);
    Modification fereng = new Modification("Ferrari Engineering Team",Type.ENGINEER,88);
    Modification mcleng = new Modification("Mclaren Engineering Team",Type.ENGINEER,91);

    Modification rblivery = new Modification("Red Bull Livery",Type.LIVERY,0);
    Modification merclivery = new Modification("Mercedes Livery",Type.LIVERY,0);
    Modification ferlivery = new Modification("Ferrari Livery",Type.LIVERY,0);
    Modification mcllivery = new Modification("Mclaren Livery",Type.LIVERY,0);
    Modification alplivery = new Modification("Alpine Livery",Type.LIVERY,0);
    Modification amlivery = new Modification("Aston Martin Livery",Type.LIVERY,0);
    Modification atlivery = new Modification("Alpha Tauri Livery",Type.LIVERY,0);
    Modification willlivery = new Modification("Williams Livery",Type.LIVERY,0);



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

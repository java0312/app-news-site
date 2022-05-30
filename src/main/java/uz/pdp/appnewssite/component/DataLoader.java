package uz.pdp.appnewssite.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.appnewssite.entity.Role;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.entity.enums.Permission;
import uz.pdp.appnewssite.repository.RoleRepository;
import uz.pdp.appnewssite.repository.UserRepository;
import uz.pdp.appnewssite.utils.AppConstants;

import java.util.Arrays;
import java.util.HashSet;

import static uz.pdp.appnewssite.entity.enums.Permission.*;

/*
* Programma run bollganda ishlaydi
* */
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {

        if (initialMode.equals("never"))
            return;

        //barcha rollar massivi
        Permission[] values = Permission.values();


        //Default admin rollar
        Role admin = roleRepository.save(new Role(
                AppConstants.ADMIN,
                new HashSet<>(Arrays.asList(values)),
                "This is ADMIN"
        ));

        //Default user rollari
        Role user = roleRepository.save(new Role(
                AppConstants.USER,
                new HashSet<>(Arrays.asList(ADD_COMMENT, EDIT_COMMENT, DELETE_MY_COMMENT)),
                "This is USER"
        ));

        userRepository.save(new User(
                "Admin",
                "admin",
                passwordEncoder.encode("admin123"),
                admin,
                true
        ));

        userRepository.save(new User(
                "User",
                "user",
                passwordEncoder.encode("user123"),
                user,
                true
        ));


    }


}

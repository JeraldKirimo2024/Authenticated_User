package org.alex.exercisesecurity;

import org.alex.exercisesecurity.entity.Role;
import org.alex.exercisesecurity.entity.User;
import org.alex.exercisesecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class ExerciseSecurityApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(ExerciseSecurityApplication.class, args);
    }
public void run(String...args){
    User adminAccount= userRepository.findByRole(Role.ADMIN);
    if(null ==adminAccount){
        User user = new User();

        user.setEmail("admin@gmail.com");
        user.setFirstname("@admin");
        user.setSecondname("@admin");
        user.setRole(Role.ADMIN);
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        userRepository.save(user);

    }

}
}

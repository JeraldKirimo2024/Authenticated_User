package org.alex.exercisesecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.alex.exercisesecurity.dtos.SignUpRequest;
import org.alex.exercisesecurity.entity.Role;
import org.alex.exercisesecurity.entity.User;
import org.alex.exercisesecurity.repository.UserRepository;
import org.alex.exercisesecurity.service.AuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User signUp(SignUpRequest signUpRequest){

        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstname());
        user.setSecondname(signUpRequest.getLastname());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

       return  userRepository.save(user);
    }
}

package org.alex.exercisesecurity.service;

import org.alex.exercisesecurity.dtos.SignUpRequest;
import org.alex.exercisesecurity.entity.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);
}

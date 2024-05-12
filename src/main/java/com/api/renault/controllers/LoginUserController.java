package com.api.renault.controllers;

import com.api.renault.models.UserModel;
import com.api.renault.repository.UserRepository;
import com.api.renault.responses.ErrorResponse;
import com.api.renault.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/renault/login")
public class LoginUserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Object> postUser(@RequestBody UserModel userModel) {

        try {

                if (!userRepository.existsByLoginUser(userModel.getLoginUser())) {

                    String encryptedPassword = new BCryptPasswordEncoder().encode(userModel.getPasswordUser());
                    userModel.setPasswordUser(encryptedPassword);
                    userRepository.save(userModel);

                    return SuccessResponse.success200(userModel);
                }

                return ErrorResponse.error400("Login already used");
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }

    @GetMapping
    public ResponseEntity<Object> loginUser(@RequestParam(name = "login") String loginUser, @RequestParam(name = "password") String passwordUser) {

        UserModel usuarioEncontrado = userRepository.findByLoginUser(loginUser);

        try {

            if (usuarioEncontrado != null) {
                if (new BCryptPasswordEncoder().matches(passwordUser, usuarioEncontrado.getPasswordUser())) {
                    return SuccessResponse.success200(usuarioEncontrado);
                }

                return ErrorResponse.error400("Password Incorrect");
            }

            return ErrorResponse.error400("User Not Found");
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }
}

package com.api.renault.repository;

import com.api.renault.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByLoginUser(String loginUser);
    boolean existsByLoginUser(String loginUser);
}

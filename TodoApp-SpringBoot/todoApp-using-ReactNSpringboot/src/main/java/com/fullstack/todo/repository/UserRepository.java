package com.fullstack.todo.repository;

import com.fullstack.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
Explanation of the code below: UserRepository interface that extends JpaRepo in build interface that provides CRUD Operation and Query Methods Capabilities.
However, I have provided a User Entity type and Long primary key type are specified as generics parameters

Custom Query methods:
Here, I have provided Query methods using Optional<T> class because I am trying to avoid null point Exception by searching a User with username or email.
Also, it provides a way to explicitly handle the absence of a value.

 */

public interface UserRepository extends JpaRepository<User, Long > {

//    Custom Query methods using Optional<T> class
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsernameOrEmail (String username, String email);

    Boolean existsByUsername(String username);
}



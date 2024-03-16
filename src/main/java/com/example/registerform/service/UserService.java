package com.example.registerform.service;

import com.example.registerform.dto.UserDto;
import com.example.registerform.entity.User;

public interface UserService {

    UserDto save(User user) throws Exception;

    UserDto update(User user);

    UserDto get(Long id);

    String delete(User user);
}

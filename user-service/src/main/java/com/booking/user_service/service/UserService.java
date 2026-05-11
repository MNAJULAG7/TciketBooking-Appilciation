package com.booking.user_service.service;

import com.booking.user_service.dto.UserRequest;
import com.booking.user_service.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse addUser(UserRequest request);

    UserResponse getUserById(Long id);

    UserResponse upadateUser(Long id, UserRequest request);

    UserResponse deleteById(Long id);

    List<UserResponse> getAll();
}

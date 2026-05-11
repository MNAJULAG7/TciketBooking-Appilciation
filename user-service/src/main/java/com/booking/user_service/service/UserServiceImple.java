package com.booking.user_service.service;

import com.booking.user_service.dto.UserRequest;
import com.booking.user_service.dto.UserResponse;
import com.booking.user_service.entity.Role;
import com.booking.user_service.entity.User;
import com.booking.user_service.exception.UserNotFoundException;
import com.booking.user_service.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserResponse addUser(UserRequest request) {
        User user = modelMapper.map(request,User.class);
        if(request.getRole()==null || request.getRole().toLowerCase().equals("admin"))
            user.setRole(Role.ROLE_ADMIN);
        else
            user.setRole(Role.ROLE_USER);

        User us = userRepo.save(user);
        UserResponse userResponse = modelMapper.map(us,UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
        UserResponse ur = modelMapper.map(user,UserResponse.class);
        return ur;
    }

    @Override
    public UserResponse upadateUser(Long id, UserRequest request) {
        User user = userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
        user.setRole(Role.valueOf("ROLE_"+request.getRole().toUpperCase()));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        User us = userRepo.save(user);
        UserResponse ur = modelMapper.map(us,UserResponse.class);
        return ur;
    }

    @Override
    public UserResponse deleteById(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
        userRepo.delete(user);
        UserResponse ur = modelMapper.map(user,UserResponse.class);
        return ur;
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> user = userRepo.findAll();
        List<UserResponse> ur = user.stream()
                        .map(u->modelMapper.map(u,UserResponse.class))
                .toList();
        return ur;

    }
}

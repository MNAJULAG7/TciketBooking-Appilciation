package com.booking.user_service.controller;

import com.booking.user_service.dto.UserRequest;
import com.booking.user_service.dto.UserResponse;
import com.booking.user_service.service.UserService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class userController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponse>  addUser(@RequestBody  UserRequest request)
    {
        return ResponseEntity.ok().body(userService.addUser(request));

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>  getUserById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(userService.getUserById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse>  updateUser(@PathVariable Long id,@RequestBody  UserRequest request)
    {
        return ResponseEntity.ok().body(userService.upadateUser(id,request));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>>  deleteById(@PathVariable Long id)
    { UserResponse ur = userService.deleteById(id);
        Map<String,Object> m = new HashMap<>();
        m.put("message", "deleted succesfully");
        m.put("deleted Item",ur);

        return ResponseEntity.ok().body(m);

    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>>  getAll()
    {
        return ResponseEntity.ok().body(userService.getAll());

    }

}

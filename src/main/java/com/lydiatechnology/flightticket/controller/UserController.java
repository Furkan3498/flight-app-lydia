package com.lydiatechnology.flightticket.controller;



import com.lydiatechnology.flightticket.dto.UserDto;
import com.lydiatechnology.flightticket.request.CreateUpdateUserRequest;
import com.lydiatechnology.flightticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody CreateUpdateUserRequest request){
        return service.createUser(request);
    }
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id) {
        return service.getUserById(id);
    }


    @PutMapping("{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody CreateUpdateUserRequest request){
        return service.updateUser(id,request);
    }

    @GetMapping
    public List<UserDto> getUserList() {
        return service.getUserList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable  int id){
        service.deleteUser(id);
    }


}

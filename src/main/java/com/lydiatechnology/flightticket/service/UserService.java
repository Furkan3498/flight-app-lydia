package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.UserDto;
import com.lydiatechnology.flightticket.entity.User;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.UserRespository;
import com.lydiatechnology.flightticket.request.CreateUpdateUserRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {
    private final UserRespository repository;

    public UserDto createUser(CreateUpdateUserRequest request){
        User user = new User();
        user.setUserEmail(request.getUserEmail());
        user.setUserPassword(request.getUserPassword());
        user.setUserFirstName(request.getUserFirstName());
        user.setUserLastName(request.getUserLastName());
        user.setUserPhoneNumber(request.getUserPhoneNumber());
        user.setUserIdentityNumber(request.getUserIdentityNumber());
        user.setCreationDate(new Date());
        return convertToDto(repository.save(user));
    }
    public UserDto updateUser(int id, CreateUpdateUserRequest request){
        User user =repository.findById(id).orElseThrow(()->new NotFoundException("User not found."));
        user.setUserEmail(request.getUserEmail());
        user.setUserPassword(request.getUserPassword());
        user.setUserFirstName(request.getUserFirstName());
        user.setUserLastName(request.getUserLastName());
        user.setUserPhoneNumber(request.getUserPhoneNumber());
        user.setUserIdentityNumber(request.getUserIdentityNumber());
        user.setLastModificationDate(new Date());
        User updatedUser =repository.save(user);
        return convertToDto(updatedUser);
    }
    public UserDto getUserById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("User not found.")));
    }

    public List<UserDto> getUserList(){
        List<UserDto> userDtos = new ArrayList<>();
        repository.findAll().forEach(u -> userDtos.add(convertToDto(u)));
        return userDtos;
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(),
                new ArrayList<>());
    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .userEmail(user.getUserEmail())
                .userFirstName(user.getUserFirstName())
                .userIdentityNumber(user.getUserIdentityNumber())
                .userLastName(user.getUserLastName())
                .userPhoneNumber(user.getUserPhoneNumber())
                .build();
    }
    }


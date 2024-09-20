package com.lydiatechnology.flightticket.mapper;

import com.lydiatechnology.flightticket.dto.UserDto;
import com.lydiatechnology.flightticket.entity.User;
import com.lydiatechnology.flightticket.request.CreateUpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER= Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> userList);

    User createUser(CreateUpdateUserRequest request);

    void updateUser(@MappingTarget User user, CreateUpdateUserRequest request);

}

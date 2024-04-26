package com.example.pharmacy.mappers;

import com.example.pharmacy.dto.request.UserRequest;
import com.example.pharmacy.dto.response.UserResponse;
import com.example.pharmacy.entities.AppUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AppUserMapper {

    List<UserResponse> toListResponse(List<AppUser> list);
    default UserResponse toResponse(AppUser user){
        return UserResponse.builder().id(user.getId()).
                name(user.getName()).username(user.getUsername())
                        .email(user.getEmail()).password(user.getPassword()).
                build();
    }
    default UserRequest toRequest(AppUser user){
        return UserRequest.builder().
                name(user.getName()).username(user.getUsername())
                .email(user.getEmail()).password(user.getPassword()).
                build();
    }


}

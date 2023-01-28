package com.socialNetwork.springboot.converter;


import com.socialNetwork.springboot.dto.UserDto;
import com.socialNetwork.springboot.model.AppUser;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

  UserDto toDto(final AppUser user);

}

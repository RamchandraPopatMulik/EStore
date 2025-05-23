package com.lcwd.electronic.store.ElectronicStore1.services;

import com.lcwd.electronic.store.ElectronicStore1.dtos.PageableResponse;
import com.lcwd.electronic.store.ElectronicStore1.dtos.UserDto;

import java.util.List;

public interface UserService {

    //create

    UserDto createUser(UserDto userDto);

    //update
    UserDto updateUser(UserDto userDto,String userId);

    //delete
    void deleteUser(String userId);

    //get all users
    PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir);

    UserDto getUserById(String userId);
    //get single user Id

    //get single by email
    UserDto getUserByEmail(String email);
    //search user
    List<UserDto> search(String keyword);
    //other user specific features
}

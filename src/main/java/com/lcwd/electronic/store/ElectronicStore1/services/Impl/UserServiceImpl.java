package com.lcwd.electronic.store.ElectronicStore1.services.Impl;

import com.lcwd.electronic.store.ElectronicStore1.dtos.UserDto;
import com.lcwd.electronic.store.ElectronicStore1.entities.User;
import com.lcwd.electronic.store.ElectronicStore1.repositories.UserRepository;
import com.lcwd.electronic.store.ElectronicStore1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = dtoTOEntity(UserDto);
        User savedUser = userRepository.save(user);
        UserDto newDto = entityToDto(savedUser);
        return newDto;
    }



    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> search(String keyword) {
        return null;
    }
}

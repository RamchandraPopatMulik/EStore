package com.lcwd.electronic.store.ElectronicStore1.services.Impl;

import com.lcwd.electronic.store.ElectronicStore1.dtos.UserDto;
import com.lcwd.electronic.store.ElectronicStore1.entities.User;
import com.lcwd.electronic.store.ElectronicStore1.repositories.UserRepository;
import com.lcwd.electronic.store.ElectronicStore1.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
/*
        String userId = UUID.randomUUID().toString();  // Generate UUID
        userDto.setUserId(String.valueOf(userId));*/

        User user = dtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        UserDto newDto = entityToDto(savedUser);
        return  newDto;

    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Fund Of given Id"));
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setImgName(userDto.getImgName());
        User updatedUser = userRepository.save(user);
        UserDto updatedDto1 = entityToDto(updatedUser);
        return updatedDto1;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Deleted Successfully !!!"));
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> dtoList = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with given email and password !!!"));
        return entityToDto(user);
    }

    @Override
    public List<UserDto> search(String keyword) {
        List<User> users = userRepository.findByNameContaining(keyword);
        List<UserDto> dtoList = (List<UserDto>) users.stream().map(user -> entityToDto(user));
        return dtoList;
    }


    private UserDto entityToDto(User savedUser) {
       /*UserDto userDto=UserDto.builder().
                userId(savedUser.getUserId()).
                name(savedUser.getName()).
                email(savedUser.getEmail()).
                password(savedUser.getPassword()).
                about(savedUser.getAbout()).
                gender(savedUser.getGender()).
                imgName(savedUser.getImgName()).build();*/

        return modelMapper.map(savedUser, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {

     /*  User user= User.builder().
                userId(userDto.getUserId()).
                name(userDto.getName()).
                email(userDto.getEmail()).
                password(userDto.getPassword()).
                about(userDto.getAbout()).
                imgName(userDto.getImgName()).
                gender(userDto.getGender()).build();*/

        return modelMapper.map(userDto, User.class);
    }
}

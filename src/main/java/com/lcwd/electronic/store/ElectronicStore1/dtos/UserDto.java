package com.lcwd.electronic.store.ElectronicStore1.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String userId;

    @Size(min=3,max=15,message="Invalid Name !!!!")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Invalid User Email !!!")
    @Email(message ="Invalid User Email !!")
    private String email;

    @NotBlank(message = "Password is Required!!")
    private String password;
    @Size(min=4,max=6,message ="Invalid Gender!!!")
    private String gender;

    @NotBlank(message = "Write Something About UserSelf!!!")
    private String about;
    private String imgName;
}

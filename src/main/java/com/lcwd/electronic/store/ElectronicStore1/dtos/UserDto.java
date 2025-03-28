package com.lcwd.electronic.store.ElectronicStore1.dtos;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String userId;
    private String name;

    private String email;

    private String password;

    private String gender;
    private String about;

    private String imgName;
}

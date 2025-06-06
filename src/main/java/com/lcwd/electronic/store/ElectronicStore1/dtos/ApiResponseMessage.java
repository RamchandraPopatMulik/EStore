package com.lcwd.electronic.store.ElectronicStore1.dtos;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseMessage {

    private String message;

    private boolean success;

    private HttpStatus status;

}

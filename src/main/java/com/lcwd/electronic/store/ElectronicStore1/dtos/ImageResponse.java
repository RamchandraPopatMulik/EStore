package com.lcwd.electronic.store.ElectronicStore1.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResponse {

        private String imageName;

        private String message;

        private boolean success;

        private HttpStatus status;

}


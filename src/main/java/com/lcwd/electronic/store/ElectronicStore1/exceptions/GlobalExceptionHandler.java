package com.lcwd.electronic.store.ElectronicStore1.exceptions;


import com.lcwd.electronic.store.ElectronicStore1.dtos.ApiResponseMessage;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.*;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private Logger logger= (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> ResourseNotFoundException(ResourseNotFoundException ex)
    {
               logger.info("Exception Handler invoked !!!");
               ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
               return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(BadApiRequest.class)
    public ResponseEntity<ApiResponseMessage> handleBadApiRequest(BadApiRequest ex)
    {
        logger.info("Bad Api Request !!!");
        ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST).success(false).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public InputStream getResource(String path,String name) throws FileNotFoundException {

        String fullPath=path+ File.separator+name;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream;
    }

}

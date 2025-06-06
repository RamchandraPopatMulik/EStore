package com.lcwd.electronic.store.ElectronicStore1.validate;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ImageNameValidator.class)
public @interface ImageNameValidate
{

    String message() default "Invalid Image Name !!!!";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

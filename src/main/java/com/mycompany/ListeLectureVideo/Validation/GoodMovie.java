package com.mycompany.ListeLectureVideo.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GoodMovieValidator.class)
public @interface GoodMovie {

    String message() default "If a movie is as good as 8 then priority should be at least M";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
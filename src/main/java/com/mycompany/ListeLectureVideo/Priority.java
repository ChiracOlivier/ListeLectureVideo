package com.mycompany.ListeLectureVideo;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityValidation.class)
public @interface Priority {

    String message() default "Please enter L, M or H for priority";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}

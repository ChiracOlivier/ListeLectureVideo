package com.mycompany.ListeLectureVideo.Validation;

import com.mycompany.ListeLectureVideo.Validation.Priority;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriorityValidation implements ConstraintValidator<Priority, String> {
   public void initialize(Priority constraint) {
   }

   @Override
   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return obj.trim().length()==1 && "LMH".contains(obj.toUpperCase());
   }
}

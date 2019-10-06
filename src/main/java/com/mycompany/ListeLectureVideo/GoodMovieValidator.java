package com.mycompany.ListeLectureVideo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GoodMovieValidator implements ConstraintValidator<com.mycompany.ListeLectureVideo.GoodMovie, String> {
   public void initialize(com.mycompany.ListeLectureVideo.GoodMovie constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return true;
   }
}

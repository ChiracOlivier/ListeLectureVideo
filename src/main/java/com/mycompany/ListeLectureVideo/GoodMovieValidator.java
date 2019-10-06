package com.mycompany.ListeLectureVideo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GoodMovieValidator implements ConstraintValidator<com.openclassrooms.watchlist.GoodMovie, String> {
   public void initialize(com.openclassrooms.watchlist.GoodMovie constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return false;
   }
}

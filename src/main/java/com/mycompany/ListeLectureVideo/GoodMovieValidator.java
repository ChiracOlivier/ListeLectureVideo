package com.mycompany.ListeLectureVideo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GoodMovieValidator implements ConstraintValidator<GoodMovie, WatchlistItem> {
   public void initialize(GoodMovie constraint) {
   }

   @Override
   public boolean isValid(WatchlistItem value, ConstraintValidatorContext context) {
      return !(Double.parseDouble(value.getRating()) >= 8 &&  "L".equals(value.priority));
   }

}

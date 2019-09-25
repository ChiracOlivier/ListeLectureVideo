package com.mycompany.ListeLectureVideo;



import java.util.HashMap;
import java.util.Map;

    @Controller
    public class ListeLecture {

        @GetMapping("/watchlist")
        public ModelAndView getWatchlist() {

            String viewName = "watchlist";

            Map<String, Object> model = new HashMap<String, Object>();

            model.put("numberOfMovies", "1234");

            return new ModelAndView(viewName , model);
        }
    }


package com.mycompany.ListeLectureVideo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ListeLecture {

    private List<WatchlistItem> watchlistItems= new ArrayList<WatchlistItem>();
    private static int index=0;
    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistItemForm(){
        String viewName= "watchlistItemForm";
        Map<String, Object> model = new HashMap<String, Object>();

        model.put("watchlistItemForm", new WatchlistItem());
        return new ModelAndView(viewName, model);
    }

    @PostMapping("watchlistItemForm")
    public ModelAndView sumitWatchlistItemForm(WatchlistItem watchlistItem ){

        watchlistItem.setId(index++);
        watchlistItem.setComment("comment");
        watchlistItem.setPriority("priority");
        watchlistItem.setRating("rating");
        watchlistItem.setTitle("title");
        watchlistItems.add(watchlistItem);

        RedirectView redirectView= new RedirectView();
        redirectView.setUrl("/watchlist");
        return new ModelAndView(redirectView);
    }

    @GetMapping("/watchlist")
    public ModelAndView getWatchlist() {

        String viewName = "watchlist";

        Map<String, Object> model = new HashMap<String, Object>();


        model.put("watchlistItems", watchlistItems);
        model.put("numberOfMovies", watchlistItems.size());

        return new ModelAndView(viewName , model);
    }
}


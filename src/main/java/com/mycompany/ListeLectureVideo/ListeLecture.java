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
    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchlistItemForm(WatchlistItem watchlistItem) {

        WatchlistItem existingItem = findWatchlistItemById(watchlistItem.getId());

        if (existingItem == null) {
            watchlistItem.setId(index++);
            watchlistItems.add(watchlistItem);
        } else {
            existingItem.setComment(watchlistItem.getComment());
            existingItem.setPriority(watchlistItem.getPriority());
            existingItem.setRating(watchlistItem.getRating());
            existingItem.setTitle(watchlistItem.getTitle());
        }

        RedirectView redirect = new RedirectView();
        redirect.setUrl("/watchlist");

        return new ModelAndView(redirect);
    }

    private WatchlistItem findWatchlistItemById(Integer id) {
       for(WatchlistItem watchlistItem: watchlistItems){
           if(watchlistItem.getId()==id)
               return watchlistItem;
       }

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


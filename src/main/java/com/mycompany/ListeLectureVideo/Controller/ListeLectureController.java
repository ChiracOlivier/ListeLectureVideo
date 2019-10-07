package com.mycompany.ListeLectureVideo.Controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.ListeLectureVideo.domain.WatchlistItem;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class ListeLectureController {

    private List<WatchlistItem> watchlistItems= new ArrayList<WatchlistItem>();
    private static int index=0, inde=0;
    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistItemForm(@RequestParam(required = false) Integer id){
        String viewName= "watchlistItemForm";
        Map<String, Object> model = new HashMap<String, Object>();
        WatchlistItem watchlistIte= findWatchlistItemById(id);
        WatchlistItem watchlistItem;

        if(watchlistIte==null)
            watchlistItem = new WatchlistItem();
        else
            watchlistItem = watchlistIte;



       if(id!=null) inde=id;
        model.put("watchlistItemFor", watchlistItem);
        return new ModelAndView(viewName, model);
    }
    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchlistItemForm(@Valid WatchlistItem watchlistItem, BindingResult bindingResult){
        Map<String, Object> modello = new HashMap<String, Object>();
        if(bindingResult.hasErrors()){

            modello.put("error1", true);
            modello.put("watchlistItemFor", watchlistItem);
            return new ModelAndView("watchlistItemForm", modello);
        }
        if (itemAlreadyExists(watchlistItem.getTitle())) {
            bindingResult.rejectValue("title", "", "This movie is already on your watchlist");

            modello.put("watchlistItemFor",watchlistItem);
            return new ModelAndView("watchlistItemFor", modello);
        }

        WatchlistItem existingItem = findWatchlistItemById(inde);
        inde=index++;

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
        WatchlistItem watchlistIt=null;
        for(WatchlistItem watchlistItem: watchlistItems){
            if(watchlistItem.getId()==id)
                watchlistIt= watchlistItem;
        }
        return watchlistIt;
    }

    private boolean itemAlreadyExists(String title) {

        for (WatchlistItem watchlistItem : watchlistItems) {
            if (watchlistItem.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/watchlist")
    public ModelAndView getWatchlist() {

        String viewName = "watchlist";

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("watchlistItems", watchlistItems);
        model.put("numberOfMovies", watchlistItems.size());
        //System.out.println(watchlistItems.get(inde).getTitle());
        //System.out.println(watchlistItems.size());
        return new ModelAndView(viewName , model);
    }
}

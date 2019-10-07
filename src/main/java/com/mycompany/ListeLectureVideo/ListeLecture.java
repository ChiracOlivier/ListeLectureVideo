package com.mycompany.ListeLectureVideo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class ListeLecture {

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

        if(bindingResult.hasErrors()){
            Map<String, Object> model = new HashMap<String, Object>();
            boolean error= true;
            model.put("error", error);
            model.put("watchlistItemFor", watchlistItem);
            return new ModelAndView("watchlistItemForm", model);
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
        model.put("numberOfMovi", watchlistItems.size());

        return new ModelAndView(viewName , model);
    }

    @PostMapping("/watchlistItem")
    public ModelAndView watchlistItemSubmit(@Valid WatchlistItem watchlistItem, BindingResult bindingResult) {

        Map<String, Object> model = new HashMap<String, Object>();

        if (bindingResult.hasErrors()) {
            model.put("watchlistItemFor", watchlistItem);
            return new ModelAndView("watchlistItem");
        }

        if (itemAlreadyExists(watchlistItem.getTitle())) {
            bindingResult.rejectValue("title", "", "This movie is already on your watchlist");
            return new ModelAndView("watchlistItem");
        }

        watchlistItems.add(watchlistItem);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/watchlist");

        return new ModelAndView(new RedirectView("/watchlist"));
    }
}


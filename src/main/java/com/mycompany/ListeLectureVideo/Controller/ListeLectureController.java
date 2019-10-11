package com.mycompany.ListeLectureVideo.Controller;



import java.util.HashMap;
import java.util.Map;

import com.mycompany.ListeLectureVideo.domain.WatchlistItem;
import com.mycompany.ListeLectureVideo.exception.BindingResultException;
import com.mycompany.ListeLectureVideo.exception.ItemAlreadyExistException;
import com.mycompany.ListeLectureVideo.service.WatchlistService;
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
    int[]tab= new int[]{0, 0};
   WatchlistService watchlistService=new WatchlistService();
    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistItemForm(@RequestParam(required = false) Integer id){
        String viewName= "watchlistItemForm";
        Map<String, Object> model = new HashMap<String, Object>();
        WatchlistItem watchlistIte= watchlistService.findWatchlistItemById(id);
        WatchlistItem watchlistItem;

        if(watchlistIte==null)
            watchlistItem = new WatchlistItem();
        else
            watchlistItem = watchlistIte;

       if(id!=null) tab[0]=id;
        model.put("watchlistItemFor", watchlistItem);
        return new ModelAndView(viewName, model);
    }
    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchlistItemForm(@Valid WatchlistItem watchlistItem, BindingResult bindingResult){
        Map<String, Object> modello = new HashMap<String, Object>();
       
    }



    @GetMapping("/watchlist")
    public ModelAndView getWatchlist() {

        String viewName = "watchlist";

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("watchlistItems", watchlistService.getListWatchlistItem() );
        model.put("numberOfMovies", watchlistService.getWatchlistItemsSize());
        System.out.println(watchlistService.getListWatchlistItem().size());
        System.out.println(watchlistService.getWatchlistItemsSize());
        //System.out.println(watchlistService.findWatchlistItemById(tab[0]).getTitle());
        return new ModelAndView(viewName , model);
    }
}

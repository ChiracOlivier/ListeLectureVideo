package com.mycompany.ListeLectureVideo.service;

import com.mycompany.ListeLectureVideo.domain.WatchlistItem;
import com.mycompany.ListeLectureVideo.exception.itemAlreadyExistException;
import com.mycompany.ListeLectureVideo.repository.WatchlistRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public class WatchlistService {

    WatchlistRepository watchlistRepository=new WatchlistRepository();

    public List<WatchlistItem> getListWatchlistItem(){
        return watchlistRepository.getList();
    }

    public int getWatchlistItemsSize(){
        return watchlistRepository.getList().size();
    }

    public WatchlistItem findWatchlistItemById(Integer id){
        return watchlistRepository.findById(id);
    }

    public void addOrUpdateWatchlistItem(int inde, WatchlistItem watchlistItem, BindingResult bindingResult,  Map<String, Object> modello ){
        if(bindingResult.hasErrors()){

           throw new  bindingResultException;
        }
        if (itemAlreadyExists(watchlistItem.getTitle())) {
           throw new itemAlreadyExistException;
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
    }
}

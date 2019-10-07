package com.mycompany.ListeLectureVideo.service;

import com.mycompany.ListeLectureVideo.domain.WatchlistItem;
import com.mycompany.ListeLectureVideo.exception.BindingResultException;
import com.mycompany.ListeLectureVideo.exception.ItemAlreadyExistException;
import com.mycompany.ListeLectureVideo.repository.WatchlistRepository;
import org.springframework.validation.BindingResult;

import java.util.List;

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

    public int[] addOrUpdateWatchlistItem(int inde, WatchlistItem watchlistItem , BindingResult bindingResult, int index ) throws ItemAlreadyExistException, BindingResultException {
       int[] tab={inde,index};
        if(bindingResult.hasErrors()){
           throw new BindingResultException();
        }
        if (watchlistRepository.itemAlreadyExist(watchlistItem.getTitle())) {
           throw new ItemAlreadyExistException();
        }
        WatchlistItem existingItem = findWatchlistItemById(tab[0]);
        tab[0]=tab[1]++;

        if (existingItem == null) {
           tab[1]=watchlistRepository.addItem(watchlistItem, tab[1]);
        } else {
            existingItem.setComment(watchlistItem.getComment());
            existingItem.setPriority(watchlistItem.getPriority());
            existingItem.setRating(watchlistItem.getRating());
            existingItem.setTitle(watchlistItem.getTitle());
        }
        return tab;
    }
}

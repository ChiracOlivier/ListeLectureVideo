package com.mycompany.ListeLectureVideo.repository;

import com.mycompany.ListeLectureVideo.domain.WatchlistItem;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository {
    private List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();


    public List<WatchlistItem> getList(){
        return watchlistItems;
    }
    public boolean itemAlreadyExist(String title) {
        return findByTitle(title) != null;
    }

    public int addItem(WatchlistItem watchlistItem,int index) {
        watchlistItem.setId(index++);
        watchlistItems.add(watchlistItem);
        return index;
    }

    public WatchlistItem findById(Integer id) {
        WatchlistItem watchlistIt=null;
        for(WatchlistItem watchlistItem: watchlistItems){
            if(watchlistItem.getId()==id)
                watchlistIt= watchlistItem;
        }
        return watchlistIt;
    }

    public WatchlistItem findByTitle(String title) {
        for (WatchlistItem watchlistItem : watchlistItems) {
            if (watchlistItem.getTitle().equals(title)) {
                return watchlistItem;
            }
        }
        return null;
    }
}

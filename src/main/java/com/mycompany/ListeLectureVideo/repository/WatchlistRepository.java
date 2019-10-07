package com.mycompany.ListeLectureVideo.repository;

import com.mycompany.ListeLectureVideo.domain.WatchlistItem;

public class WatchlistRepository {
    private List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();
    private static int index = 1;

    public List<WatchlistItem> getList(){
        return watchlistItems;
    }

    public void addItem(WatchlistItem watchlistItem) {
        watchlistItem.setId(index++);
        watchlistItems.add(watchlistItem);
    }

    private WatchlistItem findWatchlistItemById(Integer id) {
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

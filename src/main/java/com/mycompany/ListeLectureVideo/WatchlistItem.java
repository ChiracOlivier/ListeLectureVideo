package com.mycompany.ListeLectureVideo;

public class WatchlistItem {

    private String title;
    private String rating;
    private String priority;
    private String comment;
    private Integer Id;
    private static int index=0;

    public WatchlistItem() {
        this.Id = index ++;
    }

    public WatchlistItem(String title, String rating,String priority, String comment, Integer Id) {
        super();
        this.title = title;
        this.rating= rating;
        this.priority= priority;
        this.comment= comment;
        this.Id= index++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}

package com.mycompany.ListeLectureVideo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class WatchlistItem {

    @NotBlank(message = "Please enter the title")
    private String title;

    @NotBlank(message = "Please enter the rating" )
    private String rating;

    @Priority
    @NotBlank(message = "Please enter the priority")
    private String priority;

    @NotBlank(message = "Please enter the comment")
    @Size(max = 50, message = "Comment should be maximum 50 caracters.")
    private String comment;

    private Integer id;
    private static int index;

    public WatchlistItem() {
        this.id = index++ ;
    }

    public WatchlistItem(String title, String rating,String priority, String comment, Integer id) {
        super();
        this.title = title;
        this.rating= rating;
        this.priority= priority;
        this.comment= comment;
        this.id= index;
    }
    public String messageTitle(String title){
        if(title==null)
            return "";
        else if(title.isEmpty())
            return "Please enter the title";
        else
            return "";
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
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }
}

package com.example.hanzjoki.ui.home;

public class CategoryHome {
    public String title;
    public String pic;

    public CategoryHome(String title, String pic){
        this.title = title;
        this.pic = pic ;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}

package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public abstract class Media implements Comparable<Media>{
    protected String title;
    protected String category;
    protected float cost;
    protected String id;

    public Media() {

    }

    public String getId() {
        return id;
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category) {
        this(title);
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Media(String id, String title, String category, float cost) {
        this(id, title, cost);
        this.category = category;
    }

    public boolean equals(Object object) {
        Media media = (Media) object;
        if(id.equals(media.id))
            return true;
        return false;
    }

    public int compareTo(Media media) {
        if (this instanceof Book && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            return -1;
        }
        if(this instanceof DigitalVideoDisc && media instanceof CompactDisc)
            return -1;
        if(this instanceof CompactDisc && (media instanceof DigitalVideoDisc || media instanceof Book))
            return 1;
        if(this instanceof DigitalVideoDisc && media instanceof Book)
            return 1;
        return 0;
    }
}

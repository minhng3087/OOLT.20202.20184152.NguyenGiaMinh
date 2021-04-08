package hust.soict.hedspi.aims.media;

public abstract class Media {
    protected String title;
    protected String category;
    protected float cost;
    protected String id;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
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
}

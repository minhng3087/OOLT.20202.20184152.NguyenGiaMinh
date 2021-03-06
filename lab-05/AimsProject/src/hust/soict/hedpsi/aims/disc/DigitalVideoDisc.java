package hust.soict.hedpsi.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public boolean equals(Object obj) {
        if (obj instanceof DigitalVideoDisc) {
            DigitalVideoDisc another = (DigitalVideoDisc) obj;
            if (this.category.equals(another.category) && this.director.equals(another.director) && this.length == another.length && this.cost == another.cost) {
                return true;
            }
        }
        return false;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }

    public DigitalVideoDisc(String category, String director, int length, float cost) {
        super();
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }


    public void print() {
        System.out.println(this.title + " " + this.category + " " + this.director + " " + this.length + " " + this.cost);
    }

    public static void swap(DiscSwap cw1,  DiscSwap cw2)
    {
        DigitalVideoDisc temp = cw1.c;
        cw1.c = cw2.c;
        cw2.c = temp;
    }

    public boolean search(String title) {
        String[] input = title.toLowerCase().split(" ");
        for (int i = 0; i < input.length; i++) {
            if(getTitle().toLowerCase().contains(input[i])) {
                return true;
            }
        }
        return false;
    }

}



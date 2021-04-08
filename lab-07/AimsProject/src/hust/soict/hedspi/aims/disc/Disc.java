package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public Disc(String id, String title, float cost) {
        super(id, title, cost);
    }

    public Disc(String id, String title, int length, float cost) {
        super(id, title, cost);
        this.length = length;
    }

    public Disc(String id, String title, String category, int length, float cost ) {
        super(id, title, category, cost);
        this.length = length;
    }

    public Disc(String id, String title, String category, int length, String director, float cost) {
        this(id, title, category, length, cost);
        this.director = director;
    }
}

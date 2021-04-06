package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Media {
    private int length;
    private String director;
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public DigitalVideoDisc(String id, String title, String category, int length, float cost ) {
        super(id, title, category, cost);
        this.length = length;
    }

    public DigitalVideoDisc(String id, String title, String category, int length, String director, float cost) {
        this(id, title, category, length, cost);
        this.director = director;
    }
}

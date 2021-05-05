package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String id, String title, int length, float cost) {
        super(id, title, length, cost);
    }
    public DigitalVideoDisc(String id, String title, String category, int length, float cost ) {
        super(id, title, category, length, cost);
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

    public DigitalVideoDisc(String id, String title, String category, int length, String director, float cost) {
        super(id, title, category, length, director, cost);
    }

    public DigitalVideoDisc() {
        super();
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public int compareTo(Media media) {
        if(media instanceof DigitalVideoDisc) {
            if(this.getCost() < media.getCost())
                return -1;
            else if(this.getCost() == media.getCost())
                return 0;
            else return 1;
        }else {
            return super.compareTo(media);
        }
    }


}

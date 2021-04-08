package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String id, String title, int length, float cost) {
        super(id, title, length, cost);
    }
    public DigitalVideoDisc(String id, String title, String category, int length, float cost ) {
        super(id, title, category, length, cost);
    }

    public DigitalVideoDisc(String id, String title, String category, int length, String director, float cost) {
        super(id, title, category, length, director, cost);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestMediaCompareTo {
    public static void main(String[] args) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc();
        dvd1.setTitle("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc();
        dvd2.setTitle("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc();
        dvd3.setTitle("Aladdin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);

        java.util.Collection collection = new java.util.ArrayList();
        collection.add(dvd2);
        collection.add(dvd1);
        collection.add(dvd3);

        java.util.Iterator iterator = collection.iterator();

        System.out.println("-------------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while (iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }

        java.util.Collections.sort((java.util.List)collection);

        iterator = collection.iterator()
        ;
        System.out.println("-------------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while (iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }

        System.out.println("--------------------------------------");
    }

}

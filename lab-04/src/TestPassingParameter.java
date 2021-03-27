public class TestPassingParameter {
    public static void main(String[] args) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("Geogre Lucas");
        dvd2.setLength(124);

        DiscSwap cw1 = new DiscSwap(dvd1);
        DiscSwap cw2 = new DiscSwap(dvd2);
        DigitalVideoDisc.swap(cw1, cw2);

        cw1.c.print();
        cw2.c.print();


    }



}

public class Aims {
    public static void main(String[] args) {
        // Order anOrder = new Order();
        // DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        // dvd1.setCategory("Animation");
        // dvd1.setCost(19.95f);
        // dvd1.setDirector("Roger Allers");
        // dvd1.setLength(87);
        // anOrder.addDigitalVideoDisc(dvd1);
        // DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        // dvd2.setCategory("Science Fiction");
        // dvd2.setCost(24.95f);
        // dvd2.setDirector("Geogre Lucas");
        // dvd2.setLength(124);
        // anOrder.addDigitalVideoDisc(dvd2);
        // DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin");
        // dvd3.setCategory("Animation");
        // dvd3.setCost(18.99f);
        // dvd3.setDirector("John Musker");
        // dvd3.setLength(90);
        // DigitalVideoDisc dvd4 = new DigitalVideoDisc("Alladin");
        // dvd4.setCategory("Animation");
        // dvd4.setCost(18.99f);
        // dvd4.setDirector("John Musker");
        // dvd4.setLength(100);
        // anOrder.addDigitalVideoDisc(dvd3);
        // anOrder.removeDigitalVideoDisc(dvd2);
        // System.out.print("Total Cost is: ");
        // System.out.println (anOrder.totalCost());

        System.out.println("Test1:");
        Mydate test1 = new Mydate();
        System.out.println(test1.getDay());
        System.out.println(test1.getMonth());
        System.out.println(test1.getYear());

        System.out.println("Test2:");
        Mydate test2 = new Mydate(3, 4, 2020);
        System.out.println(test2.getDay());
        System.out.println(test2.getMonth());
        System.out.println(test2.getYear());

        System.out.println("Test3: ");
        Mydate test3 = new Mydate("5/8/2020");
        System.out.println(test3.getDay());
        System.out.println(test3.getMonth());
        System.out.println(test3.getYear());

        test1.accept();
        System.out.println(test1.getDay());
        System.out.println(test1.getMonth());
        System.out.println(test1.getYear());

        test1.print();



    }
}

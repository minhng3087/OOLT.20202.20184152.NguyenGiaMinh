
public class Aims {

    
    public static void main(String[] args) throws Exception {
        Order order1 = Order.getOrder();
		Order order2 = Order.getOrder();
        Order order3 = Order.getOrder();
        Order order4 = Order.getOrder();
        Order order5 = Order.getOrder();
        Order order6 = Order.getOrder();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        order1.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("Geogre Lucas");
        dvd2.setLength(124);
        order1.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars");
        dvd3.setCategory("Science Fiction");
        dvd3.setCost(24.95f);
        dvd3.setDirector("Geogre Lucas");
        dvd3.setLength(124);
        order1.addDigitalVideoDisc(dvd3);
        order1.addDisc(dvd1, dvd2, dvd3, dvd3, dvd3);
        if (order1 != null) order1.printListOfOrdered();
        if (order2 != null) order2.printListOfOrdered();
        if (order3 != null) order3.printListOfOrdered();
        if (order4 != null) order4.printListOfOrdered();
        if (order5 != null) order5.printListOfOrdered();
        if (order6 != null) order6.printListOfOrdered();



    }
}

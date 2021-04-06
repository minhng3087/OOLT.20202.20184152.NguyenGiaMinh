package hust.soict.hedspi.aims.order;


import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.Mydate;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public static final int MAX_NUMBER_ORDERS = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private static int nbOrders = 0;

    private static final int numberOfOrder = 4;

    private Mydate dateOrdered = new Mydate();

    public ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Mydate getDateOrdered() {
        return dateOrdered;
    }

    private Order() {
        nbOrders++;
    }

    public static Order getOrder() {
        if(nbOrders < MAX_LIMITTED_ORDERS) {
            Order newOrder = new Order();
            nbOrders++;
            System.out.println("Creat new order successfully!");
            return newOrder;
        }
        else {
            System.out.println("The numbers of orders is almost max.");
            return null;
        }
    }

    public void addMedia(Media media){
        if(itemsOrdered.contains(media)) {
            System.err.println("The media with title: " + media.getTitle() + " is existed!");
        }else{
            itemsOrdered.add(media);
            System.out.println("***The media:  " + media.getTitle() + " has been added");
        }
    }

    public void addMedia(Media... mediaList) {
        for(int i = 0; i < mediaList.length; i++) {
            addMedia(mediaList[i]);
        }
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media with ID: " + media.getId() + " has been deleted!");
        }else {
            System.err.println("Can't not find!");
        }
    }
    public boolean removeMedia(String id) {
        boolean mark = false;
        for(Media media: itemsOrdered) {
            if(media.getId().equalsIgnoreCase(id)) {
                removeMedia(media);
                mark = true;
                break;
            }
        }
        if(mark == false) {
            System.err.println("Can't find id");
        }
        return mark;
    }

    public float totalCost() {
        float total = 0.0f;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    public void printListOfOrdered() {
        System.out.println("********************************ORDER******************************");
        dateOrdered.print();
        int i = 1;
        System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s | %-10s |\n", "STT", "Type", "ID", "Title", "Category", "Cost");
        for(Media media: itemsOrdered) {
            if(media instanceof Book) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s | %-10s |\n", i, "Book", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            }else if(media instanceof DigitalVideoDisc) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s | %-10s |\n", i, "DVD", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            }
            i++;
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*******************************************************************");
    }

    public boolean checkId(String id) {
        for(Media media: itemsOrdered) {
            if(media.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static void addBookToOrder(Order anOrder) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\tNhap id: ");
        String id = sc.nextLine();
        System.out.print("\tNhap title: ");
        String title = sc.nextLine();
        System.out.print("\tNhap category: ");
        String category = sc.nextLine();
        System.out.print("\tNhap cost: ");
        float cost = sc.nextFloat();
        // constructor a book without AuthorsList
        Book aBook = new Book(id, title, category, cost);
        System.out.print("\tNhap so luong authors: ");
        int iAuthors = sc.nextInt();
        while(iAuthors <= 0) {
            System.err.println("So luong authors phai lon hon 0");
            System.out.print("\tNhap so luong authors: ");
            iAuthors = sc.nextInt();
        }
        sc.nextLine();
        while(iAuthors > 0) {
            System.out.print("\tNhap author: ");
            String author = sc.nextLine();
            aBook.addAuthor(author);
            iAuthors--;
        }
        anOrder.addMedia(aBook);
    }

    public static void addDvdToOrder(Order anOrder) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\tNhap id: ");
        String id = sc.nextLine();
        System.out.print("\tNhap title: ");
        String title = sc.nextLine();
        System.out.print("\tNhap category: ");
        String category = sc.nextLine();
        System.out.print("\tNhap director: ");
        String director = sc.nextLine();
        System.out.print("\tNhap cost: ");
        float cost = sc.nextFloat();
        System.out.print("\tNhap length: ");
        int length = sc.nextInt();
        sc.nextLine();
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, length, director, cost);
        anOrder.addMedia(dvd);
    }

    public static void removeMediaInOrder(Order anOrder) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id: ");
        String id = sc.nextLine();
        anOrder.removeMedia(id);
    }
}

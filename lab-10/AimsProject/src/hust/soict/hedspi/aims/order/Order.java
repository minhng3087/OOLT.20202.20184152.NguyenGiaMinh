package hust.soict.hedspi.aims.order;


import hust.soict.hedspi.aims.exceptions.LuckyItemException;
import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.Track;
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

    public ArrayList<Media> itemsOrdered = new ArrayList<>();
    private int thresholdsTotal;
    private float thresholdsSale;

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
        for (Media media : mediaList) {
            addMedia(media);
        }
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("***Media with ID: " + media.getId() + " has been deleted!");
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
        if(!mark) {
            System.err.println("Can't find id");
        }
        return mark;
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
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
            }else if(media instanceof CompactDisc) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s | %-10s |\n", i, "CD", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
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

    public static void addDvdToOrder(Order anOrder) throws PlayerException {
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
        String ask;
        do {
            System.out.print("***\tBan muon nghe thu khong(yes|no): ");
            ask = sc.nextLine();
            switch (ask) {
                case "yes":
                    System.out.println("===============================");
                    dvd.play();
                    System.out.println("===============================");
                    break;
                case "no":
                    break;
                default:
                    System.err.println("Nhap sai cu phap");
            }
        } while (!ask.equalsIgnoreCase("yes") && !ask.equalsIgnoreCase("no"));
        anOrder.addMedia(dvd);
    }

    public static void addCdToOrder(Order anOrder) throws PlayerException {
        Scanner sc = new Scanner(System.in);
        System.out.print("\tNhap id: ");
        String id = sc.nextLine();
        System.out.print("\tNhap title: ");
        String title = sc.nextLine();
        System.out.print("\tNhap category: ");
        String category = sc.nextLine();
        System.out.print("\tNhap artist: ");
        String artist = sc.nextLine();
        System.out.print("\tNhap cost: ");
        float cost = sc.nextFloat();
        CompactDisc cd = new CompactDisc(id, title, category, artist, cost);
        System.out.print("\tSo luong Track: ");
        int count = sc.nextInt();
        while(count <= 0) {
            System.err.println("So luong Track phai lon hon 0");
            System.out.print("\tSo luong Track: ");
            count = sc.nextInt();
        }
        sc.nextLine();
        Track track;
        String titleTrack;
        int lengthTrack;
        for(int i = 0; i < count; i++) {
            System.out.println("***\tTrack " + (i+1));
            System.out.print("\tNhap title cua track: ");
            titleTrack = sc.nextLine();
            System.out.print("\tNhap length cua track: ");
            lengthTrack = sc.nextInt();
            track = new Track(titleTrack, lengthTrack);
            cd.addTrack(track);
            sc.nextLine();
        }
        String ask;
        do {
            System.out.print("***\tBan muon nghe thu khong(yes|no): ");
            ask = sc.nextLine();
            switch (ask) {
                case "yes":
                    System.out.println("===============================");
                    cd.play();
                    System.out.println("===============================");
                    break;
                case "no":
                    break;
                default:
                    System.err.println("Nhap sai cu phap");
            }
        } while (!ask.equalsIgnoreCase("yes") && !ask.equalsIgnoreCase("no"));
        anOrder.addMedia(cd);
    }

    public static void removeMediaInOrder(Order anOrder) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id: ");
        String id = sc.nextLine();
        anOrder.removeMedia(id);
    }

    public Media getALuckyItem() throws LuckyItemException{
        if(itemsOrdered.size() >= numberOfOrder && this.totalCost() >= thresholdsTotal) {
            if(checkOrder(this)) {
                int item = 0;
                do {
                    double rand = Math.random();
                    rand *= itemsOrdered.size();
                    item = (int)rand;
                } while (itemsOrdered.get(item).getCost() <= this.totalCost()*thresholdsSale);
                return itemsOrdered.get(item);
            }else {
                throw new LuckyItemException("Tất cả hàng đều lớn hơn ngưỡng quà tặng (" + totalCost()*thresholdsSale + ")");
            }
        }else {
            throw new LuckyItemException("Không đủ điều kiện nhận sản phẩm may mắn\nSố sản phẩm >= " + numberOfOrder + "\nTổng đơn hàng >= " + thresholdsTotal);
        }
    }

    private boolean checkOrder(Order order) {
        for(Media media: order.itemsOrdered) {
            if(media.getCost() <= order.totalCost()*thresholdsSale)
                return true;
        }
        return false;
    }

    public void setThresholds(int thresholdsTotal, float thresholdsSale) {
        this.thresholdsTotal = thresholdsTotal;
        this.thresholdsSale = thresholdsSale;
    }
}

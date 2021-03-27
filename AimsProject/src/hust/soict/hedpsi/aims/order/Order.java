package hust.soict.hedpsi.aims.order;

import hust.soict.hedpsi.aims.disc.DigitalVideoDisc;
import hust.soict.hedpsi.aims.utils.Mydate;

import java.util.Scanner;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private int qtyOrdered = 0;
    private static int nbOrders = 0;

    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private final Mydate dateOrdered = new Mydate();

    public static Order getOrder() {
        if(nbOrders < MAX_LIMITTED_ORDERS) {
            Order newOrder = new Order();
            nbOrders++;
            return newOrder;
        }
        else {
            System.out.println("The numbers of orders is almost max.");
            return null;
        }
    }



    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered  < MAX_NUMBERS_ORDERED) {
            DigitalVideoDisc item = new DigitalVideoDisc(disc.getTitle(), disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
            this.itemsOrdered[this.qtyOrdered] = item;
            this.qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added");
        }
        else System.out.println("The order is almost full");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        if (this.qtyOrdered  < MAX_NUMBERS_ORDERED) {
            DigitalVideoDisc item1 = new DigitalVideoDisc(disc1.getCategory(), disc1.getDirector(), disc1.getLength(), disc1.getCost());
            DigitalVideoDisc item2 = new DigitalVideoDisc(disc2.getCategory(), disc2.getDirector(), disc2.getLength(), disc2.getCost());
            this.itemsOrdered[this.qtyOrdered++] = item1;
            if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The dvd " +  disc2.getTitle()+ " could not be added");
            }else {
                this.itemsOrdered[this.qtyOrdered++] = item2;
            }
        }
        else System.out.println("The order is almost full");
    }

    public void addDisc(DigitalVideoDisc ...discList) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The order is almost full");
            return;
        }
        for (DigitalVideoDisc disc: discList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered[this.qtyOrdered++] = disc;
                System.out.println("The DVD " + disc.getTitle() + " has been added.");
            }else {
                System.out.println("The order is almost full");
                break;

            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int k = -1;
        for(int i=0; i < this.qtyOrdered; i++) {
            if(this.itemsOrdered[i].equals(disc)) {
                for(int j=i;j < this.qtyOrdered - 1; j++) {
                    this.itemsOrdered[j] = new DigitalVideoDisc(this.itemsOrdered[j+1].getTitle(), this.itemsOrdered[j+1].getCategory(), this.itemsOrdered[j+1].getDirector(), this.itemsOrdered[j+1].getLength(), this.itemsOrdered[j+1].getCost());
                }
                this.qtyOrdered--;
                k = i;
                System.out.println("Remove " + disc.getTitle() + " successfully");
                break;
            }
        }
        if (k == -1) {
            System.out.println("The Disc " +  disc.getTitle() + " Not found");
        }


    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < this.qtyOrdered; i++) {
            sum += this.itemsOrdered[i].getCost();
        }
        return sum;
    }


    public void printListOfOrdered() {
        System.out.println("********************************ORDER******************************");
        dateOrdered.print();
        System.out.println("Ordered Items: ");
        for(int i=0; i<this.qtyOrdered; i++) {
            System.out.println("DVD - " + this.itemsOrdered[i].getTitle() + " - " + this.itemsOrdered[i].getCategory() + " - " + this.itemsOrdered[i].getDirector() + " - " + this.itemsOrdered[i].getLength() + " : " + this.itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: " + totalCost());

    }

    public void check() {
        int mark = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("======Nhap title muon tim kiem: ========");
        String title = sc.nextLine();
        System.out.println("======Ket qua tim kiem: =======");
        for(DigitalVideoDisc disc: this.itemsOrdered) {
            if(disc != null && disc.search(title)) {
                mark = 1;
                System.out.println(disc.getTitle());
            }
        }
        if(mark == 0) {
            System.out.println("Khong co ket qua tim kiem");
        }
    }

    public void getALuckyItem(){
        int min = 1;
        int range = MAX_NUMBERS_ORDERED - min + 1;
        int rand = (int)(Math.random() * range) + min;
        System.out.println(rand);
        itemsOrdered[rand] = new DigitalVideoDisc(itemsOrdered[rand].getTitle(), itemsOrdered[rand].getCategory(), itemsOrdered[rand].getDirector(),itemsOrdered[rand].getLength(), 0);
    }

}






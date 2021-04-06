package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class Aims {
    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    // Menu select Book or DVD
    public static void showMenuMedia() {
        System.out.println("Select add Book or DVD ");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selection;
        int case1 = 0;
        Order anOrder = null;
        do {
            showMenu();
            selection = sc.nextInt();
            switch (selection) {
                case 1 -> {
                    anOrder = Order.getOrder();
                    case1 = 1;
                }
                case 2 -> {
                    if (case1 == 0) {
                        System.err.println("Hay nhap case 1!");
                        break;
                    }
                    int temp;
                    do {
                        showMenuMedia();
                        temp = sc.nextInt();
                        switch (temp) {
                            case 1 -> {
                                sc.nextLine();
                                Order.addBookToOrder(anOrder);
                            }
                            case 2 -> {
                                sc.nextLine();
                                assert anOrder != null;
                                Order.addDvdToOrder(anOrder);
                            }
                            case 0 -> System.out.println("Exit submenu!");
                            default -> System.err.println("Error input enter, again!");
                        }
                    } while (temp != 0);
                }
                case 3 -> {
                    if (case1 == 0) {
                        System.err.println("Hay nhap case 1!");
                        break;
                    }
                    sc.nextLine();
                    assert anOrder != null;
                    Order.removeMediaInOrder(anOrder);
                }
                case 4 -> {
                    if (case1 == 0) {
                        System.err.println("Hay nhap case 1!");
                        break;
                    }
                    assert anOrder != null;
                    if (anOrder.itemsOrdered.isEmpty()) {
                        System.err.println("List of Order is empty!");
                    } else {
                        anOrder.printListOfOrdered();
                    }
                }
                case 0 -> {
                    sc.close();
                    System.out.println("Bye!!!");
                }
                default -> System.err.println("Error input enter, again!");
            }
        } while (selection != 0);
    }
}


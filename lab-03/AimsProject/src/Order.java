public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered  < MAX_NUMBERS_ORDERED) {
            DigitalVideoDisc item = new DigitalVideoDisc(disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
            this.itemsOrdered[this.qtyOrdered] = item;
            this.qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added");
        }
        else System.out.println("The order is almost full");
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
}

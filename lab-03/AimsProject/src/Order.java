public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered  <= MAX_NUMBERS_ORDERED) {
            DigitalVideoDisc item = new DigitalVideoDisc(disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
            this.itemsOrdered[this.qtyOrdered] = item;
            this.qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else System.out.println("The order is almost full");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i=0; i < this.qtyOrdered; i++) {
            if(this.itemsOrdered[i].equals(disc)) {
                for(int j=i;j<qtyOrdered; j++) {
                    this.itemsOrdered[j] = this.itemsOrdered[j+1];
                }
                this.qtyOrdered--;
            }
        }
        
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < this.qtyOrdered; i++) {
            sum += this.itemsOrdered[i].getCost();
        }
        return sum;
    }

    public void printm() {
        for (int i = 0; i < this.qtyOrdered; i++) {
            System.out.println(this.itemsOrdered[i]);
        }
    }
}

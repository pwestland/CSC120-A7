
/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /* creates the cafe */

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 200;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 25;
        System.out.println("You have built a cafe: ☕");
    }
    
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(size > this.nCoffeeOunces){
            System.out.println("You do not have enough coffee to complete this order.");
            restock(size, 0, 0, 0);
        }
        if(nSugarPackets > this.nSugarPackets){
            System.out.println("You do not have enough sugar packets to complete this order.");
            restock(0, nSugarPackets, 0, 0);
        }
        if(nCreams > this.nCreams){
            System.out.println("You do not have enough cream to complete this order.");
            restock(0, 0, nCreams, 0);
        }
        if(nCups < 1){
            System.out.println("You do not have enough cups to complete this order.");
            restock(0, 0, 0, 1);
        }
        else{
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public static void main(String[] args) {
        Cafe Compass = new Cafe("Compass Cafe", "7 Neilson Dr", 1);
    }
    
}

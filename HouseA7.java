
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {
  
  private ArrayList<String> residents;
  private boolean hasDiningHall;

  /* creates the house */

  public House(String name, String address, int nFloors, boolean hasDiningHall) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningHall = hasDiningHall;
    
    System.out.println("You have built a house: 🏠");
  }
  
  /* returns whether house has a dining hall */

  public boolean hasDiningHall(){
    return this.hasDiningHall;
  }

  /* returns how many residents in the house */

  public int nResidents(){
    return this.residents.size();
  }

  /* moves a person into the house */

  public void moveIn(String name){
    if (this.residents.contains(name)){
      throw new RuntimeException(name + " already lives in " + this.name);
    }
    this.residents.add(name);

  }

  /* moves a person out of the house, as long as they already live there */

  public String moveOut(String name){
    if (this.residents.contains(name)){
      this.residents.remove(name);
      return(name + " no longer lives in " + this.name);
    }
    else{
      throw new RuntimeException(name + " does not live in " + this.name);
    }
  }

  /* checks if a person lives in the house */

  public boolean isResident(String person){
    return this.residents.contains(person);
  }

  public static void main(String[] args) {
    House lawrence = new House("Lawrence House", "99 Green St", 4, false);
    lawrence.moveIn("Pippa");
    lawrence.moveIn("Pippa");
    lawrence.moveIn("Pippa W.");
    lawrence.moveIn("Sophie");
    lawrence.moveIn("Jarrah");
    lawrence.moveOut("Jarrah");
    System.out.println(lawrence.hasDiningHall());
    System.out.println(lawrence.nResidents());
  }

}

import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    /* creates the library */

    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      this.hasElevator = hasElevator;

      System.out.println("You have built a library: 📖");
    }
    
    public boolean hasElevator(){
      return hasElevator;
    }


    /* adds a book to the collection, as long as it's not already there */

    public void addTitle(String title){
      if (this.collection.containsKey(title)){
        throw new RuntimeException(title + " is already in the library's collection. ");
      }
      this.collection.put(title, true);
      System.out.println(title + " is now in the library's collection. ");
    }

    /* removes a book from the collection, as long as it's already there */

    public String removeTitle(String title){
      if (this.collection.containsKey(title)){
        this.collection.remove(title);
        System.out.println(title + " is no longer in the library's collection. ");
        return title;
      }
      else{
        throw new RuntimeException(title + " is not in the library's collection. ");
      }
    }
  
    /* checks out a book, provided it's in the collection and available */

    public void checkOut(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException(title + " is not in the library's collection. ");
      }
      if (!this.collection.get(title)){
        throw new RuntimeException(title + " is currently checked out of the library. ");
      }
      this.collection.put(title, false);
      System.out.println(title + " is now checked out of the library. ");
    }

    /* returns a book, provided it's in the collection and unavailable */

    public void returnBook(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException(title + " is not in the library's collection. ");
      }
      if (this.collection.get(title)){
        throw new RuntimeException(title + " is not currently checked out of the library. ");
      }
      this.collection.put(title, true);
      System.out.println(title + " has been returned to the library. ");
    }

    /* checks if a book is in the collection */

    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    /* checks if a book is available */

    public boolean isAvailable(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException(title + " is not in the library's collection. ");
      }
      return this.collection.get(title);
    }

    public void printCollection(){
      if (this.collection.isEmpty()){
        System.out.println("There are no books in this library's collection.");
      }
      System.out.println("This library's collection: ");
    }

    public void goToFloor(int floorNum){
      if(this.hasElevator() == true){
        super.goToFloor(floorNum);
      }
      else{
        if(this.activeFloor == -1){
          throw new RuntimeException("You cannot go to this floor from outside the building.");
        }
        if(floorNum < 1 || floorNum > this.nFloors){
          throw new RuntimeException("That floor does not exist, choose a number within the building's range.");
        }
        throw new RuntimeException("This building does not have an elevator, you must use the stairs.");
      }
    }

    public static void main(String[] args) {
      Library Neilson = new Library("Neilson", "7 Neilson Dr", 5, true);
    }
  
  }
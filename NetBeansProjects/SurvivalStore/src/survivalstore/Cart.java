/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survivalstore;
import java.util.*;
/**
 *
 * @author meghasharma
 */
public class Cart {
    
    private int numInCart = 0;
    private List<Product> cartList = new ArrayList<>();
    
    
    
   public void addToCart(Product product){
        cartList.add(product);
        numInCart++;
    }
    
   public void removeFromCart(Product product){
        cartList.remove(product);
        numInCart--;
    }
    
   public void mainMenu(Inventory inventory, Wallet wallet){
        
        int choice = 0;
        Scanner in = new Scanner(System.in);
        
        
        
        do{
            //to clear up the screen //doesnt work? found online
            System.out.print("\f");
            
            printMenuOptions();
            
            choice = in.nextInt();
            
            switch (choice){
                
                case 1:
                    printItemsInCart();
                    break;
                case 2:
                    // perform add
                    System.out.println("So far there are + " + numInCart + "items in your cart...\n");
                    if (performAdd(inventory)){
                        System.out.println("It worked");
                    }
                    else
                        System.out.println("Doesnt work");
                    break;
                case 3:
                    // perform remove
                    System.out.println("So far there are + " + numInCart + "items in your cart...\n");
                    if (performAdd(inventory)){
                        System.out.println("It worked");
                    }
                    else
                        System.out.println("Doesnt work");
                    break;
                case 4:
                    System.out.println("the total for the cart is: " + ckeckOut(wallet));
                    break;
                case 5:
                    System.out.println("returning to main menu");
                    break;
                default:
                    System.out.println("The value you entered is not within the required range for this program (1..5), please re-enter\n");
                    break;
            }
            
        }while (choice != 5);
    }
    
   private void printMenuOptions(){
        
        System.out.println("This is the cart menu: \n"
                         + "To view all Items in your cart currently enter 1\n"
                         + "To add item/s to your cart enter 2\n"
                         + "To remove item/s from your cart enter 3\n"
                         + "To checkout 4\n"
                         + "To exit cart menu and return to main menu enter 5");
    }
    
   private void printItemsInCart(){
        
        if (cartList.isEmpty()){
            System.out.println("Currently you have no items in the cart.\n");
        }
        else{
            
            ListIterator itr = (ListIterator) cartList.iterator();
        
            while (itr.hasNext()){
                
                System.out.println(itr.next());
            
            }
        }
    }
    
   public List<Product> getCartList(){
        return cartList;
    }
    
    
    
   private boolean performAdd(Inventory inventory) {
        // return value
        boolean success = false;
   
        Scanner tem = new Scanner(System.in);
        
//        //DEBUG STUFF : TO DO: REMOVE /************************************************************************
//        Random random = new Random();
//        Integer rand = 0 + (49 - 0) * random.nextInt();
//        System.out.println(rand);
//        //System.out.println("A random unique for an item is: " + inventory.productList.get(rand).getUniqueID());
//        //*****************************************************************************************************
        
        
        System.out.println("Please provide the uniqueID of the item you would like to add to the cart");
        String temp = tem.nextLine();
 
  
        // empty product object using default
        Product prod = new Product();
        
         
        // looping through the array list of our inventory of items
            
         for (int i = 0; i < inventory.productList.size(); i++){
             
             // check to see which product has the same name as what the user said 
             if (i < inventory.productList.size())
             {
                 if (temp.equals(inventory.productList.get(i).getUniqueID())) {
                    System.out.println("The current item that is being checked is: " + inventory.productList.get(i).getName());
                    prod = inventory.productList.get(i); // grab the product object from inventory list and assign empty product object
                 
                    inventory.productList.remove(i); // remove this object from the inventory list
                 
                    addToCart(prod); // call to in class method for cart
                 
                    success = true; // change boolean return value
                    System.out.println(success);
                } 
             }
         
        
         }
        return success;
  } 
    
   private boolean performSubtract(Inventory inventory) {
       
        //return value
        boolean success = false;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please provide the name of the item you would like to remove from the cart");
        String temp = in.nextLine();
        
        // empty product object using default
        Product prod = new Product();
        
         
        // looping through the array list of our cart of items
         
        for (int i = 0; i < cartList.size(); i++){
            
             // check to see which product has the same name as what the user said 
            
             if (temp.equals(cartList.get(i).getName())) {
                 
                 prod = cartList.get(i); // grab the product object from cart list and assign empty product object
                 
                 removeFromCart(prod); // call to in class method for cart
                 
                 inventory.productList.add(prod); // add this object from the inventory list
                 
                 success = true; // change boolean return value
                 
                }
         }
        
        return success;
    }
    
   
   private Double ckeckOut(Wallet wallet) {

        double totalPrice = 0.0;
        String temp = "";
        
        for (int i = 0; i < cartList.size(); i++) {
          temp = cartList.get(i).getPrice().replace("$", "");
          wallet.deductFromBalance(Double.parseDouble(temp));
          totalPrice = Double.parseDouble(temp);

        }
        cartList.removeAll(cartList);
        return totalPrice;
    }
 
}

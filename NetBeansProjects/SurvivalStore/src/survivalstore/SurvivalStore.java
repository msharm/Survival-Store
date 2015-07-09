/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survivalstore;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author meghasharma
 */
public class SurvivalStore {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        int choice;
        
        Inventory inventory = new Inventory("/Users/meghasharma/NetBeansProjects/SurvivalStore/resources/survival_store_inventory.csv");
        inventory.loadData();
        
        Wallet wallet =  new Wallet();
       
        System.out.println("Hello! This is our text based store application, please enter a value between (1..5) \n\n");
        
        Scanner in = new Scanner(System.in);
        
        do{
            // to clear up the screen // doesnt work
            System.out.print("\f");
            
            printWelcomeMessage();
            
            choice = in.nextInt();
            
            switch (choice){
                
                case 1:
                    inventory.displayProducts();
                    break;
                case 2:
                    //sort stuff
                    break;
                case 3:
                    doCartStuff(inventory, new Cart(), wallet);
                    break;
                case 4:
                    System.out.println("Your wallet's current ballence is: $" + wallet.getBalance() + "\n");
                    break;
                case 5:
                    System.out.println("Thank you for using the store app! Have a gread day :D");
                    System.exit(0);
                    break;
                default:
                    System.out.println("The value you entered is not within the required range for this program (1..5), please re-enter\n");
                    break;
            }
            
        }while (choice != 5);
  
    }
    
    public static void printWelcomeMessage(){
        System.out.println("The menu is setup in the following way: \n\n"
                         + "To see all products enter: 1\n"
                         + "To go into the sort menu enter: 2\n"
                         + "To view cart enter: 3\n"
                         + "To check wallet enter: 4\n"
                         + "To exit application enter: 5\n" );
    }
    
    public static void doCartStuff(Inventory inventory, Cart cart, Wallet wallet) {
        
        cart.mainMenu(inventory, wallet);
        
    }
    
}

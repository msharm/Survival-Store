/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package survivalstore;
import java.io.*;
import java.util.*;

/**
 *
 * @author meghasharma
 */
public class Inventory {
    
  private String fileName = "";
  public List<Product> productList = new ArrayList<>();
  private String line = "";
  
  //overloaded constructor
  Inventory(String file){
      this.fileName = file;
  }
    
  public void loadData() throws IOException{
      
      
        boolean firstline = true;
        BufferedReader fileIn = null;
        
        //debug stuff
        int i = 0;
        
        try{
            fileIn = (new BufferedReader(new FileReader(fileName)));
            while (( line = fileIn.readLine()) != null){
                
                //to igore the first line, just gives us info about how the data is stored in the csv file
                if (firstline){
                    firstline = false;
                }
                else {
                    
                        Product prod = new Product(line);
                        productList.add(prod);
                        //DEBUG: TO DO: REMOVE LINE OF CODE
                        //System.out.println(productList.get(i).getName());
                        i++;
                }    
            }
        }
        catch (IOException e) { e.printStackTrace();}
        finally {
            if (fileIn  != null){
                try {
                    fileIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       
    }
  
  
  //private utilities
  private void debugPrintFile(String line){
      System.out.print("The line that was just read had: " + line + "\n");
  }
  
  // print all products 
  public void displayProducts(){
      
        Iterator itr = productList.iterator();

        int i = 0;
        while (i < productList.size())
            if (i < productList.size())
                System.out.println(itr.next());
            i++;
        }
  
  }
  


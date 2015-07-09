/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survivalstore;

import java.util.UUID;

/**
 *
 * @author meghasharma
 */
public class Product  {
    
    //data types
    private final String CSV_SPLIT_VALUE = ",";
    
    private String name = "";
    private String category = "";
    
    private String price = "";
    private Double priceNum = 0.0;
    
    private String inStock = "";
    private int inStockNum = 0;
    
    private String line = "";
    
    private String uniqueID = "";
    
    //constructors
    Product(){
       //default
    }
    
    //overloaded constructor
    public Product(String line){
        this.line = line; 
        splitLine(line);
    }
    
   @Override
   public String toString() {
    return line;
   }
    
    //public getters
    public String getName(){
        return name;
    }
    
    public String getUniqueID(){
        // DEBUG STATEMENT TO DO REMOVE THIS LINE
        return uniqueID;
    }
    
    public String getCategory(){
        return category;
    }
    
    public String getPrice(){
        return price;
    }
    
    public Double getPriceNum(){
        return priceNum;
    }
    
    public String getInStock(){
        return inStock;
    }
    
    //public setters
    public void setName(String name){
        this.name = name;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setPrice(String price){
        this.price = price;
    }
    
    public void setInStock(String inStock) {
        this.inStock = inStock;
    }
    
    //private methods
    private void setPriceNum(String temp)  {
          priceNum = Double.parseDouble(temp.replace("$", ""));
    }
    
    private void setInStockNum(String temp){
      inStockNum = Integer.parseInt(temp);    
    }
    
    
    private void splitLine(String line){
        String [] productInfo = line.split(CSV_SPLIT_VALUE);
        
        category = productInfo[0];
        name = productInfo[1];
        price = productInfo[2];
        inStock = productInfo[3];
        uniqueID = UUID.randomUUID().toString();
    }
    
    //public utilities
    public boolean isInStock(){
        
        return inStockNum > 0 ? true : false;  
        
    }
    
    public boolean subtractStockValue(int num){
        
        if ( isInStock() ) {
            inStockNum = inStockNum - num;
            return true;
        }
        else
            return false;
            
    }
}



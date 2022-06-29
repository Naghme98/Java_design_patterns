package decorator;

import java.time.LocalDateTime;

public class TextView implements Report{
    int saleNumber = 0;
    int numberOfCustomers = 0;
    float printingCost = 0;
    String name ;
    LocalDateTime dateStablished ;
    int hashCode = 0;
    String headName = "Felani";


    public TextView (int saleNumber , int numberOfCustomers , float printingCost, String name, 
            LocalDateTime dateStablished
    ,int hashCode, String headName ){
        this.saleNumber = saleNumber;
        this .numberOfCustomers = numberOfCustomers;
        this.dateStablished = dateStablished;
        this.hashCode = hashCode;
        this.headName = headName;
        this.name = name;
        this.printingCost = printingCost;
    }
    @Override
    public String showText(){
        String result = "";
        result += this.name + "\n";
        result += this.dateStablished + "\n";
        result += this.hashCode + "\n";
        result += this.headName + "\n";
        result += this.saleNumber + "\n";
        result += this.numberOfCustomers + "\n";
        result += this.printingCost + "\n";
        return result;
    }
    @Override
    public Report removeDecorate(String className){
        System.out.println("There is no such a thing left to remove");
        return this;
    }

    @Override
    public Report undecorate() {
        return this;
    }
    
}
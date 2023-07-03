
public class ItemInformation 
{
    private String itemId;
    private String itemName;
    private double itemPrice;
    private String datePurchase;
    
    
    //constructor
    public ItemInformation()
    {
        itemId = "";
        itemName = "";
        itemPrice = 0.00;
        datePurchase = "";
    }
    
    public ItemInformation(String itemId, String itemName, double price, String date)
    {
        this.itemId = itemId; //same attribute name
        this.itemName = itemName; //same attribute name
        itemPrice = price;
        datePurchase = date;
    }
    
    public void setItemInfo(String itemId, String itemName, double price, String date)
    {
        this.itemId = itemId; //same attribute name
        this.itemName = itemName; //same attribute name
        itemPrice = price;
        datePurchase = date;
    }
    
    //setter
    public void setitemId (String itemId)
    {
        this.itemId = itemId;
    }
    
    public void setitemName (String itemName)
    {
        this.itemName = itemName;
    }
    
    public void setitemPrice (double price)
    {
        itemPrice = price;
    }
    
    public void setdatePurchase (String date)
    {
        datePurchase = date;
    }
    
    public void calcTotal(double itemPrice)
    {
        this.itemPrice = itemPrice;
    }
    
    //getter
    public String getitemId()
    {
        return itemId;
    }
    
    public String getitemName()
    {
        return itemName;
    }
    
    public double getitemPrice()
    {
        return itemPrice;
    }
    
    public String getdatePurchase()
    {
        return datePurchase;
    }
    
     public double calcTotal()
    {
        double Price = 0.0;
        Price += itemPrice ;
        return Price;
    }
    
    public String toString()
    {
        return ("Item id: " + itemId + "\nItem Name: "+ itemName + "\nItem Price: " + itemPrice +  "\nDate purchase" + datePurchase + "\n");
    }
}

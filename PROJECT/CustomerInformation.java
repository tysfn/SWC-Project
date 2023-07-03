import java.util.LinkedList;
import java.util.ArrayList;

public class CustomerInformation
{
    private String custId;
    private String custIC;
    private int counterPaid;
    private LinkedList<ItemInformation> itemInformationList;
    
    public CustomerInformation()
    {
        custId = "";
        custIC = "";
        counterPaid = 0;
    }
    
    public CustomerInformation(String custId, String cust_ic, int counterPaid)
    {
        custId = custId; 
        custIC = cust_ic;
        counterPaid = counterPaid;
    }
    
    //setter
    public void setCustomerInfo(String custId, String cust_ic, int counterPaid)
    {
        custId = custId; 
        custIC = cust_ic;
        counterPaid = counterPaid;
    }
    
    public void setcustId (String custId)
    {
        this.custId = custId;
    }
    
    public void setcustIC (String cust_ic)
    {
        custIC = cust_ic;
    }
    
    public void setcounterPaid (int counter)
    {
        counterPaid = counterPaid;
    }
    
    //getter
    public String getcustId()
    {
        return custId;
    }
    
    public String getcustIC()
    {
        return custIC;
    }
    
    public int getcounterPaid()
    {
        return counterPaid;
    }
    
    public ArrayList <ItemInformation> getallItem()
    {
        return null;
    }
    
    public String toString()
    {
        return ("Customer id: " + custId + "\nCustomer ic: "+ custIC + "\nCounter: " + counterPaid +  "\n");
    }
}

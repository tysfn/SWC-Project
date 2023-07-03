import java.util.*;
import java.io.*;
import javax.swing.*;
import java.util.Stack;

public class HypermarketSelfSystem 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Read customer information and items purchased from the input file
            BufferedReader in = new BufferedReader(new FileReader("customerList.txt"));

            LinkedList<CustomerInformation> customerList = new LinkedList<>();
            ArrayList<ItemInformation> itemList = new ArrayList();
            Stack<CustomerInformation> qCompleteStack = new Stack<>();
            
            Queue qCustomer = new Queue();
            Queue qCounter1 = new Queue();
            Queue qCounter2 = new Queue();
            Queue qCounter3 = new Queue();
            
            String indata = null;

            CustomerInformation custInfo;
            ItemInformation itemInfo;

            while((indata = in.readLine())!=null)
            {
                StringTokenizer st = new StringTokenizer(indata, ";");
                String custId= st.nextToken();
                String custIC = st.nextToken();
                int counterPaid = Integer.parseInt(st.nextToken());
                //String datePurchase = st.nextToken();

                LinkedList<ItemInformation> itemInformationList = new LinkedList<>();
                StringTokenizer dc = new StringTokenizer (indata, ":");
                while(dc.hasMoreTokens())
                {
                    StringTokenizer sr = new StringTokenizer(indata, ",");
                    String itemId= sr.nextToken();
                    String itemName = sr.nextToken();
                    double itemPrice = Double.parseDouble(sr.nextToken());
                    String datePurchase = st.nextToken();

                    //create object
                    itemInfo = new ItemInformation( itemId,itemName,itemPrice, datePurchase);      
                    //enqueue in queue
                    qCustomer.enqueue(itemInfo);
                }
                
                //create  object for custInfo
                custInfo = new CustomerInformation(custId, custIC,counterPaid);
                //enqueue in queue 
                qCustomer.enqueue(custInfo);
            }
            in.close();

            for (int i=0; i<3; i++)
            {
                custInfo = (CustomerInformation) qCustomer.dequeue();
                qCounter1.enqueue(custInfo);                
            }
            
            for (int i=0; i<3; i++)
            {
                custInfo = (CustomerInformation) qCustomer.dequeue();
                qCounter2.enqueue(custInfo);                
            }
            int menu = 0;
            do
            {
                String input;
                double price;

                //ask cust to enter the menu
                input = JOptionPane.showInputDialog("Menu 1 - Remove and add new customer at Counter 1 \n Menu 2 - Remove and add new customer at Counter 2 \nMenu 3 - Remove and add new customer at Counter 3 \nMenu 4- Exit and Display completed customer");
                menu= Integer.parseInt(input);
                
                //price = itemInfo.calcTotal();

                if (menu == 1)
                {
                    while (!qCounter1.empty())
                    { 
                        //remove 1 customer from counter 1
                        custInfo = (CustomerInformation) qCounter1.dequeue();

                        //add new customer into counter 1
                        qCounter1.enqueue(qCustomer.dequeue());

                        //set the total payment
                        //itemList.setitemPrice(price);

                        //add into qCompleted
                        qCompleteStack.push(custInfo);

                        //ask user either to continue or to stop
                        String answer = JOptionPane.showInputDialog("Do you want to continue remove customer? (Yes/No)");

                        if(answer.equalsIgnoreCase("Yes"))
                        {
                            continue;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else if (menu == 2)
                {
                    while (!qCounter2.empty())
                    {
                        //remove 1 customer from counter 1
                        custInfo = (CustomerInformation) qCounter2.dequeue();

                        //add new customer into counter 1
                        qCounter2.enqueue(qCustomer.dequeue());

                        //set the total payment
                        //itemInfo.setitemPrice(price);

                        //add into qCompleted
                        qCompleteStack.push(custInfo);

                        //ask user either to continue or to stop
                        String answer = JOptionPane.showInputDialog("Do you want to continue rwmove customer? (Yes/No)");
                        if(answer.equalsIgnoreCase("Yes"))
                        {
                            continue;
                        }
                        else
                        {
                            break;
                        }
                    }
                }else if (menu == 3)
                {
                    while (!qCounter3.empty()){
                        custInfo = (CustomerInformation)qCounter3.dequeue();//remove one cust from counter 1
                        //add cust from waiting list in qCustomer to counter 1
                        qCounter3.enqueue(qCustomer.dequeue());

                        //calc
                        //itemInfo.setitemPrice(price);

                        //add into qCompleted
                        qCompleteStack.push(custInfo);

                        //ask user either to continue or not
                        String answ = JOptionPane.showInputDialog("Do you wish to continue? (yes/no)");

                        if(answ.equalsIgnoreCase("yes")){
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                } 
                else if(menu==4)
                {
                    System.out.println ("Paid customer");
                    while(!qCompleteStack.empty())
                    {
                        CustomerInformation customer = qCompleteStack.pop();
                        System.out.println("Customer ID: " + customer.getcustId());
                        System.out.println("Counter Paid: " + customer.getcounterPaid());
                        System.out.println("Items Purchased:");

                        double totalPrice = 0.00;
                        for (ItemInformation item : customer.getallItem()) {
                            System.out.println("Item ID: " + item.getitemId());
                            System.out.println("Item Name: " + item.getitemName());
                            System.out.println("Item Price: " + item.getitemPrice());
                            System.out.println("Date Purchased: " + item.getdatePurchase());
                            System.out.println("Total Price: " + item.calcTotal());

                            totalPrice += item.getitemPrice();
                        }

                        System.out.println();
                    }
                    break;
                    } 
                }while(menu!=4);
            //display all completed customer
            while(!qCompleteStack.empty())
            {
                custInfo = (CustomerInformation) qCompleteStack.pop();
                System.out.println(custInfo);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        }
}

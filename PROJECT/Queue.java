//import the LinkedList package
import java.util.LinkedList;

public class Queue
{
    private LinkedList q; //Declare the object of the queue using LinkedList
    int size =0;
    
    //Constructor w/o parameter
    public Queue()
    {
        q = new LinkedList();
    }//end of contructor
    
    
    //method to insert an object to a queue
    public void enqueue(Object item)
    {
        q.addLast(item);
        //size++;
    }
    
    //to remove object
    public Object dequeue()
    {
        if (!empty())
        {
            //size--;
            return q.removeFirst();//remove the first element
        }
        System.out.println("Queue is empty!");
        return 0;
    }
    
    //method to test whether the queue is empty or not
    public boolean empty()
    {
        return (q.size() == 0);
    }
        
    //returun  the elemeny at the front w/o removing it
    public Object front()
    {
        if(!empty())
            
            return q.getFirst();
            
        else 
            System.out.println("Queue is empty");
        return 0;
    }
}

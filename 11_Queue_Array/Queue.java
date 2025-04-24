package Array_Queue;


public interface Queue {
    public void add(Object obj);  // Adds an object to the queue
    public Object first();        // Returns the first element in the queue
    public Object remove();       // Removes and returns the first element in the queue
    public int size();            // Returns the size of the queue
}
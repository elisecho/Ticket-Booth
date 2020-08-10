import ch04.queues.ArrayBoundedQueue;
import ch04.queues.QueueUnderflowException;
import java.util.*;

public class TixQueue extends ArrayBoundedQueue<TixOrder> implements Runnable{

    // Fields
    private int totTix;
    private int pause;

    // Constructor
    public TixQueue(int totTix, int pause) {
        this.totTix = totTix;
        this.pause = pause;
    }

    @Override
    public void run() {
        System.out.println("Run Method - Thread: " + Thread.currentThread().getName());
        while (true) {
            System.out.println(dequeueOrder());
        }
    }

    // Method to remove orders from the que
    public String dequeueOrder() {
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isEmpty()){
            return "No Orders in the queue";
        } else {
            System.out.println("DQ Oder - Thread: " + Thread.currentThread().getName());
            String status = "";

            // Dequeue the first item in the queue save it variable currOrder
            TixOrder currOrder = dequeue();

            // If the order is requesting more tickets than available Status = FALSE
            if (totTix < currOrder.getTixCount()) {
                status = "Not enough tickets were available to complete this order.";
            } else {
                status = "Order was successful!!";
                removeTix(currOrder.getTixCount());
            }

            return "*************************************************" +
                    "\nORDER NUMBER: " + getOrderNumber() +
                    "\nTIME STAMP: " + getTimeStamp() +
                    "\nName: " + currOrder.getName() +
                    "\nOrder Status: " + status +
                    "\nTickets Requested: " + currOrder.getTixCount() +
                    "\nTickets Available: " + totTix +
                    "\n*************************************************";
        }
    }

    // Method to reduce the number of tickets
    public void removeTix(int count) {
        totTix = totTix - count;
    }


    // GETTERS
    // Method to retrieve the date and time
    public String getTimeStamp() {
        Date now = new Date();
        return now.toString();
    }

    // Method to create an order number
    public int getOrderNumber() {
        String s = getTimeStamp();
        return Math.abs(s.hashCode());
    }

    // Method to get the current total number of tickets
    public int getTotTix() {
        return totTix;
    }
}
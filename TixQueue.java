import ch04.queues.ArrayBoundedQueue;
import ch04.queues.QueueUnderflowException;

import java.util.*;

public class TixQueue extends ArrayBoundedQueue<TixOrder> implements Runnable {

    // Fields
    private int totTix;
    private int pause;

    // Constructor
    public TixQueue(int totTix, int pause) {
        this.totTix = totTix;
        this.pause = pause;
    }

    // Method to get Total Ticket Count
    public int getTotTix() {
        return totTix;
    }

    public void removeTix(int count) {
        totTix = totTix - count;
    }

    public String dequeueOrder() {
        while (totTix > 0) {
            String status = "";

            // Dequeue the first item in the queue save it variable currOrder
            TixOrder currOrder = dequeue();

            // If the order is requesting more tickets than available Status = FALSE
            if (totTix < currOrder.getTixCount()) {
                status = "Not enough tickets were available to complete this order.";
            }
            else {
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
        return null; // the program wont let me add the original retrun statement??
    }

//    @Override
//    public T dequeue()
//    // Throws QueueUnderflowException if this queue is empty;
//    // otherwise, removes front element from this queue and returns it.
//    {
//        if (isEmpty())
//            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
//        else
//        {
//            T toReturn = elements[front];
//            elements[front] = null;
//            front = (front + 1) % elements.length;
//            numElements = numElements - 1;
//            return toReturn;
//        }
//    }

    public String getTimeStamp() {
        Date now = new Date();
        return now.toString();
    }

    public int getOrderNumber() {
        String s = getTimeStamp();
        return Math.abs(s.hashCode());
    }

    @Override
    public void run() {
        try {
            dequeueOrder();
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
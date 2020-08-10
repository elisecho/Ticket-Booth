import ch04.queues.ArrayBoundedQueue;

public class QueueProcessing {

    public static void main(String[] args) {

        // Create new Ticket Queue
        TixQueue newTixQue = new TixQueue(10,10000);

        // Move the new Ticket Queue object into the second thread
        Thread t = new Thread(newTixQue);
        t.start();

//        TixOrder testOrder = new TixOrder("Someone", 3);
//        newTixQue.enqueue(testOrder);
//        testOrder.order();

        System.out.println("Current available tickets: " + newTixQue.getTotTix());

        boolean contRun = true;

        do {
            // Create amd enqueue a ticket order
            TixOrder orderOne = new TixOrder();
            newTixQue.enqueue(orderOne);
        } while (contRun);


//        // Create and enqueue order 2
//        TixOrder orderTwo = new TixOrder();
//        newTixQue.enqueue(orderTwo);
//        System.out.println(newTixQue.dequeueOrder());
//
//        // Process orders

    }
}
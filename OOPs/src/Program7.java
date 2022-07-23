import java.util.ArrayList;

public class Program7 {
    public static void main(String[] args) throws InterruptedException {
        Market m = new Market(2);

        Thread farmer = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    m.produce("Apple");
                    m.produce("Mango");
                    m.produce("RipedMango");
                    m.produce("Orange");
                }catch (Exception e){
                   e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    m.consume();
                    m.consume();
                    m.consume();
                    m.consume();
                }catch (Exception e){
                  e.printStackTrace();
                }
            }
        });
        farmer.start();
        consumer.start();

        farmer.join();
        consumer.join();

    }
}
class Market {
    int fruitsNo;
    ArrayList<String> fruits;


    public Market(int fN) {
        fruits = new ArrayList<>();

        this.fruitsNo = fN;
    }

    synchronized boolean isFull() {
        return fruits.size() == fruitsNo;
    }

    synchronized boolean isEmpty() {
        return fruits.size() == 0;
    }

    public void produce(String str) throws InterruptedException {
        synchronized (this) {
            while (isFull())
                wait();
            System.out.println("Farmer produced " + str);
            fruits.add(str);
            notify();
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (isEmpty()) wait();
            String str1 = fruits.remove(0);
            System.out.println("Consumer consumed " + str1);

            notify();
            Thread.sleep(1000);
        }
    }
}

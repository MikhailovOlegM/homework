package threadsmu;

public class Main {

  public static void main(String[] args) {

    Count count = new Count();
    MyIncrement myIncrement = new MyIncrement(count);

    while (!count.isFinish()) {
      Thread t1 = new Thread(myIncrement);
      Thread t2 = new Thread(myIncrement);
      Thread t3 = new Thread(myIncrement);

      t1.setName("1");
      t2.setName("2");
      t3.setName("3");

      t1.start();
      t2.start();
      t3.start();

      try {
        t1.join();
        t2.join();
        t3.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  private static class MyIncrement implements Runnable {

    private Count count;

    public MyIncrement(Count count) {
      this.count = count;
    }

    @Override
    public void run() {
      int numberThread = Integer.parseInt(Thread.currentThread().getName());
      if (count.getCount() != numberThread) {
        try {
          Thread.currentThread().wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else {
        notify();
        count.increment();
      }
    }
  }


}


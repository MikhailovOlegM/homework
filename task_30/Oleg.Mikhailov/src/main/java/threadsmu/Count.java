package threadsmu;


public class Count {

  private int count = 1;

  public Count() {
    this.count = count;
  }

  public void increment() {
    count++;
    String name = Thread.currentThread().getName();
    System.out.println(Thread.currentThread().getName() + " thread - " + count);
  }

  public int getCount() {
    return count;
  }

  public boolean isFinish() {
    if (count >= 100) {
      return true;
    }
    return false;
  }
}

package philosophers;

public class Philosopher implements Runnable{
    private ThreadLocal<Integer> threadCount= new ThreadLocal<>();
    private final Object monitor;
    Philosopher(){
        this.monitor = Philosopher.class;
    }
    @Override
    public void run() {
         if(threadCount.get()==null){
            threadCount.set(3);
        }
        while (threadCount.get() > 0) {
            synchronized (monitor) {
                try {
                    System.out.println("Обедает " + Thread.currentThread().getName());
                    Thread.sleep(500);
                    monitor.notifyAll();
                    monitor.wait();
                    threadCount.set(threadCount.get() - 1);
                    Thread.sleep(500);
                    if(threadCount.get()==0){
                        monitor.notify();
                   }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Завершение работы "+Thread.currentThread().getName());
    }
}

package philosophers;

public class Main {
    /**
     * Есть пять философов (потоки), которые могут либо обедать (выполнение кода) либо размышлять (ожидание).
     * Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
     * После каждого приема пищи философ должен размышлять
     * Не должно возникнуть общей блокировки
     * Философы не должны есть больше одного раза подряд
     * @param args
     */
    public static void main(String[] args) {
        Thread philosopher1 = new Thread(new Philosopher(), "Philosopher-1");
        Thread philosopher2 = new Thread(new Philosopher(), "Philosopher-2");
        Thread philosopher3 = new Thread(new Philosopher(), "Philosopher-3");
        Thread philosopher4 = new Thread(new Philosopher(), "Philosopher-4");
        Thread philosopher5 = new Thread(new Philosopher(), "Philosopher-5");
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();
    }
}

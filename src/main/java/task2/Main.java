package seminar;

public class Main {
    /**
     * Создайте два потока A и B.
     * Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд (true в состояние false и наоборот).
     * Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100 с задержкой 100 миллисекунд
     * и приостанавливает свое действие, как только поток A переключит switcher в состояние false.
     * Условием завершения работы потоков является достижение отсчета нулевой отметки.
     * Можно воспользоваться синхронизацией для управления значения переменной или volatile
     * @param args
     */
    static boolean switcher=false;
    static int counter=25;
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(()-> {
            while (counter>0) {
                try {
                    switcher=!switcher;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadB= new Thread(()->{
            while (counter>0){
                if(!switcher) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    try {
                        System.out.println(counter--);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        threadB.start();
        threadA.start();
    }
}

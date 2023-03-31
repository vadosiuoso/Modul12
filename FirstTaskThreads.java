import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FirstTaskThreads {
    public static void main(String[] args) {
        long startProgramTime = System.currentTimeMillis();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                    long currentTime = System.currentTimeMillis() - startProgramTime;
                    LocalTime localTime = LocalTime.ofNanoOfDay(currentTime * 1_000_000);
                    String formattedTime = localTime.format(formatter);
                    System.out.format("З моменту запуску програми пройшло %s \n",formattedTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Пройшло 5 секунд");
            }
        }).start();
    }
}

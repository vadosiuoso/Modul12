public class SecondTaskThreads {
    private int n;
    private int currentNumber;
    private static StringBuilder builder = new StringBuilder();
    public SecondTaskThreads(int n){
        this.n = n;
        currentNumber = 1;
    }

    public static void main(String[] args) throws InterruptedException {
        SecondTaskThreads task = new SecondTaskThreads(150);
        new Thread(() -> {
            task.fizz();
        }).start();
        new Thread(() -> {
            task.buzz();
        }).start();
        new Thread(() -> {
            task.fizzbuzz();
        }).start();
        new Thread(() -> {
            task.number();
        }).start();

        Thread.sleep(300);
        String result = builder.append(".").toString().replaceAll(" ", ", ");
        System.out.println(result);
    }

    private synchronized void number() {
        while (currentNumber <= n){
            if(currentNumber % 3 != 0 && currentNumber % 5 != 0){
                builder.append(currentNumber);
                if (currentNumber != n) builder.append(" ");
                currentNumber++;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        notifyAll();
    }

    private synchronized void fizzbuzz() {
        while (currentNumber <= n){
            if(currentNumber % 3 == 0 &&  currentNumber % 5 == 0){
                builder.append("fizzbuzz");
                if (currentNumber != n) builder.append(" ");
                currentNumber++;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        notifyAll();
    }

    private synchronized void buzz() {
        while (currentNumber <= n){
            if(currentNumber % 5 == 0 && currentNumber % 3 != 0){
                builder.append("buzz");
                if (currentNumber != n) builder.append(" ");
                currentNumber++;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        notifyAll();
    }

    private synchronized void fizz() {
        while (currentNumber <= n){
            if(currentNumber % 3 == 0 && currentNumber % 5 != 0){
                builder.append("fizz");
                if (currentNumber != n) builder.append(" ");
                currentNumber++;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        notifyAll();
    }
}

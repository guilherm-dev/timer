import java.util.*;

public class Timerr {
    static Scanner scanner = new Scanner(System.in);
    static Timer timer = new Timer();

    public static void main(String[] args) {
        Menu();
        scanner.close();
    }

    static void Menu() {
        System.out.println("S = seg -> 10s = 10 seconds");
        System.out.println("M = min -> 1m = 1 minute");
        System.out.println("H = hour -> 1h = 1 hour");
        System.out.println("D = day -> 1d = 1 day");
        System.out.println("0 = Exit");
        System.out.println("How much time do you want to count?");

        String timeInput = scanner.nextLine().toLowerCase();

        if (timeInput.equals("0")) {
            System.out.println("Exiting...");
            return;
        }

        char type = timeInput.charAt(timeInput.length() - 1);
        int time = Integer.parseInt(timeInput.substring(0, timeInput.length() - 1));
        int multiplier;

        switch (type) {
            case 's':
                multiplier = 1000;
                break;
            case 'm':
                multiplier = 1000 * 60;
                break;
            case 'h':
                multiplier = 1000 * 3600;
                break;
            case 'd':
                multiplier = 1000 * 86400;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                Menu();
                return;
        }

        final int delay = time * multiplier;
        int remainingTime = delay;

        numbersOnScreen(time);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                timer.cancel(); // Stops the timer after the specified time
            }

            @Override
            public boolean cancel() {
                System.out.println("Timer cancelled by user.");
                return super.cancel();
            }
        }, delay, 1000);

        // Countdown timer display
        System.out.println("Countdown started...");
        while (remainingTime > 0) {
            System.out.println( (remainingTime / 1000) + " seconds");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            remainingTime -= 1000;
        }
    }

    static void numbersOnScreen(int time) {
        System.out.println("Ready...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Set...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Go...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

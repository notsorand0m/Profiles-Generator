import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main implements Runnable{

    // Change if needed
    private int counter = 20;

    private int nameCnt = 0;

    List<String> names = List.of("Gray", "Martin", "Jason", "Fill", "John", "Peter", "Paul");
    List<String> cities = List.of("Plovdiv, Bulgaria", "Sofia, Bulgaria", "London, UK", "Paris, France", "Atina, Greece", "California, USA", "Ruse, Bulgaria");

    public static void main(String[] args) {

        ExecutorService user = Executors.newFixedThreadPool(1000);

        Thread thread = new Thread(new Main());

        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Enter how much user accounts you want to create (max 7): ");
            int input = scanner.nextInt();

            for(int i = 0; i < input; i++) {
                user.submit(thread);
            }

        }
        finally{
            user.shutdown();
        }
    }



    @Override
    public void run() {
        // Use synchronized(this) to generate parallely combined profiles and not random ones
        System.out.println(names.get(nameCnt++) + " | " + ++counter + " | " + cities.get(nameCnt));
    }
}

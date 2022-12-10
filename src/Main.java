import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String[] input = getInput();
            System.out.println(actionData(input));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String[] getInput() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("input.txt");
        Scanner scan = new Scanner(fis);
        String[] input = new String[145];
        for (int i = 0; i < input.length; i++) {
            input[i] = scan.nextLine();
        }
        return input;
    }

    public static int actionData(String[] input) {
        ArrayList<Integer> values = new ArrayList<>();
        int cycle = 0;
        int x = 1;
        for (int i = 0; i < input.length; i++) {
            if (i == 130) {
                System.out.println();
            }
            String operation = input[i].substring(0,4);
            if (operation.equals("noop")) {
                cycle ++;
                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                    values.add(cycle * x);
                }

            }else if (operation.equals("addx")) {
                int xAmount = Integer.parseInt(input[i].substring(5));
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        cycle++;
                        if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                            values.add(cycle * x);
                        }
                    } else if (j > 0) {
                        cycle++;
                        if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                            values.add(cycle * x);
                        }
                        x += xAmount;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
            sum += values.get(i);
        }
        return sum;
    }
}
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){

        try (FileOutputStream fos = new FileOutputStream("text.txt")) {

            byte[] buffer = "  Hell8o! 45  How8  92  are you 7, my friend??? 45 0 9  ".getBytes();
            fos.write(buffer);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try (FileInputStream fis = new FileInputStream("text.txt")) {

            byte[] buffer = new byte[256];

            int count;
            String newText = "";
            while((count=fis.read(buffer))!=-1){

                for(int i=0; i<count;i++){

                    newText += (char)buffer[i];

                    System.out.print((char)buffer[i]);
                }

                System.out.println();
            }

            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher numbers = pattern.matcher(newText);

            int sum = 0;
            var numbersSet = new HashSet<Integer>();

            while (numbers.find()) {

                System.out.println("Число: " + numbers.group());
                sum += Integer.parseInt(numbers.group());
                numbersSet.add(Integer.parseInt(numbers.group()));
            }

            System.out.println(sum);

            sum = 0;
            for (int number : numbersSet) {
                System.out.println("Число: " + number);
                sum += number;
            }

            System.out.println(sum);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
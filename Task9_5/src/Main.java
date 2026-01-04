import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){

        try (FileOutputStream fos = new FileOutputStream("text.txt")) {

            byte[] buffer = "  Hello! How  are you, my friend???  ".getBytes();
            fos.write(buffer);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try (FileInputStream fis = new FileInputStream("text.txt")) {

            byte[] buffer = new byte[256];
            System.out.println("File data:");

            int count;
            String newText = "";
            while((count=fis.read(buffer))!=-1){

                for(int i=0; i<count;i++){

                    newText += (char)buffer[i];

                    System.out.print((char)buffer[i]);
                }

                System.out.println();
            }

            int nWords = newText.trim().split("\\s+").length;

            Pattern pattern = Pattern.compile("[,!.;:?]");
            Matcher punctuation = pattern.matcher(newText);

            int nPunctuation = 0;
            while (punctuation.find()) {
                nPunctuation++;
            }

            System.out.printf("Количество слов: %d, количество знаков препинания: %d", nWords, nPunctuation);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
import java.io.File;

public class Main {

    public static void main(String[] args){

        File dir = new File("D://My//EFCON");

        if (dir.isDirectory() && dir.exists()) {

            System.out.println("Каталоги:");

            for(File item : dir.listFiles()) {

                if (item.isDirectory()) {
                    System.out.println(item.getName());
                }
            }

            System.out.println("Файлы:");

            for(File item : dir.listFiles()){

                if (item.isFile()) {
                    System.out.println(item.getName());
                }
            }
        }
    }
}
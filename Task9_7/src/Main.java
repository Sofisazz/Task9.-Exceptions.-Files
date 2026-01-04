import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        var people = new ArrayList<Person>();

        for (int i = 1; i < 11; i++) {
            people.add(new Person("Person " + i, "Surname person " + i, new Random().nextInt(15) + 15));
        }

        writePeople(people);
        printPeople(people.size());
    }

    public static void writePeople(ArrayList<Person> people) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {

            for (Person person : people) {
                oos.writeObject(person);
            }
        }
        catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public static void printPeople(int n) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat")))
        {
            for (int i = 0; i < n; i++) {
                Person p = (Person) ois.readObject();
                System.out.printf("Name: %s \t Surname: %s \t Age: %d \n", p.getName(), p.getSurname(), p.getAge());
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
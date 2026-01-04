public class Main {

    public static void main(String[] args){

        try {
            Product mobile = new Product("Мобильный телефон", 15847);
            Product doll = new Product("Лабубу", -10);
        }
        catch (ProductPriceException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
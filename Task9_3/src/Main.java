public class Main {

    public static void main(String[] args) {

        try {
            createProduct("Мобильный телефон", 15847);
            createProduct("Лабубу", -10);
        }
            catch (ProductPriceException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }

    public static void createProduct(String name, double price) throws ProductPriceException{

        Product product = new Product(name, price);
    }
}
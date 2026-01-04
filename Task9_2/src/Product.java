public class Product {

    private String name;
    private double price;

    Product(String name, double price) throws ProductPriceException {
        this.name = name;

        if (price < 0) throw new ProductPriceException("Цена продукта не может быть меньше 0.");
        this.price = price;
    }
}

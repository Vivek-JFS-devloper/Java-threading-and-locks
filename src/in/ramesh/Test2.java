package in.ramesh;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

		Map<String, Long> collect = words.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(collect);

		List<Product> products = Arrays.asList(new Product(1, 100, "Footwear"), new Product(1, 200, "Footwear"),
				new Product(3, 300, "C"));
		 List<Product> collect2 = products
				 .stream()
				 .filter(c->c.getCategory()=="Footwear")
		
		.map(price-> new Product(price.getProduct_id(), price.getPrice() - (price.getPrice() * 15 / 100), price.getCategory()))
			 
		 .collect(Collectors.toList());
		 
		 System.out.println(collect2);
	}
}

class Product {
	private int product_id;
	private double price;
	private String category;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(int product_id, double price, String category) {
		super();
		this.product_id = product_id;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", price=" + price + ", category=" + category + "]";
	}

	// Getters and setters

}

//Find all the products which belong to “Footwear” category and apply 15% discount on them.

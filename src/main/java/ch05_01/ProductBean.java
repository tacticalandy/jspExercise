package ch05_01;
 
public class ProductBean implements java.io.Serializable {
  	private static final long serialVersionUID = 1L;
  	private String productNo ;
    private String name ;
    private double price;
    private double weight;

	public ProductBean() {
	}
	public ProductBean(String productNo, String name, double price,
			double weight) {
		this.productNo = productNo;
		this.name = name;
		this.price = price;
		this.weight = weight;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
    
}

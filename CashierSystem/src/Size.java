import java.io.Serializable;


public class Size implements Serializable{
	private static final long serialVersionUID = 8564339533244105994L;
	private String size;
	private double price;
	public Size(){
		
	}
	public Size(String size, double price){
		this.setSize(size);
		this.setPrice(price);
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

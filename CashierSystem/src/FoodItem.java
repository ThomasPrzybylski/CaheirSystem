import java.io.Serializable;
public class FoodItem implements Serializable {
	private static final long serialVersionUID = -1768768613979009009L;
private String name;
private int quantity;
private LinkedList<Size> size = new LinkedList<Size>();
private String description;
private SpecialOrder special;
public FoodItem(){
	
}
public FoodItem(String name, LinkedList<Size> size, String Discription, SpecialOrder special){
	this.setName(name);
	this.setSize(size);
	this.setDescription(Discription);
	this.setSpecial(special);
}
public FoodItem(String name, String size, double price, String Discription, SpecialOrder special){
	this.setName(name);
	this.addToSize(new Size(size, price));
	this.setDescription(Discription);
	this.setSpecial(special);
}
public FoodItem(String name) {
	this.setName(name);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LinkedList<Size> getSize() {
	return size;
}
public void setSize(LinkedList<Size> size) {
	this.size = size;
}
public void addToSize(Size size) {
	if(this.size.isEmpty())
	this.size.addFirst(size);
	else
		this.size.add(size);
	
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public SpecialOrder getSpecial() {
	return special;
}
public void setSpecial(SpecialOrder special) {
	this.special = special;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}

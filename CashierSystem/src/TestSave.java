
public class TestSave {

	public static void main(String[] args) {
		
		FoodItem node = new FoodItem("French Fries", "Small", 1.75, "Thin potato fries, fried in penut oil, and lightly dusted with Cajin spices.", new SpecialOrder(false,"invalid"));
		Catagory cat = new Catagory();
		CatagoryNode appetizers = new CatagoryNode("appetizers");
		appetizers.add(node);
		cat.add(appetizers);
		IOSys.writeToBinary("save.dat", cat);

	}

}

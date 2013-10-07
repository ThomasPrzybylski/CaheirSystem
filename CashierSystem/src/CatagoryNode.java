import java.io.Serializable;


public class CatagoryNode extends LinkedList<FoodItem>implements Serializable{
	public CatagoryNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 9051670242141223460L;
	private String catagoryName;
	private CatagoryNode nextCatagory;

	public CatagoryNode(String name){
		this.setCatagoryName(name);
	}

	public CatagoryNode getNextCatagory() {
		return nextCatagory;
	}

	public void setNextCatagory(CatagoryNode nextCatagory) {
		this.nextCatagory = nextCatagory;
	}

	public String getCatagoryName() {
		return catagoryName;
	}
	public LinkedListNode<FoodItem> getFirstFoodList(){
		return super.list;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	
}

import java.io.Serializable;
public class Catagory extends LinkedList<CatagoryNode> implements Serializable {
	public Catagory() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -1531659951550468563L;

	public boolean contains(FoodItem foodItem) {
		LinkedListNode<CatagoryNode> temp;
		temp = super.list;
		CatagoryNode newTemp = temp.getElement();
		return newTemp.contains(foodItem);
		
	}

	public String[] toStringArray() {
		LinkedListNode<CatagoryNode> temp;
		temp = super.list;
		String[] strtemp = new String[20];
		int count = 0; 
		while(temp.getLink() != null)
		{
			strtemp [count] = temp.element.getCatagoryName();
			temp = temp.getLink();
			count++;
		}
		strtemp [count] = temp.element.getCatagoryName();
		return strtemp;
	}

}

import java.io.Serializable;


public class LinkedListNode <T>implements Serializable{
	private static final long serialVersionUID = 1309233252071755461L;
	T element;
	LinkedListNode <T> link;
	
	public LinkedListNode(T element) {
		super();
		this.element = element;
		this.link = null;
	}
	
	public LinkedListNode(T element, LinkedListNode <T> link) {
		super();
		this.element = element;
		this.link = link;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public LinkedListNode <T> getLink() {
		return link;
	}
	public void setLink(LinkedListNode <T>link) {
		this.link = link;
	}
}

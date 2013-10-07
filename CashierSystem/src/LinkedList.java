import java.io.Serializable;

public class LinkedList <T> implements Serializable {
	private static final long serialVersionUID = -7190134783779455027L;
	public LinkedListNode <T> list;
	public int count=0;

	public LinkedList() {
		list = null;
	}
	public void add(T element) 
	{
		LinkedListNode<T> temp = list;
		if(isEmpty())
		{
			addFirst(element);
		}
		else
		{
			
		try {
			while (temp.getElement() != null)
			{
				temp = (LinkedListNode<T>) temp.getLink();
			}
		
			
		temp.setLink(new LinkedListNode<T>(element));
		} catch (Exception e) {
			addFirst(element);
		}
		}
		
		count++;
	}
	
	public void addFirst(T element)
	{
	LinkedListNode <T> newNode = new LinkedListNode<T>(element, list);
		list = newNode;
		count++;
	}

	public T remove(T element) {
		if(!isEmpty())
		{
			LinkedListNode<T> temp = list;
			if(list.getElement() == element)
			{
				T out = temp.getElement();
				pop();
				return out;
			}	
			while (temp.getElement() != element)
			{
				if(temp.getLink() != null)
				{
					if(temp.getLink().getElement() != element)
					{
						temp = (LinkedListNode<T>) temp.getLink();
					}
					else
					{
						T out = (T) temp.getLink().getElement();
						temp.setLink((LinkedListNode<T>) temp.getLink().getLink());
						count--;
						return out;
					}
				}
				else
					return null;
			}
			return null;
		}
		return null;
	}


	public T pop() {
		T temp = list.getElement();
		list = list.getLink();
		count--;
		return temp;
	}

	public boolean contains(T element) {
		LinkedListNode<T> current = list;
		if (!isEmpty()) {
			while (current != null) {
				if (current.getElement().equals(element))
					return true;
				current = current.getLink();
			}
		}
		return false;
	}

	public boolean isEmpty() {
		if (list == null)
			return true;
		else
			return false;
	}

	public int size() {
		return this.count;
	}

	public String toString() {
		String out = "";
		LinkedListNode<T> temp;
		temp = list;
		while (temp != null) {
			out += temp.getElement() + "\n";
			temp = temp.getLink();
		}
		return out;
	}
	public LinkedListNode<T> get(T element){
		LinkedListNode<T> current = list;
		if (!isEmpty()) {
			while (current != null) {
				if (current.getElement().equals(element))
					return current;
				current = current.getLink();
			}
		}
		return null;
	}
		public String [] toStringArray()
		{
			LinkedListNode<T> temp;
			temp = list;
			String[] strtemp = new String[20];
			int count = 0; 
			while(temp.getLink() != null)
			{
				strtemp [count] = (String) temp.getElement();
				temp = temp.getLink();
				count++;
			}
			strtemp [count] = (String) temp.getElement();
			return strtemp;
		}
	}



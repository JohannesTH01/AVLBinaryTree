package uebung02.BinaryTree;

public class IntElement implements Element, Cloneable {
	
	private Integer key;
	
	public IntElement(int i) {
		this.key = i;
	}
	
	public void setKey(int i) {
		this.key = i;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		IntElement element;
		if(arg0 instanceof IntElement) {
			element = (IntElement) arg0;
			if(element.getValue() == this.key)
				return 0;	//identical
			else if(element.getValue() > this.key)
				return 1;	//arg0 is greater
			else if(element.getValue() < this.key)
				return -1;	//arg0 is smaller
			
			
		}
		/**
		 * @return 0 for identical
		 * @return 1 if arg0 > this
		 * @return -1 if arg0 < this
		 * */
		return -1;
	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}
	
	@Override
    public Element clone() { // clone method from interface
		// TODO Auto-generated method stub
		return null;	
	}

	public Integer getValue(){
		return this.key;
	}

}


public class Node {
	private Node link;
	private Object data;
	private String name;
	private int scor;
	
	
	public Node(Object data) {
		
		this.link = null;
		this.data = data;
	}
    public Node(String name,int scor) {
		
		this.link = null;
		this.name=name;
		this.scor=scor;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScor() {
		return scor;
	}
	public void setScor(int scor) {
		this.scor = scor;
	}
	

}

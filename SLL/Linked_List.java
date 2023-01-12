import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Linked_List {
	Node head;
	
	public boolean whileFlag() {
		Node temp=head;
		boolean flag=true;
		while(temp!=null) {
			
			String control=temp.getData().toString();
			if (control.equals("_")) {
				flag= false;
				break;
			}
			temp=temp.getLink();
		}
		return flag;
	}
	public void addToPrevious(int location,Object letter) {
		if (location==1) {
						head.setData(letter);
			
		}
		else {
			Node temp=head;
			
			for(int i =1;i<location;i++) {
				
				temp=temp.getLink();
			}
			
			temp.setData(letter);
			

		}
			}
	public int locationletter(Object letter) {
		Node temp =head;
		int count=0;
		String newLetter=letter.toString();
		
			while(true) {
				count++;
				if (newLetter.equalsIgnoreCase(temp.getData().toString())) {
					break;
				}
				temp=temp.getLink();
			}
			
		
		return count;
	}
	public boolean searchletter(Object letter) {
		String newletter=letter.toString();
		
		boolean flag=false;
		if (head==null) {
			System.out.println("List is empty");
			
		}
		else {
			Node temp=head;
			while(temp!=null) {
				String newTemp=temp.getData().toString();
				if (newTemp.equalsIgnoreCase(newletter)) {
					flag= true;
					break;
				}
				temp=temp.getLink();
			}
		}
			return flag;
	}
	public Object random_letter(int random) {
		if (head==null) {
			System.out.println("List is empty");
			return null;
		}
		else {
			if (random==0) {
				 Object temp_head=head.getData();
				 head=head.getLink();
				 return temp_head;
				
			}
			else {
				Node temp=head;
			Node previous=null;
			for(int i =0;i<random;i++) {
				previous=temp;
				temp=temp.getLink();
			}
			Object temp_data =temp.getData();
			
			previous.setLink(temp.getLink());
			temp=previous;
			return temp_data;
			}
			
		}
	}
	public void writeTXT() throws IOException {
		Node temp=head;
		File file3=new File("D:\\HighScoreTable.txt”");
		 FileWriter fw=new FileWriter(file3);
		 PrintWriter pw = new PrintWriter(fw);
		 
		while(temp!=null) {
			String name=temp.getName().toString();
			String score=String.valueOf(temp.getScor());
			pw.println(name);
			pw.println(score);
			temp=temp.getLink();
		}
		fw.close();
		pw.close();
	}
	public void normal_add(String letter) {
		Node temp=head;
		if (head==null) {
			Node newNode=new Node(letter);
			head=newNode;
		}
		else {
				while(temp.getLink()!=null) {
			temp=temp.getLink();
		}
		Node newNode=new Node(letter);
		temp.setLink(newNode);
		}
	
	}
	public void addscor(String name,int scor) {
		if (head==null) {
			Node newNode=new Node(name,scor);
			head=newNode;
		}
		else if(head.getScor()<scor) {
			Node newNode=new Node(name,scor);
			newNode.setLink(head);
			head=newNode;
		}
		else {
			Node temp=head;
			Node previous=null;
			while(temp!=null&&temp.getScor()>scor) {
				previous=temp;
				temp=temp.getLink();
			}
			if (temp==null) {
				Node newNode=new Node(name,scor);
				previous.setLink(newNode);
			}
			else {
				Node newNode=new Node(name,scor);
				newNode.setLink(previous.getLink());
				previous.setLink(newNode);
			}
		}
		if (size()>10) {
			Node temp=head;
			for(int i =0;i<9;i++) {
				temp=temp.getLink();
						
			}
			temp.setLink(null);
		}
		
	}
	public void add_alphabetical (Object data) {
		if (head==null) {
			Node newNode=new Node(data);
			head=newNode;
		}
		else if(head.getData().toString().compareToIgnoreCase(data.toString())>0) {
			Node newNode=new Node(data);
			newNode.setLink(head);
			head=newNode;
		}
		else {
			Node temp=head;
			Node previous=null;
			while(temp!=null&&(temp.getData().toString()).compareToIgnoreCase(data.toString())<0) {
				previous=temp;
				temp=temp.getLink();
			}
			if (temp==null) {
				Node newNode=new Node(data);
				previous.setLink(newNode);
			}
			else {
				Node newNode=new Node(data);
				newNode.setLink(previous.getLink());
				previous.setLink(newNode);
			}
		}
	}
	
	public int size() {
		if (head==null) {
			return 0;
		}
		else
		{
			Node temp=head;
			int size=0;
			while(temp!=null) 
			{
				temp=temp.getLink();
				size++;
			}
			return size;
			
		}
			
		
	}
	public void dislay() {
		if (head==null) {
			System.out.println("List is empty");
		}
		else
		{
			Node temp=head;
			while(temp!=null) 
			{
				System.out.print(temp.getData()+" ");
				temp=temp.getLink();
			}
		}
	}
	public void displayScore() {
		if (head==null) {
			System.out.println("List is empty");
		}
		else
		{
			Node temp=head;
			while(temp!=null) 
			{
				System.out.println(temp.getName()+" "+temp.getScor());
				temp=temp.getLink();
			}
		}
	}
	public Object select_random_animal(int random) {
		if (head==null) {
			System.out.println("List is empty");
			return null;
		}
		else
		{
			Node temp=head;
			
			for(int i=0;i<random;i++) {
				temp=temp.getLink();
			}
			return temp.getData();
		}
	}
	 
	
	

}





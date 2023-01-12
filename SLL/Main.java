import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Linked_List SLL_1=new Linked_List();
		try {
		      File myObj = new File("D:\\animals.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        SLL_1.add_alphabetical (data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
		//For Add all letters using ascii
		
		Linked_List SLL_2=new Linked_List();
		for(int i=65;i<91;i++) {
			char int_to_ascii=(char)i;
			SLL_2.add_alphabetical (int_to_ascii);
			
		}
		
		Linked_List SLL_3=new Linked_List();
		//score
		try {
		      File myObj2 = new File("D:\\HighScoreTable.txt”");
		      Scanner myReader2 = new Scanner(myObj2);
		      while (myReader2.hasNextLine()) {
		        String name = myReader2.nextLine();
		       String score=myReader2.nextLine();
		       int real_score=Integer.parseInt(score);
		       SLL_3.addscor(name, real_score);
		        //linked_list_for_score.addscor(name, scor);
		       
		      }
		      myReader2.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		  Random rnd = new Random();
		  int random=rnd.nextInt(SLL_1.size());
		  
		  Linked_List SLL_4=new Linked_List();
		  System.out.println("Randomly Generated Number : "+(random+1));
		String random_animal=SLL_1.select_random_animal(random).toString(); 

	
		for(int i =0;i<random_animal.length();i++) {
		SLL_4.normal_add(random_animal.substring(i, i+1));				
		}
		  Linked_List SLL_5=new Linked_List();
		for(int i =0;i<random_animal.length();i++) {
			SLL_5.normal_add("_");			
			}
		
		//game
		int counter_step=1;
		int score=0;
		  
		   int plus_score=0;
		while(true) {
			
			
			
		System.out.print("\nWord : ");SLL_5.dislay();
		random=rnd.nextInt(SLL_2.size());
		Object[] wheel= {10,20,30,"Bankrupt",40,100,200,300,400,"Bankrupt"};
		
		int random_for_score=rnd.nextInt(10);
		System.out.println("\nWheel : "+wheel[random_for_score]);
		
		if (wheel[random_for_score].toString().equals("Bankrupt")) score=0;
			
					
		Object letter=SLL_2.random_letter(random);
		System.out.println("Guess : "+letter);
		
		boolean flag=SLL_4.searchletter(letter);
		if (flag) {
			if (wheel[random_for_score].toString().equals("Bankrupt")) {
				plus_score=0;
			}
			else {
				String for_score=wheel[random_for_score].toString();
				 plus_score=Integer.parseInt(for_score);
			}
			
			score=score+plus_score;
			int location =SLL_4.locationletter(letter);
			SLL_5.addToPrevious(location, letter);
			System.out.println();
			
		}
		if (SLL_5.whileFlag()) {
			System.out.print("Word : ");SLL_5.dislay();
			System.out.println("\n                                                   **********GAME İS OVER*********");
			System.out.println("\n\nYOUR TOTAL SCORE IS : "+score);
			
			SLL_3.addscor("You", score);
			System.out.println();
			SLL_3.writeTXT();
			SLL_3.displayScore();
			
			break;
		}
		System.out.print("                             Step:  "+counter_step);
		System.out.print("                                            Score:  "+score);
		counter_step++;
		System.out.println();
		}
		
		
	
		
		  
		  }

	}



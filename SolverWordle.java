import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class SolverWordle {
	public static void main(String[] args) throws IOException {

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Please enter the letters to include:");
	    String lettersInclude = scanner.nextLine().toUpperCase();
	    System.out.println("Please enter the letters to exclude:");
	    String lettersExclude = scanner.nextLine().toUpperCase();
	    System.out.println("Please enter word code, with * as unknown letters");
	    String wordCode = scanner.nextLine().toUpperCase();
	    
	    BufferedReader reader = new BufferedReader(new FileReader("./src/dictionary.txt"));
	   
	    System.out.println("All possible words you can make with those letters:");
	   
	    String line = reader.readLine();
	    while (line != null) {
	    	if (line.length() == 5) {
	    		HashSet<Character> setWord = new HashSet<Character>();
	    	    for (int i = 0; i < 5; i++) {
	    	    	setWord.add(line.charAt(i));
	    	    }
	    	    
	    	    boolean isMatch = true;
	    	    for (int i = 0; i < lettersInclude.length(); i++) {
	    	    	if (!setWord.contains(lettersInclude.charAt(i))) {
	    	    		isMatch = false;
	    	    	}
	    	    }
	    	    for (int i = 0; i < lettersExclude.length(); i++) {
	    	    	if (setWord.contains(lettersExclude.charAt(i))) {
	    	    		isMatch = false;
	    	    	}
	    	    }
	    	    
	    	    for (int i = 0; i < 5; i++) {
	    	    	char letter;
	    	    	if (wordCode.length() <= i) {
	    	    		letter = '*';
	    	    	} else {
	    	    		letter = wordCode.charAt(i);
	    	    	}
	    	    	if (letter != ' ' && letter != '*') {
	    	    		if (letter != line.charAt(i)) {
	    	    			isMatch = false;
	    	    		}
	    	    	}
	    	    }
	    	    
	    	    
	    	    
	    	    if (isMatch) {
	    	    	System.out.println(line);
	    	    }
	    	}
	    	
	    	
	    	line = reader.readLine();
	    }
	    scanner.close();
	    reader.close();
	  }

	  
}

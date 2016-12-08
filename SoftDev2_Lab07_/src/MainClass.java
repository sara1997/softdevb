import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class MainClass {
	
	public static void main(String[]args){
	
	Set<String> strings = new TreeSet<String>();
	System.out.println("the size is "+strings.size());
	strings.add("Mary");
	strings.add("sara");
	strings.add("shannon");
	strings.add("peter");
	strings.add("Annie");
	
	for(String currentString : strings){
		System.out.println(currentString);
	}
	strings.remove("Mary");
	System.out.println("the size is now "+strings.size());
	
	
	Set<String> strings2 = new HashSet<String>();
	strings2.add("tom");
	strings2.add("carl");
	strings2.add("sandra");
	strings2.add("aoifa");
	strings2.add("jim");
	
	List<String> newList = new ArrayList<String>();
	newList.addAll(strings);
	newList.addAll(strings2);
	System.out.println(newList);
	}
	
	

	
}
			

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainBook {

	public static void main(String[]args){


		Set<String> Books= new LinkedHashSet<String>();
		System.out.println("the size is "+Books.size());
		Books.add("book1");
		Books.add("book2");
		Books.add("book3");


		for(String currentString : Books){
			System.out.println(currentString);
		}
	}
}



public class Book {

	String title;
	String author;
	int price;
	public Book(){

	}

	public Book (String title,String author,int price){
		this.title=title;
		this.author=author;
		this.price=price;
	}
	@Override
	public String toString (){
		return title+ ":" +author+":"+price;

	}
	
	
}




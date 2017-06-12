package library;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;


@Service("bookService")
public class BookService {

	private static List<Book> bookList = new LinkedList<>();
	private static final Logger LOGGER = Logger.getLogger( Logger.class.getName() );
	
	public List<Book> getBookList(){
		if(bookList.isEmpty())
			LOGGER.log(Level.WARNING, "GET: empty bookList");
		return this.bookList;
	}
	
	public boolean isBookExist(Book book){
		if (bookList.contains(book)){
			LOGGER.log(Level.WARNING, "Attempted to add existing book");
			return true;
		}			
		else
		{
			return false;
		}
	}
	
	public void addBook(Book book){		
		if(bookList.add(book)){
			LOGGER.log(Level.FINE, "Added new book");
			if(book.getIsbn().isEmpty())
				LOGGER.log(Level.WARNING, "ISBN field is empty");
			if(book.getIsbn().matches(".*\\d+.*"))
				LOGGER.log(Level.SEVERE, "ISBN has no digits!");
		}
	}
}

package library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/getAllBooks")	
	public @ResponseBody List<Book> getAllBooks() {
		List<Book> bookList = bookService.getBookList();
		return bookList;
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		if(bookService.isBookExist(book)){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		bookService.addBook(book);
		   
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}	
}

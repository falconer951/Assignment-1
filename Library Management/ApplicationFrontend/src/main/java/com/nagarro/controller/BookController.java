package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.model.Book;
import com.nagarro.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
//	open add book page
	@RequestMapping("addBook")
	public String showAddBookPage() {
		return "addBook";
	}
//	open edit page
	@RequestMapping("editBook")
	public String showEditBookPage() {
		return "editBook";
	}
	
//	open show book page
	@RequestMapping("showBooks")
	public String showBooksPage() {
		return "showBooks";
	}
	
//	add new book to the library
	@RequestMapping(value = "add_book", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {

		bookService.addBook(book);

		return "redirect:/show_books";
	}
	
//	this method use to handle edit book request and redirects to edit book page
//	to edit book details of provided book code.
	@RequestMapping("/edit_book/{code}")
	public String handleEditBook(@PathVariable("code") long bookCode, HttpSession session) {

		Book book = bookService.getBook(bookCode);
		session.setAttribute("book", book);
		session.setAttribute("bookCode", bookCode);
		session.setAttribute("date", book.getDate());
		return "redirect:/editBook";
	}
	
//	edit book details of the provided book
	@RequestMapping("/edit_Book/{code}")
	public String editBook(@PathVariable("code") long bookCode, @RequestParam("name") String name,
			@RequestParam("author") String author) {

		Book book = bookService.getBook(bookCode);
		book.setAuthor(author);
		book.setName(name);
		bookService.editBook(book);
		return "redirect:/show_books";
	}
	
//	display the details of book
	@RequestMapping("/show_books")
	public String showBooks(Model model, HttpSession session) {

		List<Book> books = this.bookService.getBooks();
		model.addAttribute("books", books);
		session.setAttribute("books", books);

		return "redirect:/showBooks";
	}
	
//	delete a particular book and display the remaining books
	@RequestMapping("/deleteBook/{code}")
	public String deleteBook(@PathVariable("code") long bookCode) {

		bookService.deleteBook(bookCode);
		return "redirect:/show_books";
	}

}

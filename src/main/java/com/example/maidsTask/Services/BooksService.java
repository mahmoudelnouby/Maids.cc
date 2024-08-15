package com.example.maidsTask.Services;

import com.example.maidsTask.Entities.Book;
import com.example.maidsTask.Model.Request.BookDto;
import com.example.maidsTask.Repos.BooksRepo;
import com.example.maidsTask.Utils.IntegerUtils;
import com.example.maidsTask.Utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BooksRepo booksRepo;
    public List<Book> getListOfAllBooks() {
        return booksRepo.findAll();
    }

    public Book getBookById(Integer id) {
        if(IntegerUtils.isNull(id))
        {
            throw new RuntimeException("Cannot Find Book While The Id Is Null!");
        }
        Book book=booksRepo.findById(id).orElse(null);
        if(book==null)
            throw new RuntimeException("Book Not Found!");
        return book;
    }
    @Transactional
    public Book addNewBook(BookDto bookDto) {
        bookValidation(bookDto);

        if(!booksRepo.findByTitle(bookDto.getTitle()).isEmpty())
        {
            throw new RuntimeException("Book Already Exist!");
        }
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setPuplishYear(bookDto.getPuplishYear());
        return booksRepo.saveAndFlush(book);
    }

    @Transactional
    public Book updateExistingBookById(Integer bookid, BookDto bookDto) {
        if(IntegerUtils.isNull(bookid))
        {
            throw new RuntimeException("You Must Enter Id To Update!");
        }
        Book book=booksRepo.findById(bookid).orElse(null);
        if(book==null)
            throw new RuntimeException("No Book With This Id Found!");

        //    In Order To Use DTO As Variety

        bookValidation(bookDto);
        book.setBookId(bookid);
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setPuplishYear(bookDto.getPuplishYear());
        return booksRepo.save(book);
    }


    public void bookValidation(BookDto bookDto)
    {
        if(StringUtils.isNull(bookDto.getTitle()))
        {
            throw new RuntimeException("You Must Enter Book Title!");
        }
        if(StringUtils.isNull(bookDto.getAuthor()))
        {
            throw new RuntimeException("You Must Enter The Author Of Book !");
        }
        if(IntegerUtils.isNull(bookDto.getPuplishYear()))
        {
            throw new RuntimeException("You Must Enter The Publish Year!");
        }
        if(StringUtils.isNull(bookDto.getIsbn()))
        {
            throw new RuntimeException("You Must Enter The ISBN Of The Book!");
        }
    }

    @Transactional
    public boolean deleteBookById(Integer id) {
        if(IntegerUtils.isNull(id))
            throw new RuntimeException("You Must Enter Valid Id!");
        Book book=booksRepo.findById(id).orElse(null);
        if(book==null)
        {
            throw new RuntimeException("No Book Found With This Id!");
        }
        booksRepo.deleteById(id);
        return true;
    }
}

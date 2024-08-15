package com.example.maidsTask.Controller;

import com.example.maidsTask.GlobalEnums.ResponseMessage;
import com.example.maidsTask.Model.Request.BookDto;
import com.example.maidsTask.Model.Response.Response;
import com.example.maidsTask.Services.BooksService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BooksController {


    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseEntity<?> getListOfAllBooks()
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getListOfAllBooks"),
                booksService.getListOfAllBooks()));
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getBookById"),
                booksService.getBookById(id)));
    }
    @PostMapping
    public ResponseEntity<?> addNewBook(@RequestBody BookDto bookDto)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("addNewBook"),
                booksService.addNewBook(bookDto)));
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateExistingBookById(@PathVariable Integer id,@RequestBody BookDto bookDto)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("updateExistingBookById"),
                booksService.updateExistingBookById(id,bookDto)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("deleteBookById"),
                booksService.deleteBookById(id)));
    }
}

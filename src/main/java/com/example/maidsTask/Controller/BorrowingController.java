package com.example.maidsTask.Controller;

import com.example.maidsTask.GlobalEnums.ResponseMessage;
import com.example.maidsTask.Model.Response.Response;
import com.example.maidsTask.Services.BorrowingService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<?> addNewBorrowRecord(@PathVariable Integer bookId,@PathVariable Integer patronId)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getAllPatrons"),
                borrowingService.addNewBorrowRecord(bookId,patronId)));
    }
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<?> updateReturnDateOfBorrowRecord(@PathVariable Integer bookId,@PathVariable Integer patronId)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("updateReturnDateOfBorrowRecord"),
                borrowingService.updateReturnDateOfBorrowRecord(bookId,patronId)));
    }
}

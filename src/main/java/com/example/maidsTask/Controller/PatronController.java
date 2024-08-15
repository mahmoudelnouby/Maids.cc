package com.example.maidsTask.Controller;

import com.example.maidsTask.Entities.Patron;
import com.example.maidsTask.GlobalEnums.ResponseMessage;
import com.example.maidsTask.Model.Response.Response;
import com.example.maidsTask.Services.PatronService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/patrons")
@CrossOrigin(origins = "*")
public class PatronController {


    @Autowired
    private PatronService patronService;
    @GetMapping
    public ResponseEntity<?> getAllPatrons()
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getAllPatrons"),
                patronService.getAllPatrons()));
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getPatronsById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getPatronById"),
                patronService.getPatronById(id)));
    }
    @PostMapping
    public ResponseEntity<?> addNewPatron(@RequestBody Patron patron)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("addNewPatron"),
                patronService.addNewPatron(patron)));
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateExistingPatron(@PathVariable Integer id,@RequestBody Patron patron)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("updateExistingPatron"),
                patronService.updateExistingPatron(id,patron)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteExistingPatron(@PathVariable Integer id)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("deleteExistingPatron"),
                patronService.deleteExistingPatron(id)));
    }
}

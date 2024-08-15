package com.example.maidsTask.Services;

import com.example.maidsTask.Entities.Book;
import com.example.maidsTask.Entities.Patron;
import com.example.maidsTask.Model.Request.BookDto;
import com.example.maidsTask.Repos.PatronRepo;
import com.example.maidsTask.Utils.IntegerUtils;
import com.example.maidsTask.Utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatronService {
    @Autowired
    private PatronRepo patronRepo;
    public List<Patron> getAllPatrons() {
        return patronRepo.findAll();
    }

    public Patron getPatronById(Integer id) {
        if(IntegerUtils.isNull(id))
            throw new RuntimeException("Id Cannot Be Null!");
        Patron patron=patronRepo.findById(id).orElse(null);
        if(patron==null)
            throw new RuntimeException("Patron Not Found!");
        return patron;
    }
    @Transactional
    public Patron addNewPatron(Patron patron)
    {
        if(!patronRepo.findByName(patron.getName()).isEmpty())
        {
            throw new RuntimeException("Patron With Same Name Already Exist");
        }
        patronValidation(patron);
        return patronRepo.saveAndFlush(patron);

    }


    public void patronValidation(Patron patron)
    {
        if(StringUtils.isNull(patron.getName()))
        {
            throw new RuntimeException("You Must Enter Patron Name!");
        }
        if(StringUtils.isNull(patron.getAddress()))
        {
            throw new RuntimeException("You Must Enter The Patron Address !");
        }
        if(StringUtils.isNull(patron.getEmail()))
        {
            throw new RuntimeException("You Must Enter The Patron Email!");
        }
        if(StringUtils.isNull(patron.getMobileNumber()))
        {
            throw new RuntimeException("You Must Enter The Patron Mobile Number!");
        }
    }

    @Transactional
    public Patron updateExistingPatron(Integer id, Patron patron) {
        if(IntegerUtils.isNull(id))
        {
            throw new RuntimeException("You Must Enter Id To Update!");
        }
        Patron patron1=patronRepo.findById(id).orElse(null);
        if(patron1==null)
            throw new RuntimeException("No Patron With This Id Found!");
        patronValidation(patron);
        patron.setPatronId(id);
        return patronRepo.save(patron);
    }

    @Transactional
    public boolean deleteExistingPatron(Integer id) {
        if(IntegerUtils.isNull(id))
            throw new RuntimeException("You Must Enter Valid Id!");
        Patron patron=patronRepo.findById(id).orElse(null);
        if(patron==null)
        {
            throw new RuntimeException("No Patron Found With This Id!");
        }
        patronRepo.deleteById(id);
        return true;
    }
}

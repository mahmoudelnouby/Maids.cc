package com.example.maidsTask.Services;

import com.example.maidsTask.Entities.Book;
import com.example.maidsTask.Entities.BorrowingRecord;
import com.example.maidsTask.Entities.CompositeKey;
import com.example.maidsTask.Entities.Patron;
import com.example.maidsTask.Repos.BooksRepo;
import com.example.maidsTask.Repos.BorrowingRepo;
import com.example.maidsTask.Repos.PatronRepo;
import com.example.maidsTask.Utils.IntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BorrowingService {
    @Autowired
    private PatronRepo patronRepo;
    @Autowired
    private BooksRepo booksRepo;
    @Autowired
    private BorrowingRepo borrowingRepo;
    @Transactional
    public BorrowingRecord addNewBorrowRecord(Integer bookId, Integer patronId) {
        borrowingValidations(bookId,patronId);
        Book book=booksRepo.findById(bookId).orElse(null);
        Patron patron=patronRepo.findById(patronId).orElse(null);
        CompositeKey compositeKey=new CompositeKey(book,patron);
        BorrowingRecord borrowingRecord=new BorrowingRecord();
        borrowingRecord.setCompositeKey(compositeKey);
        borrowingRecord.setBorrowingDate(LocalDateTime.now());
//        borrowingRecord.setReturnDate(LocalDateTime.now().plusDays(10));
        return borrowingRepo.saveAndFlush(borrowingRecord);
    }
    public void borrowingValidations(Integer bookId,Integer patronId)
    {
        if(IntegerUtils.isNull(bookId))
        {
            throw new RuntimeException("The Book Id Is Null!");
        }
        if(IntegerUtils.isNull(patronId))
        {
            throw new RuntimeException("The Patron Id Is Null!");
        }
        if(booksRepo.findById(bookId).isEmpty())
        {
            throw new RuntimeException("No Books Found With This Id!");
        }
        if(patronRepo.findById(patronId).isEmpty())
        {
            throw new RuntimeException("No Patron Found With This Id!");
        }
    }
    @Transactional
    public BorrowingRecord updateReturnDateOfBorrowRecord(Integer bookId, Integer patronId) {
        borrowingValidations(bookId,patronId);
        Book book=booksRepo.findById(bookId).orElse(null);
        Patron patron=patronRepo.findById(patronId).orElse(null);
        CompositeKey compositeKey=new CompositeKey(book,patron);
        BorrowingRecord borrowingRecord=borrowingRepo.findById(compositeKey).orElse(null);
        if(borrowingRecord==null)
        {
            throw new RuntimeException("No Record Found With This Key!");
        }
        borrowingRecord.setReturnDate(LocalDateTime.now());
        return borrowingRepo.save(borrowingRecord);
    }
}

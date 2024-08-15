package com.example.maidsTask.Repos;

import com.example.maidsTask.Entities.BorrowingRecord;
import com.example.maidsTask.Entities.CompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepo extends JpaRepository<BorrowingRecord, CompositeKey> {
}

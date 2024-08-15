package com.example.maidsTask.Repos;

import com.example.maidsTask.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Book,Integer> {
    @Query(value = "select DISTINCT title from Books where title=:title",nativeQuery = true)
    List<String> findByTitle(String title);
}

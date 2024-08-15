package com.example.maidsTask.Repos;

import com.example.maidsTask.Controller.PatronController;
import com.example.maidsTask.Entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatronRepo extends JpaRepository<Patron,Integer> {
    @Query(value = "select DISTINCT name from patron where name=:name",nativeQuery = true)
    List<String> findByName(String name);
}

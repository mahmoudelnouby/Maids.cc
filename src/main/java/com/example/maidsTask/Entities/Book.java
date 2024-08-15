package com.example.maidsTask.Entities;


import jakarta.persistence.*;
import lombok.*;
@Table(name = "Books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "puplish_year")
    private Integer puplishYear;
    @Column(name = "isbn")
    private String isbn;
}

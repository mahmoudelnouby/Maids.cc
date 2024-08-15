package com.example.maidsTask.Model.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
//    In Order To Use DTO As Variety
    private String title;
    private String author;
    private Integer puplishYear;
    private String isbn;
}

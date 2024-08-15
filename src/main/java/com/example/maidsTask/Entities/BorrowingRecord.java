package com.example.maidsTask.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "borrowing_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BorrowingRecord {
    @EmbeddedId
    private CompositeKey compositeKey;
    @Column(name = "borrowing_date")
    private LocalDateTime borrowingDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;

}

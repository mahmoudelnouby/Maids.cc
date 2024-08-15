package com.example.maidsTask.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CompositeKey implements Serializable {
    @JoinColumn(name = "book_id",referencedColumnName = "book_id")
    @ManyToOne( targetEntity = Book.class,fetch = FetchType.EAGER)
    Book book_id;
    @JoinColumn(name = "patron_id",referencedColumnName = "patron_id")
    @ManyToOne( targetEntity = Patron.class,fetch = FetchType.EAGER)
    Patron patron_id;

}

package com.ildar.bookapp;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookCounter {

    @Id
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    private Long bookCount;
}

package com.ildar.bookapp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private BookCounter bookCounter;

    private String name;

    public Book(String name) {
        this.name = name;
        this.bookCounter = new BookCounter();
    }

    public Long previousBookCount() {
        return bookCounter.getBookCount();
    }
}

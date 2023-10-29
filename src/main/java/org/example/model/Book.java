package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private LocalDate published_year;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne( cascade = CascadeType.PERSIST)
    private Publisher publishers;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author authors;
    @ManyToOne( cascade = CascadeType.PERSIST)
    private Reader readers;


    public Book(String name, String country, LocalDate published_year, int price, Genre genre) {
        this.name = name;
        this.country = country;
        this.published_year = published_year;
        this.price = price;
        this.genre = genre;

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", published_year=" + published_year +
                ", price=" + price +
                ", genre=" + genre +
                ", publishers=" + publishers +
                '}';
    }
}
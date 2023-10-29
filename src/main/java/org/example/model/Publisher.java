package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="publishers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Author> authors;
    @OneToMany(mappedBy = "publishers", cascade = CascadeType.PERSIST)
    private List<Book> books;
    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;

    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}



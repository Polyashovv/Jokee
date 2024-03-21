package ru.poldjoke.demo.jokebot.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Jokes")
@Table(name = "Jokes")
public class Joke {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
    public Joke(String text, Date createdAt){
        this.text = text;
        this.createdAt = createdAt;
    }

}

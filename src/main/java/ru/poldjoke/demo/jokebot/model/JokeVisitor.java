package ru.poldjoke.demo.jokebot.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Joke_Visitor")
public class JokeVisitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joke_visitor_seq_gen")
    @SequenceGenerator(name = "joke_visitor_seq_gen", sequenceName = "joke_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "joke_id")
    private Joke jokeId;

    @Column(name = "date")
    private Date visitAt;
}

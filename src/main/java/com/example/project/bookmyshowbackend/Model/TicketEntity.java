package com.example.project.bookmyshowbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String alloated_seats;

    int amount;
    @CreationTimestamp
    Date createdOn;

    //done on child's behalf
    @ManyToOne
    @JoinColumn
    @JsonIgnore//personal use
    UserEntity user;//this is a foreign key that will connect to the user table

    //ShowEntity

    //ListShowTicketEntity
}

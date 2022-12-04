package com.example.project.bookmyshowbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
@Builder
@ToString
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alloted_seats",nullable = false)
    private String alloted_seats;

    @Column(name = "amount",nullable = false)
    private double amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at",nullable = false)
    private Date bookedAt;

    //done on child's behalf
    @ManyToOne
    @JoinColumn
    @JsonIgnore//personal use
    private UserEntity user;//this is a foreign key that will connect to the user table

    //ShowEntity
    @ManyToOne
    @JsonIgnore
    private ShowEntity show;

    //List<ShowSeatsEntity>
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;
}

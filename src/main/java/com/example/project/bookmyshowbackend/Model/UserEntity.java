package com.example.project.bookmyshowbackend.Model;

import lombok.Setter;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mobileNo;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)// cascade if we save the parent child automatically
    private List<TicketEntity> listOfTickets;//gets saved and can use child functions




}

package com.example.project.bookmyshowbackend.Model;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder//to create/build objects
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "mobile",nullable = false)
    private String mobile;
//bidirectional mapping
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)// cascade if we save the parent child automatically
    private List<TicketEntity> ticketEntities;//gets saved and can use child functions

}

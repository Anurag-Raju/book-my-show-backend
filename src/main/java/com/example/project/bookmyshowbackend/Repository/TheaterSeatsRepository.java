package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity,Integer> {
}

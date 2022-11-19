package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}

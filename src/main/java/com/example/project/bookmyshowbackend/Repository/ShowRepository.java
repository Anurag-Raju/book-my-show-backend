package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}

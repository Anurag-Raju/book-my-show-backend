package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
}

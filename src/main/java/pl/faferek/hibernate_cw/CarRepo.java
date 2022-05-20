package pl.faferek.hibernate_cw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findCarByColor(Color color);
    List<Car> findCarByColorAndMark(Color color, String mark);
}


package pl.faferek.hibernate_cw;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private CarRepo carRepo;

    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Car carPolonez = new Car("Polonez", "Caro", Color.BLACK);
        Car carFiat = new Car("Fiat", "Panda", Color.RED);
        Car carBmw = new Car("BMW", "A1", Color.RED);
        Car carBmw2 = new Car("BMW", "A2", Color.RED);

        carRepo.save(carPolonez);
        carRepo.save(carFiat);
        carRepo.save(carBmw);
        carRepo.save(carBmw2);

        carRepo.findCarByColor(Color.RED).forEach(System.out::println);
        carRepo.findCarByColorAndMark(Color.RED, "BMW").forEach(System.out::println);

    }
}

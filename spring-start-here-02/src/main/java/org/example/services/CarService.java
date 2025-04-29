package org.example.services;

import org.example.repositories.WheelRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final WheelRepository wheelRepository;

    public CarService(WheelRepository wheelRepository) {
        this.wheelRepository = wheelRepository;
    }

    public WheelRepository getWheelRepository() {
        return wheelRepository;
    }
}

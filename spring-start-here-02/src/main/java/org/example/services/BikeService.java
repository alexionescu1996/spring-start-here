package org.example.services;

import org.example.repositories.WheelRepository;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    private final WheelRepository wheelRepository;

    public BikeService(WheelRepository wheelRepository) {
        this.wheelRepository = wheelRepository;
    }

    public WheelRepository getWheelRepository() {
        return wheelRepository;
    }
}

package com.app.msgbackend.service;

import com.app.msgbackend.model.RecyclingCenterModel;
import com.app.msgbackend.repository.RecyclingCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecyclingCenterService {
    private final RecyclingCenterRepository repository;

    public RecyclingCenterModel addRecyclingCenter(RecyclingCenterModel center) {
        return repository.save(center);
    }

    public List<RecyclingCenterModel> findAllRecyclingCenters(){
        List<RecyclingCenterModel> centers = repository.findAll();

        centers.forEach(center -> {
            String combinedLocation = center.getAddress() + ", " + center.getCity() + ", " + center.getCountry();
            center.setLocation(combinedLocation);
        });

        return centers;
    }
}

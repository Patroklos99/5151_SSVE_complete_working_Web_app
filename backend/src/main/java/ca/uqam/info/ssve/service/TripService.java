package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.Trip;
import ca.uqam.info.ssve.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip getTrip(Long id) {
        return tripRepository.findById(id).get();
    }

    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

}

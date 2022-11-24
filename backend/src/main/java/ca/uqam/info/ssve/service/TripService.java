package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.TripNeeds;
import ca.uqam.info.ssve.repository.TripNeedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    @Autowired
    private TripNeedsRepository tripNeedsRepository;

    public TripNeeds getTrip(Long id) {
        TripNeeds tn = tripNeedsRepository.findById(id).get();
        System.out.println(tn.toString());
        return tn;
    }

    public TripNeeds saveTripNeeds(TripNeeds tripNeeds) {
        TripNeeds bd = tripNeedsRepository.save(tripNeeds);
        return bd;
    }

}

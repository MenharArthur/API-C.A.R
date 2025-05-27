package com.king.demo_car_api.service;

import com.king.demo_car_api.entitys.TravelRequest;
import com.king.demo_car_api.entitys.TravelRequestStatus;
import com.king.demo_car_api.repository.TravelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Service
public class TravelRequestService {

    @Autowired
    TravelRequestRepository travelRequestRepository;

    private static final int MAX_TRAVEL_TIME = 600;

    @Autowired
    GMapsService gMapsService;

    /* Salvar a requisição de viagem */
    public TravelRequest saveTravelRequest(TravelRequest travelRequest){
        travelRequest.setStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationDate(LocalDateTime.now());
        return travelRequestRepository.save(travelRequest);
    }

    /* listar pedidos de viagens próximos */
    public List<TravelRequest> listNearbyTravelRequests(String currentAddress) {

        List<TravelRequest> requests = travelRequestRepository.findByStatus(TravelRequestStatus.CREATED);

        return requests
                .stream()
                .filter(tr -> gMapsService.getDistanceBetweenAddress(currentAddress, tr.getOrigin()) < MAX_TRAVEL_TIME)
                .toList();
    }
}

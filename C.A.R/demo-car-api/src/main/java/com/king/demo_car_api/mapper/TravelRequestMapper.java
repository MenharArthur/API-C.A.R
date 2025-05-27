package com.king.demo_car_api.mapper;

import com.king.demo_car_api.DTO.TravelRequestInput;
import com.king.demo_car_api.DTO.TravelRequestOutput;
import com.king.demo_car_api.controller.PassengerController;
import com.king.demo_car_api.entitys.Passenger;
import com.king.demo_car_api.entitys.TravelRequest;
import com.king.demo_car_api.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class TravelRequestMapper {

    @Autowired
    private PassengerRepository passengerRepository;

    /* Sua função é mapear o objeto input e transforma-los em um objeto travelRequest */
    public TravelRequest map(TravelRequestInput input){

        Passenger passenger = passengerRepository.findById(input.getPassengerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setOrigin(input.getOrigin());
        travelRequest.setDestination(input.getDestination());
        travelRequest.setPassenger(passenger);

        return travelRequest;
    }

    /* sua função é mapear o objeto travelRequest e transforma-lo em um objeto output */
    public TravelRequestOutput map(TravelRequest travelRequest){

        TravelRequestOutput travelRequestOutput = new TravelRequestOutput();

        travelRequestOutput.setCreationDate(travelRequest.getCreationDate());
        travelRequestOutput.setDestination(travelRequest.getDestination());
        travelRequestOutput.setId(travelRequest.getId());
        travelRequestOutput.setOrigin(travelRequest.getOrigin());
        travelRequestOutput.setStatus(travelRequest.getStatus());

        return travelRequestOutput;
    }

    /* sua função é construir um link  */
    public EntityModel<TravelRequestOutput> buildOutputModel(TravelRequest travelRequest,
                                                             TravelRequestOutput output){
        EntityModel<TravelRequestOutput> model = EntityModel.of(output);

        Link passengerLink = WebMvcLinkBuilder
                .linkTo(PassengerController.class)
                .slash(travelRequest.getPassenger().getId())
                .withRel("passenger")
                .withTitle(travelRequest.getPassenger().getName());
        model.add(passengerLink);

        return model;
    }

    public List<EntityModel<TravelRequestOutput>> buildOutputModel(List<TravelRequest> requests){
        return requests
                .stream()
                .map(tr -> buildOutputModel(tr, map(tr)))
                .toList();
    }
}

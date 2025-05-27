package com.king.demo_car_api.controller;

import com.king.demo_car_api.DTO.TravelRequestInput;
import com.king.demo_car_api.DTO.TravelRequestOutput;
import com.king.demo_car_api.mapper.TravelRequestMapper;
import com.king.demo_car_api.entitys.TravelRequest;
import com.king.demo_car_api.mapper.TravelRequestMapper;
import com.king.demo_car_api.service.TravelRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/travelrequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestController {

    @Autowired
    TravelRequestService travelRequestService;

    @Autowired
    TravelRequestMapper mapper;

    /* Fazer solicitação de viagem */
    @PostMapping
    public EntityModel<TravelRequestOutput> makeTravelRequest(@Valid @RequestBody TravelRequestInput travelRequestInput){

        TravelRequest request = travelRequestService.saveTravelRequest(mapper.map(travelRequestInput));

        TravelRequestOutput output = mapper.map(request);

        return mapper.buildOutputModel(request, output);
    }

    /* Listar solicitações próximas */
    @GetMapping("/nearby")
    public List<EntityModel<TravelRequestOutput>> listNearbyRequests(@RequestParam String currentAddress){

        List<TravelRequest> requests = travelRequestService.listNearbyTravelRequests(currentAddress);

        return mapper.buildOutputModel(requests);
    }
}

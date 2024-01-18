package com.app.msgbackend.controller;

import com.app.msgbackend.exception.TokenExpiredException;
import com.app.msgbackend.model.RecyclingCenterModel;
import com.app.msgbackend.service.RecyclingCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recycling-centers")
@RequiredArgsConstructor
public class RecyclingCenterController {
    private final RecyclingCenterService service;

    @PostMapping(path = "/addCenter")
    public ResponseEntity<Map<String, String>> addRecyclingCenter(@RequestBody RecyclingCenterModel center){
        System.out.println(center);
        RecyclingCenterModel newCenter = service.addRecyclingCenter(center);
        return ResponseEntity.ok(Map.of("Message","The center was added to the list successfully"));
    }
    @GetMapping(path = "/getAllCenters")
    public ResponseEntity<List<RecyclingCenterModel>> getAllRecyclingCenters(){
        List<RecyclingCenterModel> AllRecyclingCenters = service.findAllRecyclingCenters();
        return ResponseEntity.ok(AllRecyclingCenters);
    }
}

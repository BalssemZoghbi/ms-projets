package com.example.hotelms.controllers;

import com.example.hotelms.dto.HotelRequest;
import com.example.hotelms.dto.HotelResponse;
import com.example.hotelms.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveHotel(@RequestBody HotelRequest hotelRequest){
     hotelService.saveHotel(hotelRequest);
    }

    @GetMapping("/{id}")
    public HotelResponse getHotel(@PathVariable String id){
       return hotelService.getHotelById(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HotelResponse> getAllHotels(){
      return  hotelService.getAllHotels();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateHotel(@PathVariable String id, @RequestBody HotelRequest hotelRequest) {
        hotelService.updateHotel(id, hotelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
    }

}

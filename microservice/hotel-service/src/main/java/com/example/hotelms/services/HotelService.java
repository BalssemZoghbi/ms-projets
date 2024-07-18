package com.example.hotelms.services;

import com.example.hotelms.dto.HotelRequest;
import com.example.hotelms.dto.HotelResponse;
import com.example.hotelms.entities.Hotel;
import com.example.hotelms.repository.HotelRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelResponse> getAllHotels() {
       List<Hotel> hotels= this.hotelRepository.findAll();
      return hotels.stream().map(this::mapToHotelResponse).toList();
    }
   private HotelResponse mapToHotelResponse(Hotel hotel){
    return HotelResponse.builder()
            .id(hotel.getId())
            .name(hotel.getName())
            .address(hotel.getAddress())
            .build();
    }


    public void saveHotel(HotelRequest hotelRequest) {
        Hotel hotel=Hotel.builder()
                .name(hotelRequest.getName())
                .address(hotelRequest.getAddress())
                .build();
        this.hotelRepository.save(hotel);
    }


}
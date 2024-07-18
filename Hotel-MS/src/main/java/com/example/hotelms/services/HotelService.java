package com.example.hotelms.services;

import com.example.hotelms.dto.HotelRequest;
import com.example.hotelms.dto.HotelResponse;
import com.example.hotelms.entities.Hotel;
import com.example.hotelms.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HotelService implements IHotelService{
    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelResponse> getAllHotels() {
       List<Hotel> hotels= this.hotelRepository.findAll();
      return hotels.stream().map(this::mapToHotelResponse).toList();
    }


   private HotelResponse mapToHotelResponse(Hotel hotel){
    return HotelResponse.builder()
            .id(hotel.getHotelId())
            .name(hotel.getName())
            .address(hotel.getAddress())
            .build();
    }

    public HotelResponse getHotelById(String id) {
        Hotel hotel=hotelRepository.findById(id).orElse(null);
        return HotelResponse.mapFromEntity(hotel);
    }

    public void saveHotel(HotelRequest hotelRequest) {
        Hotel hotel=Hotel.builder()
                .name(hotelRequest.getName())
                .address(hotelRequest.getAddress())
                .build();
        this.hotelRepository.save(hotel);
    }
    public void updateHotel(String id, HotelRequest hotelRequest) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            hotel.setName(hotelRequest.getName());
            hotel.setAddress(hotelRequest.getAddress());
            hotelRepository.save(hotel);
        } else {
            log.error("Hotel with id {} not found", id);
            throw new RuntimeException("Hotel not found");
        }
    }

    public void deleteHotel(String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> {
            log.error("Hotel with id {} not found", id);
            return new RuntimeException("Hotel not found");
        });
        hotelRepository.delete(hotel);
    }



}
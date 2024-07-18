package com.example.hotelms.services;

import com.example.hotelms.dto.HotelRequest;
import com.example.hotelms.dto.HotelResponse;

import java.util.List;

public interface IHotelService {
    List<HotelResponse> getAllHotels();
    HotelResponse getHotelById(String id);
    void saveHotel(HotelRequest hotelRequest);
    void updateHotel(String id, HotelRequest hotelRequest);
    void deleteHotel(String id);
}

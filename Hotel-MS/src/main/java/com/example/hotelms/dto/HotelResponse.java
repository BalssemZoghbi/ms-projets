package com.example.hotelms.dto;

import com.example.hotelms.entities.Hotel;
import com.example.hotelms.entities.HotelMapper;
import lombok.Builder;

@Builder
public record HotelResponse(
        String id,
        String name,
        String address
) {

    public static HotelResponse mapFromEntity(Hotel hotel) {
        return HotelMapper.INSTANCE.toDto(hotel);
    }
}

package com.example.hotelms.entities;

import com.example.hotelms.dto.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);
    @Mapping(target = "id", source = "id")
    HotelResponse toDto(Hotel hotel);
    @Mapping(target = "id", source = "id")
    Hotel toEntity(HotelResponse hotelResponse);
}
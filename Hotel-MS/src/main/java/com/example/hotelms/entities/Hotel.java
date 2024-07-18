package com.example.hotelms.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "Hotel")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String address;
}

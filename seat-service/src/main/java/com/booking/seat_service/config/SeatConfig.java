package com.booking.seat_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeatConfig {
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}

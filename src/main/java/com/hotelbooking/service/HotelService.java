package com.hotelbooking.service;

import com.hotelbooking.model.Hotel;
import com.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // ✅ Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // ✅ Get hotel by ID
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    // ✅ Save (Add or Update) hotel
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // ✅ Update hotel if exists
    public Optional<Hotel> updateHotel(Long id, Hotel updatedHotel) {
        return hotelRepository.findById(id).map(existingHotel -> {
            existingHotel.setName(updatedHotel.getName());
            existingHotel.setLocation(updatedHotel.getLocation());
            existingHotel.setPrice(updatedHotel.getPrice());
            existingHotel.setImageUrl(updatedHotel.getImageUrl());
            return hotelRepository.save(existingHotel);
        });
    }

    // ✅ Delete hotel by ID
    public boolean deleteHotel(Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

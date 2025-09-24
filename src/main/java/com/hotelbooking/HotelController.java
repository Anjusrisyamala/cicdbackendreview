package com.hotelbooking;

import com.hotelbooking.model.Hotel;
import com.hotelbooking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:3000") // Allow only your React app
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // ✅ Get all hotels
    @GetMapping
    public List<Hotel> getHotels() {
        return hotelService.getAllHotels();
    }

    // ✅ Get single hotel by ID
    @GetMapping("/{id}")
    public Optional<Hotel> getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    // ✅ Add new hotel
    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    // ✅ Update hotel (PUT /hotels/{id})
    @PutMapping("/{id}")
    public Optional<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel updatedHotel) {
        return hotelService.updateHotel(id, updatedHotel);
    }

    // ✅ Delete hotel
    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id) {
        boolean deleted = hotelService.deleteHotel(id);
        return deleted ? "Hotel deleted successfully" : "Hotel not found";
    }
 

}

package com.hotelbooking.repository;

import com.hotelbooking.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    // ✅ Find hotels by location (case-insensitive)
    List<Hotel> findByLocationContainingIgnoreCase(String location);

    // ✅ Find hotels with price less than or equal to a value
    List<Hotel> findByPriceLessThanEqual(int price);

    // ✅ Find hotels by location + price range
    List<Hotel> findByLocationContainingIgnoreCaseAndPriceLessThanEqual(String location, int price);
}

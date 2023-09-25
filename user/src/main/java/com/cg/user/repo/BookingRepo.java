package com.cg.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer>{

}

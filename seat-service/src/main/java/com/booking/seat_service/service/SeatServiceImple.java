package com.booking.seat_service.service;

import com.booking.seat_service.entity.Seat;
import com.booking.seat_service.entity.Status;
import com.booking.seat_service.exception.SeatNotFoundException;
import com.booking.seat_service.payload.SeatResponse;
import com.booking.seat_service.repository.SeatRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImple implements SeatService{

    @Autowired
    SeatRepo seatRepo;

    @Autowired
    FromEventService eventService;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void allocateSeats(long eventid) {

        Long seats = eventService.getById(eventid);
        for(Long i = 0L;i<seats;i++)
        {
            Seat seat = new Seat();
            seat.setSeatNumber(i);
            seat.setEventId(eventid);
            seat.setStatus(Status.AVAILABLE);
            seatRepo.save(seat);
        }


    }

    public List<SeatResponse> getAllSeatsByEventId(Long eventid) {
        List<Seat> seats = seatRepo.findAllByEventId(eventid);
        List<SeatResponse> seatResponses = seats.stream()
                .map(seat -> {
                    SeatResponse se = modelMapper.map(seat, SeatResponse.class);
                    se.setStatus(seat.getStatus().name());
                    return se;}
                )
                .toList();
        return seatResponses;

    }

    public List<SeatResponse> getAllByEventAndAvailable(Long eventId) {
        List<Seat> seats = seatRepo.findAllByEventIdAndStatus(eventId,Status.AVAILABLE);
        List<SeatResponse> seatResponses = seats.stream()
                .map(seat -> {
                    SeatResponse se = modelMapper.map(seat, SeatResponse.class);
                    se.setStatus(seat.getStatus().name());
                    return se;
                })
                .toList();
        return seatResponses;

    }

    @Override
    public void markUnavailable(List<Long> seatId) {
        List<Seat> seat = seatRepo.findAllById(seatId);

        for (Seat s : seat) {
            s.setStatus(Status.LOCKED);
        }

        seatRepo.saveAll(seat);

    }

    @Override
    public SeatResponse getSeatById(Long id) {
        Seat seat = seatRepo.findById(id).orElseThrow(()->new SeatNotFoundException(id));
        SeatResponse se =  modelMapper.map(seat,SeatResponse.class);
        se.setStatus(seat.getStatus().name());
        return se;
    }

    public void markingTheStatus(Long id, Boolean staus) {
        Seat seat = seatRepo.findById(id).orElseThrow(()->new SeatNotFoundException(id));
        if(staus)
        seat.setStatus(Status.BOOKED);
        else
            seat.setStatus(Status.AVAILABLE);
      seatRepo.save(seat);
    }

    public void markingAsLocked(Long id) {
        Seat seat = seatRepo.findById(id).orElseThrow(()->new SeatNotFoundException(id));
        seat.setStatus(Status.LOCKED);
        seatRepo.save(seat);
    }
}

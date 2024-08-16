package org.example.tp_architecture.infrastructure.springdata.portimpl;

import org.example.tp_architecture.infrastructure.springdata.repository.ReservationRepository;
import org.example.tp_architecture.shared.dto.ReservationDTO;
import org.example.tp_architecture.shared.port.ReservationPort;

import java.util.List;

public class ReservationPortImpl implements ReservationPort {
    private final ReservationRepository reservationRepository;

    public ReservationPortImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationDTO save(ReservationDTO reservation) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ReservationDTO> getAll() {
        return List.of();
    }
}

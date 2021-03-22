package ru.job4j.cinema.store;

import ru.job4j.cinema.model.Seat;
import ru.job4j.cinema.model.Ticket;

import java.util.Collection;

public interface Store {

    Collection<Seat> findAllSeats();

    Seat findById(int id);

    void addTicket(Ticket ticket);

    int findAccountIdByPhone(String phone);

    void updateCells(int id);
}

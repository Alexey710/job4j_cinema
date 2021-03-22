package ru.job4j.cinema.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import ru.job4j.cinema.model.Seat;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.PsqlStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String in = br.readLine();
        JSONObject jsonObject = new JSONObject(in);
        int id = jsonObject.getInt("id");
        Seat seat = PsqlStore.instOf().findById(id);
        String phone = jsonObject.getString("phone");
        int account = PsqlStore.instOf().findAccountIdByPhone(String.valueOf(phone));
        if (account != -1) {
            PsqlStore.instOf().updateCells(id);
            Ticket ticket = new Ticket(1, seat.getRow(), seat.getCell(), account);
            PsqlStore.instOf().addTicket(ticket);

            ObjectMapper mapper = new ObjectMapper();
            String string = mapper.writeValueAsString("Билет куплен");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("json");
            resp.getWriter().write(string);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String string = mapper.writeValueAsString("Билет не куплен");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("json");
            resp.getWriter().write(string);
        }
    }
}

package ru.job4j.cinema.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cinema.model.Seat;
import ru.job4j.cinema.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("name");
        Seat seat = PsqlStore.instOf().findById(Integer.parseInt(id));
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String entry = String.format("%s,%s", seat.getRow(), seat.getCell());
        writer.println(entry);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Seat> list = (List<Seat>) PsqlStore.instOf().findAllSeats();
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(list);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("json");
        resp.getWriter().write(string);
    }
}

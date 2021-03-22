package ru.job4j.cinema.model;

public class Seat {
    private int id;
    private boolean occupied;
    private int row;
    private int cell;

    public Seat(int id, boolean occupied, int row, int cell) {
        this.id = id;
        this.occupied = occupied;
        this.row = row;
        this.cell = cell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "Seat{"
                + "id=" + id
                + ", occupied=" + occupied
                + ", row=" + row
                + ", cell=" + cell
                + '}';
    }
}

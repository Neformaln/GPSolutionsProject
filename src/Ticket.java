/**
 * Created by User on 05.04.2017.
 */
public class Ticket {

    private int id;
    private CinemaRoom hall;
    private Hour hour;
    private int row, coloumn;

    public Ticket(CinemaRoom hall, Hour hour, int row, int coloumn) {
        super();
        this.hall = hall;
        this.hour = hour;
        this.row = row;
        this.coloumn = coloumn;
    }

    public Ticket(int id, CinemaRoom hall, Hour hour, int row, int coloumn) {
        super();
        this.id = id;
        this.hall = hall;
        this.hour = hour;
        this.row = row;
        this.coloumn = coloumn;
    }

    public int getId() {
        return id;
    }

    public CinemaRoom getHall() {
        return hall;
    }

    public Hour getHour() {
        return hour;
    }

    public int getRow() {
        return row;
    }

    public int getColoumn() {
        return coloumn;
    }

    @Override
    public String toString() {
        return "***Ticket****\nid=" + id + "\nhall=" + hall.getName() + "\nhour=" + hour
                + "\nrow=" + row + "\ncoloumn=" + coloumn + "\n*************";
    }

}

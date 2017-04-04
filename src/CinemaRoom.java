import java.util.ArrayList;

/**
 * Created by User on 05.04.2017.
 */
public class CinemaRoom {
    private int id;
    private int rows, cols;
    private String name;
    private Hour session;
    private int array[][];

    public CinemaRoom(int rows, int cols, String name) {
        super();
        this.rows = rows;
        this.cols = cols;
        this.name = name;
        array = new int[rows][cols];
    }

    public CinemaRoom(int id, int rows, int cols, String name) {
        super();
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.name = name;
    }

    public int[][] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "----Hall---- \nrows=" + rows + "\ncols=" + cols + "\nname="
                + name + "\n------------";
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public String getName() {
        return name;
    }

    public void reserveChair(int row, int coloumn) {
        this.array[row - 1][coloumn - 1] = 1;
    }

    public static CinemaRoom findHall(ArrayList<CinemaRoom> hallList, String hallName) {

        for (int i = 0; i < hallList.size(); i++) {
            if (hallList.get(i).name.equals(hallName))
                return hallList.get(i);

        }
        return null;

    }
}

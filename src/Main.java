/**
 * Created by User on 05.04.2017.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        ArrayList<CinemaRoom> hallList = new ArrayList<CinemaRoom>();
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        Hour[] hours = Hour.values();
        boolean available = false;

        int choice;
        int rows, cols;
        String name, string;

        do {
            System.out.println("1.Admin\n2.Reservation\n3.EXIT\n4.Print lists");
            choice = myScanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter hall name");
                myScanner.nextLine();
                name = myScanner.nextLine();
                System.out.println(name);
                System.out.println("Enter row x col (for example - 10x10)");
                string = myScanner.next();

                String[] splitted = string.split("x");
                rows = Integer.parseInt(splitted[0]);
                cols = Integer.parseInt(splitted[1]);

                CinemaRoom hall = new CinemaRoom(rows, cols, name);

                hallList.add(hall);

                System.out.println("Hall created");
                System.out.println(hall.toString());

            } else if (choice == 2) {

                if (!hallList.isEmpty()) {
                    System.out.println("Select a hall");
                    for (int i = 0; i < hallList.size(); i++) {
                        System.out.println("Hall name:"
                                + hallList.get(i).getName());
                        System.out.println("Hall size: "
                                + hallList.get(i).getCols() + "x"
                                + hallList.get(i).getRows());
                    }
                    myScanner.nextLine();
                    String selectedHallName = myScanner.nextLine();
                    if (CinemaRoom.findHall(hallList, selectedHallName) != null) {
                        for (int j = 0; j < hours.length; j++) {
                            System.out.println(hours[j]);
                        }
                        System.out.println("Enter the hour");
                        String hour = myScanner.next();
                        Hour selectedHour = Hour.valueOf(hour);
                        System.out.println(selectedHour);
                        System.out.println("Hall size: "
                                + CinemaRoom.findHall(hallList, selectedHallName)
                                .getCols()
                                + "x"
                                + CinemaRoom.findHall(hallList, selectedHallName)
                                .getRows());

                        do {
                            System.out
                                    .println("Enter the chair of rows and coloumns");
                            String chair = myScanner.next();
                            String[] splitted = chair.split("x");

                            if ((Integer.parseInt(splitted[0]) <= Integer
                                    .valueOf(CinemaRoom.findHall(hallList,
                                            selectedHallName).getRows()))
                                    && (Integer.parseInt(splitted[1]) <= Integer
                                    .valueOf(CinemaRoom.findHall(hallList,
                                            selectedHallName).getCols()))) {
                                available = false;
                                Ticket ticket = new Ticket(CinemaRoom.findHall(
                                        hallList, selectedHallName),
                                        selectedHour,
                                        (Integer.parseInt(splitted[0])),
                                        (Integer.parseInt(splitted[1])));
                                System.out.println(ticket.toString());
                                ticketList.add(ticket);
                                CinemaRoom.findHall(hallList, selectedHallName)
                                        .reserveChair(
                                                Integer.parseInt(splitted[0]),
                                                Integer.parseInt(splitted[1]));
                            } else {
                                available = true;
                                System.out.println("Bound exceed");
                            }
                        } while (available);
                    } else
                        System.out.println("Enter correctly");
                } else
                    System.out.println("There is no hall");

            } else if (choice == 4) {

                int array[][];
                for (int i = 0; i < hallList.size(); i++) {
                    System.out.println(hallList.get(i));
                    array = hallList.get(i).getArray();
                    for (int k = 0; k < array.length; k++) {
                        for (int y = 0; y < array.length; y++) {
                            System.out.print(array[k][y]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }

                for (int j = 0; j < ticketList.size(); j++) {
                    System.out.println(ticketList.get(j));
                }
            }

        } while (choice != 3);
    }
}

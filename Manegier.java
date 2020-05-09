/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sulaiman
 */
public class Manegier {

    Scanner in = new Scanner(System.in);
    static lecturer[] arr_lecturer = new lecturer[10];
    static int counter_Lecturer = 0;

    static Day[] day = new Day[10];
    static int conter_Day = 0;
 static   ArrayList<Appointement> listApp =new ArrayList<>();
    public static void main(String[] args) {
        Manegier m = new Manegier();
        Scanner in = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.println("------------------------------------");
            System.out.println("***The Main Menu***\n"
                    + "1. Lecturer menu\n"
                    + "2. Appointment menu\n"
                    + "3. Report menu\n"
                    + "4. Exit the system");
            System.out.println("------------------------------------");
            String mainMenu = in.next();

            if (mainMenu.equals("1")) {
                boolean exit2 = true;
                while (exit2) {
                    System.out.println("*** Lecturer Menu***\n"
                            + "1. Add new Lecturer.\n"
                            + "2. Delete Lecturer.\n"
                            + "3. Show Lecturer.\n"
                            + "4. return to main menu.");
                    String enter = in.next();
                    if (enter.equals("1")) {
                        m.addLecturer();

                    } else if (enter.equals("2")) {

                        m.deleteLecturer();

                    } else if (enter.equals("3")) {
                        m.showLecutrer();

                    } else if (enter.equals("4")) {
                        exit2 = false;
                    }
                }
            } else if (mainMenu.equals("2")) {

             
                int indext = -1;

                System.out.println("Enter id Lecturer to log into Appointement Menu");
                int id = in.nextInt();
                indext = m.searchLect(id);
                if (indext == -1) {
                    System.out.println("The lecturer is not exits");
                    System.out.println("---------------------------");

                } else {
                    System.out.println("The lcturer id : " + arr_lecturer[indext].getId()
                            + "\nThe lecturer name : " + arr_lecturer[indext].getName());

                    System.out.println(m.displayAppLictirer(id));
                }

                boolean exit2 = true;
                while (exit2) {

                    System.out.println("***Modification Menu***\n"
                            + "What you want to modify ?\n"
                            + "1. Add new Appointment.\n"
                            + "2. Delete Appointment.\n"
                            + "3. Postpone Appointment.\n"
                            + "4. Change appointment status.\n"
                          
                            + "Enter 0 to exit");

                    String input = in.next();
                    if (input.equals("1")) {
                        m.addNewAppLictirer(arr_lecturer[indext]);

                    }else if (input.equals("2")) {
                        m.deleteAppointment(arr_lecturer[indext]);
                        
                    }
                    else if (input.equals("0")) {
                        exit2 = false;
                    }

                }
            } else if (mainMenu.equals("3")) {
                System.out.println("***report Menu***\n"
                        + "1. display all appointments for a specified day.\n"
                        + "2. display appointment for a specified lecturer.\n"
                        + "3. return to main menu");

            } else if (mainMenu.equals("4")) {

                exit = false;

            } else {
                System.out.println("Input Error");
            }

        }
    }

    public void addLecturer() {
        int agin = 0;
        do {

            System.out.println("Enter ID Lecturer ");
            int id = in.nextInt();

            if (searchLect(id) == -1) {
                System.out.println("Enter name Lecturer");
                String name = in.next();

                arr_lecturer[counter_Lecturer] = new lecturer(id, name);
                counter_Lecturer++;

            } else {
                System.out.println("This lecturer is found");
            }
            System.out.println("---------------------------");
            System.out.println("Enter 0 to add agin or Enter 1 to Exit");
            agin = in.nextInt();
        } while (agin == 0);

    }

    public int searchLect(int id) {
        for (int i = 0; i < counter_Lecturer; i++) {
            if (arr_lecturer[i].getId() == id) {
                return i;

            }
        }
        return -1;
    }

    public void showLecutrer() {
        int agin = 0;
        do {

            System.out.println("Enter ID Lecturer ");
            int id = in.nextInt();
            int idext = searchLect(id);
            if (idext != -1) {
                String show = "ID Lecturer is :" + arr_lecturer[idext].getId() + "\nName Lecturer is: " + arr_lecturer[idext].getName();

                System.out.println(show);

            } else {
                System.out.println("This lecturer is not found");
            }
            System.out.println("---------------------------");
            System.out.println("Enter 0 to show agin or Enter 1 to Exit");
            agin = in.nextInt();
        } while (agin == 0);
    }

    public void deleteLecturer() {
        int agin = 0;
        do {

            System.out.println("Enter ID Lecturer ");
            int id = in.nextInt();
            int idext = searchLect(id);
            if (idext != -1) {
                arr_lecturer[idext] = arr_lecturer[arr_lecturer.length - 1];
                counter_Lecturer--;
                System.out.println("Delete Done");
            } else {
                System.out.println("This lecturer is not found");
            }
            System.out.println("---------------------------");
            System.out.println("Enter 0 to delete agin or Enter 1 to Exit");
            agin = in.nextInt();
        } while (agin == 0);

    }

    public static String displayAppLictirer(int id) {

        String dital2 = "SRN\t\t Date /time\t\t status" + "\n";
        int cont = 1;

        for (int i = 0; i < conter_Day; i++) {
            for (int j = 0; j < 10; j++) {
                if (id == day[i].getApp()[j].getLec().getId()) {
                    listApp.add(day[i].getApp()[j]);
                    dital2 += cont + "\t\t  " + day[i].getDate() + "/" + day[i].getApp()[j].getTime() + "\t\t"
                            + day[i].getApp()[j].getStatus() + "\n";
                    cont++;
                }

            }

        }
        return dital2;
    }

    public void addNewAppLictirer(lecturer lec) {

        int agin = 0;
        do {
            System.out.println("Enter day date use this format {dd-mm-yyy}");
            String date = in.next();
            Day d = null;
            int indext = searchDate(date);
            if (indext == -1) {
                d = new Day(date);

            } else {
                d = day[indext];
            }
            String s = "The time slots for that day:\n ";
            for (int i = 0; i < 10; i++) {

                s += d.getApp()[i].getSRN() + "   " + d.getApp()[i].getTime() + "    "
                        + (d.getApp()[i].getisAvailapble()? "Available" : "not Available") + "   "
                        + d.getApp()[i].getLec().getId() + "<=>" + d.getApp()[i].getLec().getName();

                s += "\n";
            }
            
              System.out.println(s);
            s += "Enter the time slot No. ";
               String number2 =in.next();
            int cho = Integer.parseInt(number2);

            if (cho >= 1 && cho <= 10) {
                if (lec.getId() == d.getApp()[cho - 1].getLec().getId() || d.getApp()[cho - 1].getLec().getId() >= 1) {

                    System.out.println("The AppLictirer not Available");

                } else {
                    d.getApp()[cho - 1].setLec(lec);
                    d.getApp()[cho - 1].setIsAvailapble(false);
                    if (indext == -1) {
                        day[conter_Day] = d;
                        conter_Day++;

                    }
                }
            }

            System.out.println("---------------------------");
            System.out.println("Enter 0 to add new AppLictirer agin or Enter 1 to Exit");
            agin = in.nextInt();
        } while (agin == 0);

    }

    public int searchDate(String date) {

        for (int i = 0; i < conter_Day; i++) {
            if (day.equals(day[i].getDate())) {
                return i;

            }

        }

        return -1;

    }
    public void deleteAppointment(lecturer lec){
         int agin = 0;
        do {
            String s = displayAppLictirer(lec.getId());
            System.out.println(s);
            System.out.println("Enter number appointment SRN");
            String s2 = in.next();
            int oc = Integer.parseInt(s2);
            if (!listApp.isEmpty()) {
                
                listApp.get(oc-1).setIsAvailapble(true);
                listApp.get(oc-1).setLec(new lecturer(0, "---"));
                listApp.get(oc-1).setStatus("pending");
                System.out.println("Delete Done");
                
            }
            
            System.out.println("---------------------------");
            System.out.println("Enter 0 to delete Appointment agin or Enter 1 to Exit");
            agin = in.nextInt();
        } while (agin == 0);

        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import javax.swing.JOptionPane;
import java.io.Serializable;
import static project.Project.busList;
/**
 *
 * @author Amrousy
 */

public class Bus implements Serializable {
//    private static final int seats = 10; // Info
//    private static int availableBus = 5; // Info
    private static final long serialVersionUID = -9077151025667917852L;
    private int busNo;
    private String route;
    private int timeDepart;
//    private int reservedSeats;
//    private int availableSeats;
    
    
    Bus(int busNo, String route, int timeDepart) {
        this.busNo = busNo;
        this.route = route;
        this.timeDepart = timeDepart;
    }
    
    String getRouteName() {
        return route;
    }
    
    int getBusNo() {
        return busNo;
    }
    
    int getTimeDepart() {
        return timeDepart;
    }
    
    String getTimeDepartString() {
        return Integer.toString(timeDepart);
    }
    
    void createBus() throws IOException {
        try {
            Search search = new Search();
            BusFunctions busFunc = new BusFunctions();
         if (search.isRouteAvailable(route) == false) {
             JOptionPane.showMessageDialog(null, "This route doesn't exist", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         
         if (busNo > 5) {
             JOptionPane.showMessageDialog(null, "There are only 5 buses available", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         
         if(timeDepart > 11) {
             JOptionPane.showMessageDialog(null, "Departure time should be between 6 am - 11 pm", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         if (search.isBusReserved(busNo)) {
             JOptionPane.showMessageDialog(null, "This bus is already reserved", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         if (search.isRouteReservedInBus(route)) {
             JOptionPane.showMessageDialog(null, "This routes is already reserevd to another bus", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         busList.add(this);
         JOptionPane.showMessageDialog(null, "Bus was assigned to route successfully");
         busFunc.saveBusToFile();
        } catch(NotSerializableException e) {
           JOptionPane.showMessageDialog(null, "Bus: ERROR", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    

    
    void deleteBus(int busNumber, boolean output) throws IOException {
        Bus curBus;
        BusFunctions busFunc = new BusFunctions();
        if (busList.size() > 0) {
            for (int i = 0; i < busList.size(); i++) {
                curBus = busList.get(i);
                if (curBus.getBusNo() == busNumber) {
                    busList.remove(curBus);
                    busFunc.saveBusToFile();
                    if (output == true)
                        JOptionPane.showMessageDialog(null, "", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }
}
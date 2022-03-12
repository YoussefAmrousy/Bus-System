/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;
import javax.swing.JOptionPane;
import static project.Project.passengerList;


/**
 *
 * @author Amrousy
 */
public class Passenger implements Serializable {
    private String name;
    private String routeName;
    private String pickupPoint;
    private String destinationPoint;
    private int busNum;
    private int timeDepart;
    Search search = new Search();
    
    Passenger(String name, String routeName, String pickupPoint, String destinationPoint, int busNum, int timeDepart) {
        this.name = name;
        this.routeName = routeName;
        this.pickupPoint = pickupPoint;
        this.destinationPoint = destinationPoint;
        this.busNum = busNum;
        this.timeDepart = timeDepart;
    }
    
    void bookTicket() {
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger passenger = passengerList.get(i);
            if (passenger.timeDepart == timeDepart) {
                JOptionPane.showMessageDialog(null, "This route doesn't exist", null, JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
}




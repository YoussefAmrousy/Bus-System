/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static project.Project.busList;
import static project.Project.passengerList;

/**
 *
 * @author Amrousy
 */
public class PassengerFunctions {
    File passengerFile = new File("Bus.bin");
    void savePassengersToFile() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(passengerFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(passengerList);
            oos.close();
            fos.close();
        } catch(NotSerializableException e) {
           JOptionPane.showMessageDialog(null, "PassengerFunctions: ERROR", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void loadBuses() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
        if (passengerFile.exists() && passengerFile.length()!=0) {
            FileInputStream is = new FileInputStream(passengerFile);
            ObjectInputStream ois = new ObjectInputStream(is);
            passengerList=(ArrayList<Passenger>) ois.readObject();
            is.close();
            ois.close();
        }
        } catch(NotSerializableException e) {
           JOptionPane.showMessageDialog(null, "PassengerFunctions: ERROR", null, JOptionPane.ERROR_MESSAGE);
        }
    }
}

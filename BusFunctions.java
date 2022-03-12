/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static project.Project.busList;

/**
 *
 * @author Amrousy
 */
public class BusFunctions {
    File busFile = new File("Bus.bin");
    public void saveBusToFile() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(busFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(busList);
            oos.close();
            fos.close();
        } catch(NotSerializableException e) {
           JOptionPane.showMessageDialog(null, "Bus: ERROR", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void loadBuses() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
        if (busFile.exists() && busFile.length()!=0) {
            FileInputStream is = new FileInputStream(busFile);
            ObjectInputStream ois = new ObjectInputStream(is);
            busList=(ArrayList<Bus>) ois.readObject();
            is.close();
            ois.close();
        }
        } catch(NotSerializableException e) {
           JOptionPane.showMessageDialog(null, "Bus: ERROR", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String[] getAssignedBusesNos() {
        int[] busNos = new int[busList.size()];
        String[] busNoString = new String[busNos.length];
        for (int i = 0; i < busList.size(); i++) {
            Bus curBus = busList.get(i);
            busNos[i] = curBus.getBusNo();
        }
        for (int i = 0; i < busNos.length; i++) {
            busNoString[i] = String.valueOf(busNos[i]);
        }
        return busNoString;
    }
    
    public String getBusRouteName(int busNo) {
        for (int i = 0; i < busList.size(); i++) {
            Bus curBus = busList.get(i);
            if (curBus.getBusNo() == busNo) {
                return curBus.getRouteName();
            }
        }
        return null;
    }
    
    public String getTimeDeparture(int busNo) {
        for (int i = 0; i < busList.size(); i++) {
            Bus curBus = busList.get(i);
            if (curBus.getBusNo() == busNo) {
                return curBus.getTimeDepartString();
            }
        }
        return null;
    }
}

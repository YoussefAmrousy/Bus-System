/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Amrousy
 */
public class Project {
        static ArrayList<Bus> busList = new ArrayList<>(5);
        static ArrayList<User> userList = new ArrayList<>();
        static ArrayList<Passenger> passengerList = new ArrayList<>();
        public static ArrayList<String> routeCollection = new ArrayList<>();
        
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        LoginFrame loginframe = new LoginFrame();
        loginframe.showFrame();
    }
}

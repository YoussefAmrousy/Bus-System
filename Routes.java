/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import javax.swing.JOptionPane;
import static project.Project.routeCollection;
import static project.Project.busList;
/**
 *
 * @author Amrousy
 */

/** Route Name ( File Name):
 * Pickup Destination
 * Pickup Destination
 * Drop off Destination
 * Drop off Destination
 * Drop off Destination
 * Drop off Destination
 */
public class Routes {
    String[] routePoints = new String[6];
    RouteFunctions routeFunc = new RouteFunctions();
    Search search = new Search();
    
    public void getRoutePoints(String routeName) throws FileNotFoundException, IOException {
        if (search.isRouteAvailable(routeName) == true) {
            File file = new File(routeName + ".txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String route;
            int count = 0;
            while( (route = br.readLine()) != null && count < 6) {
                routePoints[count] = route;
                ++count;
            }
            fr.close();
            br.close();
        }
    }
    public String[] getDestinationPoints(String routeName) throws IOException {
        String[] destinationPoints = new String[4];
        getRoutePoints(routeName);
        destinationPoints[0] = routePoints[2];
        destinationPoints[1] = routePoints[3];
        destinationPoints[2] = routePoints[4];
        destinationPoints[3] = routePoints[5];
        return destinationPoints;
    }
    
        public String[] getPickupPoints(String routeName) throws FileNotFoundException, IOException {
        String[] pickupPoints = new String[2];
        getRoutePoints(routeName);
        for (int i = 0; i < 2; i++) {
            pickupPoints[i] = routePoints[i];
        }
        return pickupPoints;
    }
        
    public void createRoute(String route, String[] points) throws FileNotFoundException, IOException, ClassNotFoundException {
        if (search.isRouteAvailable(route) == true) {
            JOptionPane.showMessageDialog(null, "This route already exists!", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Route was created successfully");
        routeCollection.add(route);
        routeFunc.createRouteFile(route, points);
        routeFunc.saveRoutesToFile();
    }
    
    public boolean deleteRoute(String routeName) throws FileNotFoundException, IOException, ClassNotFoundException {
        if (search.isRouteAvailable(routeName) == true) {
            JOptionPane.showMessageDialog(null, "Route was deleted successfully");
            routeCollection.remove(routeName);
            routeFunc.saveRoutesToFile();
            for (int i = 0; i < busList.size(); i++) {
                Bus curBus = busList.get(i);
                if (curBus.getRouteName().equals(routeName)) {
                    BusFunctions busFunc = new BusFunctions();
                    curBus.deleteBus(curBus.getBusNo(), false);
                }
            }
            return true;
        }
        return false;
    }
}

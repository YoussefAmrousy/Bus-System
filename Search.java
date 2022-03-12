/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import static project.Project.routeCollection;
import static project.Project.busList;
/**
 *
 * @author Mayar, Amrousy
 */
public class Search {
    public boolean isRouteAvailable(String routeName) {
        for (int i = 0; i < routeCollection.size(); i++) {
            String curRoute = routeCollection.get(i);
            if (curRoute.equalsIgnoreCase(routeName))
                return true;
        }
        return false;
    }
    
    public boolean isBusReserved(int busNo) {
        for (int i = 0; i < busList.size(); i++) {
            Bus curBus = busList.get(i);
            if (curBus.getBusNo() == busNo)
                return true;
        }
        return false;
    }
    
    public boolean isRouteReservedInBus(String routeName) {
        for (int i = 0; i < busList.size(); i++) {
            Bus curBus = busList.get(i);
            if (curBus.getRouteName().equals(routeName))
                return true;
        }
        return false;
    }
}


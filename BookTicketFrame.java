/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Amrousy
 */

public class BookTicketFrame extends JFrame {
    RouteFunctions routeFunc = new RouteFunctions();
    Routes route = new Routes();
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel name = new JLabel("Name: ");
    JTextField nameField = new JTextField(6);
    JLabel routesLabel = new JLabel("Routes Available: ");
    JComboBox routesComboBox;
    JLabel pickupPoint = new JLabel("Choose Pickup point: ");
    JComboBox pickupPointComboBox = new JComboBox();
    JLabel destinationPoint = new JLabel("Choose Destination point: ");
    JComboBox destinationPointComboBox = new JComboBox();
    JLabel price = new JLabel("Total price: ");
    JLabel priceLabel = new JLabel("                          ");
    JLabel time = new JLabel("Time: ");
    JLabel timeLabel = new JLabel("                          ");
    JButton findPointsBtn = new JButton("Points");
    JButton bookTicketBtn = new JButton("Book Ticket");
    
    public BookTicketFrame() {
        routesComboBox = new JComboBox(routeFunc.returnRoutes().toArray());
        frame.setLayout(layout);
        frame.add(name);
        frame.add(nameField);
        frame.add(routesLabel);
        frame.add(routesComboBox);
        frame.add(pickupPoint);
        frame.add(pickupPointComboBox);
        frame.add(destinationPoint);
        frame.add(destinationPointComboBox);
        frame.add(price);
        frame.add(priceLabel);
        frame.add(time);
        frame.add(timeLabel);
        frame.add(findPointsBtn);
        frame.add(bookTicketBtn);
        
        findPointsBtn.setActionCommand("Points");
        findPointsBtn.addActionListener(new ButtonClickListener());
        bookTicketBtn.setActionCommand("Book Ticket");
        bookTicketBtn.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() {
        frame.setTitle("Book Ticket");
        frame.setLocationRelativeTo(null);
        frame.setSize(250, 300);
        frame.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "Points") {
                String routeName = (String) routesComboBox.getSelectedItem();
                if (routeName == null) {
                    JOptionPane.showMessageDialog(null, "You haven't choosen any route", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    pickupPointComboBox = new JComboBox(route.getPickupPoints(routeName));
                    destinationPointComboBox = new JComboBox(route.getDestinationPoints(routeName));
                    price.setVisible(true);
                    priceLabel.setVisible(true);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "BookTicketFrame: ERROR", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

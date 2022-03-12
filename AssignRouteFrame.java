/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Amrousy
 */
public class AssignRouteFrame extends JFrame {
    BusFunctions busFunc = new BusFunctions();
    RouteFunctions routeFunc = new RouteFunctions();
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel busNum = new JLabel("Bus Number: ");
    JTextField busNumF = new JTextField(4);
    JLabel routeName = new JLabel("Route Name: ");
    JComboBox routeNameComboBox = new JComboBox(routeFunc.returnRoutes().toArray());
    JLabel timeDepart = new JLabel("Time Departrue: ");
    JTextField timeDepartF = new JTextField(4);
    JButton button = new JButton("Assign Route");
    
    public AssignRouteFrame() {
        frame.setLayout(layout);
        frame.add(busNum);
        frame.add(busNumF);
        frame.add(routeName);
        frame.add(routeNameComboBox);
        frame.add(timeDepart);
        frame.add(timeDepartF);
        frame.add(button);
        
        button.setActionCommand("AssignRouteBtn");
        button.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() throws IOException, FileNotFoundException, ClassNotFoundException {
        frame.setTitle("Route Management");
        frame.setLocationRelativeTo(null);
        frame.setSize(200, 250);
        frame.setVisible(true);    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "AssignRouteBtn") {
                String busNum = busNumF.getText();
                String time = timeDepartF.getText();
                String route = (String) routeNameComboBox.getSelectedItem();
                if (route == null || busNum.isEmpty() || time.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    int busNoInt = Integer.parseInt(busNum);
                    int timeInt = Integer.parseInt(time);
                    Bus busEntered = new Bus(busNoInt, route, timeInt);
                    busEntered.createBus();
                } catch (IOException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "AssignRouteFrame: ERROR", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

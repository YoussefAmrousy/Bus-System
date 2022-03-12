/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Amrousy
 */
public class PassengerFrame extends JFrame {
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JButton bookTicket = new JButton("Book Ticket");
    JButton suggest = new JButton("Suggest/Complaint");
    JButton chat = new JButton("Chat");
    
    public PassengerFrame() {
        frame.setLayout(layout);
        frame.add(bookTicket);
        frame.add(suggest);
        frame.add(chat);
        
        bookTicket.setActionCommand("Book Ticket");
        bookTicket.addActionListener(new ButtonClickListener());
        
        suggest.setActionCommand("Suggest/Complaint");
        suggest.addActionListener(new ButtonClickListener());
        
        chat.setActionCommand("Chat");
        chat.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() {
        frame.setTitle("Admin");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 230);
        frame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
        }
    }
}

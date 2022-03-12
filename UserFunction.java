/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static project.Project.userList;

/**
 *
 * @author Amrousy
 */
public class UserFunction {
    public void saveUsersToFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("Users.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userList);
        oos.close();
        fos.close(); 
    }
    
    public void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        File usersFile = new File("Users.bin");
        if (usersFile.exists() && usersFile.length()!=0) {
            FileInputStream is = new FileInputStream(usersFile);
            ObjectInputStream ois = new ObjectInputStream(is);
            userList=(ArrayList<User>) ois.readObject();
            is.close();
            ois.close();
        }
    }
    
    boolean userLogin(String enteredUsername, String enteredPassword) throws IOException, FileNotFoundException, ClassNotFoundException {
        User user;
        if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Welcome, Admin");
            AdminFrame adminF = new AdminFrame();
            adminF.showFrame();
            return true;
        }
        loadUsers();
        if (userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {
                user = userList.get(i);
                if (user.username.equals(enteredUsername) && user.password.equals(enteredPassword)) {
                    JOptionPane.showMessageDialog(null, "Welcome, " + enteredUsername);
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Wrong Username/Password", null, JOptionPane.ERROR_MESSAGE);
        return false;
    }    
    
    boolean userRegister(String enteredUsername, String enteredPassword, String email) throws IOException, FileNotFoundException, ClassNotFoundException {
        loadUsers();
        User user;
        for (int i = 0; i < userList.size(); i++) {
            user = userList.get(i);
            if (user.username.equals(enteredUsername)) {
                JOptionPane.showMessageDialog(null, "This username already exists!", null, JOptionPane.ERROR_MESSAGE);
                return false ;
            }
        }
        if (enteredPassword.length() < 5) {
            JOptionPane.showMessageDialog(null, "The minimum length for password is 5 characters", null, JOptionPane.ERROR_MESSAGE);
            return false ;
        }
        user = new User(enteredUsername, enteredPassword, email);
        userList.add(user);
        saveUsersToFile();
        JOptionPane.showMessageDialog(null, "You've registerd successfuly");
        return true;
    }
}

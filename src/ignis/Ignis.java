/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author hectordiazaceves
 */
public class Ignis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database database = new Database();
        
        database.getData();
        getCredentials();
        
        
    }

    public static void getCredentials() {
        JFrame f = new JFrame("Authentication Panel");
        f.setSize(500, 300);
        
        //Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 100, 140, 40);
        
        //Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 100, 140, 40);
        

        //Enter username label
        JLabel label = new JLabel();
        label.setText("Enter Username :");
        label.setBounds(10, 10, 150, 100);
        
        
        //Label which shows if a username already has that or if registered successfully or login failed
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(10, 110, 200, 100);
        

        //Textfield to enter username
        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(170, 50, 200, 30);
        

        //Add elements to frame
        f.add(messageLabel);
        f.add(usernameTextField);
        f.add(label);
        f.add(registerButton);
        f.add(loginButton);
        f.setLayout(null);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //action listener
        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                messageLabel.setText("Name has been submitted.");
                String username = usernameTextField.getText();
                Database database = new Database();
                database.registerUser(username);
                Game g = new Game("Atomos", 1200, 800);
                g.start();
            }

        });
    }

}

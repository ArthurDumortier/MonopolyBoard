import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Inputs.SoundHandler;

class MonopolyStartMenu extends JFrame {
    MonopolyStartMenu() {
        super("Monopoly");

        JPanel panel = new JPanel(new FlowLayout());
        panel.setLayout(null);

        // to be able to display the menu image
        ImageIcon monopolyLogo = new ImageIcon("Ressources/Epitech.gif");
        JLabel imageLabel = new JLabel(monopolyLogo);
        imageLabel.setBounds(0, 0, 500, 600);

        // start button
        JButton startButton = new JButton();
        startButton.setBounds(160, 300, 180, 40);

        // next two lines are for make the buttons transparent
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);

        // action listener when click
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Plateau p = new Plateau(); // open the game
            }
        });

        // exit button
        JButton exitButton = new JButton("Exit Game");
        exitButton.setBounds(160, 370, 180, 40);

        // next two lines are for make the buttons transparent
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);

        // action listener when click
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Game",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0); // exit game
                }
            }
        });

        // everything we add we need to add here too
        panel.add(imageLabel);
        panel.add(startButton);
        panel.add(exitButton);

        // set element position
        panel.setComponentZOrder(imageLabel, 0);
        panel.setComponentZOrder(startButton, 1);
        panel.setComponentZOrder(exitButton, 1);

        add(panel);

        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        SoundHandler.RunMusic("Ressources/StartMusique.wav");
    }

    public static void main(String args[]) {
        new MonopolyStartMenu();
    }
}
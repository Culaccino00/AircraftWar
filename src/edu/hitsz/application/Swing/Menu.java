package edu.hitsz.application.Swing;

import edu.hitsz.application.Game.EasyGame;
import edu.hitsz.application.Game.Game;
import edu.hitsz.application.Game.HardGame;
import edu.hitsz.application.Game.MediumGame;
import edu.hitsz.application.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Menu{
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JComboBox musicCombo;
    private JLabel musicLabel;
    private JPanel easyPanel;
    private JPanel mediumPanel;
    private JPanel hardPanel;
    private JPanel musicPanel;
    private JPanel mainPanel;

    public Menu() {


        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new EasyGame();
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                game.action();
            }
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new MediumGame();
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                game.action();
            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new HardGame();
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                game.action();
            }
        });
        musicCombo.addItem("开启");
        musicCombo.addItem("关闭");
        musicCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = e.getItem().toString();
                switch (item){
                    case "开启":
                        System.out.println("音效开启！");
                        break;
                    case "关闭":
                        System.out.println("音效关闭！");
                        break;
                    default:
                }
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

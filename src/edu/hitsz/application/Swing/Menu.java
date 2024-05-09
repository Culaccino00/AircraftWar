package edu.hitsz.application.Swing;

import edu.hitsz.application.Game.EasyGame;
import edu.hitsz.application.Game.Game;
import edu.hitsz.application.Game.HardGame;
import edu.hitsz.application.Game.MediumGame;
import edu.hitsz.application.Main;
import edu.hitsz.application.Music.MusicPlayer;
import edu.hitsz.application.Music.MusicThread;

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


        /**
         * 点击按钮，选择游戏难度
         */
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
        /**
         * 设置音效开启 /关闭
         */
        musicCombo.addItem("开启");
        musicCombo.addItem("关闭");
        musicCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = e.getItem().toString();
                if(item == "关闭"){
                    MusicPlayer.getMusicPlayer().noMusic();
                }
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

}

package edu.hitsz.application.Swing;

import edu.hitsz.DAO.Record;
import edu.hitsz.DAO.RecordDao;
import edu.hitsz.DAO.RecordDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RankList {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JTable rankTable;
    private JButton deleteButton;
    private JLabel levelLabel;
    private JLabel rankLabel;
    private JScrollPane rankScroll;
    private List<Record> records ;
    String[] columnNames = {"名次", "玩家名", "得分", "记录时间"};
    String[][] tableData = null;

    private RecordDao recordDao;
    DefaultTableModel model ;
    public RankList(int level) {
        if(level==1){
            levelLabel.setText("难度：EASY");
        }else if (level==2){
            levelLabel.setText("难度：MEDIUM");
        }else if (level==3){
            levelLabel.setText("难度：HARD");
        }
        recordDao = new RecordDaoImpl(level);
        try {
            records = recordDao.getAllRecord(level);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        getScoreTable(level);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = rankTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的行", "warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    int result = JOptionPane.showConfirmDialog(null, "是否确认删除选中的玩家？", "选择一个选项", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (result == JOptionPane.YES_OPTION) {

                        try {
                            recordDao.deleteRecord(row, level);
                            model.removeRow(row);
                            refresh(level);
                        } catch (IOException | ClassNotFoundException ioException) {
                            throw new RuntimeException(ioException);
                        }
                    }
                }
                showRankList(level);
            }
        });
    }
    private void getScoreTable(int level){
        if(records != null && !records.isEmpty()){
            for (Record record : records) {
                tableData = new String[records.size()][4];
                for (int i = 0; i < records.size(); i++) {
                    tableData[i][0] = String.valueOf(i + 1);
                    tableData[i][1] = records.get(i).getUserName();
                    tableData[i][2] = String.valueOf(records.get(i).getScore());
                    tableData[i][3] = records.get(i).getTime();
                }
            }
        }
        else {
            tableData = null;
        }
    }
    public void refresh(int level) throws IOException, ClassNotFoundException {
        records = recordDao.getAllRecord(level);
        getScoreTable(level);
        recordDao.printRecord(level);
    }
    public void inputRecord(int score, int level){
        String input = null;
        input = JOptionPane.showInputDialog(null, "游戏结束，您的分数为"+score+",\n"+"请输入名字记录得分：");
//        if (input == null || input.isEmpty()) {
        if (input == null ) {
            JOptionPane.showMessageDialog(null, "未成功保存数据", "warning",JOptionPane.WARNING_MESSAGE);
            try {
                recordDao.printRecord(level);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            if(input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "未输入名字，您的名字将为 John Doe ！", "warning",JOptionPane.WARNING_MESSAGE);
                input = "John Doe";
            }
            //获取当前时间
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
            Record record = new Record();
            record.setUserName(input);
            record.setScore(score);
            record.setTime(formatter.format(date));
            try {
                //更新数据
                recordDao.updateRecord(record, level);
                refresh(level);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void showRankList(int level){
        getScoreTable(level);
        model = new DefaultTableModel(tableData, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //从表格模型那里获取数据
        rankTable.setModel(model);
        rankScroll.setViewportView(rankTable);
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

}

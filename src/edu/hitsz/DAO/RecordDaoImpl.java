package edu.hitsz.DAO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class RecordDaoImpl implements RecordDao{
    private File file= new File("src/edu/hitsz/DAO/Record.dat");
    // 构建FileOutputStream对象,文件不存在会自动新建
    public RecordDaoImpl() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读取文件中的数据
    @Override
    public List<Record> getAllRecord() throws IOException, ClassNotFoundException {
        List<Record> records = new ArrayList<>();
        if(file.exists() && file.length() != 0){
            //从文件中读取数据
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            while(fileInputStream.available() > 0){
                records = (List<Record>) ois.readObject();
            }
            fileInputStream.close();
            ois.close();
            return records;
        }else{
            return new ArrayList<>();
        }
    }

    //加入某个记录，并重新排序
    @Override
    public void updateRecord(Record record) throws IOException{
        List<Record> records;
        try {
            records = getAllRecord();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        records.add(record);
        //根据分数排序
        if(records.size() > 1){
            Collections.sort(records, (o1, o2) -> o2.getScore() - o1.getScore());
        }
        //将数据写入文件
        writeRecord(records);
    }

    //删除某个记录
    @Override
    public void deleteRecord(int row) throws IOException{
        List<Record> records;
        try {
            records = getAllRecord();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        records.remove(records.get(row));
        //将数据写入文件
        writeRecord(records);
    }

    //将榜单写入文件
    @Override
    public void writeRecord(List<Record> records) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(records);
        oos.close();
    }

    //打印榜单
    @Override
    public void printRecord() throws IOException {
        if(file.exists()){
            List<Record> records;
            try {
                records = getAllRecord();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            //通过字符输出流实现可读文件
            FileWriter fileWriter ;
            fileWriter = new FileWriter("src/edu/hitsz/DAO/Ranking.txt");
            int i = 1;
            System.out.println("""
                **************************************
                               得分排行榜
                **************************************""");
            for(Record record : records){
                System.out.println("第"+i+"名: "+record.getUserName() + "," + record.getScore() + "," + record.getTime());
                fileWriter.write("第"+i+"名: "+record.getUserName() + "," + record.getScore() + "," + record.getTime()+"\n");
                i ++;
            }
            fileWriter.close();
        }
    }
}

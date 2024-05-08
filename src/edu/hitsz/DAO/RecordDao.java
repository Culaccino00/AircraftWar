package edu.hitsz.DAO;

import java.io.IOException;
import java.util.List;

public interface RecordDao {
    /**
     * 获取所有数据
     * @param
     */
    List<Record> getAllRecord(int level) throws IOException, ClassNotFoundException;

    /**
     * 将新的成绩加入榜单，并对榜单进行由高到低排序
     * @param record
     */
    void updateRecord(Record record, int level) throws IOException;

    /**
     * 删除数据
     * @param row
     */
    void deleteRecord(int row, int level) throws IOException;

    /**
     * 获取用户可读的榜单文件
     */
    void writeRecord(List<Record> records, int level) throws IOException;
    void printRecord(int level) throws IOException;
}

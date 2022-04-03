package dao;

import Model.ClassManager;

import java.sql.SQLException;
import java.util.List;

public interface IClassDAO {
    public void insertClassManager (ClassManager classManager) throws SQLException;
    public ClassManager selectClassManager(int id);

    public List<ClassManager> selectAllClassManager();

    public boolean deleteClassManager(int id) throws SQLException;

    public boolean updateClassManager(ClassManager classManager) throws SQLException;
}

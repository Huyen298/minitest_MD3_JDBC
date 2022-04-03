package service;

import Model.ClassManager;

import java.util.List;

public interface ClassService {
    List<ClassManager> findAll();

    void save(ClassManager classManager);

    ClassManager findById(int id);

    void update(int id, ClassManager classManager);

    void remove(int id);
}

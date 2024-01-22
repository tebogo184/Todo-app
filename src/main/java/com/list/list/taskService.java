package com.list.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class taskService {

    @Autowired
    private taskRepostiory taskRepo;

    public List<taskEntity> getAllTask() {
        return taskRepo.findAll();
    }

    public taskEntity getTaskById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    public void updateTask(taskEntity task, Long id) {
        if (task != null) {
            taskEntity tempTask = taskRepo.findById(id).orElse(null);
            tempTask.setTaskName(task.getTaskName());
            taskRepo.save(tempTask);
        }
    }

    public void saveTask(taskEntity task) {

        taskRepo.save(task);
    }

    public void deleteTaskById(Long id) {
        taskRepo.deleteById(id);
    }

    public void deleteAllTasks() {
        taskRepo.deleteAll();
    }
}

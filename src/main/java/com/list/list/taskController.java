package com.list.list;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
public class taskController {

    @Autowired
    private taskService TaskService;

    @RequestMapping("/AllTasks")
    public List<taskEntity> findAllTasks() {
        return TaskService.getAllTask();
    }

    @PostMapping("/update/{id}")
    public void UpdateTask(@RequestBody taskEntity task, @PathVariable Long id) {
        TaskService.updateTask(task, id);
    }

    @PostMapping("/saveTask")
    public void SaveTask(@ModelAttribute taskEntity task) {
        TaskService.saveTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        TaskService.deleteTaskById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllTasks() {
        TaskService.deleteAllTasks();
    }

}

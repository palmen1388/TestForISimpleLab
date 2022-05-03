package Emelyanov.TodoList.Actions.ShowTasks;

import Emelyanov.TodoList.Actions.Action;
import Emelyanov.TodoList.Task.Task;
import Emelyanov.TodoList.Task.TaskStatus;

import java.util.ArrayList;

public class ShowInProgressTasks implements Action {

    private final String name;

    public ShowInProgressTasks() {
        this.name = "list_in_progress";
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void doAction(ArrayList<Task> taskList) {
        for (Task task : taskList) {
            if (TaskStatus.IN_PROGRESS.equals(task.getTaskStatus())) {
                System.out.println(task);
            }
        }
    }

    public String toString() {
        return name;
    }
}

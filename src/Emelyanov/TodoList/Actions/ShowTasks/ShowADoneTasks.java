package Emelyanov.TodoList.Actions.ShowTasks;

import Emelyanov.TodoList.Actions.Action;
import Emelyanov.TodoList.Task.Task;
import Emelyanov.TodoList.Task.TaskStatus;

import java.util.ArrayList;

public class ShowADoneTasks implements Action {

    private final String name;

    public ShowADoneTasks() {
        this.name = "list_done";
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void doAction(ArrayList<Task> taskList) {
        for (Task task : taskList) {
            if (TaskStatus.DONE.equals(task.getTaskStatus())) {
                System.out.println(task);
            }
        }
    }

    public String toString() {
        return name;
    }
}

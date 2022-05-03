package Emelyanov.TodoList.Actions.ShowTasks;

import Emelyanov.TodoList.Actions.Action;
import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;

public class ShowTasks extends Action {

    private String name;

    public ShowTasks() {
        this.name = "list";
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void doAction(ArrayList<Task> taskList) {
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }

    public String toString() {
        return name;
    }
}

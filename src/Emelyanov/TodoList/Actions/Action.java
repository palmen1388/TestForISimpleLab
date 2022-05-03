package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;

public interface Action {

    String name = null;

    default String getName() {
        return name;
    }

    void doAction(ArrayList <Task> taskList);


}

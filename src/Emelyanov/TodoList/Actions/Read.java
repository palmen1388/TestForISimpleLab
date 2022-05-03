package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;

public abstract class Read implements Action {

    @Override
    public abstract void doAction(ArrayList<Task> taskList);
}

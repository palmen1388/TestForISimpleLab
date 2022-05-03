package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;

public abstract class Read extends Action {

    @Override
    public abstract void doAction(ArrayList<Task> taskList);
}

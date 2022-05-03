package Emelyanov.TodoList;

import Emelyanov.TodoList.Actions.Action;
import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;

public class ActionMenu {

    private Action[] actions;

    public ActionMenu(Action[] actions) {
        this.actions = actions;
    }

    public void executeAction(String value, ArrayList<Task> taskList) {
        int temp = 0;
        for (Action action : actions) {
            if (action.getName().equalsIgnoreCase(value)) {
                action.doAction(taskList);
                temp++;
            }
            if ("help".equalsIgnoreCase(value)) {
                System.out.println(action.getName());
                temp++;
            }
        }
        if (temp == 0) {
            System.out.println("Такой команды не существует");
        }
    }
}


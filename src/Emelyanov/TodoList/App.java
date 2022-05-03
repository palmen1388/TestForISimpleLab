package Emelyanov.TodoList;

import Emelyanov.TodoList.Actions.*;
import Emelyanov.TodoList.Actions.ShowTasks.ShowADoneTasks;
import Emelyanov.TodoList.Actions.ShowTasks.ShowInProgressTasks;
import Emelyanov.TodoList.Actions.ShowTasks.ShowNewTasks;
import Emelyanov.TodoList.Actions.ShowTasks.ShowTasks;
import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
        Action[] actions = {
                new ReadFromXml(),
                new CreateNewTask(),
                new EditTask(),
                new RemoveTask(),
                new TagTaskLikeDone(),
                new TagTaskLikeInProgress(),
                new ShowTasks(),
                new ShowNewTasks(),
                new ShowADoneTasks(),
                new ShowInProgressTasks(),
                new SaveToXml()};
        ActionMenu actionMenu = new ActionMenu(actions);
        System.out.println("Можете ввести help для вывода команд");
        String userValue = scanner.nextLine();
        while (!"exit".equalsIgnoreCase(userValue)) {
                actionMenu.executeAction(userValue, taskList);
            int temp = 1;
            for (Task task : taskList) {
                task.setId(temp);
                temp++;
            }
            userValue = scanner.nextLine();
        }
        actionMenu.executeAction(userValue, taskList);
    }
}


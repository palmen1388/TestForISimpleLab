package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveTask implements Action {

    private Scanner scanner = new Scanner(System.in);
    private String name;

    public RemoveTask() {
        this.name = "remove";
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void doAction(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Введите id задачи которую хотите удалить");
            int id = scanner.nextInt();
            for (int i = 0; i < taskList.size(); i++) {
                if (id < 1 || id > taskList.size()) {
                    System.out.println("Такой задачи нет, вы ничего не изменили");
                    break;
                }
                if (id == taskList.get(i).getId()) {
                    taskList.remove(i);
                }
            }
        }
    }

    public String toString() {
        return name;
    }
}


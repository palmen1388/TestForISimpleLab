package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;
import Emelyanov.TodoList.Task.TaskStatus;

import java.util.ArrayList;
import java.util.Scanner;

public class TagTaskLikeInProgress extends Action {

    private Scanner scanner = new Scanner(System.in);
    private String name;

    public TagTaskLikeInProgress() {
        this.name = "in_progress";
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
            System.out.println("Введите id задачи которую хотите пометить как в процессе");
            int id = scanner.nextInt();
            for (Task task : taskList) {
                if (id == task.getId()) {
                    task.setTaskStatus(TaskStatus.IN_PROGRESS);
                }
                if (id < 1 || id > taskList.size()) {
                    System.out.println("Такой задачи нет, вы ничего не изменили");
                    break;
                }
            }
        }
    }

    public String toString() {
        return name;
    }
}

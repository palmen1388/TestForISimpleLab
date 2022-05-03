package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;
import Emelyanov.TodoList.Task.TaskStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TagTaskLikeDone extends Action {

    private Scanner scanner = new Scanner(System.in);
    private String name;

    public TagTaskLikeDone() {
        this.name = "complete";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doAction(ArrayList<Task> taskList) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = dateFormat.format(date);
        if (taskList.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Введите id задачи которую хотите пометить как выполненную");
            int id = scanner.nextInt();
            for (Task task : taskList) {
                if (id == task.getId()) {
                    task.setTaskStatus(TaskStatus.DONE);
                    task.setDateOfCompletion(currentDate);
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

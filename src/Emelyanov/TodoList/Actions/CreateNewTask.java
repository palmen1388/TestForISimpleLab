package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;
import Emelyanov.TodoList.Task.TaskStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CreateNewTask extends Action {

    private Scanner scanner = new Scanner(System.in);
    private String name;

    public CreateNewTask() {
        this.name = "new";
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
        Task task = new Task();
        task.setTaskStatus(TaskStatus.NEW);
        System.out.println("Введите заголовок задачи от 1 до 50 символов");
        task.setHeader(scanner.next());
        if (task.getHeader().length() > 50) {
            String cutString = task.getHeader().substring(0, 50);
            task.setHeader(cutString);
        }
        System.out.println("Введите описание задачи");
        task.setDescription(scanner.next());
        System.out.println("Введите приоритетность задачи от 0 до 10");
        task.setPriority(scanner.nextInt());
        while (task.getPriority() < 0 || task.getPriority() > 10) {
            System.out.println("Введите значение от 0 до 10");
            task.setPriority(scanner.nextInt());
        }
        task.setDate(currentDate);
        taskList.add(task);
    }
    public String toString() {
        return name;
    }
}

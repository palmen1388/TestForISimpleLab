package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class EditTask extends Action {

    private Scanner scanner = new Scanner(System.in);
    private String confirmation;
    private String name;

    public EditTask() {
        this.name = "edit";
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
            System.out.println("Введите id задачи которую хотите изменить");
            int id = scanner.nextInt();
            for (Task task : taskList) {
                if (task.getId() == id) {
                    System.out.println("Вы действительно хотите изменить задачу, если уверены 'Y' иначе 'N'");
                    confirmation = scanner.next();
                    while (!("y".equalsIgnoreCase(confirmation) || "n".equalsIgnoreCase(confirmation))) {
                        System.out.println("Введите 'Y' или 'N'");
                        confirmation = scanner.next();
                    }
                    if (confirmation.equalsIgnoreCase("y")) {
                        System.out.println("Измените заголовок задачи от 1 до 50 символов");
                        task.setHeader(scanner.next());
                        if (task.getHeader().length() > 50) {
                            String cutString = task.getHeader().substring(0, 50);
                            task.setHeader(cutString);
                        }
                        System.out.println("Измените описание задачи");
                        task.setDescription(scanner.next());

                        System.out.println("Измените важность задачи");
                        task.setPriority(scanner.nextInt());
                        while (task.getPriority() < 0 || task.getPriority() > 10) {
                            System.out.println("Введите значение от 0 до 10");
                            task.setPriority(scanner.nextInt());
                        }
                    } else if (confirmation.equalsIgnoreCase("n")) {
                        break;
                    }
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

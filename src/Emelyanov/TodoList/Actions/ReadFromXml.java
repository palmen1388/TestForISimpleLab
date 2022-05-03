package Emelyanov.TodoList.Actions;

import Emelyanov.TodoList.Task.Task;
import Emelyanov.TodoList.Task.TaskStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class ReadFromXml extends Read {

    private String name;
    private TaskStatus[] taskStatuses = TaskStatus.values();

    public ReadFromXml() {
        this.name = "read";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doAction(ArrayList<Task> taskList) {
        try {
            File xmlFile = new File("TodoList.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Task");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Task task = new Task();
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    task.setId(Integer.parseInt(element.getAttribute("id")));
                    task.setHeader(element.getElementsByTagName("header").item(0).getTextContent());
                    task.setDescription(element.getElementsByTagName("description").item(0).getTextContent());
                    task.setPriority(Integer.parseInt(element.getElementsByTagName("priority").item(0).getTextContent()));
                    task.setDate(element.getElementsByTagName("date").item(0).getTextContent());
                    String status = element.getElementsByTagName("taskStatus").item(0).getTextContent();
                    for (TaskStatus taskStatus : taskStatuses) {
                        if (status.equals(String.valueOf(taskStatus))) {
                            task.setTaskStatus(taskStatus);
                        }
                    }
                    if (element.getElementsByTagName("dateOfCompletion").item(0) != null) {
                        task.setDateOfCompletion(element.getElementsByTagName("dateOfCompletion").item(0).getTextContent());
                    }
                    taskList.add(task);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





package Emelyanov.TodoList.Actions;


import Emelyanov.TodoList.Task.Task;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class SaveToXml extends Save {

    private String name;

    public SaveToXml() {
        this.name = "exit";
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void doAction(ArrayList<Task> taskList) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("TodoList");
            doc.appendChild(rootElement);
            for (Task item : taskList) {
                Element task = doc.createElement("Task");
                rootElement.appendChild(task);
                task.setAttribute("id", String.valueOf(item.getId()));
                Element header = doc.createElement("header");
                header.appendChild(doc.createTextNode(item.getHeader()));
                task.appendChild(header);
                Element description = doc.createElement("description");
                description.appendChild(doc.createTextNode(item.getDescription()));
                task.appendChild(description);
                Element priority = doc.createElement("priority");
                priority.appendChild(doc.createTextNode(String.valueOf(item.getPriority())));
                task.appendChild(priority);
                Element date = doc.createElement("date");
                date.appendChild(doc.createTextNode(item.getDate()));
                task.appendChild(date);
                Element taskStatus = doc.createElement("taskStatus");
                taskStatus.appendChild(doc.createTextNode(item.getTaskStatus().toString()));
                task.appendChild(taskStatus);
                if (item.getDateOfCompletion() != null) {
                    Element dateOfCompletion = doc.createElement("dateOfCompletion");
                    dateOfCompletion.appendChild(doc.createTextNode(item.getDateOfCompletion()));
                    task.appendChild(dateOfCompletion);
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("TodoList.xml"));
            transformer.transform(source, result);
            System.out.println("Файл сохранен");
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}

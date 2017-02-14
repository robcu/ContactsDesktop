package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    ListView list;
    @FXML
    TextField name;
    @FXML
    TextField phone;
    @FXML
    TextField email;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

    public void addContact() throws IOException {
        Contact contact = new Contact(name.getText(), phone.getText(), email.getText());
        contacts.add(contact);
        writeJson();
    }

    public void removeContact() throws IOException {
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
        writeJson();
    }

    public void writeJson() throws IOException {
        File f = new File("people.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(contacts);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }
}

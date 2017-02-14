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

    public void addContact(){
        Contact contact = new Contact(name.getText(), phone.getText(), email.getText());
        contacts.add(contact);
    }
    public void removeContact(){
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }

//    public void writeJson(){
//
//    }
}

# ListViewWithTextArea
//Person listView to add and delete person with profile textArea
//This is the wrong way to do this, as it changes the toString method in the Person.

/**
 * Author: Johnny Taylor
 * ListView with Text area that takes user first name, last name and hobbies
 * then adds the as a Person class category into a list with formatted TextArea.
 */
package listviewwithtextarea;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ListViewWithTextAreaController implements Initializable{
    
    //Key Component: ObservableList with variety of string item types for list.
    final ObservableList<Person> listPerson = FXCollections.observableArrayList();

   @FXML
    private TextArea textArea;

    @FXML
    private ListView<Person> listView;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextArea personalHobbies;
     
    
    @FXML
    void addButtonClicked(ActionEvent event) {
        //adds new item from the user to the list.
        
        Person newPerson = new Person(firstName.getText(), lastName.getText(),personalHobbies.getText());
        
        listPerson.add(newPerson);
        
        //shows the currently added Person to the TextField.
        textArea.setText(newPerson.toString());
        clearTextRefocus();

    }
    
    @FXML
    void deleteButtonClicked(ActionEvent event){
        //Deletes the currently selected Person from the list.
        Person selectionToRemove = listView.getSelectionModel().getSelectedItem();
        listPerson.remove(selectionToRemove);
        
        textArea.clear();
        clearTextRefocus();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        //Set the listed observableList items to the listView as selections.
        listPerson.add(new Person("Sam", "Hill", "Spelunking and exploring caves."));
        listPerson.add(new Person("Jane", "Plane", "Reading Books and sewing."));
        listPerson.add(new Person("Bernice", "Ternice", " Things and stuff."));
        listView.setItems(listPerson);

        
        //cell factory implemented.
        listView.setCellFactory(param -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person p, boolean empty){
            super.updateItem(p, empty);
                if(empty || p == null || p.getFirstName() == null){
                    setText("");
                }
                else{
                    setText(p.getFirstName());
                    //Change listener implemented.
                    listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Person> observable, Person oldValue, Person newValue) -> {
            if(listView.isFocused()){
                textArea.setText(newValue.toString());
            }
        });    
                }
                
            }
        });
        
        Platform.runLater(new Runnable(){
            @Override
            public void run(){
                listView.requestFocus();
            }
        });
    }

    public void clearTextRefocus(){
        //Auto clear the user Typing textFields.
        firstName.clear();
        lastName.clear();
        personalHobbies.clear();
        
        listView.requestFocus(); //Place focus back on the list (stops focus glitch).
    }
    
        //Person  class.
    private static class Person {
        
    private String firstName;
    private String lastName;
    private String personalHobbies;
    
    public Person(String firstName, String lastName, String hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalHobbies = hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalHobbies() {
        return personalHobbies;
    }

    public void setPersonalHobbies(String personalHobbies) {
        this.personalHobbies = personalHobbies;
    }

    @Override
    public String toString() {
        return String.format(getFirstName() + "\n" + getLastName() + "\n\t" + getPersonalHobbies());     
            
        }
    }

}

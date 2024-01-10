package hr.javafx.miletic7;

import hr.javafx.miletic7.model.Address;
import hr.javafx.miletic7.model.Factory;
import hr.javafx.miletic7.utils.FileUtils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;

public class FactoryAddController implements Initializable{
    @FXML private TextField nameTextField;
    @FXML private TextField streetTextField;
    @FXML private ListView itemsListView;

    public void addNewFactory() {
        if (!nameTextField.getText().isEmpty() && !streetTextField.getText().isEmpty() && !itemsListView.getSelectionModel().isEmpty())
            HelloApplication.factories.add(new Factory(FileUtils.getNextFactoryId(), nameTextField.getText(),
                    new Address.AddressBuilder(streetTextField.getText()).build(), new HashSet<>(itemsListView.getSelectionModel().getSelectedItems())));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemsListView.setItems(FXCollections.observableArrayList(HelloApplication.items));
        itemsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}

package hr.javafx.miletic7;

import hr.javafx.miletic7.model.Category;
import hr.javafx.miletic7.model.Item;
import hr.javafx.miletic7.utils.FileUtils;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CategoryScreenController implements Initializable {
    @FXML
    private TextField categoryIdTextField;
    @FXML
    private TextField categoryNameTextField;
    @FXML
    private TableView<Category> categoryTableView;
    @FXML
    private TableColumn<Category,String> categoryIdTableColumn;
    @FXML
    private TableColumn<Category, String> categoryNameTableColumn;
    @FXML
    private TableColumn<Category, String> categoryDescTableColumn;

    public void categorySearch(){
        ObservableList<Category> observableCategoryList= FXCollections.observableArrayList(hr.javafx.miletic7.HelloApplication.categories);

        categoryTableView.setItems(observableCategoryList);
    }

    public void searchCategoryById(){
        Long categoryId= Long.valueOf(categoryIdTextField.getText());

        List<Category> filteredList= hr.javafx.miletic7.HelloApplication.categories.stream()
                .filter(category->category.getId().equals(categoryId))
                .collect(Collectors.toList());

        ObservableList<Category> observableCategoryList= FXCollections.observableArrayList(filteredList);
        categoryTableView.setItems(observableCategoryList);
    }

    public void searchCategoryByName(){
        String categoryName=categoryNameTextField.getText();

        List<Category> filteredList= hr.javafx.miletic7.HelloApplication.categories.stream()
                .filter(category->category.getName().contains(categoryName))
                .collect(Collectors.toList());

        ObservableList<Category> observableCategoryList= FXCollections.observableArrayList(filteredList);
        categoryTableView.setItems(observableCategoryList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryIdTableColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Category,String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Category,String> param){
                        return new ReadOnlyStringWrapper(param.getValue().getId().toString());
                    }
                }
        );

        categoryNameTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Category, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Category, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getName());
            }
        });

        categoryDescTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Category, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Category, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getDescription());
            }
        });
    }
}

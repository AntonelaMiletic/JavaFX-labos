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
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ItemSearchController implements Initializable {
    List<Category> categories=FileUtils.getCategoriesFromFile();
    @FXML
    private TextField itemNameTextField;
    @FXML
    private ComboBox<String> itemsCategoryComboBox;
    @FXML
    private TableView<Item> itemsTableView;
    @FXML
    private TableColumn<Item, String> itemNameTableColumn;
    @FXML
    private TableColumn<Item, String> itemCategoryTableColumn;
    @FXML
    private TableColumn<Item, String> itemWidthTableColumn;
    @FXML
    private TableColumn<Item, String> itemHeightTableColumn;
    @FXML
    private TableColumn<Item, String> itemLengthTableColumn;
    @FXML
    private TableColumn<Item, String> itemProductionCostsTableColumn;
    @FXML
    private TableColumn<Item, String> itemSellingPriceTableColumn;
    @FXML
    private TableColumn<Item, String> itemDiscountTableColumn;

    @FXML
    public void initializeComboBox(URL url, ResourceBundle resourceBundle){
        List<String> categoryItems=categories.stream()
                .map(Category::getName)
                .sorted()
                .collect(Collectors.toList());

        ObservableList<String> observableCategoryList=FXCollections.observableArrayList(categoryItems);
        itemsCategoryComboBox.setItems(observableCategoryList);
    }

    public void itemSearch(){
        ObservableList<Item> observableItemList= FXCollections.observableArrayList(hr.javafx.miletic7.HelloApplication.items);
        itemsTableView.setItems(observableItemList);
    }

    public void itemSearchByName(){
        String itemName=itemNameTextField.getText();
        List<Item> filteredList= hr.javafx.miletic7.HelloApplication.items.stream()
                .filter(item->item.getName().contains(itemName))
                .collect(Collectors.toList());

        ObservableList<Item> observableItemList= FXCollections.observableArrayList(filteredList);
        itemsTableView.setItems(observableItemList);

    }

    public void itemSearchByCategory(){
        String category= String.valueOf(itemsCategoryComboBox.getValue());
        List<Item> filteredList= hr.javafx.miletic7.HelloApplication.items.stream()
                .filter(item->item.getCategory().getName().contains(category))
                .collect(Collectors.toList());

        ObservableList<Item> observableItemList= FXCollections.observableArrayList(filteredList);
        itemsTableView.setItems(observableItemList);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeComboBox(url, resourceBundle);

        itemNameTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getName());
            }
        });

        itemCategoryTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getCategory().getName());
            }
        });

        itemWidthTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getWidth().toString());
            }
        });

        itemHeightTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getHeight().toString());
            }
        });

        itemLengthTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getLength().toString());
            }
        });

        itemProductionCostsTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getProductionCost().toString());
            }
        });

        itemSellingPriceTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getSellingPrice().toString());
            }
        });

        itemDiscountTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getDiscount().discountAmount().toString());
            }
        });
    }
}
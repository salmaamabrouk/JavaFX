/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;

/*
 * @author salmamabrouk
 */
public class Notepad extends Application {

    //File Menu
    MenuBar mbar;
    Menu fileMenu;
    MenuItem newItem;
    MenuItem saveItem;
    MenuItem openItem;
    MenuItem exitItem;

    SeparatorMenuItem sep1;
    SeparatorMenuItem sep2;
    SeparatorMenuItem sep3;

    FileChooser fileChooser;

    //Edit Menu
    Menu editMenu;
    MenuItem undoItem;
    MenuItem cutItem;
    MenuItem copyItem;
    MenuItem pasteItem;
    MenuItem deleteItem;
    MenuItem selectallItem;

    //Help Menu
    Menu helpMenu;
    MenuItem aboutItem;

    TextArea textArea;

    @Override

    public void init() throws Exception {

        //File Menu
        mbar = new MenuBar();
        textArea = new TextArea();
        fileMenu = new Menu("File");
        newItem = new MenuItem("New");
        newItem.setAccelerator(KeyCombination.keyCombination("Alt+f"));
        saveItem = new MenuItem("Save");
        saveItem.setAccelerator(KeyCombination.keyCombination("Alt+s"));
        openItem = new MenuItem("Open");
        openItem.setAccelerator(KeyCombination.keyCombination("Alt+o"));
        exitItem = new MenuItem("Exit");
        sep1 = new SeparatorMenuItem();
        fileMenu.getItems().addAll(newItem, saveItem, openItem, exitItem);
        fileMenu.getItems().add(3, sep1);

        //Edit Menu
        sep2 = new SeparatorMenuItem();
        sep3 = new SeparatorMenuItem();
        editMenu = new Menu("Edit");
        undoItem = new MenuItem("Undo");
        undoItem.setAccelerator(KeyCombination.keyCombination("Alt+z"));
        cutItem = new MenuItem("Cut");
        cutItem.setAccelerator(KeyCombination.keyCombination("Alt+x"));
        copyItem = new MenuItem("Copy");
        copyItem.setAccelerator(KeyCombination.keyCombination("Alt+c"));
        pasteItem = new MenuItem("Paste");
        pasteItem.setAccelerator(KeyCombination.keyCombination("Alt+v"));
        deleteItem = new MenuItem("Delete");
        deleteItem.setAccelerator(KeyCombination.keyCombination("Alt+d"));
        selectallItem = new MenuItem("Select All");
        editMenu.getItems().addAll(undoItem, cutItem, copyItem, pasteItem, deleteItem, selectallItem);
        editMenu.getItems().add(3, sep2);
        editMenu.getItems().add(5, sep3);

        //Help Menu
        helpMenu = new Menu("Help");
        aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem);

        mbar.getMenus().addAll(fileMenu, editMenu, helpMenu);
    }

    @Override
    public void start(Stage primaryStage) {

        //File Menu
        saveItem.setOnAction(event -> {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Save As");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("Java", "*.java"));
            fileChooser.showSaveDialog(primaryStage);
        });

        newItem.setOnAction(event -> {
            textArea.clear();
        });

        openItem.setOnAction(event -> {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Open existing file");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("Java", "*.java"));
            fileChooser.showOpenDialog(primaryStage);
        });

        exitItem.setOnAction((ActionEvent event) -> {
            System.exit(0);
            primaryStage.close();
        });

        //Edit Menu
        copyItem.setOnAction((ActionEvent event) -> {
            textArea.copy();
        });

        pasteItem.setOnAction((ActionEvent event) -> {
            textArea.paste();
        });

        undoItem.setOnAction((ActionEvent event) -> {
            textArea.undo();
        });

        cutItem.setOnAction((ActionEvent event) -> {
            textArea.cut();
        });

        deleteItem.setOnAction((ActionEvent event) -> {
            textArea.deletePreviousChar();
        });
        selectallItem.setOnAction((ActionEvent event) -> {
            textArea.selectAll();
        });

        //Help Menu
        aboutItem.setOnAction(event -> {
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Salma's Notepad :D");
            a.show();
        });
        BorderPane pane = new BorderPane();

        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setTitle("SALMA'S NOTEPAD");
        pane.setTop(mbar);
        pane.setCenter(textArea);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

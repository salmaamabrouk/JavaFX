/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.Reflection;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author salmamabrouk
 */
public class Lab1 extends Application {
    Text t;
    Rectangle rect;
    StackPane root;
    Reflection ref;

    @Override
     public void init() throws Exception {
        
       super.init(); 
        t=new Text("Hello World T^T");
        t.setId("Text");
        rect =new Rectangle(0,0,500,400);
        rect.setId("Rect");
        ref= new Reflection();
        ref.setFraction(0.6);
        t.setEffect(ref);

         root = new StackPane();
         root.getChildren().add(rect);
         root.getChildren().add(t);
         
       
    }

    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = new Scene(root, 500, 400);
       scene.getStylesheets().add(getClass().getResource("style.css").toString());
        primaryStage.setTitle("Lab 1 - Salma Yasser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
       launch(args);
    }
    
}
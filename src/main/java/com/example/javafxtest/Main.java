package com.example.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    Button button;
    TableView<Student> tableView;

    @Override
    public void start(Stage stage) throws IOException {
        // hello-view 로드
        Parent root = (Parent) FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



//        window = stage;
//        window.setTitle("TableView");
//
        /*
        button = new Button("전송");

        TableColumn<Product, String> nameColumn = new TableColumn<>("NAME");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String> explainColumn = new TableColumn<>("EXPLAIN");
        explainColumn.setMinWidth(150);
        explainColumn.setCellValueFactory(new PropertyValueFactory<>("explain"));

        tableView = new TableView<>();
        tableView.setItems(getProduct());
        tableView.getColumns().addAll(nameColumn, explainColumn);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().add(tableView);
        layout.getChildren().add(button);

        scene = new Scene(layout, 400, 300);

         */
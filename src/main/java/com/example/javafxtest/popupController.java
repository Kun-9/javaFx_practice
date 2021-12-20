package com.example.javafxtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class popupController implements Initializable {

    @FXML
    TextField name;

    @FXML
    TextField korean;

    @FXML
    TextField math;

    @FXML
    TextField english;

    @FXML
    Button addBtn;

    @FXML
    Button cancelBtn;

    @FXML
    Student student;

    public Parent parent = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Student> students = new ArrayList<>();

        ObservableList<Student> productsList = FXCollections.observableArrayList(students);


        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


//                Product product =
//                        new Product(name.toString(),
//                                Integer.parseInt(korean.toString()),
//                                Integer.parseInt(math.toString()),
//                                Integer.parseInt(english.toString())
//                        );
                Student student = new Student("hello", 2,3,4);
//                productArrayList.addProduct(product);
                System.out.println(student.getName());
                System.out.println(student.getKorean());
                System.out.println(student.getMath());
                System.out.println(student.getEnglish());

//                productsList.add(product);

            }
        });
    }
}



//                Product product =
//                        new Product(name.toString(),
//                                Integer.parseInt(korean.toString()),
//                                Integer.parseInt(math.toString()),
//                                Integer.parseInt(english.toString())
//                        );
//
//                productsList.add(product);
//            }
//        });
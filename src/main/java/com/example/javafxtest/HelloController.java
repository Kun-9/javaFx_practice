package com.example.javafxtest;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    TableView<Student> tableView;

    @FXML
    TableColumn<Student, String> nameColumn;

    @FXML
    TableColumn<Student, Integer> koreanColumn;

    @FXML
    TableColumn<Student, Integer> mathColumn;

    @FXML
    TableColumn<Student, Integer> englishColumn;

    @FXML
    Button btnAdd;

    @FXML
    Button btnChart;

    // 학생에 대한 ArrayList배열 생성
    ArrayList<Student> students = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // 각 행에 대한 값 연결
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        koreanColumn.setCellValueFactory(new PropertyValueFactory<>("korean"));
        mathColumn.setCellValueFactory(new PropertyValueFactory<>("math"));
        englishColumn.setCellValueFactory(new PropertyValueFactory<>("english"));

        // 추가 버튼의 클릭 메소드 구현
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Student객체를 추가하기 위한 addForm.fxml로드
                FXMLLoader fxmlLoader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getResource("addForm.fxml"))
                );

                Parent root;
                Stage popupStage;
                try {
                    root = fxmlLoader.load();
                    popupStage = new Stage();
                    popupStage.setTitle("popup");

                    // addForm의 객체들 등록
                    TextField name = (TextField) root.lookup("#name");
                    TextField korean = (TextField) root.lookup("#korean");
                    TextField math = (TextField) root.lookup("#math");
                    TextField english = (TextField) root.lookup("#english");

                    Button addBtn = (Button) root.lookup("#addBtn");
                    Button cancelBtn = (Button) root.lookup("#cancelBtn");

                    // addForm의 추가버튼 클릭메소드 구현
                    addBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            // 각 항목의 값을 읽어오고
                            // 새로운 Student객체를 생성한다.
                            // Student배열로 이루어진 students배열에 등록
                            students.add(
                                    new Student(
                                            name.getText(),
                                            Integer.parseInt(korean.getText()),
                                            Integer.parseInt(math.getText()),
                                            Integer.parseInt(english.getText())
                                    )
                            );

                            // observableArrayList를 생성하고 students배열을 대입
                            // 이것을 tableView의 setItems메소드를 통해 표에 등록한다.
                            tableView.setItems(
                                    FXCollections.observableArrayList(students)
                            );
                        }
                    });

                    // 취소 버튼의 클릭 메소드 구현
                    cancelBtn.setOnAction(event1 -> popupStage.close());

                    // Scene 설정 후 새창 생성
                    popupStage.setScene(new Scene(root));
                    popupStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // 차트 버튼의 클릭 메소드 구현
        btnChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // 차트 표시를 위한 chartView.fxml로드
                FXMLLoader fxmlLoader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getResource("chartView.fxml"))
                );
                Parent root2;
                try {
                    root2 = fxmlLoader.load();
                    Stage chartView;

                    chartView = new Stage();
                    chartView.setTitle("Chart");

                    // chartView의 객체 등록
                    Button cancelBtn = (Button) root2.lookup("#cancelBtn");
                    BarChart barChart = (BarChart) root2.lookup("#barChart");

                    // chart의 Y축 최댓값 설정
                    Axis yAxis = barChart.getYAxis();
                    yAxis.setAutoRanging(false);
                    yAxis.setUserData(100);

                    // 생성되었던 students배열을 참조히여 과목에 대한 새 배열 생성 후 배분
                    XYChart.Series koreanChart = new XYChart.Series();
                    koreanChart.setName("국어");

                    XYChart.Series mathChart = new XYChart.Series();
                    mathChart.setName("수학");

                    XYChart.Series englishChart = new XYChart.Series();
                    englishChart.setName("영어");

                    ArrayList<XYChart.Data> koreanArray = new ArrayList<>();
                    for(int i = 0; i < students.size(); i ++) {
                        koreanArray.add(new XYChart.Data(students.get(i).getName(), students.get(i).getKorean()));
                    }

                    ArrayList<XYChart.Data> mathArray = new ArrayList<>();
                    for(int i = 0; i < students.size(); i ++) {
                        mathArray.add(new XYChart.Data(students.get(i).getName(), students.get(i).getMath()));
                    }

                    ArrayList<XYChart.Data> englishArray = new ArrayList<>();
                    for(int i = 0; i < students.size(); i ++) {
                        englishArray.add(new XYChart.Data(students.get(i).getName(), students.get(i).getEnglish()));
                    }

                    koreanChart.setData(FXCollections.observableArrayList(koreanArray));
                    mathChart.setData(FXCollections.observableArrayList(mathArray));
                    englishChart.setData(FXCollections.observableArrayList(englishArray));

                    // barChart에 배열 등록
                    for (XYChart.Series series : Arrays.asList(koreanChart, mathChart, englishChart)) {
                        barChart.getData().add(series);
                    }

                    // 취소버튼의 클릭 메소드 구현
                    cancelBtn.setOnAction(event1 -> chartView.close());

                    // 씬 등록 후 새창 생성
                    chartView.setScene(new Scene(root2));
                    chartView.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

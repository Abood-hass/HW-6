/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AboodHass.HW_6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Component;
import com.AboodHass.HW_6.Entity.*;
import com.AboodHass.HW_6.repositories.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FXML Controller class
 *
 * @author AboodHassKov
 */
@Component
public class The_GUIController implements Initializable {

    @FXML
    private Pane ThePane;
    @FXML
    private TableView<Student> TableView_Student;
    @FXML
    private TableColumn<Student, Integer> ID_Column_STD;
    @FXML
    private TableColumn<Student, String> Name_Column_STD;
    @FXML
    private TableColumn<Student, String> Major_Column_STD;
    @FXML
    private TableColumn<Student, Double> Grade_Column_STD;
    @FXML
    private Label S_Label;
    @FXML
    private Button Add_Button;
    @FXML
    private Button Delete_Button;
    @FXML
    private Button Update_Button;
    @FXML
    private Button Add_REG_Button;
    @FXML
    private Label ID_Label;
    @FXML
    private Label Name_Label;
    @FXML
    private Label MAjor_Label;
    @FXML
    private Label Grade_Label;
    @FXML
    private TextField ID_Field;
    @FXML
    private TextField NAme_Field;
    @FXML
    private TextField Major_Field;
    @FXML
    private TextField Grade_Field;
    @FXML
    private Label R_Label;
    @FXML
    private TableView<Registration> TableView_Registration;
    @FXML
    private TableColumn<Registration, Integer> sID_Column_REG;
    @FXML
    private TableColumn<Registration, Integer> cID_Column_REG;
    @FXML
    private TableColumn<Registration, String> Semester_Column_REG;
    @FXML
    private Button SE_Student_Button;
    @FXML
    private Button Excellent_Button;
    @FXML
    private Button Pass_Button;
    @FXML
    private Button CS_Button;
    @FXML
    private Label course_id_Label;
    @FXML
    private Label Semester_Label;
    @FXML
    private TextField Semester_Field;
    @FXML
    private Button Delete_REG_Button;
    @FXML
    private Button Update_REG_Button;
    @FXML
    private ComboBox<Integer> CB_ID_Course;
    
    @Autowired
        Student_Repositories SR;
    
    @Autowired
        Registration_Repositories RR;
    
    @Autowired
        Course_Repositories CR;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ID_Column_STD   .setCellValueFactory(new PropertyValueFactory("id"));
        Name_Column_STD .setCellValueFactory(new PropertyValueFactory("name"));
        Major_Column_STD.setCellValueFactory(new PropertyValueFactory("major"));
        Grade_Column_STD.setCellValueFactory(new PropertyValueFactory("grade"));
        
        sID_Column_REG     .setCellValueFactory(new PropertyValueFactory("studentid"));
        cID_Column_REG     .setCellValueFactory(new PropertyValueFactory("courseid"));
        Semester_Column_REG.setCellValueFactory(new PropertyValueFactory("semester"));
        
        
        List<Course> Courses = CR.findAll();
        for(Course Course : Courses) {
            CB_ID_Course.getItems().add(Course.getId());
        }
        
        show();
        
        TableView_Student.
                    getSelectionModel().
                    selectedItemProperty().
                    addListener(event-> ShowSTDSelected());
        
        TableView_Registration.
                    getSelectionModel().
                    selectedItemProperty().
                    addListener(event-> ShowREGSelected());

    }    

    @FXML
    private void Button_Add(ActionEvent event) {
        int id = Integer.parseInt(ID_Field.getText());
        String name = NAme_Field.getText()+"";
        String major = Major_Field.getText()+"";
        double grade = Double.parseDouble(Grade_Field.getText());
        Student STD = new Student
                ();
        STD.setId(id);
        STD.setName(name);
        STD.setMajor(major);
        STD.setGrade(grade);
        SR.save(STD);
        show();
    }

    @FXML
    private void Button_Delete(ActionEvent event) {
        int id = Integer.parseInt(ID_Field.getText());
        if(SR.existsById(id)){
            Student STD = SR.findById(id).get();
            SR.delete(STD);
        }
        show();
    }

    @FXML
    private void Button_Update(ActionEvent event) {
        int id = Integer.parseInt(ID_Field.getText());
        String name = NAme_Field.getText()+"";
        String major = Major_Field.getText()+"";
        double grade = Double.parseDouble(Grade_Field.getText());
        if(SR.existsById(id)){
            Student STD = SR.findById(id).get();
            STD.setId(id);
            STD.setName(name);
            STD.setMajor(major);
            STD.setGrade(grade);
        }
        show();
    }

    @FXML
    private void Button_Add_REG(ActionEvent event) {
        int sid = Integer.parseInt(ID_Field.getText());
        int cid = CB_ID_Course.getValue();
        String semester = Semester_Field.getText()+"";
        
            Registration REG = new Registration();
            REG.setStudentid(sid);
            REG.setCourseid(cid);
            REG.setSemester(semester);
            RR.save(REG);
        show();
    }

    @FXML
    private void Button_SE(ActionEvent event) {
        TableView_Student.getItems().clear();
        List<Student> STDs = SR.findAll();
        for(Student STD : STDs) {
            if(STD.getMajor().equals("Software Engineering")){
            TableView_Student.getItems().add(STD);
            }
        }
        
    }

    @FXML
    private void Button_excellent(ActionEvent event) {
        TableView_Student.getItems().clear();
        List<Student> STDs = SR.findAll();
        for(Student STD : STDs) {
            double Grade = STD.getGrade();
            if(Grade >= 90.0){
            TableView_Student.getItems().add(STD);
            }
        }
    }

    @FXML
    private void Button_pass(ActionEvent event) {
        TableView_Student.getItems().clear();
        List<Student> STDs = SR.findAll();
        for(Student STD : STDs) {
            double Grade = STD.getGrade();
            if(Grade >= 65.0){
            TableView_Student.getItems().add(STD);
            }
        }
    }

    @FXML
    private void Button_CS(ActionEvent event) {
        TableView_Student.getItems().clear();
        List<Student> STDs = SR.findAll();
        for(Student STD : STDs) {
            if(STD.getMajor().equals("Computer Science")){
                double Grade = STD.getGrade();
                STD.setGrade(Grade + 3);
                SR.save(STD);
            }
        }
        show();
    }

    @FXML
    private void Button_Delete_REG(ActionEvent event) {
        int id = Integer.parseInt(ID_Field.getText());
        if(RR.existsById(id)){
            Registration REG = RR.findById(id).get();
            RR.delete(REG);
        }
        show();
    }

    @FXML
    private void Button_Update_REG(ActionEvent event) {
        int sid = Integer.parseInt(ID_Field.getText());
        int cid = CB_ID_Course.getValue();
        String semester = Semester_Field.getText()+"";
        if(RR.existsById(sid)){
            Registration REG = new Registration();
            REG.setStudentid(sid);
            REG.setCourseid(cid);
            REG.setSemester(semester);
            RR.save(REG);
        }
        show();
    }

    @FXML
    private void Button_Show(ActionEvent event) {
        show();
    }

    @FXML
    private void Button_Show(DragEvent event) {
        
    }
    void show(){
        
        
        List<Student> STDs = SR.findAll();
        TableView_Student.getItems().setAll(STDs);
        
        List<Registration> REGs = RR.findAll();
        TableView_Registration.getItems().setAll(REGs);
    }
    
     private void ShowSTDSelected() {
        
        Student selected_STD =  TableView_Student.getSelectionModel().getSelectedItem();
        
        if(selected_STD != null){
        ID_Field.setText(selected_STD.getId()+"");
        NAme_Field.setText(selected_STD.getName());
        Major_Field.setText(selected_STD.getMajor());
        Grade_Field.setText(selected_STD.getGrade()+"");
        }
        
        
    }
     
    private void ShowREGSelected() {
        Registration selected_REG = TableView_Registration.getSelectionModel().getSelectedItem();
        
        if(selected_REG != null){
        ID_Field.setText(selected_REG.getStudentid()+"");
        Semester_Field.setText(selected_REG.getSemester()+"");
        CB_ID_Course.setValue(selected_REG.getCourseid());
        }
    }
}

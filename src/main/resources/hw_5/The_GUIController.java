/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_5;

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

/**
 * FXML Controller class
 *
 * @author AboodHassKov
 */
public class The_GUIController implements Initializable {

    @FXML
    private Pane ThePane;
    @FXML
    private TableView<?> TableView_Student;
    @FXML
    private TableColumn<?, ?> ID_Column_STD;
    @FXML
    private TableColumn<?, ?> Name_Column_STD;
    @FXML
    private TableColumn<?, ?> Major_Column_STD;
    @FXML
    private TableColumn<?, ?> Grade_Column_STD;
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
    private TableView<?> TableView_Registration;
    @FXML
    private TableColumn<?, ?> sID_Column_REG;
    @FXML
    private TableColumn<?, ?> cID_Column_REG;
    @FXML
    private TableColumn<?, ?> Semester_Column_REG;
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
    private ComboBox<?> CB_ID_Course;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Button_Add(ActionEvent event) {
    }

    @FXML
    private void Button_Delete(ActionEvent event) {
    }

    @FXML
    private void Button_Update(ActionEvent event) {
    }

    @FXML
    private void Button_Add_REG(ActionEvent event) {
    }

    @FXML
    private void Button_SE(ActionEvent event) {
    }

    @FXML
    private void Button_excellent(ActionEvent event) {
    }

    @FXML
    private void Button_pass(ActionEvent event) {
    }

    @FXML
    private void Button_CS(ActionEvent event) {
    }

    @FXML
    private void Button_Delete_REG(ActionEvent event) {
    }

    @FXML
    private void Button_Update_REG(ActionEvent event) {
    }

    @FXML
    private void Button_Show(ActionEvent event) {
    }

    @FXML
    private void Button_Show(DragEvent event) {
    }
    
}

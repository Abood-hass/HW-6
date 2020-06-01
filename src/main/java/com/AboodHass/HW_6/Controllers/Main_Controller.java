/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AboodHass.HW_6.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AboodHass.HW_6.repositories.*;
import com.AboodHass.HW_6.Entity.*;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author AboodHassKov
 */
@RestController
public class Main_Controller {
    
@Autowired
Student_Repositories student_repositories;


@Autowired
Course_Repositories course_repositories;

    @RequestMapping("/")
    public String Index(){
        return String.format("%s","JPA using Sprint Boot");
    }
    
    @RequestMapping("/showall")
    public String ShowAll(){
        List<Student> Student = student_repositories.findAll();
        String STR = "";
        for (Student student : Student) {
            STR += student + "<br>";
            return String.format("%s",STR);
        }
        
        
        List<Course> Course = course_repositories.findAll();
        STR = "";
        for (Course course : Course) {
            STR += course + "<br>";
            return String.format("%s",STR);
        }
    return "";
    }
    
    
    @RequestMapping("/showstudent/(id)")
    public String ShowStudentByID(@PathVariable Integer id){
        Student STD = student_repositories.findById(id).get();
        return String.format("%s", STD);
}
    
    
    @RequestMapping("/showcourse/(id)")
    public String ShowCourseByID(@PathVariable Integer id){
        Course course = course_repositories.findById(id).get();
        return String.format("%s", course);
}
}

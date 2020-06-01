/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AboodHass.HW_6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AboodHass.HW_6.Entity.Student;
/**
 *
 * @author AboodHassKov
 */
public interface Student_Repositories extends JpaRepository<Student, Integer>{
    
}

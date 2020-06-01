/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AboodHass.HW_6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AboodHass.HW_6.Entity.Registration;
/**
 *
 * @author AboodHassKov
 */
public interface Registration_Repositories extends JpaRepository<Registration, Integer>{
    
}

package domain.impl;


import domain.Faculty;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author urosv
 */
public class Supervisor implements Faculty{

    private String name;
    private String departmentName;
    
    private List<Faculty> myFacultyList;

    public Supervisor(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
        this.myFacultyList = new ArrayList<>();
    }
    
    @Override
    public String getDetails() {
        return (name + " is the " + departmentName);
    }
    
    public void add(Faculty professor){
        myFacultyList.add(professor);
    }
    
    public void removeOldest(){
        myFacultyList.remove(0);
    }
    
    public List<Faculty> getMyFaculty(){
        return myFacultyList;
    }
    
    
    
}

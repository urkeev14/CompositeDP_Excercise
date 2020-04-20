/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.Faculty;
import domain.impl.*;
import java.util.List;

/**
 *
 * @author urosv
 */
public class Client {

    public static void main(String[] args) {

        Supervisor technologyDean = new Supervisor("Dr. Mike", "Dean of Technology");

        Supervisor chairOfComputerScienceDepartment = new Supervisor("Dr. Ian", "Chair of CS Department");
        Supervisor chairOfMathDepartment = new Supervisor("Dr. John", "Chair of Math Department");

        makeMathDepartment(chairOfMathDepartment);
        makeCSDepartment(chairOfComputerScienceDepartment);

        technologyDean.add(chairOfComputerScienceDepartment);
        technologyDean.add(chairOfMathDepartment);

        printAllDetails(technologyDean, chairOfMathDepartment, chairOfComputerScienceDepartment);
        
        chairOfComputerScienceDepartment.removeOldest();
        System.out.println("\nAfter oldest professor left...");
        printDepartmentDetails(chairOfComputerScienceDepartment);
    }

    private static void printAllDetails(Supervisor technologyDean, Supervisor chairOfMathDepartment, Supervisor chairOfComputerScienceDepartment) {
        System.out.println("===Composite Pattern demo===");
        System.out.println("\nThe college has the following structure: \n");
        System.out.println(technologyDean.getDetails());

        printChairDetails(technologyDean);
        printDepartmentDetails(chairOfMathDepartment);
        printDepartmentDetails(chairOfComputerScienceDepartment);
    }

    private static void printDepartmentDetails(Supervisor superior) {
        List<Faculty> subordinates = superior.getMyFaculty();
        for (Faculty subordinat : subordinates) {
            System.out.println("\t\t" + subordinat.getDetails());
        }
    }

    private static void printChairDetails(Supervisor technologyDean) {
        List<Faculty> chairs = technologyDean.getMyFaculty();
        for (Faculty chair : chairs) {
            System.out.println("\t" + chair.getDetails());
        }
    }

    private static void displayDownwardHierarchyFrom(Supervisor technologyDean) {

    }

    private static void makeCSDepartment(Supervisor chairOfComputerScienceDepartment) {
        Professor csProfessor1 = new Professor("CSE Professor 1", "Adjunct", 501);
        Professor csProfessor2 = new Professor("CSE Professor 2", "Associate", 502);
        Professor csProfessor3 = new Professor("CSE Professor 3", "Adjunct", 503);

        chairOfComputerScienceDepartment.add(csProfessor1);
        chairOfComputerScienceDepartment.add(csProfessor2);
        chairOfComputerScienceDepartment.add(csProfessor3);
    }

    private static void makeMathDepartment(Supervisor chairOfMathDepartment) {
        Professor mathProfessor1 = new Professor("Math Professor 1", "Adjunct", 302);
        Professor mathProfessor2 = new Professor("Math Professor 2", "Associate", 303);

        chairOfMathDepartment.add(mathProfessor1);
        chairOfMathDepartment.add(mathProfessor2);
    }

}

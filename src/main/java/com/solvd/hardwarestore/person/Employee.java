package com.solvd.hardwarestore.person;


import com.solvd.hardwarestore.abstract_classes.Person;
import com.solvd.hardwarestore.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;

public class Employee extends Person {
    private static final Logger LOGGER= LogManager.getLogger(Employee.class);

    private String personalId;//The personal id of the worker
    private double costPerHour;//The pay per hour of the worker
    private String speciality;//What kind of job the worker does
    private int employeeAge;//how old is the employee
    private static ArrayList<Employee> employeeList=new ArrayList<>();//The list that saves the Object employees
    private static HashSet<String> resumedEmployeeInformationList=new HashSet<>();//List with only resumed information
    private Integer vacation;//The amount of vacation for each employee


    //Constructor

    public Employee(String personName, String personEmail, String phoneNumber,String speciality) {
        super(personName, personEmail, phoneNumber);
        this.speciality=speciality;
    }
    //End constructor

    //Getter and setters

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

    public Integer getVacation() {
        return vacation;
    }


    //end getters and setters

    //Abstract method implementation
    @Override
    public void checkAge(){
        if (this.getEmployeeAge()<21){
            LOGGER.warn("You must be older than 18 years to be an employee.");
            if (this.employeeAge==0){
                LOGGER.warn("Please set the employee age.");
            }
        }else {
            LOGGER.info("You can be an employee.");
        }
    }

    //Try-catch methods
    //This method allows checking if the employee name is longer than the maximum it is used to
    // define the exception
    private void throwNameException(String employeeName) throws LongEmployeeNameException, NumberInNamesException {
        if (employeeName.length()>20) {
            throw new LongEmployeeNameException("The name is too long, pleas make it less than 20 characters.");
        }else if ((employeeName.contains("0") || employeeName.contains("1") || employeeName.contains("2") || employeeName.contains("3") || employeeName.contains("4") || employeeName.contains("5") || employeeName.contains("6") || employeeName.contains("7") || employeeName.contains("8") || employeeName.contains("9"))){
            throw new NumberInNamesException("The employee name has a number, please correct it.");
        }else{
            LOGGER.info("The name length is ok and it has not any number inside");
        }
    }

    //This exception check Email
    private void throwEmailException(String employeeEmail) throws EmailException {
        if (!employeeEmail.contains("@gmail.com") ) {
            throw new EmailException("Please only use a @gmail.com email.");
        } else {
            LOGGER.info("The gmail format is OK, only gmail mails.");
        }
    }
    //This exception checks the phone number length
    private void throwPhoneNumberException(String employeePhoneNumber) throws PhoneNumberException {
        if (employeePhoneNumber.length()==8) {
            LOGGER.info("The 8 digit phone number is Ok.");
        } else {
            throw new PhoneNumberException("The phone number has " + employeePhoneNumber.length()
                    + " digits and should be 8 digits");
        }
    }

    //This exception checks the speciality
    private void throwEmployeeSpecialityException(String employeeSpeciality) throws EmployeeSpecialityException {
        if (employeeSpeciality.equals("seller")|| employeeSpeciality.equals("owner") || employeeSpeciality.equals("deposit")) {
            LOGGER.info("The specialty "+employeeSpeciality+" is Ok.");
        }else {
            throw new EmployeeSpecialityException("The speciality"+ employeeSpeciality+" doesn't exist, please " +
                    "enter a valid one: seller or deposit.");
        }
    }

    //Now the method that uses the try catch and in which we use the exception.
    // This is the one that is going to be used in Main
    public void checkEmployeeData(){
        try {
            throwNameException(this.getPersonName());
            throwEmailException(this.getPersonEmail());
            throwPhoneNumberException(this.getPhoneNumber());
            throwEmployeeSpecialityException(this.speciality);
        }catch (EmployeeSpecialityException | EmailException | NumberInNamesException
                | LongEmployeeNameException | PhoneNumberException e){
            LOGGER.error(e);
        }

    }
    //end Try-catch methods


    @Override
    public String toString() {
        return "Employee :" +
                "name='" + this.getPersonName() + '\'' +
                "personalId='" + personalId + '\'' +
                ", speciality='" + speciality + '\'';
    }

    //List methods
    public static ArrayList<Employee> getCopyOfEmployeeArrayList() {
        return new ArrayList<Employee>(Employee.employeeList);
    }
    public static void addEmployeeToArrayList(Employee employee){
        Employee.employeeList.add(employee);
    }

    //This method allows iterating in the employeeList and retrieving the names of the employees
    public static HashSet<String> getEmployeeResumeList(){
        for (Employee employee:Employee.getCopyOfEmployeeArrayList()) {
            //System.out.println();
            String resumedInfo="\nName: "+employee.getPersonName()+
                    "\nSpeciality: "+ employee.getSpeciality()+
                    "\nPhone number: "+employee.getPhoneNumber();
            //Saving the resumed names in another string with arrays
            Employee.resumedEmployeeInformationList.add(resumedInfo);
        }
        return Employee.resumedEmployeeInformationList;
    }
    //End List methods



}

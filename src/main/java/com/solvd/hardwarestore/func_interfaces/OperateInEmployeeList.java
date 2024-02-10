package com.solvd.hardwarestore.func_interfaces;

import com.solvd.hardwarestore.person.Employee;

import java.util.ArrayList;

@FunctionalInterface
public interface OperateInEmployeeList <T extends ArrayList<Employee>,R> {
     R getFromEmployeeArray(T t);
}


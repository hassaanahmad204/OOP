package com.Management.Department;
import com.Management.Lab.*;
import com.Management.Employe.*;

public class Department {
    private String departmentName;
    private Employe HOD;
    private Lab[] labList;

    public Department(String departmentName, Person HOD, Lab[] labList) {
        this.departmentName = departmentName;
        this.HOD = HOD;
        this.labList = labList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department Name: ").append(departmentName).append("\n");
        sb.append("HOD: ").append(HOD.toString()).append("\n");
        sb.append("=".repeat(50)).append("\n");
        sb.append("Labs Details:\n");
        for (Lab lab : labList) {
            sb.append(lab).append("\n");
        }  
        return sb.toString();
    }
}

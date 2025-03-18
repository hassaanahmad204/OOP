package university.Lab;

import university.SystemUnit.*;
import university.Employee.*;

public class Lab {
    private String labName;
    private Employee labStaff;
    private int numOfPcs;
    private SystemUnit[] pcList;
    private boolean hasMultimedia;

    public Lab(String labName, Employee labStaff, int numOfPcs, SystemUnit[] pcList, boolean hasMultimedia) {
        this.labName = labName;
        this.labStaff = labStaff;
        this.numOfPcs = numOfPcs;
        this.hasMultimedia = hasMultimedia;

        if (pcList != null && pcList.length == numOfPcs) {
            this.pcList = pcList;
        } else {
            System.out.println("Warning: Mismatch in number of PCs. Adjusting size.");
            this.pcList = new SystemUnit[numOfPcs];
        }
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabStaff(Employee labStaff) {
        this.labStaff = labStaff;
    }

    public Employee getLabStaff() {
        return labStaff;
    }

    public void setNumOfPcs(int numOfPcs) {
        this.numOfPcs = numOfPcs;
    }

    public int getNumOfPcs() {
        return numOfPcs;
    }

    public void setPcList(SystemUnit[] pcList) {
        if (pcList.length == numOfPcs) {
            this.pcList = pcList;
        } else {
            System.out.println("Error: Number of PCs does not match declared count.");
        }
    }

    public SystemUnit[] getPcList() {
        return pcList;
    }

    public void setHasMultimedia(boolean hasMultimedia) {
        this.hasMultimedia = hasMultimedia;
    }

    public boolean hasMultimedia() {
        return hasMultimedia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lab Name: ").append(labName).append("\n");
        sb.append("Lab Staff: ").append(labStaff).append("\n");
        sb.append("Number of PCs: ").append(numOfPcs).append("\n");
        sb.append("PCs have Multimedia: ").append(hasMultimedia).append("\n");
        sb.append("Details of PCs in this Lab: \n");

        for (SystemUnit pc : pcList) {
            sb.append(pc != null ? pc.toString() : "Empty Slot").append("\n");
        }
        return sb.toString();
    }
}

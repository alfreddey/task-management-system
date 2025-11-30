package models;

import java.util.HashMap;

public class HardwareProject extends Project {
    private double materialCost;

    public HardwareProject(String name, String description, int teamSize, double budget) {
        super(name, description, teamSize, budget, ProjectType.HARDWARE);
        this.materialCost = 0;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    @Override
    public HashMap<String, String> getProjectDetails() {
        // TODO Auto-generated method stub
        return null;
    }
}

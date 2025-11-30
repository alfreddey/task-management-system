package services;

import java.util.Arrays;

import models.Project;

public class ProjectService {
    private final int MAX_PROJECTS = 999;
    private static ProjectService service;
    private Project[] projects;
    private int projectCount;

    private ProjectService() {
        this.projectCount = 0;
        this.projects = new Project[MAX_PROJECTS];
    }

    public static ProjectService getService() {
        if (service == null) {
            service = new ProjectService();
        }

        return service;
    }

    public void addProject(Project project) {
        if (projectCount < MAX_PROJECTS) {
            projects[projectCount++] = project;
            return;
        }

        System.out.println("Project array is full");
    }

    public Project getProjectById(String id) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                return project;
            }
        }

        return null;
    }

    public Project[] getAllProjects() {
        return Arrays.copyOf(projects, projectCount);
    }

    public int getProjectCount() {
        return projectCount;
    }
}

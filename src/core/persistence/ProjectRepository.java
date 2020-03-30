package core.persistence;

import core.domain.Project;

import java.util.ArrayList;

public class ProjectRepository {

    private ArrayList<Project> projects = new ArrayList<>();

    public ArrayList<Project> findAll() {
        //TODO: replace with real db conn

        return projects;
    }

    public Project findById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }

        return null;
    }

    public void persist(Project project) {
        projects.add(project);
    }
}

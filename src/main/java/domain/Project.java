package domain;

import java.util.ArrayList;

public class Project {
    private String name;
    private String description;
    private ArrayList<BacklogItem> backlogItems = new ArrayList<>();
    private ArrayList<Sprint> sprints = new ArrayList<>();
    private ArrayList<Developer> developers = new ArrayList();
    private Developer projectLead;

    /* Constructors */
    public Project(Developer projectLead){
        this.projectLead = projectLead;
    };
    /* Getters */

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<BacklogItem> getBacklogItems() {
        return backlogItems;
    }

    public ArrayList<Sprint> getSprints() {
        return sprints;
    }

    public ArrayList<Developer> getDevelopers() {
        return developers;
    }

    public Developer getProjectLead() {
        return projectLead;
    }
    /* Setters */

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setProjectLead(Developer projectLead) {
        this.projectLead = projectLead;
    }

    /* Methods */
    public void addBacklogItem(BacklogItem backlogItem) {
        this.backlogItems.add(backlogItem);
    }

    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    public void removeBacklogItem(BacklogItem backlogItem) {
        this.backlogItems.remove(backlogItem);
    }

    public void removeSprint(Sprint sprint) {
        this.sprints.remove(sprint);
    }

    public void removeDeveloper(Developer developer) {
        this.developers.remove(developer);
    }


}

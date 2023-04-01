package domain;

import jdk.javadoc.doclet.Reporter;

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

    public String sprintReport(Sprint sprint, String businessName){
        ArrayList<BacklogItem> backlogItems = sprint.getBacklogItems();
        ArrayList<Task> tasks = sprintReport_Tasks(backlogItems);
        String report = "Sprint Report generated for: "+businessName +"\n"+
                "State of sprint: " + sprint.getState().getStateName() + "\n" +
                "Total number of Developers: " + sprint.getDevelopers().size() + "\n" +
                "Total number of BacklogItems: " + backlogItems.size() + "\n" +
                "Containing a total of " + tasks.size() + " tasks," + "\n" +
                "of which " + sprintReport_TasksCompleted(tasks) + " have been completed." + "\n" +
                "The end date of this sprint is: " + sprint.getEndDate().toString();

        return report;
    }
    public ArrayList<Task> sprintReport_Tasks(ArrayList<BacklogItem> backlogItems){
        ArrayList<Task> tasks = new ArrayList<>();
        for (BacklogItem backlogItem : backlogItems){
            tasks.addAll(backlogItem.getTasks());
        }
        return tasks;
    }

    public int sprintReport_TasksCompleted(ArrayList<Task> tasks){
        int amt =0;
        for (Task task : tasks) if (task.isFinished()) amt++;
        return amt;
    }

    public void exportReport(String report, String preferredType){
        if (preferredType == "System"){
            System.out.println(report);
        }
        //Open for more export types.
    }
}

package domain;

import domain.states.backlog_item.InBacklogState;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project {
    /* ATTRIBUTES */
    private String name;
    private String description;
    private final ArrayList<BacklogItem> backlogItems = new ArrayList<>();
    private final ArrayList<Sprint> sprints = new ArrayList<>();
    private final ArrayList<Developer> developers = new ArrayList<>();
    private Developer projectLead;
    Logger logger = Logger.getLogger(InBacklogState.class.getName());

    /* CONSTRUCTORS */
    public Project(Developer projectLead){
        this.projectLead = projectLead;
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }
    public List<Sprint> getSprints() {
        return sprints;
    }
    public List<Developer> getDevelopers() {
        return developers;
    }
    public Developer getProjectLead() {
        return projectLead;
    }

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setProjectLead(Developer projectLead) {
        this.projectLead = projectLead;
    }
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

    /* METHODS */
    public String sprintReport(Sprint sprint, String businessName){
        List<BacklogItem> sprintBacklogItems = sprint.getBacklogItems();
        List<Task> tasks = sprintReportTasks(sprintBacklogItems);

        return String.format("Sprint Report generated for: %s\n" +
                "State of sprint: %s\n" +
                "Total number of Developers: %d\n" +
                "Total number of BacklogItems: %d\n" +
                "Containing a total of %d tasks,\n" +
                "of which %d have been completed.\n" +
                "The end date of this sprint is: %s", businessName, sprint.getState().getStateName(), sprint.getDevelopers().size(), sprintBacklogItems.size(), tasks.size(), sprintReportTasksCompleted(tasks), sprint.getEndDate().toString());
    }
    public List<Task> sprintReportTasks(List<BacklogItem> backlogItems){
        ArrayList<Task> tasks = new ArrayList<>();
        for (BacklogItem backlogItem : backlogItems){
            tasks.addAll(backlogItem.getTasks());
        }
        return tasks;
    }

    public int sprintReportTasksCompleted(List<Task> tasks){
        int amt =0;
        for (Task task : tasks) if (task.isFinished()) amt++;
        return amt;
    }

    public void exportReport(String report, String preferredType){
        if (preferredType.equals("System")){
            logger.log(Level.INFO, report);
        }
        //Open for more export types.
    }
}

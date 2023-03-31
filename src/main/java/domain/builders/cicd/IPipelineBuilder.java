package domain.builders.cicd;

import domain.composites.cicd.Job;
import domain.composites.cicd.Stage;

public interface IPipelineBuilder {
    void reset();
    void setName(String name);
    void setDescription(String name);
    void addStage(String name, String description);
    Stage setCurrentStage(String currentStage);
    void addJob(String name, String description);
    Job setCurrentJob(String currentJob);
    void addCommand(String name, String[] outputLines);
}

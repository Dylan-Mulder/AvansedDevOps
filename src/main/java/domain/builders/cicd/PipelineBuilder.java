package domain.builders.cicd;

import domain.composites.cicd.*;

public class PipelineBuilder implements IPipelineBuilder {
    /* ATTRIBUTES */
    private Pipeline pipeline;
    private Stage currentStage;
    private Job currentJob;

    /* CONSTRUCTORS */
    public PipelineBuilder() {
        this.reset();
    }

    /* METHODS */
    @Override
    public void reset() {
        pipeline = new Pipeline();
    }
    @Override
    public void setName(String name) {
        pipeline.setName(name);
    }
    @Override
    public void setDescription(String description) {
        pipeline.setDescription(description);
    }
    @Override
    public void addStage(String name, String description) {
        Stage stage = new Stage();
        stage.setName(name);
        stage.setDescription(description);
        currentStage = stage;
        pipeline.addComponent(stage);
    }
    @Override
    public Stage setCurrentStage(String stageName) {
        for (int i = 0; i <= pipeline.getComponentsSize(); i++) {
            if (pipeline.getComponent(i).getName().equals(stageName)) {
                return (Stage) pipeline.getComponent(i);
            }
        }
        throw new IllegalArgumentException();
    }
    @Override
    public void addJob(String name, String description) {
        Job job = new Job();
        job.setName(name);
        job.setDescription(description);
        currentJob = job;
        currentStage.addComponent(job);
    }
    @Override
    public Job setCurrentJob(String jobName) {
        for (int i = 0; i <= currentStage.getComponentsSize(); i++) {
            if (currentStage.getComponent(i).getName().equals(jobName)) {
                return (Job) currentStage.getComponent(i);
            }
        }
        throw new IllegalArgumentException();
    }
    @Override
    public void addCommand(String name, String[] outputLines) {
        Command command = new Command(name, outputLines);
        currentJob.addComponent(command);
    }

    public Pipeline build() {
        Pipeline result = pipeline;
        this.reset();
        return result;
    }
}

package domain;

public class SprintBuilder implements IBuilder {
    /* ATTRIBUTES */
    private Sprint sprint;

    /* CONSTRUCTORS */
    public SprintBuilder() {
        this.reset();
    }

    /* METHODS */
    @Override
    public void reset() {
        sprint = new Sprint();
    }

    @Override
    public void setType(FinishBehaviour finishBehaviour) {
        sprint.setFinishBehaviour(finishBehaviour);
    }

    @Override
    public void setDuration(int weeks) {
        sprint.setDuration(weeks);
    }

    @Override
    public void setScrumMaster(Developer developer) {
        sprint.setScrumMaster(developer);
    }

    public Sprint build() {
        sprint.setName("New Sprint");
        sprint.setDescription("A newly created sprint!");
        Sprint result = sprint;
        this.reset();
        return result;
    }
}

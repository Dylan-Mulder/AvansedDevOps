package domain.builders.sprint;

import domain.Sprint;
import domain.strategies.sprint.IFinishBehaviour;

import java.time.LocalDate;

public class SprintBuilder implements ISprintBuilder {
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
    public void setName(String name) {
        sprint.setName(name);
    }
    @Override
    public void setDescription(String description) {
        sprint.setDescription(description);
    }
    @Override
    public void setType(IFinishBehaviour finishBehaviour) {
        sprint.setFinishBehaviour(finishBehaviour);
    }
    @Override
    public void setDuration(int weeks) {
        sprint.setDuration(weeks);
    }
    @Override
    public void setStartDate(LocalDate date) {
        sprint.setStartDate(date);
        sprint.setEndDate(date.plusWeeks(sprint.getDuration()));
    }

    public Sprint build() {
        Sprint result = sprint;
        this.reset();
        return result;
    }
}

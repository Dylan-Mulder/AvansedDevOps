package domain.builders.sprint;

import domain.strategies.sprint.AbstractFinishBehaviour;

import java.time.LocalDate;

public interface ISprintBuilder {
    void reset();
    void setName(String name);
    void setDescription(String description);
    void setType(AbstractFinishBehaviour finishBehaviour);
    void setDuration(int weeks);
    void setStartDate(LocalDate date);
}

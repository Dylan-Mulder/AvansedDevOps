package domain.builders.sprint;

import domain.strategies.sprint.IFinishBehaviour;

import java.time.LocalDate;

public interface ISprintBuilder {
    void reset();
    void setName(String name);
    void setDescription(String description);
    void setType(IFinishBehaviour finishBehaviour);
    void setDuration(int weeks);
    void setStartDate(LocalDate date);
}

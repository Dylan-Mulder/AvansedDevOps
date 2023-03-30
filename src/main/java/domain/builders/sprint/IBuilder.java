package domain.builders.sprint;

import domain.Developer;
import domain.strategies.sprint.IFinishBehaviour;

import java.time.LocalDate;

public interface IBuilder {
    void reset();
    void setName(String name);
    void setDescription(String description);
    void setType(IFinishBehaviour finishBehaviour);
    void setDuration(int weeks);
    void setStartDate(LocalDate date);
}

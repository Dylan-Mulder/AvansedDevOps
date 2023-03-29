package domain.builders.sprint;

import domain.Developer;
import domain.strategies.sprint.IFinishBehaviour;

public interface IBuilder {
    void reset();
    void setType(IFinishBehaviour finishBehaviour);
    void setDuration(int weeks);
    void setScrumMaster(Developer developer);
}

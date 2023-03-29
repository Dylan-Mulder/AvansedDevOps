package domain;

public interface IBuilder {
    void reset();
    void setType(FinishBehaviour finishBehaviour);
    void setDuration(int weeks);
    void setScrumMaster(Developer developer);
}

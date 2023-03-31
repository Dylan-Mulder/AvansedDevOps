import domain.builders.cicd.PipelineBuilder;
import domain.builders.cicd.PipelineDirector;
import domain.composites.cicd.Pipeline;
import domain.visitors.cicd.ExecuteVisitor;

public class Main {
    public static void main(String[] args) {
        PipelineDirector director = new PipelineDirector();
        PipelineBuilder builder = new PipelineBuilder();

        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();

        ExecuteVisitor visitor = new ExecuteVisitor();
        pipeline.acceptVisitor(visitor);
    }
}

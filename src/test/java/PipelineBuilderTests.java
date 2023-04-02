import domain.builders.cicd.PipelineBuilder;
import domain.builders.cicd.PipelineDirector;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PipelineBuilderTests {
    /* ATTRIBUTES */
    private PipelineDirector director;
    private PipelineBuilder builder;

    /* DATA MANAGEMENT */
    @BeforeAll
    public void setupMockData() {
        director = new PipelineDirector();
        builder = new PipelineBuilder();
    }

    @AfterEach
    public void resetMockData() {
        builder.reset();
    }

    /* TESTS */
    @Test
    void checkIfReleasePipelineHasCorrectStages() {
        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();

        assertAll(
                "Grouped Assertions of Release Pipeline Stages",
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(0)),
                () -> assertEquals( "Source", pipeline.getComponent(0).getName()),
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(1)),
                () -> assertEquals( "Build", pipeline.getComponent(1).getName()),
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(2)),
                () -> assertEquals( "Test", pipeline.getComponent(2).getName()),
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(3)),
                () -> assertEquals( "Deployment", pipeline.getComponent(3).getName()),
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(4)),
                () -> assertEquals( "Release", pipeline.getComponent(4).getName())
        );
    }

    @Test
    void checkIfReleasePipelineSourceStageHasCorrectJobs() {
        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(0);

        assertAll(
                "Grouped Assertions of Release Pipeline Source Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Clone GIT Repository", stage.getComponent(0).getName())
        );
    }

    @Test
    void checkIfReleasePipelineBuildStageHasCorrectJobs() {
        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(1);

        assertAll(
                "Grouped Assertions of Release Pipeline Build Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Build the Code", stage.getComponent(0).getName())
        );
    }

    @Test
    void checkIfReleasePipelineTestStageHasCorrectJobs() {
        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(2);

        assertAll(
                "Grouped Assertions of Release Pipeline Build Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Run all Tests", stage.getComponent(0).getName())
        );
    }

    @Test
    void checkIfReleasePipelineDeploymentStageHasCorrectJobs() {
        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(3);

        assertAll(
                "Grouped Assertions of Release Pipeline Build Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Deploy the Code", stage.getComponent(0).getName())
        );
    }

    @Test
    void checkIfReleasePipelineReleaseStageHasCorrectJobs() {
        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(4);

        assertAll(
                "Grouped Assertions of Release Pipeline Build Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Deploy the Code", stage.getComponent(0).getName())
        );
    }

    // REVIEW
    @Test
    void checkIfReviewPipelineHasCorrectStages() {
        director.buildReviewPipeline(builder);
        Pipeline pipeline = builder.build();

        assertAll(
                "Grouped Assertions of Review Pipeline Stages",
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(0)),
                () -> assertEquals( "Source", pipeline.getComponent(0).getName()),
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(1)),
                () -> assertEquals( "Build", pipeline.getComponent(1).getName()),
                () -> assertInstanceOf(Stage.class, pipeline.getComponent(2)),
                () -> assertEquals( "Test", pipeline.getComponent(2).getName())
        );
    }

    @Test
    void checkIfReviewPipelineSourceStageHasCorrectJobs() {
        director.buildReviewPipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(0);

        assertAll(
                "Grouped Assertions of Review Pipeline Source Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Clone GIT Repository", stage.getComponent(0).getName())
        );
    }

    @Test
    void checkIfReviewPipelineBuildStageHasCorrectJobs() {
        director.buildReviewPipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(1);

        assertAll(
                "Grouped Assertions of Review Pipeline Build Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Build the Code", stage.getComponent(0).getName())
        );
    }

    @Test
    void checkIfReviewPipelineTestStageHasCorrectJobs() {
        director.buildReviewPipeline(builder);
        Pipeline pipeline = builder.build();
        Stage stage = (Stage) pipeline.getComponent(2);

        assertAll(
                "Grouped Assertions of Review Pipeline Build Stage",
                () -> assertInstanceOf(Job.class, stage.getComponent(0)),
                () -> assertEquals( "Run all Tests", stage.getComponent(0).getName())
        );
    }
}

package domain.builders.cicd;

public class PipelineDirector {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public PipelineDirector() {}

    /* METHODS */
    public void buildReleasePipeline(IPipelineBuilder builder) {
        builder.reset();
        builder.setName("Release Pipeline");
        builder.setDescription("This pipeline leads to a release to the production environment");

        builder.addStage("Source", "");
        builder.addJob("Clone GIT Repository", "");
        builder.addCommand("git clone https://gitlab.com/tvw203/avanseddevops.git", new String[]{});

        builder.addStage("Build", "");
        builder.addJob("Build the Code", "");
        builder.addCommand("mvn clean install", new String[]{});

        builder.addStage("Test", "");
        builder.addJob("Run all Tests", "");
        builder.addCommand("mvn test", new String[]{});

        builder.addStage("Deployment", "Staging Environment");
        builder.addJob("Deploy the Code", "");
        builder.addCommand("scp avanseddevops localhost:1234", new String[]{});

        builder.addStage("Release", "Staging Environment");
        builder.addJob("Deploy the Code", "Production Environment");
        builder.addCommand("scp avanseddevops 2123985@avans.com:4044", new String[]{});
    }

    public void buildReviewPipeline(IPipelineBuilder builder) {

    }
}

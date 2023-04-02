package domain.builders.cicd;

import java.time.LocalDateTime;

public class PipelineDirector {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public PipelineDirector() {}

    /* METHODS */
    public void buildReleasePipeline(IPipelineBuilder builder) {
        builder.reset();
        builder.setName("Release Pipeline");
        builder.setDescription("This pipeline leads to a release to the production environment.");

        setupMainStructure(builder);

        builder.addStage("Deployment", "Staging Environment");
        builder.addJob("Deploy the Code", "");
        builder.addCommand("scp avanseddevops root@172.20.10.8/tmp", new String[]{
                "Reading configuration data...",
                "Connecting to root@172.20.10.8/tmp",
                "Copying files...",
                "...4.8%",
                "...13.2%",
                "...30.1",
                "...46.8%",
                "...69.4%",
                "...83.1%",
                "...92.2%",
                "Completed!"
        });

        builder.addStage("Release", "Staging Environment");
        builder.addJob("Deploy the Code", "Production Environment");
        builder.addCommand("scp avanseddevops 2123985@avans.com:4044", new String[]{
                "Reading configuration data...",
                "Connecting to 2123985@avans.com:4044/dir/release",
                "Establishing SSH Connection...",
                "Connection established!",
                "Copying files...",
                "...4.8%",
                "...13.2%",
                "...30.1",
                "...46.8%",
                "...69.4%",
                "...83.1%",
                "...92.2%",
                "Completed!"
        });
    }

    public void buildReviewPipeline(IPipelineBuilder builder) {
        builder.reset();
        builder.setName("Review Pipeline");
        builder.setDescription("This pipeline leads to a review of the code.");

        setupMainStructure(builder);
    }

    private void setupMainStructure(IPipelineBuilder builder) {
        builder.addStage("Source", "");
        builder.addJob("Clone GIT Repository", "");
        builder.addCommand("git clone https://gitlab.com/tvw203/avanseddevops.git", new String[]{
                "Cloning into 'avanseddevops'...",
                "remote: Enumerating objects: 147, done.",
                "remote: Counting objects: 100% (147/147), done.",
                "remote: Compressing objects: 100% (104/104), done.",
                "remote: Total 147 (delta 52), reused 137 (delta 42), pack-reused 0",
                "Receiving objects: 100% (147/147), 43.87 KiB | 3.27 MiB/s, done.",
                "Resolving deltas: 100% (52/52), done."
        });

        builder.addStage("Build", "");
        builder.addJob("Build the Code", "");
        builder.addCommand("mvn clean install", new String[]{
                "[INFO] Scanning for projects...",
                "[INFO] ",
                "[INFO] --------------< com.example:avanseddevops >--------------",
                "[INFO] Building Avansed DevOps 1.0-SNAPSHOT",
                "[INFO] --------------------------------[ jar ]---------------------------------",
                "Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.pom",
                "Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.pom (3.9 kB at 4.6 kB/s)",
                "Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/28/maven-plugins-28.pom",
                "Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/28/maven-plugins-28.pom (12 kB at 215 kB/s)",
                "Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.jar",
                "Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.jar (24 kB at 486 kB/s)",
                "...",
                "[INFO] ------------------------------------------------------------------------",
                "[INFO] BUILD SUCCESS",
                "[INFO] ------------------------------------------------------------------------",
                "[INFO] Total time:  3.456 s",
                "[INFO] Finished at: " + LocalDateTime.now(),
                "[INFO] ------------------------------------------------------------------------"
        });

        builder.addStage("Test", "");
        builder.addJob("Run all Tests", "");
        builder.addCommand("mvn test", new String[]{
                "[INFO] Scanning for projects...",
                "[INFO] ",
                "[INFO] --------------< com.example:avanseddevops >--------------",
                "[INFO] Building Avansed DevOps 1.0-SNAPSHOT",
                "[INFO] --------------------------------[ jar ]---------------------------------",
                "...",
                "-------------------------------------------------------",
                "T E S T S",
                "-------------------------------------------------------",
                "Running com.example.BuilderTests",
                "Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.723 sec",
                "",
                "Results :",
                "",
                "Tests run: 4, Failures: 0, Errors: 0, Skipped: 0",
                "",
                "[INFO] ------------------------------------------------------------------------",
                "[INFO] BUILD SUCCESS",
                "[INFO] ------------------------------------------------------------------------",
                "[INFO] Total time:  10.378 s",
                "[INFO] Finished at: " + LocalDateTime.now(),
                "[INFO] ------------------------------------------------------------------------"
        });
    }
}

package io.jenkins.plugins.analysis.warnings;

import java.io.IOException;

import hudson.maven.MavenModuleSet;

/**
 * Integration tests of {@link hudson.maven.MavenModuleSet} with {@link io.jenkins.plugins.analysis.core.quality.QualityGate}.
 *
 * @author Michaela Reitschuster
 */
public class MavenProjectQualityGateITest extends AbstractQualityGateITest<MavenModuleSet> {

    @Override
    protected MavenModuleSet getProject() {
        MavenModuleSet project = createJob();
        copyFilesToWorkspace(project, "checkstyle-qualitygate.xml");
        return project;
    }

    private MavenModuleSet createJob() {
        try {
            return j.createProject(MavenModuleSet.class);
        }
        catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}

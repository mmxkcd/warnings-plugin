package io.jenkins.plugins.analysis.warnings;

import java.io.IOException;

import hudson.model.FreeStyleProject;

/**
 * Integration tests of {@link hudson.model.FreeStyleProject} with {@link io.jenkins.plugins.analysis.core.quality.QualityGate}.
 *
 * @author Michaela Reitschuster
 */
public class FreeStyleProjectQualityGateITest extends AbstractQualityGateITest<FreeStyleProject> {

    @Override
    protected FreeStyleProject getProject() {
        FreeStyleProject job = createJob();
        copyFilesToWorkspace(job, "checkstyle-qualitygate.xml");
        return job;
    }

    private FreeStyleProject createJob() {
        try {
            return j.createFreeStyleProject();
        }
        catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}

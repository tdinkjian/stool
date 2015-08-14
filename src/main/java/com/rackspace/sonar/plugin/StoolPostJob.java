package com.rackspace.sonar.plugin;

import org.sonar.api.batch.CheckProject;
import org.sonar.api.batch.PostJob;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

/**
 * Created by dimi5963 on 8/14/15.
 */
public class StoolPostJob implements PostJob, CheckProject {
    public boolean shouldExecuteOnProject(Project project) {
        return false;
    }

    public void executeOn(Project project, SensorContext sensorContext) {

    }
}

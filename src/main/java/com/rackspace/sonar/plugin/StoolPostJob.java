package com.rackspace.sonar.plugin;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.sonar.api.batch.CheckProject;
import org.sonar.api.batch.PostJob;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.Project;

/**
 * Created by dimi5963 on 8/14/15.
 */
public class StoolPostJob implements PostJob, CheckProject {

    private final Settings settings;

    public StoolPostJob(Settings settings) {
        this.settings = settings;
    }

    public boolean shouldExecuteOnProject(Project project) {
        return false;
    }

    public void executeOn(Project project, SensorContext sensorContext) {
        // this sensor is executed if no config defined on sonar server
        String jtlPath = settings.getString(StoolPluginConst.LOCAL_RESULTS_PATH_PROPERTY);
//        String config = settings.getString(StoolPluginConst.);
        if (StringUtils.isNotBlank(jtlPath)){
            return;
        }

        try {

            GlobalSummary summary = getGlobalSummaryFromLocalJTL(project);
            if (summary != null) {
                StoolDAO.saveSummaryAsMetrics(summary, context);
            }

        } catch (Exception e) {

        }
    }

    /**
     * Gets the generated jtl file path, if it was any generated
     */
    protected String getJtlFilePath(Project project, String stoolreportspath) {
        String baseDirPath = project.getFileSystem().getBasedir().getAbsolutePath();
        File reportDir = new File(baseDirPath + stoolreportspath);

        if (reportDir.exists()) {
            for (File file : (Collection<File>) FileUtils.listFiles(reportDir, new String[]{"jtl"}, true)) {
                return file.getAbsolutePath();
            }

            for (File file : (Collection<File>) FileUtils.listFiles(reportDir, new String[]{"xml"}, true)) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }
}
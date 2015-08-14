package com.rackspace.sonar.plugin;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;


@Properties( {
        @Property(key = StoolPluginConst.LOCAL_RESULTS_PATH_PROPERTY,
                name = "Local results path file",
                description = "Local results file path. If specified no remote config is used.", project = true, global = false)
})

public class StoolPlugin extends SonarPlugin {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List getExtensions() {
        return Arrays.asList(StoolMetrics.class, StoolSensor.class,
                StoolDAO.class,
                StoolDashboardWidget.class, StoolPostJob.class
        );
    }
}

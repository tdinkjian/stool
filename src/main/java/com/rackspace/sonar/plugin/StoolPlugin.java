package com.rackspace.sonar.plugin;

import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

public class StoolPlugin extends SonarPlugin {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List getExtensions() {
        return Arrays.asList(StoolMetrics.class, StoolSensor.class,
                StoolDAO.class,
                StoolDashboardWidget.class, StoolPostJob.class
        );
    }
}

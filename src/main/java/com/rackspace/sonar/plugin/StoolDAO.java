package com.rackspace.sonar.plugin;

import org.sonar.api.batch.SensorContext;

import java.util.logging.Logger;

/**
 * Created by dimi5963 on 8/14/15.
 */
public class StoolDAO {

    private StoolDAO() {
    }

    public static void saveSummaryAsMetrics(GlobalSummary summary, SensorContext context) {

        context.saveMeasure(StoolMetrics.requestResponseTimeAvg, summary.getRequestResponseTimeAvg());
    }
}

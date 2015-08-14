package com.rackspace.sonar.plugin;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;
import org.sonar.api.measures.Metric.ValueType;

import java.util.Arrays;
import java.util.List;

public class StoolMetrics implements Metrics {
    public static final String STOOL_DOMAIN = "Performance tests";

    private static Metric newMetric(String key, String name, String descrip, ValueType valueType, int direction) {
        return new Metric.Builder(key, name, valueType)
                .setDescription(descrip==null? name : descrip)
                .setQualitative(false)
                .setDirection(direction)
                .setDomain(STOOL_DOMAIN)
                .create();
    }

    public static final Metric requestResponseTimeAvg = newMetric(
            "requestResponseTimeAvg", "Average Response time per request",
            "Average response time per request",
            ValueType.MILLISEC, Metric.DIRECTION_WORST);

    // Used by Sonar to retrieve the list of metrics
    public List<Metric> getMetrics() {
        return Arrays.asList(requestResponseTimeAvg);
    }
}

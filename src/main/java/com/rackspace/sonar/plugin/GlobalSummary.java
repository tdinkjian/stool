package com.rackspace.sonar.plugin;

/**
 * Created by dimi5963 on 8/14/15.
 */
public class GlobalSummary {
    public Double getRequestResponseTimeAvg() {
        return requestResponseTimeAvg;
    }

    public void setRequestResponseTimeAvg(Double requestResponseTimeAvg) {
        this.requestResponseTimeAvg = requestResponseTimeAvg;
    }

    private Double requestResponseTimeAvg;

}

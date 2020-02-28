package com.o2o.action.server.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleJSON {
    List<ScheduleInfo> scheduleListIn;

    public ScheduleJSON() {

    }

    public List<ScheduleInfo> getScheduleListIn() {
        return scheduleListIn;
    }

    public void setScheduleListIn(List<ScheduleInfo> scheduleListIn) {
        this.scheduleListIn = scheduleListIn;
    }
}

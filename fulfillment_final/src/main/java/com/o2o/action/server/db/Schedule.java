package com.o2o.action.server.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.o2o.action.server.json.ScheduleInfo;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(name = "aog_schedule_scheduleid_idx", columnList = "scheduleId")})
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Channel channel;

    @Column(nullable = false)
    long startTime;
    @Column(nullable = false)
    long endTime;
    @Column(nullable = false)
    String scheduleId;
    @Column(nullable = false)
    String name;
    @Column(length = 4096)
    String description;

    public Schedule() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void update(ScheduleInfo schedule) {
        this.startTime = schedule.getStarttime();
        this.endTime = schedule.getEndtime();
        this.name = schedule.getProgram_name();
        this.description = schedule.getSummary();
        this.scheduleId = schedule.getSchedule_id();
    }
}

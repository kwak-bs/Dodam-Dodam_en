package com.o2o.action.server.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.o2o.action.server.json.ChannelInfo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(indexes = {@Index(name = "aog_channel_chname_idx", columnList = "chName")})
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    int chCode;
    @Column(nullable = false)
    int chNumber;
    @Column(nullable = false)
    int chGene;
    @Column(nullable = false)
    String chName;

    @Column(length = 4096)
    String description;

    String logoPath;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "channel", fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    public Channel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getChCode() {
        return chCode;
    }

    public void setChCode(int chCode) {
        this.chCode = chCode;
    }

    public int getChNumber() {
        return chNumber;
    }

    public void setChNumber(int chNumber) {
        this.chNumber = chNumber;
    }

    public int getChGene() {
        return chGene;
    }

    public void setChGene(int chGene) {
        this.chGene = chGene;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void update(ChannelInfo newChannel) {
        this.chCode = newChannel.getFd_channel_id();
        this.chNumber = newChannel.getFd_channel_no();
        this.chGene = newChannel.getFd_genre_name();
        this.chName = newChannel.getFd_channel_name();
        this.description = newChannel.getFd_contents();
        this.logoPath = "https:" + newChannel.getFd_logo_path();
    }
}

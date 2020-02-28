package com.o2o.action.server.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelInfo {
    long pk_epg_mapp;
    long fd_mapp_cd;
    String fd_logo_path;
    int fd_genre_name;
    String fd_contents;
    int fd_channel_no;
    String fd_channel_name;
    int fd_channel_id;

    public ChannelInfo() {
    }

    public long getPk_epg_mapp() {
        return pk_epg_mapp;
    }

    public void setPk_epg_mapp(long pk_epg_mapp) {
        this.pk_epg_mapp = pk_epg_mapp;
    }

    public long getFd_mapp_cd() {
        return fd_mapp_cd;
    }

    public void setFd_mapp_cd(long fd_mapp_cd) {
        this.fd_mapp_cd = fd_mapp_cd;
    }

    public String getFd_logo_path() {
        return fd_logo_path;
    }

    public void setFd_logo_path(String fd_logo_path) {
        this.fd_logo_path = fd_logo_path;
    }

    public int getFd_genre_name() {
        return fd_genre_name;
    }

    public void setFd_genre_name(int fd_genre_name) {
        this.fd_genre_name = fd_genre_name;
    }

    public String getFd_contents() {
        return fd_contents;
    }

    public void setFd_contents(String fd_contents) {
        this.fd_contents = fd_contents;
    }

    public int getFd_channel_no() {
        return fd_channel_no;
    }

    public void setFd_channel_no(int fd_channel_no) {
        this.fd_channel_no = fd_channel_no;
    }

    public String getFd_channel_name() {
        return fd_channel_name;
    }

    public void setFd_channel_name(String fd_channel_name) {
        this.fd_channel_name = fd_channel_name;
    }

    public int getFd_channel_id() {
        return fd_channel_id;
    }

    public void setFd_channel_id(int fd_channel_id) {
        this.fd_channel_id = fd_channel_id;
    }
}

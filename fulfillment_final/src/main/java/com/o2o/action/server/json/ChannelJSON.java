package com.o2o.action.server.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelJSON {
    List<ChannelInfo> channelListInfo;

    public ChannelJSON() {

    }

    public List<ChannelInfo> getChannelListInfo() {
        return channelListInfo;
    }

    public void setChannelListInfo(List<ChannelInfo> channelListInfo) {
        this.channelListInfo = channelListInfo;
    }
}

package com.o2o.action.server.repo;

import com.o2o.action.server.db.Channel;
import com.o2o.action.server.db.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    List<Schedule> findByScheduleId(String id);
    List<Schedule> findByChannelAndStartTimeLessThanEqualAndEndTimeGreaterThan(Channel channel, long current1, long current2);
    List<Schedule> findByChannelInAndStartTimeLessThanEqualAndEndTimeGreaterThan(List<Channel> channel, long current1, long current2);
    List<Schedule> findByChannelOrderByStartTimeDesc(Channel channel);
}

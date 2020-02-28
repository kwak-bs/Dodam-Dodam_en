package com.o2o.action.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.o2o.action.server.db.Channel;

public interface ChannelRepository extends CrudRepository<Channel, Long> {
	List<Channel> findByChCode(int code);

	List<Channel> findByChName(String name);
}

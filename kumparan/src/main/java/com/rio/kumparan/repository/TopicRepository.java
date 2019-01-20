/**
 * 
 */
package com.rio.kumparan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rio.kumparan.model.Topic;

/**
 * @author Rio
 *
 */
public interface TopicRepository extends JpaRepository<Topic, Long>{
	Topic findByName(String name);
}

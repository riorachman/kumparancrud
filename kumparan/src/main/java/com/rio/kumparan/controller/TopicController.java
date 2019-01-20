package com.rio.kumparan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rio.kumparan.model.Topic;
import com.rio.kumparan.repository.TopicRepository;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicRepository topicRepository;

	/*
	 * getTopics
	 */
	@GetMapping("/")
	public List<Topic> getTopics() {
		return topicRepository.findAll();
	}

	/*
	 * findByName
	 */
	@GetMapping(value = "/{name}")
	public ResponseEntity<Topic> findByName(@PathVariable final String name) {
		Topic topic = topicRepository.findByName(name);
		if (topic == null) {
			return new ResponseEntity<Topic>(topic, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}

	/*
	 * save
	 */
	@PostMapping(value = "/save")
	public ResponseEntity<Topic> save(@RequestBody final Topic topics) {
		topics.setCreatOn(new Date());
		topicRepository.save(topics);
		return new ResponseEntity<Topic>(topics, HttpStatus.OK);
	}

	/*
	 * update
	 */
	@PutMapping("/{name}")
	public ResponseEntity<Topic> update(@RequestBody final Topic topics, @PathVariable String name) {
		Topic topic = topicRepository.findByName(name);

		if (null == topic) {
			return new ResponseEntity<Topic>(HttpStatus.NO_CONTENT);
		}
		
		topic.setName(topics.getName());
		topic.setModiOn(new Date());
		topicRepository.save(topic);

		return new ResponseEntity<Topic>(topics, HttpStatus.OK);
	}

	/*
	 * delete
	 */
	@DeleteMapping("/{name}")
	public ResponseEntity<Void> delete(@PathVariable("name") String name) {
		Topic topic = topicRepository.findByName(name);

		if (null == topic) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		topicRepository.delete(topicRepository.findByName(name));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

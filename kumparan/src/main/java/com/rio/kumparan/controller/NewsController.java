package com.rio.kumparan.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.rio.kumparan.model.News;
import com.rio.kumparan.model.Topic;
import com.rio.kumparan.repository.NewsRepository;
import com.rio.kumparan.repository.TopicRepository;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private NewsRepository newsRepository;

	/*
	 * getNews
	 */
	@GetMapping("/")
	public List<News> getNews() {
		return newsRepository.findAll();
	}

	/*
	 * filterByStatus
	 */
	@GetMapping(value = "/{status}")
	public List<News> filterByStatus(@PathVariable final String status) {
		return newsRepository.filterByStatus(status);
	}

	/*
	 * save
	 */
	@PostMapping(value = "/save")
	public ResponseEntity<News> save(@RequestBody final News news) {
		Set<Topic> topics = new HashSet<Topic>();

		for (Topic data : news.getTopics()) {
			topics.add(topicRepository.findByName(data.getName()));
		}

		news.setTopics(topics);
		newsRepository.save(news);
		return new ResponseEntity<News>(news, HttpStatus.OK);
	}

	/*
	 * update
	 */
	@PutMapping("/{title}")
	public ResponseEntity<News> update(@RequestBody final News news, @PathVariable String title) {
		News newRepo = newsRepository.findByTitle(title);

		if (null == newRepo) {
			return new ResponseEntity<News>(HttpStatus.NO_CONTENT);
		}

		Set<Topic> topics = new HashSet<Topic>();

		for (Topic data : news.getTopics()) {
			topics.add(topicRepository.findByName(data.getName()));
		}

		newRepo.setTopics(topics);
		newRepo.setModiOn(new Date());
		newsRepository.save(newRepo);

		return new ResponseEntity<News>(news, HttpStatus.OK);
	}

	/*
	 * delete
	 */
	@DeleteMapping("/{title}")
	public ResponseEntity<News> delete(@PathVariable("title") String title) {
		News news = newsRepository.findByTitle(title);

		if (null == news) {
			return new ResponseEntity<News>(HttpStatus.NO_CONTENT);
		}

		newsRepository.delete(newsRepository.findByTitle(title));
		return new ResponseEntity<News>(HttpStatus.OK);
	}

}

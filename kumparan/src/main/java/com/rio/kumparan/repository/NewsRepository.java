package com.rio.kumparan.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rio.kumparan.model.News;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long>{
	
	@Query("FROM NEWS N WHERE N.status = :STATUS")
	List<News> filterByStatus(@Param("STATUS") String status);
	News findByTitle(String title);
}

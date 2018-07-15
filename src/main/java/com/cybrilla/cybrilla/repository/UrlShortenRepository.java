package com.cybrilla.cybrilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybrilla.cybrilla.model.UrlShortner;

@Repository
public interface UrlShortenRepository extends JpaRepository<UrlShortner, Long>{
	

}

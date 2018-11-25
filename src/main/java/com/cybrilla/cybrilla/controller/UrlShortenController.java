package com.cybrilla.cybrilla.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybrilla.cybrilla.model.UrlShortner;
import com.cybrilla.cybrilla.repository.UrlShortenRepository;
import com.cybrilla.cybrilla.services.ShortURL;

@RestController
public class UrlShortenController {

	@Autowired
	private UrlShortenRepository urlRepository;
	
	@PostMapping("urlshortner")
	public Map<String,String> getShortenUrl(@Valid @RequestBody UrlShortner urlshortner){
		Map<String,String> response = new HashMap<String,String>();
		UrlShortner urlShortner = urlRepository.save(urlshortner);
		long urlShortnerId = urlShortner.getId();
		
		ShortURL shorturl = new ShortURL();
		
		String shortUrl = shorturl.encode(urlShortnerId);
		response.put("staatus", "success");
		response.put("shortUrl", shortUrl);
		return response;
		
	}
	
	@GetMapping("/urlshortner/{inputurl}")
	public Map<String,Object> getUrlByShortenUrl(@PathVariable String inputurl,Principal principal){
		Map<String, Object> response = new HashMap<String,Object>();
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		System.out.println(currentPrincipalName);
//		ShortURL shorturl = new ShortURL();
//		long urlid = shorturl.decode(inputurl);
//		Optional<UrlShortner> urlShorten = urlRepository.findById(urlid);
//		if(!urlShorten.isPresent()) {
//			response.put("staatus", "failed");
//			response.put("shortUrl", "Sorry! We don't have record for url!");
//		}
		response.put("status", "success");
		response.put("response",principal.getName() );
		return response;
		
	}
}

package com.eflechowicz.moviemanager.moviemicroservice.controller;

import com.eflechowicz.moviemanager.moviemicroservice.model.Movie;
import com.eflechowicz.moviemanager.moviemicroservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/")
public class MovieController{

	@Autowired
	private MovieService service;

	@RequestMapping(value = "/movies", method=RequestMethod.GET)
	public List<Movie> getMovies() {
		return service.getMovies();
}
	@RequestMapping(value = "/movies/rating/asc", method = RequestMethod.GET)
	public List<Movie> getMovieByRatingAsc(){
		return service.getMovieByRatingAsc();
	}
	
	@RequestMapping(value = "/movies/rating/desc", method = RequestMethod.GET)
	public List<Movie> getMovieByRatingDesc(){
		return service.getMovieByRatingDesc();
	}
	
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
	public Optional<Movie> getMovieById(@PathVariable String id) {
		return service.getMovieById(id);
	}
	
	@RequestMapping(value = "/movies/byTitle/{title}", method = RequestMethod.GET)
	public Movie getMovieByTitle(@PathVariable String title) {
		return service.getMovieByTitle(title);
	}
	@PostMapping(value = "/movies")
	public Movie addMovie(@Valid @RequestBody Movie entity) {
		return service.createMovie(entity);
	}
	
	@RequestMapping(value = "/movies/{title}", method=RequestMethod.DELETE)
	public Movie deleteMovie(@PathVariable String title) {
		return service.deleteMovie(title);
	}
	
}
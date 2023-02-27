package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added Succesfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added sucesfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Movie director pair added",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String>> getMoviesByDirectorName(@PathVariable String director){
        ArrayList<String> directorList = movieService.directorMovies(director);
        return new ResponseEntity<>(directorList,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<ArrayList<String>> findAllMovies(){
        ArrayList<String> movies = movieService.allMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director+ "deleted",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("ALl Directors deleted",HttpStatus.CREATED);
    }

}

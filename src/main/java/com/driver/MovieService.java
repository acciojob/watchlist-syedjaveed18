package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMoive(movie);
    }

    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director){
        movieRepository.saveMovieDirectorPair(movie,director);
    }

    public Movie findMovie(String movie){
        return movieRepository.findMovie(movie);
    }

    public Director findDirector(String director){
        return movieRepository.findDirector(director);
    }

    public ArrayList<String> directorMovies(String director){
        return movieRepository.findMoviesOfDirector(director);
    }

    public ArrayList<String> allMovies(){
        return movieRepository.allMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirector(){
        movieRepository.deleteAllDirector();
    }
}

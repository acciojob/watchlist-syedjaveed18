package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;
    private HashMap<String,ArrayList<String>> directorMovieList;

    public MovieRepository(){
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.directorMovieList = new HashMap<>();
    }

    public void saveMoive(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(),director);
    }

    public void saveMovieDirectorPair(String movie,String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            ArrayList<String> directorMovies= new ArrayList<>();

            if(directorMovieList.containsKey(director)){
                directorMovies = directorMovieList.get(director);
            }
            directorMovies.add(movie);

            directorMovieList.put(director,directorMovies);
        }
    }

    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public ArrayList<String> findMoviesOfDirector(String director){
        if(!directorMovieList.containsKey(director)){
            return new ArrayList<String>();
        }
        return directorMovieList.get(director);
    }

    public ArrayList<String> allMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        if(directorMovieList.containsKey(director)){
            ArrayList<String> moviesList = directorMovieList.get(director);

            for(String movie : moviesList){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            directorMovieList.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){

        directorMap.clear();

        ArrayList<String> movieList = new ArrayList<>();
        for(String director : directorMovieList.keySet()){
            for(String movie : directorMovieList.get(director)){
                movieList.add(movie);
            }
        }

        directorMovieList.clear();

        for(String movie : movieList){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }
}

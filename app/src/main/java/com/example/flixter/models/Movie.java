package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String posterPath;
    String title;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");//Path to movie's poster
        title = jsonObject.getString("title"); //movie's title
        overview = jsonObject.getString("overview");//movie's description
    }

    public static List<Movie> fromJsonArray(JSONArray jsonArray) throws JSONException {
        //Method creates a list of movies from the given JSON array
        List<Movie> movies = new ArrayList<>();
        JSONObject m;
        for (int i =0; i< jsonArray.length(); i++ ){
            m = jsonArray.getJSONObject(i);
            movies.add(new Movie(m));
        }
        return movies;
    }

    public String getPosterPath(){
        //if we simply return posterPath as is, it's going to be unusable. We won't be able to
        // actually get the poster from it because the current posterPath data is a shortened
        // form of what we actually need
//        return posterPath;

        return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);

    }

    public String getTitle(){
        return title;
    }

    public String getOverview(){
        return overview;
    }
}

package com.example.alexg.uni_helper_aoo;

/**
 * Created by alexg on 2/06/2017.
 */

public class Mentor {

    private String name;
    private int mentor_rating = 0;
    private int num_of_ratings = 0;
    private int absolute_ratings = 0;   // This is the total number of stars received. This will
                                        // be used for calculation later

    public Mentor(String name){
        setName(name);
        setAbsolute_ratings(0);
        setMentor_rating(0);
    }

    // Getter and setter methods below
    public void setName(String name){
            this.name = name;
    }

    public int getAbsolute_ratings(){
        return absolute_ratings;
    }

    public void setAbsolute_ratings(int star_input){
        absolute_ratings += star_input;
    }

    public int getNum_of_ratings(){
        return num_of_ratings;
    }

    // Increments number of ratings made when a new rating is entered.
    public void setNum_of_ratings(){
        num_of_ratings++;
    }

    public void setMentor_rating(int rating){

        int m_rating = getCurrentMentor_rating();
        int abs_rating = getAbsolute_ratings() + rating;

        // update the number of ratings made
        setNum_of_ratings();

        int num_ratings = getNum_of_ratings();

        // Mentor rating = sum of ratings / number of ratings
        mentor_rating = abs_rating / num_ratings;
    }

    public int getCurrentMentor_rating() {
        return mentor_rating;
    }
}
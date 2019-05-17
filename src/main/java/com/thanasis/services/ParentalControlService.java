package com.thanasis.services;

import com.thanasis.thirdparty.MovieService;
import com.thanasis.thirdparty.TechnicalFailureException;
import com.thanasis.thirdparty.TitleNotFoundException;

public class ParentalControlService {


    private String movieId;
    private String userLevel;
    private MovieService movieService;

    public ParentalControlService(MovieService movieService) {
        this.movieService = movieService;
    }


    //ParentalControlLevel.parentallevels level = ParentalControlLevel.parentallevels.eighteen;

//    public boolean isAcceptable(){
//
//        ParentalControlLevel level = EIGHTEEN;
//
//        return false;
//    }



    public boolean isAcceptable(String movieId, String userLevel) throws TechnicalFailureException, TitleNotFoundException {




        String level = movieService.getParentalControlLevel(movieId);


        String[] levels = new String[5];

        levels[0] = "U";
        levels[1] = "PG";
        levels[2] = "12";
        levels[3] = "15";
        levels[4] = "18";


        int numUserLevel = 0;
        int numLevel = 0;

        for (int i = 0; i < 5; i++) {

            if (userLevel == levels[i]) {
                numUserLevel = i;
            }
            if (level == levels[i]) {
                numLevel = i;
            }
        }

        if (numUserLevel < numLevel) {
            return false;

        } else {
            return true;
        }
    }


}



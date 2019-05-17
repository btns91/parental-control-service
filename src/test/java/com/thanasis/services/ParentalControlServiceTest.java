package com.thanasis.services;

import com.thanasis.thirdparty.MovieService;
import com.thanasis.thirdparty.TechnicalFailureException;
import com.thanasis.thirdparty.TitleNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ParentalControlServiceTest {


    @Mock
    private MovieService movieService;

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIsU() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movieU")).thenReturn("U");

        boolean access = parentalControlService.isAcceptable("movieU", "U");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnFalseWhenTheMoviesParentLevelIsHigherU() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie12")).thenReturn(("12"));

        boolean access = parentalControlService.isAcceptable("movie12", "U");


        assertEquals(false, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIsPG() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("moviePG")).thenReturn(("PG"));

        boolean access = parentalControlService.isAcceptable("moviePG", "PG");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIsLowerU() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movieU")).thenReturn("U");
        boolean access = parentalControlService.isAcceptable("movieU", "PG");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnFalseWhenTheMoviesParentLevelIsHigherPG() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie12")).thenReturn("12");

        boolean access = parentalControlService.isAcceptable("movie12", "PG");

        assertEquals(false, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIs12() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie12")).thenReturn("12");

        boolean access = parentalControlService.isAcceptable("movie12", "12");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIsLower12() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("moviePG")).thenReturn("PG");

        boolean access = parentalControlService.isAcceptable("moviePG", "12");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnFalseWhenTheMoviesParentLevelIsHigher12() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie15")).thenReturn("15");

        boolean access = parentalControlService.isAcceptable("movie15", "12");

        assertEquals(false, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIs15() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie15")).thenReturn("15");

        boolean access = parentalControlService.isAcceptable("movie15", "15");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIsLower15() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie12")).thenReturn("12");

        boolean access = parentalControlService.isAcceptable("movie12", "15");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIsHigher15() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie18")).thenReturn("18");

        boolean access = parentalControlService.isAcceptable("movie18", "15");

        assertEquals(false, access);
    }

    @Test
    void  shouldReturnTrueWhenTheMoviesParentLevelI18() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie18")).thenReturn("18");

        boolean access = parentalControlService.isAcceptable("movie18", "18");

        assertEquals(true, access);
    }

    @Test
    void shouldReturnTrueWhenTheMoviesParentLevelIsLower18() throws TechnicalFailureException, TitleNotFoundException {

        ParentalControlService parentalControlService = new ParentalControlService(movieService);

        when(movieService.getParentalControlLevel("movie15")).thenReturn("18");

        boolean access = parentalControlService.isAcceptable("movie15", "18");

        assertEquals(true, access);
    }

}
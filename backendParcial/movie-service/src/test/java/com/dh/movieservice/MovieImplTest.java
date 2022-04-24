package com.dh.movieservice;


import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MovieImplTest {
    @Autowired
    private MovieService movieService;

    @Test
    public void testCreacionPelicula(){
        Movie movie = new Movie();
        movie.setGenre("Action");
        movie.setName("Action movie");
        movie.setUrlStream("www.amazonprime.com");

        movieService.save(movie);

        //Assert.assertTrue(movieService.getListByGenre("Action").contains(movie));

    }
}

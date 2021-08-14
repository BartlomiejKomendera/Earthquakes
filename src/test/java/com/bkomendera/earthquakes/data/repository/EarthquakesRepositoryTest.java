package com.bkomendera.earthquakes.data.repository;

import com.bkomendera.earthquakes.domain.util.Coords;
import org.assertj.core.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class EarthquakesRepositoryTest {

    private EarthquakesRepository repoTest;

    @BeforeEach
    void setUp(){
        repoTest = new EarthquakesRepository();
    }

    @Test
    @DisplayName("Should save and retrieve an entry from the repository")
    void saveRetrieveEarthquakesRepo() {
        //given
        Map<String, Coords> testMap = new HashMap<>();
        testMap.put("TestString",new Coords(0.1f,0.1f));
        repoTest.saveEarthquakesRepo(testMap);

        //when
        Coords expected = null;
        expected = repoTest.getEarthquakesRepo().get("TestString");

        //then
        Assertions.assertThat(expected).isEqualTo(new Coords(0.1f,0.1f));
    }
}
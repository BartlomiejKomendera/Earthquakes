package com.bkomendera.earthquakes.service;

import com.bkomendera.earthquakes.data.api.EarthquakesApiInterface;
import com.bkomendera.earthquakes.data.repository.EarthquakesRepository;
import com.bkomendera.earthquakes.domain.Feature;
import com.bkomendera.earthquakes.domain.Geometry;
import com.bkomendera.earthquakes.domain.Properties;
import com.bkomendera.earthquakes.domain.util.Coords;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class EarthquakesServiceTest {

    @Mock
    private EarthquakesApiInterface earthquakesApiInterface;
    /*@Mock
    private EarthquakesRepository earthquakesRepository;*/
    @InjectMocks
    private EarthquakesService earthquakesServiceTest;

    @BeforeEach
    void setUp() {

    }

    @Test
    void loadEarthquakes() throws IOException {
        //given
        Feature testFeature = Mockito.mock(Feature.class);
        Properties testProperties = Mockito.mock(Properties.class);
        Geometry testGeometry = Mockito.mock(Geometry.class);
        List<Feature> testList = new LinkedList<>();
        testList.add(testFeature);
        List<Float> coordTestList = new LinkedList<>();
        coordTestList.add(45.00f);
        coordTestList.add(19.00f);
        Coords testCoords = new Coords(45.00f,19.00f);

        //when
        Mockito.when(testFeature.getGeometry()).thenReturn(testGeometry);
        Mockito.when(testGeometry.getCoordinates()).thenReturn(coordTestList);
        Mockito.when(earthquakesApiInterface.getAllMonth()).thenReturn(testList);
        Mockito.when(testFeature.getProperties()).thenReturn(testProperties);
        Mockito.when(testProperties.getTitle()).thenReturn("Test title");
        earthquakesServiceTest.loadEarthquakes();

        /*when(userRepository.save(Mockito.any(User.class)))
                .thenAnswer(i -> i.getArguments()[0]);*/

        //then
        Assertions.assertThat(earthquakesRepository.getEarthquakesRepo()).containsEntry("Test title", testCoords);

    }

    @Test
    @Disabled
    void getEarthquakes() {
    }

    @Test
    @Disabled
    void getCloseEarthquakes() {
    }

    @Test
    @Disabled
    void deg2rad() {
    }
}
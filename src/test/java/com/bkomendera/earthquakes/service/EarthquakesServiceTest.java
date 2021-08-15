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
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class EarthquakesServiceTest {

    @Mock
    private EarthquakesApiInterface earthquakesApiInterface;
    @Mock
    private EarthquakesRepository earthquakesRepository;
    @InjectMocks
    private EarthquakesService earthquakesService;

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
        List<Float> testCoordsList = new LinkedList<Float>();
        testCoordsList.add(45f);
        testCoordsList.add(19f);
        Map<String,Coords> testMap = new HashMap<>();
        testMap.put("Test title", new Coords(45f,19f));

        //when
        Mockito.when(earthquakesApiInterface.getAllMonth()).thenReturn(testList);
        Mockito.when(testFeature.getGeometry()).thenReturn(testGeometry);
        Mockito.when(testFeature.getProperties()).thenReturn(testProperties);
        Mockito.when(testGeometry.getCoordinates()).thenReturn(testCoordsList);
        Mockito.when(testProperties.getTitle()).thenReturn("Test title");
        earthquakesService.loadEarthquakes();

        //then
        Mockito.verify(earthquakesRepository).saveEarthquakesRepo(testMap);

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
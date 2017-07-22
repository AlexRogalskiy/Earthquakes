package ru.inno.earthquakes.model.earthquakes.data;

import io.reactivex.Single;
import retrofit2.http.GET;
import ru.inno.earthquakes.model.earthquakes.data.rawmodels.EarthquakesResponse;

/**
 * @author Artur Badretdinov (Gaket)
 *         20.07.17.
 */
public interface EarthquakesApiService {

    @GET("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson")
    Single<EarthquakesResponse> getEarthquakes();
}
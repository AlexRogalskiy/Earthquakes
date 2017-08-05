package ru.inno.earthquakes.model.location;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.inno.earthquakes.entities.Location;

/**
 * @author Artur Badretdinov (Gaket)
 *         22.07.17.
 */
public class LocationInteractor {

    private LocationRepository repository;

    @Inject
    public LocationInteractor(LocationRepository repository) {
        this.repository = repository;
    }

    public Single<Location.Coordinates> getCurrentCoordinates() {
        return repository.getCurrentCoordinates();
    }
}

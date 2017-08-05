package ru.inno.earthquakes.presentation.settings;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.inno.earthquakes.di.settings.SettingsComponent;
import ru.inno.earthquakes.model.settings.SettingsInteractor;

/**
 * @author Artur Badretdinov (Gaket)
 *         05.08.17
 */
@InjectViewState
public class SettingsPresenter extends MvpPresenter<SettingsView> {

    @Inject
    SettingsInteractor interactor;

    public SettingsPresenter(SettingsComponent settingsComponent) {
        settingsComponent.inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        interactor.getAlertMaxDistance()
                .subscribe(dist -> {
                    getViewState().setMaxDistance(dist);
                });
        interactor.getAlertMinMagnitude()
                .subscribe(mag -> {
                    getViewState().setMinMagnitude(mag);
                });
    }

    void onSave(int km, double magnitude) {
        interactor.saveAlertSettings(km, magnitude);
    }
}

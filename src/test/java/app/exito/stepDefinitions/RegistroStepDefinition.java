package app.exito.stepDefinitions;


import app.exito.driver.AppiumAndroidDriver;
import app.exito.tasks.RegistroTask;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.io.IOException;

import static app.exito.userInterfaces.RegistroUI.LBL_CODIGO_CONFIRMACION;

public class RegistroStepDefinition {

   // Excel datos = new Excel();

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario se encuentra en la app de Exito$")
    public void queElUsuarioSeEncuentraEnLaAppDeExito() throws IOException {
        OnStage.theActorCalled("actor").can(BrowseTheWeb.with(AppiumAndroidDriver.appium().on()));

    }

    @Cuando("^el usuario se registra en la app del exito$")
    public void elUsuarioSeRegistraEnLaAppDelExito() {
        OnStage.theActor("actor").attemptsTo(RegistroTask.on());

    }

    @Entonces("^se valida que se haya registrado de manera correcta$")
    public void seValidaQueSeHayaRegistradoDeManeraCorrecta() {
        Ensure.that(LBL_CODIGO_CONFIRMACION).isEnabled();
    }

}

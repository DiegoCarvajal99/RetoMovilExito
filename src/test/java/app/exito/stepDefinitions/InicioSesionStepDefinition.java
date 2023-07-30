package app.exito.stepDefinitions;


import app.exito.tasks.InicioSesionTask;
import app.exito.utils.Excel;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.io.IOException;

import static app.exito.userInterfaces.InicioSesionUI.LBL_NOMBRE_USUARIO;

public class InicioSesionStepDefinition {
    Excel datos = new Excel();

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^digita las credenciales de inicio de sesion$")
    public void digitaLasCredencialesDeInicioDeSesion() {
        OnStage.theActor("actor").attemptsTo(InicioSesionTask.on());
    }

    @Entonces("^valida que el nombre de usuario sea visible$")
    public void validaQueElNombreDeUsuarioSeaVisible() throws IOException {
        Ensure.that(Text.of(LBL_NOMBRE_USUARIO).equals(datos.leer("Validaciones","Data.xlsx",1,0)));
    }
}

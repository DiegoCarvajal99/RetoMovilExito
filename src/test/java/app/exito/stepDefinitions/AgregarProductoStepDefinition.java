package app.exito.stepDefinitions;


import app.exito.tasks.AgregarProductoTask;
import app.exito.tasks.CerrarSesionTask;
import app.exito.utils.Excel;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.io.IOException;

import static app.exito.userInterfaces.AgregarProductoUI.TXT_VALIDAR_PRODUCTO;

public class AgregarProductoStepDefinition {

    Excel datos = new Excel();

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^busca un producto y lo agrega al carrito$")
    public void buscaUnProductoYLoAgregaAlCarrito() {

        OnStage.theActor("actor").attemptsTo(AgregarProductoTask.on());
    }

    @Entonces("^valida que el producto se haya agregado correctamente$")
    public void validaQueElProductoSeHayaAgregadoCorrectamente() throws IOException {
        Ensure.that(Text.of(TXT_VALIDAR_PRODUCTO).equals(datos.leer("Validaciones","Data.xlsx",1,1)));

    }
}

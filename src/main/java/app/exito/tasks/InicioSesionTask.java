package app.exito.tasks;

import app.exito.driver.AppiumAndroidDriver;
import app.exito.interactions.EscribirEnExcel;
import app.exito.utils.Excel;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static app.exito.userInterfaces.InicioSesionUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InicioSesionTask implements Task {

    public static  String nombreUsuario;
    @Override
    public <T extends Actor> void performAs(T actor) {

        Excel datos = new Excel();

        if (!BTN_INGRESAR.resolveFor(actor).isVisible()){
            actor.attemptsTo(
                    CerrarSesionTask.on()

            );
        }

        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_INGRESAR, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_INGRESAR),
                    WaitUntil.the(INP_CORREO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(INP_CORREO),
                    Enter.theValue(datos.leer("DatosLogin","Data.xlsx",1,0)).into(INP_CORREO),
                    Click.on(INP_CLAVE),
                    Enter.keyValues(datos.leer("DatosLogin","Data.xlsx",1,1)).into(INP_CLAVE),
                    Click.on(BTN_INGRESAR),
                    WaitUntil.the(LBL_NOMBRE_USUARIO, isVisible()).forNoMoreThan(30).seconds()

                    );
            nombreUsuario = LBL_NOMBRE_USUARIO.resolveFor(actor).getText();
            actor.attemptsTo(
                    EscribirEnExcel.on("Data.xlsx","Validaciones", 1, 0,nombreUsuario)

            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


      /*  TouchAction check = new TouchAction(AppiumAndroidDriver.driver);

            int x = 794;
            int y = 1504;
            check.tap(PointOption.point(x, y)).perform();*/


    }

    public static Performable on() {

        return Instrumented.instanceOf(InicioSesionTask.class).withProperties();
    }
}

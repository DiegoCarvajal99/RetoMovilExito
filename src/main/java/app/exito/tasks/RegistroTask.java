package app.exito.tasks;

import app.exito.driver.AppiumAndroidDriver;
import app.exito.utils.Excel;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;


import static app.exito.userInterfaces.RegistroUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistroTask implements Task {

    Excel datos = new Excel();

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!BTN_REGISTRARSE.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    CerrarSesionTask.on()

            );
        }

        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_REGISTRARSE, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_REGISTRARSE),
                    WaitUntil.the(INP_NOMBRE, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(INP_NOMBRE),
                    Enter.theValue(datos.leer("DatosRegistro","Data.xlsx",1,0)).into(INP_NOMBRE),
                    Click.on(INP_APELLIDO),
                    Enter.keyValues(datos.leer("DatosRegistro","Data.xlsx",1,1)).into(INP_APELLIDO),
                    Click.on(INP_NUMERO_DOCUMENTO),
                    Enter.theValue(datos.leer("DatosRegistro","Data.xlsx",1,2)).into(INP_NUMERO_DOCUMENTO),
                    Click.on(INP_ANIO),
                    Click.on(SELECT_ANIO),
                    Click.on(INP_MES),
                    Click.on(SELECT_MES),
                    Click.on(INP_DIA),
                    Click.on(SELECT_DIA),
                    Click.on(INP_CELULAR),
                    Enter.theValue(datos.leer("DatosRegistro","Data.xlsx",1,6)).into(INP_CELULAR),
                    Click.on(LBL_FECHA_NACIMIENTO),
                    Click.on(INP_CORREO),
                    Enter.keyValues(datos.leer("DatosRegistro","Data.xlsx",1,7)).into(INP_CORREO),
                    Click.on(LBL_FECHA_NACIMIENTO)

            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TouchAction check = new TouchAction(AppiumAndroidDriver.driver);

        int x = 90;
        int y = 1650;
        check.tap(PointOption.point(x, y)).perform();

        x = 90;
        y = 1767;
        check.tap(PointOption.point(x, y)).perform();

        actor.attemptsTo(
                Click.on(BTN_CONFIRMAR)
        );
    }

    public static Performable on() {

        return Instrumented.instanceOf(RegistroTask.class).withProperties();
    }
}

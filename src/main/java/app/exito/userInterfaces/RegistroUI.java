package app.exito.userInterfaces;

import app.exito.utils.Excel;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;

public class RegistroUI {

    static Excel datos = new Excel();

    public static final Target BTN_REGISTRARSE = Target.the("REGISTRARSE").located(By.id("com.exito.appcompania:id/AppCompatButton_registrarse"));
    public static final Target INP_NOMBRE = Target.the("NOMBRE").locatedBy("(//*[@class='android.widget.EditText'])[1]");
    public static final Target INP_APELLIDO = Target.the("APELLIDO").locatedBy("(//*[@class='android.widget.EditText'])[2]");
    public static final Target INP_NUMERO_DOCUMENTO = Target.the("NUMERO DOCUMENTO").locatedBy("(//*[@class='android.widget.EditText'])[3]");
    public static final Target INP_ANIO = Target.the("AÑO").locatedBy("//*[@id='text_input_end_icon' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Año']]]]");
    public static final Target INP_MES = Target.the("MES").locatedBy("//*[@id='text_input_end_icon' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Mes']]]]");
    public static final Target INP_NUMERO_MES = Target.the("NUMERO DEL MES").locatedBy("//*[@text='09']");

    public static final Target INP_DIA = Target.the("DIA").locatedBy("//*[@id='text_input_end_icon' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Dia']]]]");
    public static final Target INP_CELULAR = Target.the("CELULAR").located(By.id("com.exito.appcompania:id/TextInputEditText_tel"));
    public static final Target LBL_REGISTRO = Target.the("CORREO").locatedBy("//*[@text='Registro']");

    public static final Target INP_CORREO = Target.the("CORREO").locatedBy("(//*[@class='android.widget.EditText'])[5]");
    public static final Target BTN_CONFIRMAR = Target.the("CONFIRMAR").located(By.id("com.exito.appcompania:id/AppCompatButton_registrar"));
    public static final Target LBL_FECHA_NACIMIENTO = Target.the("REGISTRO").located(By.id("appCompatTextView2"));
    public static final Target LBL_CODIGO_CONFIRMACION = Target.the("TEXTO CODIGO DE CONFIRMACION").located(By.id("AppCompatTextView_bienvenido"));

    public static Target SELECT_ANIO = null;

    public static Target SELECT_MES = null;
    public static Target SELECT_DIA = null;

    static {
        try {
            SELECT_ANIO = Target.the("AÑO").locatedBy("//*[@text='"+datos.leer("DatosRegistro","Data.xlsx",1,3)+"']");
            SELECT_MES = Target.the("MES").locatedBy("//*[@text='"+datos.leer("DatosRegistro","Data.xlsx",1,4)+"']");
            SELECT_DIA = Target.the("DIA").locatedBy("//*[@text='"+datos.leer("DatosRegistro","Data.xlsx",1,5)+"']");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

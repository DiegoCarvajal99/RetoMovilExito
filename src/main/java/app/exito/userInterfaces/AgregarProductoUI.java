package app.exito.userInterfaces;

import app.exito.utils.Excel;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;

public class AgregarProductoUI {

    static Excel datos = new Excel();

    public static final Target BTN_TELEVISORES = Target.the("TELEVISORES").located(By.xpath("//*[@id='imageView_hall' and (./preceding-sibling::* | ./following-sibling::*)[@text='Televisores']]"));
    public static final Target INP_RECOGE = Target.the("RECOGE").located(By.xpath("//*[@id='constraitLayout_buy_and_collect']"));
    public static final Target INP_CIUDAD = Target.the("CIUDAD").located(By.xpath("//*[@text='Seleccione ciudad']"));
    public static final Target INP_NOMBRE_ALMACEN = Target.the("DIRECCION").located(By.xpath("//*[@text='Seleccione almacén']"));
    public static final Target BTN_CONTINUAR = Target.the("AGREGAR").located(By.xpath("//*[@id='appCompatButton_continue']"));
    public static final Target BTN_AGREGAR_PRODUCTO = Target.the("AGREGAR").located(By.xpath("//*[@id='appCompatImageView_item']"));
    public static final Target BTN_AGREGAR_AL_CARRITO = Target.the("AGREGAR AL CARRITO").located(By.xpath("//*[@id='add_to_cart_button']"));
    public static final Target TXT_VALIDAR_PRODUCTO = Target.the("VALIDAR PRODUCTO").located(By.id("appCompatTextView_product_title"));
    public static final Target ICN_CARRITO = Target.the("ICONO CARRITO").located(By.id("appCompatImageView_shopping_cart"));
    public static final Target TXT_CARRITO = Target.the("CARRITO").located(By.id("appCompatTextView_shopping_cart_title"));

    public static Target SELECT_CIUDAD = null;
    public static Target SELECT_NOMBRE_ALMACEN = null;

    static {
        try {
            SELECT_CIUDAD = Target.the("CIUDAD").located(By.xpath("//*[@text='"+datos.leer("DatosCompra","Data.xlsx",1,0)+"']"));
            SELECT_NOMBRE_ALMACEN = Target.the("DEPARTAMENTO").located(By.xpath("//*[@text='"+datos.leer("DatosCompra","Data.xlsx",1,1)+"']"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

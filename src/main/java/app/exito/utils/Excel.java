package app.exito.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Excel {
    private XSSFWorkbook book;
    private FileInputStream file;

    public String leer(String hoja, String ruta, int rowValue, int cellValue) throws IOException {
        String valor;
        file = new FileInputStream(new File(ruta));
        book = new XSSFWorkbook(file);
        Sheet sheet = book.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        valor = cell.getStringCellValue();
        book.close();
        file.close();
        return valor;
    }

}

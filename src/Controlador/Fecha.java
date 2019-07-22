package Controlador;

import interfaces.Main;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Fecha {

    Date date;


    public Date cambiar(String fecha) {

        date = Date.valueOf(fecha);

        return date;
    }
}

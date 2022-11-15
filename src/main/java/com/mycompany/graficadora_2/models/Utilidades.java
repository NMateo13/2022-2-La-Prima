package com.mycompany.graficadora_2.models;

//Importación librerías utilizadas
import com.mycompany.graficadora_2.controllers.GraficadoraController;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Utilidades
{
    //Atributos
    public static int tamLetra = 12;
    public static Color color = Color.BLACK;
    public static Boolean negrita = false;
    public static Boolean subrayado = false;
    public static Boolean cursiva = false;
    public static Boolean puntosDeControl = false;
    public static int[] tamCanvas = new int[2];
    public static String texto = "";
    public static int interlineado = 45;
    public static ArrayList<Abecedario> caracteres = new ArrayList<>();
    public static Double grosorCaracter = 3.5;
    public static int tamCaracter = 0;

    GraficadoraController pizarra = new GraficadoraController();

    //Método encargado de modificar el tamaño de la tipografía.
    //No está del todo funcional. Solo se ocupan los valores por defecto.
    public static void setTamCaracter(int tam)
    {
        switch (tam)
        {
            case 11:
                tamCaracter = 10;
                break;
            case 12:
                tamCaracter = 20;
                break;
            case 13:
                tamCaracter = 30;
                break;
            case 14:
                tamCaracter = 40;
                break;
            case 15:
                tamCaracter = 50;
                break;
            default:
                tamCaracter = 0;
                break;
        }
    }

    public static int[] anchoAltoLetra(String tipo, int tamCaracter)
    {
        int[] anchoAlto = new int[2];

        switch (tipo)
        {
            case "mayuscula":
                anchoAlto[0] = 55+tamCaracter;
                anchoAlto[1] = 65+tamCaracter;
                break;
            case "minuscula":
                anchoAlto[0] = 32+tamCaracter;
                anchoAlto[1] = 65+tamCaracter;
                break;
            default: //simbolo
                anchoAlto[0] = 40+tamCaracter;
                anchoAlto[1] = 65+tamCaracter;
                break;
        }
        return anchoAlto;
    }

    public static void resetearConfig()
    {
        subrayado = false;
        negrita = false;
        cursiva = false;
        tamCaracter=0;
        System.out.println("subrayado en reseteo: " + subrayado);
    }

    //Expresiones regulares utilizadas para validar los caracteres que se ingresan.
    //Método dónde se validan caracteres que se pueden ingresar al programa.
    public static Boolean validacionCaracter(String caracter)
    {
        String expresion = "[A-Za-z\\u00f1\\u00d1]|\\s|\\?|\\¿|\\!|\\¡|\\u002E|\\u002C|\\u003B|\\u003A|\\u2026|\\u201C|\\u201D|\\u0022|\\u2018|\\u2019|\\u0027|\\u00AB|\\u00BB|\\u0028|\\u0029|\\u005B|\\u005D|\\u007B|\\u007D|\\u002D|\\u005F|\\u005E|\\u002B|\\u0030|\\u0031|\\u0032|\\u0033|\\u0034|\\u0035";
        return Pattern.matches(expresion, caracter);
    }

    //Método para limpiar Canvas
    public static void limpiarCanvas(GraphicsContext gc, Canvas canvas)
    {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    //Método que diferencia entre una letra (mayúscula o minúscula) o un símbolo.
    public static String esLetraSimbolo(String caracter)
    {
        String expresion = "[A-Za-z\\u00f1\\u00d1]";
        if (Pattern.matches(expresion, caracter))
        {
            return "letra";
        }
        return "simbolo";
    }

    //Método que valida si el caracter es minúscula o no. (Usos específicos)
    public static String esLetraMinuscula(String caracter)
    {
        String expresion = "[a-z\\u00f1]";
        if (Pattern.matches(expresion, caracter))
        {
            return "minuscula";
        }
        return "mayuscula";
    }

    public static String tipoCaracter(String caracter)
    {
        String expresion1 = "[A-Z\\u00d1]";
        String expresion2 = "[a-z\\u00f1]";
        if (Pattern.matches(expresion1, caracter))
        {
            return "mayuscula";
        }
        if (Pattern.matches(expresion2, caracter))
        {
            return "minuscula";
        }
        return "simbolo";
    }
}

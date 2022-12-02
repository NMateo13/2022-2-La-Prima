package com.mycompany.graficadora_2.models;

//Importación librerías necesarias
import static com.mycompany.graficadora_2.models.Utilidades.color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

//Clase que guarda las coordenadas y cada símbolo solicitado.
//Además, tiene una validación para subrayar las palabras ingresadas.
//Se agregan las codificaciones unicode (JavaScript) de cada símbolo para ser utilizados en 
//la expresión regular (Utilidades).
public class FormulasSimbolos
{
    //U+00BF

    public static void aperturaInterrogacion(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.2500, simbolo.getY() +alto*0.4545, ancho*0.5625, alto*0.4727, 70, 200, ArcType.OPEN);
            gc.strokeLine(simbolo.getX() +ancho*0.6875, simbolo.getY() +alto*0.3090, simbolo.getX() +ancho*0.6250,simbolo.getY() +alto*0.4545);
            gc.strokeArc(simbolo.getX() +ancho*0.7500, simbolo.getY() +alto*0.1272, ancho*0.0625, alto*0.0363, 0, 360, ArcType.CHORD);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.2187, simbolo.getY() + alto * 0.4545, ancho * 0.5625, alto * 0.4727, 80, 200, ArcType.OPEN);
            gc.strokeLine(simbolo.getX() + ancho * 0.5625, simbolo.getY() + alto * 0.3090, simbolo.getX() + ancho * 0.5625, simbolo.getY() + alto * 0.4545);
            gc.strokeArc(simbolo.getX() + ancho * 0.5625, simbolo.getY() + alto * 0.1090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.2187, simbolo.getY() + (alto - 3) * 0.4545, (ancho + 3) * 0.5625, (alto - 3) * 0.4727, 80, 200, ArcType.OPEN);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.5625, simbolo.getY() + (alto - 3) * 0.3090, simbolo.getX() + (ancho + 3) * 0.5625, simbolo.getY() + (alto - 3) * 0.4545);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.5625, simbolo.getY() + (alto - 3) * 0.1090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.5709, simbolo.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.5509, simbolo.getY() + alto * 0.2530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.5509, simbolo.getY() + alto * 0.4230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.5509, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.5625, simbolo.getY() + alto * 0.4727, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+003F
    public static void cierreInterrogacion(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.1562, simbolo.getY() +alto*0.1818, ancho*0.5625, alto*0.4727, -100, 200, ArcType.OPEN);
            gc.strokeLine(simbolo.getX() +ancho*0.3750, simbolo.getY() +alto*0.6727, simbolo.getX() +ancho*0.3437, simbolo.getY() +alto*0.8181);
            gc.strokeArc(simbolo.getX() +ancho*0.2812, simbolo.getY() +alto*0.9090, ancho*0.0625, alto*0.0363, 0, 360, ArcType.CHORD);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.1562, simbolo.getY() + alto * 0.1818, ancho * 0.5625, alto * 0.4727, -80, 200, ArcType.OPEN);
            gc.strokeLine(simbolo.getX() + ancho * 0.4375, simbolo.getY() + alto * 0.6727, simbolo.getX() + ancho * 0.4375, simbolo.getY() + alto * 0.8181);
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.9090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1562, simbolo.getY() + (alto - 3) * 0.1818, (ancho + 3) * 0.5625, (alto - 3) * 0.4727, -80, 200, ArcType.OPEN);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.4375, simbolo.getY() + (alto - 3) * 0.6727, simbolo.getX() + (ancho + 3) * 0.4375, simbolo.getY() + (alto - 3) * 0.8181);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.9090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2509, simbolo.getY() + alto * 0.2030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.6330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.9130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.5625, simbolo.getY() + alto * 0.4727, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+00A1
    public static void aperturaExclamacion(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeLine(simbolo.getX() +ancho*0.5625, simbolo.getY() +alto*0.3636, simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.8181);
            gc.strokeArc(simbolo.getX() +ancho*0.5937, simbolo.getY() +alto*0.1454, ancho*0.0625, alto*0.0363, 0, 360, ArcType.CHORD);
        }else{ //simbolo normal
            gc.strokeLine(simbolo.getX() + ancho * 0.5000, simbolo.getY() + alto * 0.3636, simbolo.getX() + ancho * 0.5000, simbolo.getY() + alto * 0.8181);
            gc.strokeArc(simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.1090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.5000, simbolo.getY() + (alto - 3) * 0.3636, simbolo.getX() + (ancho + 3) * 0.5000, simbolo.getY() + (alto - 3) * 0.8181);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.1090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.3330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.7830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+0021
    public static void cierreExclamacion(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeLine(simbolo.getX() +ancho*0.5625, simbolo.getY() +alto*0.1818, simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.7272);
            gc.strokeArc(simbolo.getX() +ancho*0.3750, simbolo.getY() +alto*0.8727, ancho*0.0625, alto*0.0363, 0, 360, ArcType.CHORD);
        }else{ //simbolo normal
            gc.strokeLine(simbolo.getX() + ancho * 0.5000, simbolo.getY() + alto * 0.1818, simbolo.getX() + ancho * 0.5000, simbolo.getY() + alto * 0.7272);
            gc.strokeArc(simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.9090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.5000, simbolo.getY() + (alto - 3) * 0.1818, simbolo.getX() + (ancho + 3) * 0.5000, simbolo.getY() + (alto - 3) * 0.7272);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.9090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.1530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.7030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }
    //U+002E

    public static void punto(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.8545, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*0.8909, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.9090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.9090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+002C
    public static void coma(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.8545, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*0.8909, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.1250, simbolo.getY() +alto*0.7090, ancho*0.3125, alto*0.3434, -50, 20, ArcType.OPEN);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.8545, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * 0.1562, simbolo.getY() + alto * 0.7090, ancho * 0.3125, alto * 0.3434, -30, 20, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.8545, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1562, simbolo.getY() + (alto - 3) * 0.7090, (ancho + 3) * 0.3125, (alto - 3) * 0.3434, -30, 20, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.8330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.9730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.3434, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+037E
    public static void puntoComa(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.5626, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*0.5937, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*0.8545, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.3750, simbolo.getY() +alto*0.8909, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.7272, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.8545, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * 0.1562, simbolo.getY() + alto * 0.7090, ancho * 0.3125, alto * 0.3434, -30, 20, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.7272, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.8545, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1562, simbolo.getY() + (alto - 3) * 0.7090, (ancho + 3) * 0.3125, (alto - 3) * 0.3434, -30, 20, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.8530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.9730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.3434, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+0589
    public static void dosPuntos(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.5626, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*0.5937, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.3750, simbolo.getY() +alto*0.8545, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.3437, simbolo.getY() +alto*0.8909, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.0625, simbolo.getY() +alto*0.7090, ancho*0.3125, alto*0.3434, -50, 20, ArcType.OPEN);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.7272, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.9090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.7272, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.9090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4209, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+2026
    public static void puntosSuspensivo(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.1250, simbolo.getY() +alto*0.8545, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.0937, simbolo.getY() +alto*0.8909, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.8545, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.8909, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.8125, simbolo.getY() +alto*0.8545, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.7812, simbolo.getY() +alto*0.8909, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.2500, simbolo.getY() + alto * 0.9090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + ancho * 0.4375, simbolo.getY() + alto * 0.9090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.9090, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.2500, simbolo.getY() + (alto - 3) * 0.9090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4375, simbolo.getY() + (alto - 3) * 0.9090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.9090, (ancho + 3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2509, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4409, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6409, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+201C
    public static void aperturaComillaDoble(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.1875, simbolo.getY() +alto*0.0937, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.1562, simbolo.getY() +alto*0.1250, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() +ancho*0.1250, simbolo.getY() +alto*0.0727, ancho*0.3125, alto*0.3076, 160, 20, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.0937, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.1250, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*0.0727, ancho*0.3125, alto*0.3076, 160, 20, ArcType.OPEN);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.1250, simbolo.getY() + alto * 0.0769, ancho * 0.0625, alto * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * 0.1250, simbolo.getY() + alto * -0.0461, ancho * 0.3125, alto * 0.3076, 190, 20, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.0769, ancho * 0.0625, alto * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * -0.0461, ancho * 0.3125, alto * 0.3076, 190, 20, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1250, simbolo.getY() + (alto - 3) * 0.0769, (ancho + 3) * 0.0625, (alto - 3) * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1250, simbolo.getY() + (alto - 3) * -0.0461, (ancho + 3) * 0.3125, (alto - 3) * 0.3076, 190, 20, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.0769, (ancho + 3) * 0.0625, (alto - 3) * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * -0.0461, (ancho + 3) * 0.3125, (alto - 3) * 0.3076, 190, 20, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.1409, simbolo.getY() + alto * 0.0530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.1409, simbolo.getY() + alto * 0.1730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3309, simbolo.getY() + alto * 0.0530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3309, simbolo.getY() + alto * 0.1730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0307, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+201D
    public static void cierreComillaDoble(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){ //simbolo cursivo
            gc.strokeArc(simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.0937, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.1250, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() +ancho*0.2500, simbolo.getY() +alto*-0.0312, ancho*0.3125, alto*0.3076, -40, 30, ArcType.OPEN);      
            gc.strokeArc(simbolo.getX() +ancho*0.7500, simbolo.getY() +alto*0.0937, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.7187, simbolo.getY() +alto*0.1250, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() +ancho*0.5625, simbolo.getY() +alto*-0.0312, ancho*0.3125, alto*0.3076, -40, 30, ArcType.OPEN);
        }else{ //simbolo normal
            gc.strokeArc(simbolo.getX() + ancho * 0.1250, simbolo.getY() + alto * 0.0769, ancho * 0.0625, alto * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * -0.0937, simbolo.getY() + alto * -0.0461, ancho * 0.3125, alto * 0.3076, -30, 20, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3437, simbolo.getY() + alto * 0.0769, ancho * 0.0625, alto * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * 0.1250, simbolo.getY() + alto * -0.0461, ancho * 0.3125, alto * 0.3076, -30, 20, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1250, simbolo.getY() + (alto - 3) * 0.0769, (ancho + 3) * 0.0625, (alto - 3) * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * -0.0937, simbolo.getY() + (alto - 3) * -0.0461, (ancho + 3) * 0.3125, (alto - 3) * 0.3076, -30, 20, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.3437, simbolo.getY() + (alto - 3) * 0.0769, (ancho + 3) * 0.0625, (alto - 3) * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1250, simbolo.getY() + (alto - 3) * -0.0461, (ancho + 3) * 0.3125, (alto - 3) * 0.3076, -30, 20, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.1409, simbolo.getY() + alto * 0.0530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.1409, simbolo.getY() + alto * 0.1730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3309, simbolo.getY() + alto * 0.0530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3709, simbolo.getY() + alto * 0.1730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0307, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+0022
    public static void comillaDoble(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        gc.strokeLine(simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.1272, simbolo.getX() + ancho * 0.7812, simbolo.getY() + alto * 0.0545);
        gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.1272, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.0545);
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.1272, simbolo.getX() + (ancho + 3) * 0.7812, simbolo.getY() + (alto - 3) * 0.0545);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.1272, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.0545);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2609, simbolo.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4709, simbolo.getY() + alto * 0.0330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6209, simbolo.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.7809, simbolo.getY() + alto * 0.0330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+2018
    public static void aperturaComillaSimple(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeArc(simbolo.getX() +ancho*0.1875, simbolo.getY() +alto*0.0937, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.1562, simbolo.getY() +alto*0.1250, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() +ancho*0.1250, simbolo.getY() +alto*0.0727, ancho*0.3125, alto*0.3076, 160, 20, ArcType.OPEN);
        }else{
            gc.strokeArc(simbolo.getX() + ancho * 0.4025, simbolo.getY() + alto * 0.0769, ancho * 0.0625, alto * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * 0.4025, simbolo.getY() + alto * -0.0461, ancho * 0.3125, alto * 0.3076, 190, 20, ArcType.OPEN);
        }

        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4025, simbolo.getY() + (alto - 3) * 0.0769, (ancho + 3) * 0.0625, (alto - 3) * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4025, simbolo.getY() + (alto - 3) * -0.0461, (ancho + 3) * 0.3125, (alto - 3) * 0.3076, 190, 20, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4109, simbolo.getY() + alto * 0.0730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4109, simbolo.getY() + alto * 0.1730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0307, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+2019
    public static void cierreComillaSimple(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeArc(simbolo.getX() +ancho*0.7500, simbolo.getY() +alto*0.0937, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.7500, simbolo.getY() +alto*0.0937, ancho*0.0937, alto*0.0545, 0, 180, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.7187, simbolo.getY() +alto*0.1250, ancho*0.0937, alto*0.0545, 180, 180, ArcType.OPEN);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() +ancho*0.5625, simbolo.getY() +alto*0, ancho*0.3125, alto*0.3076, -30, 20, ArcType.OPEN);
        }else{
            gc.strokeArc(simbolo.getX() + ancho * 0.1250, simbolo.getY() + alto * 0.0769, ancho * 0.0625, alto * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + ancho * -0.0937, simbolo.getY() + alto * -0.0461, ancho * 0.3125, alto * 0.3076, -30, 20, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1250, simbolo.getY() + (alto - 3) * 0.0769, (ancho + 3) * 0.0625, (alto - 3) * 0.0307, 0, 360, ArcType.CHORD);
            gc.setLineWidth(3);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * -0.0937, simbolo.getY() + (alto - 3) * -0.0461, (ancho + 3) * 0.3125, (alto - 3) * 0.3076, -30, 20, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.1509, simbolo.getY() + alto * 0.0730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.1909, simbolo.getY() + alto * 0.1730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0625, simbolo.getY() + alto * 0.0307, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+0027
    public static void comillaSimple(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        gc.strokeLine(simbolo.getX() + ancho * 0.4375, simbolo.getY() + alto * 0.1272, simbolo.getX() + ancho * 0.5937, simbolo.getY() + alto * 0.0545);
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.4375, simbolo.getY() + (alto - 3) * 0.1272, simbolo.getX() + (ancho + 3) * 0.5937, simbolo.getY() + (alto - 3) * 0.0545);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4009, simbolo.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.5809, simbolo.getY() + alto * 0.0330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+00AB
    public static void aperturaComillaEspanola(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.setLineWidth(3);
            gc.strokeLine(simbolo.getX() +ancho*0.6250, simbolo.getY() +alto*0.6545, simbolo.getX() +ancho*0.7812, simbolo.getY() +alto*0.6363);
            gc.strokeLine(simbolo.getX() +ancho*0.6250, simbolo.getY() +alto*0.6909, simbolo.getX() +ancho*0.7500, simbolo.getY() +alto*0.7272);
            gc.strokeLine(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.6545, simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.6363);
            gc.strokeLine(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.6727, simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.7272);
        }else{
            gc.setLineWidth(3);
            gc.strokeLine(simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.6727, simbolo.getX() + ancho * 0.7812, simbolo.getY() + alto * 0.6363);
            gc.strokeLine(simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.6909, simbolo.getX() + ancho * 0.7812, simbolo.getY() + alto * 0.7272);
            gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.6727, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.6363);
            gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.6727, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.7272);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.setLineWidth(3);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.6727, simbolo.getX() + (ancho + 3) * 0.7812, simbolo.getY() + (alto - 3) * 0.6363);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.6909, simbolo.getX() + (ancho + 3) * 0.7812, simbolo.getY() + (alto - 3) * 0.7272);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.6727, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.6363);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.6727, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.7272);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4409, simbolo.getY() + alto * 0.5830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.2909, simbolo.getY() + alto * 0.6430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4409, simbolo.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.7709, simbolo.getY() + alto * 0.5830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6009, simbolo.getY() + alto * 0.6430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.7709, simbolo.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+00BB   
    public static void cierreComillaEspanola(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.setLineWidth(3);
            gc.strokeLine(simbolo.getX() +ancho*0.6250, simbolo.getY() +alto*0.6363, simbolo.getX() +ancho*0.7812, simbolo.getY() +alto*0.7272);
            gc.strokeLine(simbolo.getX() +ancho*0.6250, simbolo.getY() +alto*0.7454, simbolo.getX() +ancho*0.7812, simbolo.getY() +alto*0.7272);
            gc.strokeLine(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.6363, simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.7272);
            gc.strokeLine(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.7454, simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.7272);
        }else{
            gc.setLineWidth(3);
            gc.strokeLine(simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.6363, simbolo.getX() + ancho * 0.7812, simbolo.getY() + alto * 0.6727);
            gc.strokeLine(simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.7272, simbolo.getX() + ancho * 0.7812, simbolo.getY() + alto * 0.6727);
            gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.6363, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.6727);
            gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.7272, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.6727);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.setLineWidth(3);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.6363, simbolo.getX() + (ancho + 3) * 0.7812, simbolo.getY() + (alto - 3) * 0.6727);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.7272, simbolo.getX() + (ancho + 3) * 0.7812, simbolo.getY() + (alto - 3) * 0.6727);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.6363, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.6727);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.7272, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.6727);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2909, simbolo.getY() + alto * 0.5830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4409, simbolo.getY() + alto * 0.6430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.2909, simbolo.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6009, simbolo.getY() + alto * 0.5830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.7709, simbolo.getY() + alto * 0.6430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6009, simbolo.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+0028  
    public static void aperturaParentesis(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeArc(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.1636, ancho*0.4062, alto*0.8181, 80, 90, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.2812, simbolo.getY() +alto*0.1636, ancho*0.4062, alto*0.8181, 170, 90, ArcType.OPEN);
        }else{
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.1636, ancho * 0.4062, alto * 0.8181, 90, 180, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.1636, (ancho + 3) * 0.4062, (alto - 3) * 0.8181, 90, 180, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4909, simbolo.getY() + alto * 0.1330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4909, simbolo.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.8181, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+0029
    public static void cierreParentesis(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeArc(simbolo.getX() +ancho*0.1250, simbolo.getY() +alto*0.1636, ancho*0.4062, alto*0.8181, -100, 90, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.1562, simbolo.getY() +alto*0.1636, ancho*0.4062, alto*0.8181, -10, 90, ArcType.OPEN);
        }else{
            gc.strokeArc(simbolo.getX() + ancho * 0.1250, simbolo.getY() + alto * 0.1636, ancho * 0.4062, alto * 0.8181, -90, 180, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.1250, simbolo.getY() + (alto - 3) * 0.1636, (ancho + 3) * 0.4062, (alto - 3) * 0.8181, -90, 180, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2909, simbolo.getY() + alto * 0.1330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.2909, simbolo.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.8181, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+005B     
    public static void aperturaCorchete(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeLine(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*0.1818, simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.9818);
            gc.strokeLine(simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.1818, simbolo.getX() +ancho*0.6250, simbolo.getY() +alto*0.2000);
            gc.strokeLine(simbolo.getX() +ancho*0.4062, simbolo.getY() +alto*1, simbolo.getX() +ancho*0.5937, simbolo.getY() +alto*1.0181);
        }else{
            gc.strokeLine(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.1818, simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 1.0000);
            gc.strokeLine(simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.1818, simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.1818);
            gc.strokeLine(simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 1.0000, simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 1.0000);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 0.1818, simbolo.getX() + (ancho + 3) * 0.4062, simbolo.getY() + (alto - 3) * 1.0000);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.1818, simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.1818);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 1.0000, simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 1.0000);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.6309, simbolo.getY() + alto * 0.1530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3809, simbolo.getY() + alto * 0.1530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3809, simbolo.getY() + alto * 0.9830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6309, simbolo.getY() + alto * 0.9830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+005D
    public static void cierreCorchete(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeLine(simbolo.getX() +ancho*0.5625, simbolo.getY() +alto*0.1818, simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.9818);
            gc.strokeLine(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.1454, simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.1636);
            gc.strokeLine(simbolo.getX() +ancho*0.2500, simbolo.getY() +alto*0.9636, simbolo.getX() +ancho*0.4687, simbolo.getY() +alto*0.9818);
        }else{
            gc.strokeLine(simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.1818, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 1.0000);
            gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.1818, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.1818);
            gc.strokeLine(simbolo.getX() + ancho * 0.2500, simbolo.getY() + alto * 1.0000, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 1.0000);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.1818, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 1.0000);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.1818, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.1818);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.2500, simbolo.getY() + (alto - 3) * 1.0000, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 1.0000);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.4709, simbolo.getY() + alto * 0.1530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.2709, simbolo.getY() + alto * 0.1530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.2209, simbolo.getY() + alto * 0.9830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4709, simbolo.getY() + alto * 0.9830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+007B
    public static void aperturaLlave(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeArc(simbolo.getX() +ancho*0.3750, simbolo.getY() +alto*0.1636, ancho*0.4062, alto*0.6363, 80, 85, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.0625, simbolo.getY() +alto*-0.0545, ancho*0.3125, alto*0.5454, 270, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.0312, simbolo.getY() +alto*0.5272, ancho*0.3125, alto*0.5454, 50, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.3272, ancho*0.4062, alto*0.6363, 170, 95, ArcType.OPEN);
        }else{
            gc.strokeArc(simbolo.getX() + ancho * 0.3750, simbolo.getY() + alto * 0.1636, ancho * 0.4062, alto * 0.6363, 90, 85, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0937, simbolo.getY() + alto * 0.0000, ancho * 0.3125, alto * 0.5454, 270, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0937, simbolo.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.5454, 50, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3750, simbolo.getY() + alto * 0.2909, ancho * 0.4062, alto * 0.6363, 180, 85, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.3750, simbolo.getY() + (alto - 3) * 0.1636, (ancho + 3) * 0.4062, (alto - 3) * 0.6363, 90, 85, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.0937, simbolo.getY() + (alto - 3) * 0.0000, (ancho + 3) * 0.3125, (alto - 3) * 0.5454, 270, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.0937, simbolo.getY() + (alto - 3) * 0.5454, (ancho + 3) * 0.3125, (alto - 3) * 0.5454, 50, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.3750, simbolo.getY() + (alto - 3) * 0.2909, (ancho + 3) * 0.4062, (alto - 3) * 0.6363, 180, 85, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.5609, simbolo.getY() + alto * 0.1430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3609, simbolo.getY() + alto * 0.4430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.2409, simbolo.getY() + alto * 0.5330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3609, simbolo.getY() + alto * 0.5930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.5609, simbolo.getY() + alto * 0.8930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.6363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+007D
    public static void cierreLlave(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeArc(simbolo.getX() +ancho*0.1250, simbolo.getY() +alto*0.1636, ancho*0.4062, alto*0.6363, 0, 75, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*-0.0181, ancho*0.3125, alto*0.5454, 230, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.4375, simbolo.getY() +alto*0.5454, ancho*0.3125, alto*0.5454, 90, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() +ancho*0.0312, simbolo.getY() +alto*0.3090, ancho*0.4062, alto*0.6363, 270, 90, ArcType.OPEN);
        }else{
            gc.strokeArc(simbolo.getX() + ancho * 0.0937, simbolo.getY() + alto * 0.1636, ancho * 0.4062, alto * 0.6363, 10, 75, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * -0.0181, ancho * 0.3125, alto * 0.5454, 230, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.5454, 90, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.0937, simbolo.getY() + alto * 0.3090, ancho * 0.4062, alto * 0.6363, 270, 90, ArcType.OPEN);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.0937, simbolo.getY() + (alto - 3) * 0.1636, (ancho + 3) * 0.4062, (alto - 3) * 0.6363, 10, 75, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * -0.0181, (ancho + 3) * 0.3125, (alto - 3) * 0.5454, 230, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.5454, (ancho + 3) * 0.3125, (alto - 3) * 0.5454, 90, 35, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + (ancho + 3) * 0.0937, simbolo.getY() + (alto - 3) * 0.3090, (ancho + 3) * 0.4062, (alto - 3) * 0.6363, 270, 90, ArcType.OPEN);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2609, simbolo.getY() + alto * 0.1430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.4430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6709, simbolo.getY() + alto * 0.5330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4809, simbolo.getY() + alto * 0.5930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.2609, simbolo.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4062, simbolo.getY() + alto * 0.6363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+2010
    public static void guion(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeLine(simbolo.getX() +ancho*0.3125, simbolo.getY() +alto*0.9272, simbolo.getX() +ancho*0.6875, simbolo.getY() +alto*0.9636);
        }else{
            gc.strokeLine(simbolo.getX() + ancho * 0.3750, simbolo.getY() + alto * 0.6363, simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.6363);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3750, simbolo.getY() + (alto - 3) * 0.6363, simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.6363);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.3509, simbolo.getY() + alto * 0.6230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6009, simbolo.getY() + alto * 0.6230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    //U+005F
    public static void guionBajo(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getCursiva()){
            gc.strokeLine(simbolo.getX() +ancho*0.3750, simbolo.getY() +alto*0.6000, simbolo.getX() +ancho*0.6250, simbolo.getY() +alto*0.6363);
        }else{
            gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.9636, simbolo.getX() + ancho * 0.6875, simbolo.getY() + alto * 0.9636);
        }
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.9636, simbolo.getX() + (ancho + 3) * 0.6875, simbolo.getY() + (alto - 3) * 0.9636);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2809, simbolo.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6709, simbolo.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    public static void espacio(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.6909, simbolo.getY() + alto * 0.2730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    public static void acentoCircunflejo(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        gc.strokeLine(simbolo.getX() + ancho * 0.3125, simbolo.getY() + alto * 0.1076, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.0461);
        gc.strokeLine(simbolo.getX() + ancho * 0.6250, simbolo.getY() + alto * 0.1076, simbolo.getX() + ancho * 0.4687, simbolo.getY() + alto * 0.0461);
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3125, simbolo.getY() + (alto - 3) * 0.1076, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.0461);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.6250, simbolo.getY() + (alto - 3) * 0.1076, simbolo.getX() + (ancho + 3) * 0.4687, simbolo.getY() + (alto - 3) * 0.0461);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2809, simbolo.getY() + alto * 0.0930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4309, simbolo.getY() + alto * 0.0230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6009, simbolo.getY() + alto * 0.0930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }

    public static void signoMas(GraphicsContext gc, Abecedario simbolo)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(simbolo.getCaracter()), simbolo.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        gc.strokeLine(simbolo.getX() + ancho * 0.3050, simbolo.getY() + alto * 0.6363, simbolo.getX() + ancho * 0.6550, simbolo.getY() + alto * 0.6363);
        gc.strokeLine(simbolo.getX() + ancho * 0.4750, simbolo.getY() + alto * 0.4763, simbolo.getX() + ancho * 0.4750, simbolo.getY() + alto * 0.7863);
        if (simbolo.getSubrayar())
        {
            gc.strokeLine(simbolo.getX(), simbolo.getY() + alto, simbolo.getX() + ancho, simbolo.getY() + alto);
        }
        if (simbolo.getNegrita())
        {
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.3050, simbolo.getY() + (alto - 3) * 0.6363, simbolo.getX() + (ancho + 3) * 0.6550, simbolo.getY() + (alto - 3) * 0.6363);
            gc.strokeLine(simbolo.getX() + (ancho + 3) * 0.4750, simbolo.getY() + (alto - 3) * 0.4763, simbolo.getX() + (ancho + 3) * 0.4750, simbolo.getY() + (alto - 3) * 0.7863);
        }
        if (Utilidades.puntosDeControl)
        {
            gc.setStroke(color.RED);
            gc.strokeArc(simbolo.getX() + ancho * 0.2550, simbolo.getY() + alto * 0.6150, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.6609, simbolo.getY() + alto * 0.6150, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4509, simbolo.getY() + alto * 0.4450, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.strokeArc(simbolo.getX() + ancho * 0.4509, simbolo.getY() + alto * 0.7950, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
            gc.setStroke(Utilidades.color);
        }
    }
    
    
    

}

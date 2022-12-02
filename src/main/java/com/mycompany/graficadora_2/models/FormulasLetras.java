package com.mycompany.graficadora_2.models;

import static com.mycompany.graficadora_2.models.Utilidades.color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

//Clase que guarda las coordenadas y cada letra del abecedario (mayúsculas y minúsculas).
//Además, tiene una validación para subrayar las palabras ingresadas.
public class FormulasLetras
{

    public static void a(GraphicsContext gc, Abecedario letra)
    {
        System.out.println("tamLetraGuardada: " + letra.getTam()); //print de prueba
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        System.out.println("ancho: " + ancho + " alto: " + alto); //print de prueba
        if (letra.getCaracter().equals("A"))
        {//A Mayuscula
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.1230, ancho * 0.7090, alto * 0.8461, 40, 260, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.2461, letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.8769);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6545, letra.getY() + alto * 0.4307, ancho * 0.3090, alto * 0.5384, 180, 110, ArcType.OPEN);//Arcos
                gc.strokeLine(letra.getX() +ancho*0.9090, letra.getY() +alto*0.9272, letra.getX() +ancho*1, letra.getY() +alto*0.8000);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.1230, ancho * 0.7090, alto * 0.8461, 40, 280, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.2461, letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.8461);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.4307, ancho * 0.2727, alto * 0.5384, 180, 170, ArcType.OPEN);//Arcos 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
                gc.strokeArc(letra.getX() + (ancho + 3) * 0.0727, letra.getY() + (alto - 3) * 0.1230, (ancho + 3) * 0.7090, (alto - 3) * 0.8461, 40, 280, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + (ancho + 3) * 0.6909, letra.getY() + (alto - 3) * 0.2461, letra.getX() + (ancho + 3) * 0.7090, letra.getY() + (alto - 3) * 0.8461);//Línea
                gc.strokeArc(letra.getX() + (ancho + 3) * 0.7090, letra.getY() + (alto - 3) * 0.4307, (ancho + 3) * 0.2727, (alto - 3) * 0.5384, 180, 170, ArcType.OPEN);//Arcos
            }//AGREGAR ESTE ULTIMO IF A TODAS LAS LETRAS Y SIMBOLOS PARA QUE SE APLIQUEN NEGRITA A TODO

            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.2730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);//ESTAS DOS LINEAS REPRESENTAN DOS PUNTOS DE CONTROL FIJO NO ES NECESARIO HACER UN PUNTO DE CONTROL PARA LA LINEA QUE HAY EN MEDIO ES INNECESARIA
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.8030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9709, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.8461, ancho * 0.0400, alto * 0.0400, 360, 360, ArcType.CHORD);
                gc.strokeArc(letra.getX() + ancho * 0.4307, letra.getY() + alto * 0.2727, ancho * 0.0400, alto * 0.0400, 180, 155, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, -30, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0781, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 140, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.6875, letra.getY() +alto*0.6000, ancho*0.2812, alto*0.3636, 200, 130, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.6000, ancho * 0.6875, alto * 0.3636, 360, 360, ArcType.CHORD);
                gc.strokeArc(letra.getX() + ancho * 0.7968, letra.getY() + alto * 0.6000, ancho * 0.2500, alto * 0.3636, 180, 155, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0937, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.6875, (alto - 3) * 0.3636, 360, 360, ArcType.CHORD);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7968, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.2500, (alto - 3) * 0.3636, 180, 155, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.7709, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0099, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.6875, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.2500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    
    /*public static void atildes(GraphicsContext gc, Abecedario letra) //PROBANDO CODIGO
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("Á"))
        {//A Mayuscula

        }
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.1230, ancho * 0.7090, alto * 0.8461, 40, 260, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.2461, letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.8769);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6545, letra.getY() + alto * 0.4307, ancho * 0.3090, alto * 0.5384, 180, 110, ArcType.OPEN);//Arcos
                gc.strokeLine(letra.getX() +ancho*0.9090, letra.getY() +alto*0.9272, letra.getX() +ancho*1, letra.getY() +alto*0.8000);
            }else{ //letra normal
                gc.strokeLine(24, 4, 29, 0);
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.1230, ancho * 0.7090, alto * 0.8461, 40, 280, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.2461, letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.8461);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.4307, ancho * 0.2727, alto * 0.5384, 180, 170, ArcType.OPEN);//Arcos 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
                gc.strokeArc(letra.getX() + (ancho + 3) * 0.0727, letra.getY() + (alto - 3) * 0.1230, (ancho + 3) * 0.7090, (alto - 3) * 0.8461, 40, 280, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + (ancho + 3) * 0.6909, letra.getY() + (alto - 3) * 0.2461, letra.getX() + (ancho + 3) * 0.7090, letra.getY() + (alto - 3) * 0.8461);//Línea
                gc.strokeArc(letra.getX() + (ancho + 3) * 0.7090, letra.getY() + (alto - 3) * 0.4307, (ancho + 3) * 0.2727, (alto - 3) * 0.5384, 180, 170, ArcType.OPEN);//Arcos
            }//AGREGAR ESTE ULTIMO IF A TODAS LAS LETRAS Y SIMBOLOS PARA QUE SE APLIQUEN NEGRITA A TODO

            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.2730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);//ESTAS DOS LINEAS REPRESENTAN DOS PUNTOS DE CONTROL FIJO NO ES NECESARIO HACER UN PUNTO DE CONTROL PARA LA LINEA QUE HAY EN MEDIO ES INNECESARIA
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.8030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9709, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.8461, ancho * 0.0400, alto * 0.0400, 360, 360, ArcType.CHORD);
                gc.strokeArc(letra.getX() + ancho * 0.4307, letra.getY() + alto * 0.2727, ancho * 0.0400, alto * 0.0400, 180, 155, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, -30, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0781, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 140, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.6875, letra.getY() +alto*0.6000, ancho*0.2812, alto*0.3636, 200, 130, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.6000, ancho * 0.6875, alto * 0.3636, 360, 360, ArcType.CHORD);
                gc.strokeArc(letra.getX() + ancho * 0.7968, letra.getY() + alto * 0.6000, ancho * 0.2500, alto * 0.3636, 180, 155, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0937, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.6875, (alto - 3) * 0.3636, 360, 360, ArcType.CHORD);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7968, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.2500, (alto - 3) * 0.3636, 180, 155, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.7709, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0099, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.6875, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.2500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    public static void b(GraphicsContext gc, Abecedario letra)
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("B"))
        {   
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.1538, ancho * 0.2727, alto * 0.7692, 85, 260, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.1384, ancho * 0.6181, alto * 0.3692, 270, 210, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.4923, ancho * 0.6363, alto * 0.4153, 245, 200, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.4923, ancho * 0.7272, alto * 0.4615, 235, 70, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.7818, letra.getY() +alto*0.9272, letra.getX() +ancho*1, letra.getY() +alto*0.8000);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1538, ancho * 0.2727, alto * 0.7692, 100, 280, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1076, ancho * 0.6363, alto * 0.3692, 280, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.4615, ancho * 0.6363, alto * 0.4153, 245, 200, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.4615, ancho * 0.7272, alto * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1538, (ancho+3) * 0.2727, (alto - 3) * 0.7692, 100, 280, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.6363, (alto - 3) * 0.3692, 280, 220, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1272, letra.getY() + (alto - 3) * 0.4615, (ancho+3) * 0.6363, (alto - 3) * 0.4153, 245, 200, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2181, letra.getY() + (alto - 3) * 0.4615, (ancho+3) * 0.7272, (alto - 3) * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.3309, letra.getY() + alto * 0.4030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 0.4530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3209, letra.getY() + alto * 0.8530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9259, letra.getY() + alto * 0.6930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.3692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.4153, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() +ancho*0.0625, letra.getY() +alto*0.7818, letra.getX() +ancho*0.3437, letra.getY() +alto*0.4545);
                gc.strokeArc(letra.getX() +ancho*-0.1875, letra.getY() +alto*0, ancho*0.6250, alto*0.5818, -50, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.2187, letra.getY() +alto*0.1090, ancho*0.6250, alto*0.5818, 120, 55, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.2187, letra.getY() +alto*0.3636, letra.getX() +ancho*0.1250, letra.getY() +alto*0.8181);
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.6000, ancho*0.4062, alto*0.3636, 170, 175, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.4687, letra.getY() +alto*0.4909, ancho*0.6562, alto*0.3636, 215, 75, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeLine(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.2815, letra.getY() + alto * 0.4545);
                gc.strokeArc(letra.getX() + ancho * -0.2812, letra.getY() + alto * 0, ancho * 0.6250, alto * 0.5818, -30, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.1090, ancho * 0.6250, alto * 0.5818, 120, 55, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.3636, letra.getX() + ancho * 0.1875, letra.getY() + alto * 0.8181);
                gc.strokeArc(letra.getX() + ancho * 0.1571, letra.getY() + alto * 0.6000, ancho * 0.4062, alto * 0.3636, 180, 165, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.4909, ancho * 0.6562, alto * 0.3636, 225, 75, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeLine(letra.getX() + (ancho+3) * 0.0625, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.2815, letra.getY() + (alto - 3) * 0.4545);
            gc.strokeArc(letra.getX() + (ancho+3) * -0.2812, letra.getY() + (alto - 3) * 0, (ancho+3) * 0.6250, (alto - 3) * 0.5818, -30, 70, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0937, letra.getY() + (alto - 3) * 0.1090, (ancho+3) * 0.6250, (alto - 3) * 0.5818, 120, 55, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.0937, letra.getY() + (alto - 3) * 0.3636, letra.getX() + (ancho+3) * 0.1875, letra.getY() + (alto - 3) * 0.8181);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1571, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.4062, (alto - 3) * 0.3636, 180, 165, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.4909, (ancho+3) * 0.6562, (alto - 3) * 0.3636, 225, 75, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0359, letra.getY() + alto * 0.7030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2759, letra.getY() + alto * 0.4130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2559, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0559, letra.getY() + alto * 0.3730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1659, letra.getY() + alto * 0.8030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5359, letra.getY() + alto * 0.8030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9559, letra.getY() + alto * 0.8030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.5818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.5818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4062, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void c(GraphicsContext gc, Abecedario letra)
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("C"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, 10, 180, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1230, ancho * 0.8181, alto * 0.8461, 190, 110, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.6909, letra.getY() +alto*0.9272, letra.getX() +ancho*1, letra.getY() +alto*0.8000);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, 20, 180, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1230, ancho * 0.8181, alto * 0.8461, 200, 150, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1230, (ancho+3) * 0.6363, (alto - 3) * 0.8461, 20, 180, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1230, (ancho+3) * 0.8181, (alto - 3) * 0.8461, 200, 150, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0859, letra.getY() + alto * 0.6630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6859, letra.getY() + alto * 0.3830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8759, letra.getY() + alto * 0.6030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.8461, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8181, letra.getY() + alto * 0.8461, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if(letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 40, 90, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0781, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 140, 155, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*-0.5625, letra.getY() +alto*0.6000, ancho*1.5625, alto*0.3636, 300, 52, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.6000, ancho * 0.6250, alto * 0.3636, 45, 260, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * -0.5000, letra.getY() + alto * 0.5818, ancho * 1.5625, alto * 0.3636, 300, 52, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0937, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.6250, (alto - 3) * 0.3636, 45, 260, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * -0.5000, letra.getY() + (alto - 3) * 0.5818, (ancho+3) * 1.5625, (alto - 3) * 0.3636, 300, 52, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.6159, letra.getY() + alto * 0.6430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6059, letra.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0359, letra.getY() + alto * 0.7630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.5625, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void d(GraphicsContext gc, Abecedario letra)
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("D"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.1538, ancho * 0.6909, alto * 0.7692, 245, 170, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.5230, ancho * 0.7272, alto * 0.4615, 235, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.1538, ancho * 0.6909, alto * 0.7692, 420, 100, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.2153, ancho * 0.6363, alto * 0.4923, 490, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.4615, letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.9230);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0545, letra.getY() + alto * 0.8000, ancho * 0.2181, alto * 0.1846, 0, 360, ArcType.OPEN);//Arco  
                gc.strokeLine(letra.getX() +ancho*0.7090, letra.getY() +alto*0.9272, letra.getX() +ancho*1, letra.getY() +alto*0.8000);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.2307, ancho * 0.6363, alto * 0.4923, 490, 100, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.1538, ancho * 0.6909, alto * 0.7692, 440, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.4615, letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.9230);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.1538, ancho * 0.6909, alto * 0.7692, 245, 200, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.4923, ancho * 0.7272, alto * 0.4615, 235, 120, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0545, letra.getY() + alto * 0.8000, ancho * 0.2181, alto * 0.1846, 0, 360, ArcType.OPEN);//Arco 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1090, letra.getY() + (alto - 3) * 0.2307, (ancho+3) * 0.6363, (alto - 3) * 0.4923, 490, 100, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1272, letra.getY() + (alto - 3) * 0.1538, (ancho+3) * 0.6909, (alto - 3) * 0.7692, 440, 100, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2727, letra.getY() + (alto - 3) * 0.4615, letra.getX() + (ancho+3) * 0.2727, letra.getY() + (alto - 3) * 0.9230);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1272, letra.getY() + (alto - 3) * 0.1538, (ancho+3) * 0.6909, (alto - 3) * 0.7692, 245, 200, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2181, letra.getY() + (alto - 3) * 0.4923, (ancho+3) * 0.7272, (alto - 3) * 0.4615, 235, 120, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0545, letra.getY() + (alto - 3) * 0.8000, (ancho+3) * 0.2181, (alto - 3) * 0.1846, 0, 360, ArcType.OPEN);//Arco  
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.2259, letra.getY() + alto * 0.6530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2059, letra.getY() + alto * 0.2730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0959, letra.getY() + alto * 0.5230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5079, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2459, letra.getY() + alto * 0.4530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2459, letra.getY() + alto * 0.8930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2659, letra.getY() + alto * 0.8230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9159, letra.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.4923, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.1846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, -30, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0781, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 140, 180, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.8125, letra.getY() +alto*0.1818, letra.getX() +ancho*0.7500, letra.getY() +alto*0.9090);
                gc.strokeArc(letra.getX() +ancho*0.7187, letra.getY() +alto*0.6000, ancho*0.3437, alto*0.3636, 180, 160, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.6000, ancho * 0.6250, alto * 0.3636, 360, 360, ArcType.CHORD);
                gc.strokeLine(letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.1818, letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.9090);
                gc.strokeArc(letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.6000, ancho * 0.3750, alto * 0.3636, 180, 155, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0937, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.6250, (alto - 3) * 0.3636, 360, 360, ArcType.CHORD);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.1818, letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.9090);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.3750, (alto - 3) * 0.3636, 180, 155, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.6959, letra.getY() + alto * 0.1530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6959, letra.getY() + alto * 0.8930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0759, letra.getY() + alto * 0.8130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);

                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void e(GraphicsContext gc, Abecedario letra)
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("E"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.0923, ancho * 0.4909, alto * 0.4615, 10, 200, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.4769, letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.5076);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0363, letra.getY() + alto * 0.4769, ancho * 0.8181, alto * 0.4769, 110, 190, ArcType.OPEN);//Arco 
                gc.strokeLine(letra.getX() +ancho*0.6545, letra.getY() +alto*0.9272, letra.getX() +ancho*1, letra.getY() +alto*0.8000);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.0769, ancho * 0.4909, alto * 0.4615, 10, 220, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.5076, letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.5076);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0363, letra.getY() + alto * 0.4307, ancho * 0.8181, alto * 0.5384, 130, 200, ArcType.OPEN);//Arco 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0727, letra.getY() + (alto - 3) * 0.0769, (ancho+3) * 0.4909, (alto - 3) * 0.4615, 10, 220, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.1272, letra.getY() + (alto - 3) * 0.5076, letra.getX() + (ancho+3) * 0.3636, letra.getY() + (alto - 3) * 0.5076);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0363, letra.getY() + (alto - 3) * 0.4307, (ancho+3) * 0.8181, (alto - 3) * 0.5384, 130, 200, ArcType.OPEN);//Arco 
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.5559, letra.getY() + alto * 0.2430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1159, letra.getY() + alto * 0.4730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3659, letra.getY() + alto * 0.4730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7700, letra.getY() + alto * 0.8200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4909, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8181, letra.getY() + alto * 0.5384, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() +ancho*0.0625, letra.getY() +alto*0.7818, letra.getX() +ancho*0.3750, letra.getY() +alto*0.6363);
                gc.strokeArc(letra.getX() +ancho*-0.0625, letra.getY() +alto*0.0909, ancho*0.6250, alto*0.5818, -60, 30, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3750, letra.getY() +alto*0.4000, ancho*0.1562, alto*0.1818, 0, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*0.4000, ancho*0.1562, alto*0.1818, 90, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3125, letra.getY() +alto*0.2000, ancho*0.4687, alto*0.7636, 165, 115, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.6562, letra.getY() +alto*0.9272, letra.getX() +ancho*0.9375, letra.getY() +alto*0.7818);
            }else{ //letra normal
                gc.strokeLine(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.7818, letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.6363);
                gc.strokeArc(letra.getX() + ancho * -0.1875, letra.getY() + alto * 0.0909, ancho * 0.6250, alto * 0.5818, -52, 20, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.4000, ancho * 0.1562, alto * 0.1818, 0, 300, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.2000, ancho * 0.8125, alto * 0.7636, 200, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeLine(letra.getX() + (ancho+3) * 0.0625, letra.getY() + (alto - 3) * 0.7818, letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.6363);
            gc.strokeArc(letra.getX() + (ancho+3) * -0.1875, letra.getY() + (alto - 3) * 0.0909, (ancho+3) * 0.6250, (alto - 3) * 0.5818, -52, 20, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2500, letra.getY() + (alto - 3) * 0.4000, (ancho+3) * 0.1562, (alto - 3) * 0.1818, 0, 300, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2812, letra.getY() + (alto - 3) * 0.2000, (ancho+3) * 0.8125, (alto - 3) * 0.7636, 200, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0400, letra.getY() + alto * 0.7500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2900, letra.getY() + alto * 0.6300, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3800, letra.getY() + alto * 0.4900, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9600, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.5818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1562, letra.getY() + alto * 0.1818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8125, letra.getY() + alto * 0.7636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void f(GraphicsContext gc, Abecedario letra)
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("F"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0000, letra.getY() + alto * 0.1538, ancho * 0.5454, alto * 0.3846, -340, 60, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.0615, ancho * 0.3636, alto * 0.2307, 200, 120, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1538, ancho * 0.2727, alto * 0.7692, 80, 280, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2545, letra.getY() + alto * 0.6153, letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.6461);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.4923, ancho * 0.7272, alto * 0.4615, 225, 80, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() +ancho*0.6181, letra.getY() +alto*0.9272, letra.getX() +ancho*1, letra.getY() +alto*0.8000);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.4181, letra.getY() + alto * 0.0153, ancho * 0.3636, alto * 0.2307, 200, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0000, letra.getY() + alto * 0.1384, ancho * 0.5454, alto * 0.3846, -320, 60, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1538, ancho * 0.2727, alto * 0.7692, 100, 280, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.6153, letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.6153);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.4923, ancho * 0.7272, alto * 0.4615, 225, 120, ArcType.OPEN);//Arco 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4181, letra.getY() + (alto - 3) * 0.0153, (ancho+3) * 0.3636, (alto - 3) * 0.2307, 200, 150, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0000, letra.getY() + (alto - 3) * 0.1384, (ancho+3) * 0.5454, (alto - 3) * 0.3846, -320, 60, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1538, (ancho+3) * 0.2727, (alto - 3) * 0.7692, 100, 280, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2181, letra.getY() + (alto - 3) * 0.6153, letra.getX() + (ancho+3) * 0.5090, letra.getY() + (alto - 3) * 0.6153);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0727, letra.getY() + (alto - 3) * 0.4923, (ancho+3) * 0.7272, (alto - 3) * 0.4615, 225, 120, ArcType.OPEN);//Arco   
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.7609, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4009, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3309, letra.getY() + alto * 0.4030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5009, letra.getY() + alto * 0.6030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.6030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1409, letra.getY() + alto * 0.8530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7609, letra.getY() + alto * 0.7630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.2307, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*-1.7187, letra.getY() +alto*0.4363, ancho*2.1875, alto*0.4545, 305, 50, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3125, letra.getY() +alto*0.4909, ancho*0.1875, alto*0.2363, -10, 165, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.3125, letra.getY() +alto*0.5454, letra.getX() +ancho*0.2500, letra.getY() +alto*1.0909);
                gc.strokeArc(letra.getX() +ancho*0.2343, letra.getY() +alto*0.8181, ancho*0.2500, alto*0.5272, 165, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.2656, letra.getY() +alto*0.8181, ancho*0.2500, alto*0.5272, -10, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3125, letra.getY() +alto*0.8363, ancho*0.3125, alto*0.1818, 100, 190, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*-0.5312, letra.getY() +alto*0.6363, ancho*1.5625, alto*0.3636, 280, 70, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -1.7812, letra.getY() + alto * 0.4363, ancho * 2.1875, alto * 0.4545, 315, 35, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.4545, ancho * 0.1875, alto * 0.2363, 260, 360, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.5454, letra.getX() + ancho * 0.3281, letra.getY() + alto * 1.0909);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.8181, ancho * 0.2500, alto * 0.5272, 180, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.8363, ancho * 0.3125, alto * 0.1818, 90, 210, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * -0.5312, letra.getY() + alto * 0.6363, ancho * 1.5625, alto * 0.3636, 290, 70, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -1.7812, letra.getY() + (alto - 3) * 0.4363, (ancho+3) * 2.1875, (alto - 3) * 0.4545, 315, 35, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2812, letra.getY() + (alto - 3) * 0.4545, (ancho+3) * 0.1875, (alto - 3) * 0.2363, 260, 360, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.5454, letra.getX() + (ancho+3) * 0.3281, letra.getY() + (alto - 3) * 1.0909);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.8181, (ancho+3) * 0.2500, (alto - 3) * 0.5272, 180, 360, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.8363, (ancho+3) * 0.3125, (alto - 3) * 0.1818, 90, 210, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * -0.5312, letra.getY() + (alto - 3) * 0.6363, (ancho+3) * 1.5625, (alto - 3) * 0.3636, 290, 70, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0709, letra.getY() + alto * 0.8130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3909, letra.getY() + alto * 0.6630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2809, letra.getY() + alto * 0.7530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3009, letra.getY() + alto * 1.0830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3009, letra.getY() + alto * 0.9930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0209, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 2.1875, letra.getY() + alto * 0.4545, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1875, letra.getY() + alto * 0.2363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.5272, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.1818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.5625, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void g(GraphicsContext gc, Abecedario letra)
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("G"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, 35, 300, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.6461, letra.getX() + ancho * 0.6181, letra.getY() + alto * 1.2307);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.4363, letra.getY() + alto * 1.0769, ancho * 0.1818, alto * 0.3846, 110, 250, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5272, letra.getY() + alto * 1.0769, letra.getX() + ancho * 0.9454, letra.getY() + alto * 0.7692);//Línea 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, 35, 300, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.6153, letra.getX() + ancho * 0.6909, letra.getY() + alto * 1.3846);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.5272, letra.getY() + alto * 1.0769, ancho * 0.1818, alto * 0.3846, 110, 250, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6000, letra.getY() + alto * 1.0769, letra.getX() + ancho * 0.9454, letra.getY() + alto * 0.7692);//Línea
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1230, (ancho+3) * 0.6363, (alto - 3) * 0.8461, 35, 300, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.6153, letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 1.3846);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5272, letra.getY() + (alto - 3) * 1.0769, (ancho+3) * 0.1818, (alto - 3) * 0.3846, 110, 250, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 1.0769, letra.getX() + (ancho+3) * 0.9454, letra.getY() + (alto - 3) * 0.7692);//Línea  
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.6509, letra.getY() + alto * 0.3030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6609, letra.getY() + alto * 0.7030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6609, letra.getY() + alto * 0.5530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6609, letra.getY() + alto * 1.3530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6609, letra.getY() + alto * 1.1930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5509, letra.getY() + alto * 1.0730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9309, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.8461, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.5454, ancho*0.6250, alto*0.3636, -30, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0781, letra.getY() +alto*0.5454, ancho*0.6250, alto*0.3636, 140, 180, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.7500, letra.getY() +alto*0.7272, letra.getX() +ancho*0.6250, letra.getY() +alto*1.1818);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*1.0545, ancho*0.2812, alto*0.2727, 110, 240, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.4687, letra.getY() +alto*1.0545, letra.getX() +ancho*1.0312, letra.getY() +alto*0.8181);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.5454, ancho * 0.6250, alto * 0.3636, 360, 360, ArcType.CHORD);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 1.0545, ancho * 0.2812, alto * 0.2727, 110, 255, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.6718, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.6562, letra.getY() + alto * 1.1818);
                gc.strokeLine(letra.getX() + ancho * 0.4687, letra.getY() + alto * 1.0545, letra.getX() + ancho * 1.0312, letra.getY() + alto * 0.7636);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0625, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.6250, (alto - 3) * 0.3636, 360, 360, ArcType.CHORD);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3750, letra.getY() + (alto - 3) * 1.0545, (ancho+3) * 0.2812, (alto - 3) * 0.2727, 110, 255, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6718, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.6562, letra.getY() + (alto - 3) * 1.1818);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 1.0545, letra.getX() + (ancho+3) * 1.0312, letra.getY() + (alto - 3) * 0.7636);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.6509, letra.getY() + alto * 1.1430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 1.0230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6509, letra.getY() + alto * 0.6930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0209, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.2727, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void h(GraphicsContext gc, Abecedario letra)
    {
        Utilidades.setTamCaracter(letra.getTam());
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("H"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0545, letra.getY() + alto * -0.1538, ancho * 0.3818, alto * 0.3846, 205, 100, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.7692);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1454, letra.getY() + alto * 0.5846, ancho * 0.1818, alto * 0.3846, 110, 250, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2545, letra.getY() + alto * 0.5692, letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.2769);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.1076, ancho * 0.1554, alto * 0.2307, -20, 190, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.2307, letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.8153);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.6000, ancho * 0.3090, alto * 0.3846, 165, 150, ArcType.OPEN);//Arco 
                gc.strokeLine(letra.getX() + ancho * 0.8363, letra.getY() + alto * 0.8923, letra.getX() + ancho * 0.9454, letra.getY() + alto * 0.7692);//Línea 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0545, letra.getY() + alto * -0.1538, ancho * 0.3818, alto * 0.3846, 225, 100, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.7692);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.5846, ancho * 0.1818, alto * 0.3846, 110, 250, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.6000, letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.2769);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.0769, ancho * 0.1554, alto * 0.3384, -10, 210, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.2307, letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.8153);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.6000, ancho * 0.2727, alto * 0.3846, 165, 200, ArcType.OPEN);//Arco 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0545, letra.getY() + (alto - 3) * -0.1538, (ancho+3) * 0.3818, (alto - 3) * 0.3846, 225, 100, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.1538, letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.7692);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2181, letra.getY() + (alto - 3) * 0.5846, (ancho+3) * 0.1818, (alto - 3) * 0.3846, 110, 250, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2727, letra.getY() + (alto - 3) * 0.6000, letra.getX() + (ancho+3) * 0.7272, letra.getY() + (alto - 3) * 0.2769);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 0.0769, (ancho+3) * 0.1554, (alto - 3) * 0.3384, -10, 210, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 0.2307, letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 0.8153);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.2727, (alto - 3) * 0.3846, 165, 200, ArcType.OPEN);//Arco   
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0709, letra.getY() + alto * 0.1130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3709, letra.getY() + alto * 0.1130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3709, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2509, letra.getY() + alto * 0.5630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7409, letra.getY() + alto * 0.2530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5709, letra.getY() + alto * 0.2930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5709, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8509, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3818, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1554, letra.getY() + alto * 0.3384, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() +ancho*0.4062, letra.getY() +alto*0.2727, letra.getX() +ancho*0.0312, letra.getY() +alto*0.8000);
                gc.strokeArc(letra.getX() +ancho*0.0625, letra.getY() +alto*0, ancho*0.3750, alto*0.4000, -55, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.1562, letra.getY() +alto*0.1090, ancho*0.3750, alto*1.7272, 60, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.1562, letra.getY() +alto*0.7272, letra.getX() +ancho*0.0937, letra.getY() +alto*0.9818);
                gc.strokeArc(letra.getX() +ancho*0.0937, letra.getY() +alto*0.7272, ancho*0.5000, alto*0.3636, 10, 120, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.5937, letra.getY() +alto*0.7636, ancho*0.2500, alto*0.2181, 200, 90, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.8125, letra.getY() +alto*0.9454, letra.getX() +ancho*0.9687, letra.getY() +alto*0.8363);
            }else{ //letra normal
                gc.strokeLine(letra.getX() + ancho * 0.1562, letra.getY() + alto * 0.6727, letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.8000);
                gc.strokeArc(letra.getX() + ancho * 0.0937, letra.getY() + alto * 0.0909, ancho * 0.1875, alto * 0.6181, 260, 360, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.1562, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.1562, letra.getY() + alto * 0.9818);
                gc.strokeArc(letra.getX() + ancho * 0.1562, letra.getY() + alto * 0.7272, ancho * 0.5000, alto * 0.3636, 10, 140, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.7636, ancho * 0.3750, alto * 0.2181, 210, 155, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeLine(letra.getX() + (ancho+3) * 0.1562, letra.getY() + (alto - 3) * 0.6727, letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.8000);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0937, letra.getY() + (alto - 3) * 0.0909, (ancho+3) * 0.1875, (alto - 3) * 0.6181, 260, 360, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.1562, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.1562, letra.getY() + (alto - 3) * 0.9818);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1562, letra.getY() + (alto - 3) * 0.7272, (ancho+3) * 0.5000, (alto - 3) * 0.3636, 10, 140, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6562, letra.getY() + (alto - 3) * 0.7636, (ancho+3) * 0.3750, (alto - 3) * 0.2181, 210, 155, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0309, letra.getY() + alto * 0.7830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1309, letra.getY() + alto * 0.6630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1309, letra.getY() + alto * 0.9630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.7830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6309, letra.getY() + alto * 0.8730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9709, letra.getY() + alto * 0.8330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1875, letra.getY() + alto * 0.6181, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 0.2181, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void i(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("I"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * -0.1538, ancho * 0.5454, alto * 0.3846, 205, 100, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5818, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.5272, letra.getY() + alto * 0.7692);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1272, letra.getY() + alto * 0.6153, ancho * 0.3818, alto * 0.3846, 170, 200, ArcType.OPEN); //Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.5384, ancho * 0.7272, alto * 0.4615, 235, 80, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.9076, letra.getX() + ancho * 0.9454, letra.getY() + alto * 0.7692);//Línea 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * -0.1538, ancho * 0.5454, alto * 0.3846, 225, 100, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5818, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.5818, letra.getY() + alto * 0.7692);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2000, letra.getY() + alto * 0.6153, ancho * 0.3818, alto * 0.3846, 170, 200, ArcType.OPEN); //Arcos
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.5384, ancho * 0.7272, alto * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * -0.1538, (ancho+3) * 0.5454, (alto - 3) * 0.3846, 225, 100, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.5818, letra.getY() + (alto - 3) * 0.1538, letra.getX() + (ancho+3) * 0.5818, letra.getY() + (alto - 3) * 0.7692);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2000, letra.getY() + (alto - 3) * 0.6153, (ancho+3) * 0.3818, (alto - 3) * 0.3846, 170, 200, ArcType.OPEN); //Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1090, letra.getY() + (alto - 3) * 0.5384, (ancho+3) * 0.7272, (alto - 3) * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.1509, letra.getY() + alto * 0.1530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5809, letra.getY() + alto * 0.1430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5609, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1729, letra.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8209, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2309, letra.getY() + alto * 0.9230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3818, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*-0.8437, letra.getY() +alto*0.2545, ancho*1.5625, alto*0.5454, 280, 35, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.5000, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 140, 90, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.5000, letra.getY() +alto*0.6000, ancho*0.5000, alto*0.3636, 250, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.6875, letra.getY() +alto*0.5090, ancho*0.0625, alto*0.0363, 0, 357, ArcType.CHORD);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -1.0937, letra.getY() + alto * 0.3272, ancho * 1.5625, alto * 0.5454, 300, 43, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4375, letra.getY() + alto * 0.4363, ancho * 0.6250, alto * 0.5454, 175, 160, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4375, letra.getY() + alto * 0.5090, ancho * 0.0625, alto * 0.0363, 0, 357, ArcType.CHORD);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -1.0937, letra.getY() + (alto - 3) * 0.3272, (ancho+3) * 1.5625, (alto - 3) * 0.5454, 300, 43, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4375, letra.getY() + (alto - 3) * 0.4363, (ancho+3) * 0.6250, (alto - 3) * 0.5454, 175, 160, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4375, letra.getY() + (alto - 3) * 0.5090, (ancho+3) * 0.0625, (alto - 3) * 0.0363, 0, 357, ArcType.CHORD);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0409, letra.getY() + alto * 0.8130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4309, letra.getY() + alto * 0.6730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9909, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 0.5230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.5625, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void j(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("J"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0545, letra.getY() + alto * 0.4615, ancho * 0.3818, alto * 0.5384, 90, 150, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5818, letra.getY() + alto * 0.1384, letra.getX() + ancho * 0.5272, letra.getY() + alto * 1.3846);//Líneas
                gc.strokeLine(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.4769, letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.1692);
                gc.strokeArc(letra.getX() + ancho * 0.2545, letra.getY() + alto * 1.1076, ancho * 0.2727, alto * 0.3846, 105, 230, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2909, letra.getY() + alto * 1.1692, letra.getX() + ancho * 0.9636, letra.getY() + alto * 0.7692);//Línea 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0545, letra.getY() + alto * 0.4615, ancho * 0.3818, alto * 0.5384, 110, 160, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5818, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.5818, letra.getY() + alto * 1.3846);//Líneas
                gc.strokeLine(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.4769, letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.1692);
                gc.strokeArc(letra.getX() + ancho * 0.3090, letra.getY() + alto * 1.1076, ancho * 0.2727, alto * 0.3846, 105, 230, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.3636, letra.getY() + alto * 1.1692, letra.getX() + ancho * 0.9636, letra.getY() + alto * 0.7692);//Línea 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0545, letra.getY() + (alto - 3) * 0.4615, (ancho+3) * 0.3818, (alto - 3) * 0.5384, 110, 160, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.5818, letra.getY() + (alto - 3) * 0.1538, letra.getX() + (ancho+3) * 0.5818, letra.getY() + (alto - 3) * 1.3846);//Líneas
            gc.strokeLine(letra.getX() + (ancho+3) * 0.1818, letra.getY() + (alto - 3) * 0.4769, letra.getX() + (ancho+3) * 0.5454, letra.getY() + (alto - 3) * 0.1692);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3090, letra.getY() + (alto - 3) * 1.1076, (ancho+3) * 0.2727, (alto - 3) * 0.3846, 105, 230, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3636, letra.getY() + (alto - 3) * 1.1692, letra.getX() + (ancho+3) * 0.9636, letra.getY() + (alto - 3) * 0.7692);//Línea 
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.9730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.4430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5509, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5509, letra.getY() + alto * 1.3930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3809, letra.getY() + alto * 1.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9509, letra.getY() + alto * 0.7330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3818, letra.getY() + alto * 0.5384, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*-0.6875, letra.getY() +alto*0.2727, ancho*1.5625, alto*0.5454, 270, 30, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.1562, letra.getY() +alto*1, ancho*0.2500, alto*0.3272, 90, 255, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.5312, letra.getY() +alto*0.6909, letra.getX() +ancho*0.4062, letra.getY() +alto*1.2363);
                gc.strokeLine(letra.getX() +ancho*1.0000, letra.getY() +alto*0.8000, letra.getX() +ancho*0.3437, letra.getY() +alto*0.9687);
                gc.strokeArc(letra.getX() +ancho*0.5312, letra.getY() +alto*0.5454, ancho*0.0625, alto*0.0363, 0, 360, ArcType.CHORD);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -0.9687, letra.getY() + alto * 0.2727, ancho * 1.5625, alto * 0.5454, 290, 35, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 1.0909, ancho * 0.2812, alto * 0.3272, 110, 255, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.6909, letra.getX() + ancho * 0.5937, letra.getY() + alto * 1.2363);
                gc.strokeLine(letra.getX() + ancho * 1.0000, letra.getY() + alto * 0.7818, letra.getX() + ancho * 0.4375, letra.getY() + alto * 1.0909);
                gc.strokeArc(letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.5454, ancho * 0.0625, alto * 0.0363, 0, 360, ArcType.CHORD);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -0.9687, letra.getY() + (alto - 3) * 0.2727, (ancho+3) * 1.5625, (alto - 3) * 0.5454, 290, 35, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 1.0909, (ancho+3) * 0.2812, (alto - 3) * 0.3272, 110, 255, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.6909, letra.getX() + (ancho+3) * 0.5937, letra.getY() + (alto - 3) * 1.2363);
            gc.strokeLine(letra.getX() + (ancho+3) * 1.0000, letra.getY() + (alto - 3) * 0.7818, letra.getX() + (ancho+3) * 0.4375, letra.getY() + (alto - 3) * 1.0909);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.0625, (alto - 3) * 0.0363, 0, 360, ArcType.CHORD);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0409, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4209, letra.getY() + alto * 0.6630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4809, letra.getY() + alto * 0.5430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9709, letra.getY() + alto * 0.7330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3809, letra.getY() + alto * 1.0830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.5625, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.3272, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.0363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void k(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("K"))
        {
            if(letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * -0.0363, letra.getY() + alto * -0.1538, ancho * 0.5454, alto * 0.3846, 205, 100, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.7692);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.6153, ancho * 0.3272, alto * 0.3846, 170, 200, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.6153, letra.getX() + ancho * 0.8181, letra.getY() + alto * 0.1538); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.5076, ancho * 0.2363, alto * 0.1538, 0, 360, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * -0.0727, letra.getY() + alto * 0.4615, ancho * 0.7272, alto * 0.7692, 0, 50, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.5076, ancho * 0.3454, alto * 0.4615, 190, 150, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -0.0363, letra.getY() + alto * -0.1538, ancho * 0.5454, alto * 0.3846, 225, 100, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.7692);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.6153, ancho * 0.3818, alto * 0.3846, 170, 200, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.6153, letra.getX() + ancho * 0.8181, letra.getY() + alto * 0.1538); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.5076, ancho * 0.2363, alto * 0.1538, 0, 360, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * -0.0363, letra.getY() + alto * 0.4615, ancho * 0.7272, alto * 0.7692, 0, 50, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6727, letra.getY() + alto * 0.5076, ancho * 0.3090, alto * 0.4615, 190, 150, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -0.0363, letra.getY() + (alto - 3) * -0.1538, (ancho+3) * 0.5454, (alto - 3) * 0.3846, 225, 100, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4545, letra.getY() + (alto - 3) * 0.1538, letra.getX() + (ancho+3) * 0.4545, letra.getY() + (alto - 3) * 0.7692);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0727, letra.getY() + (alto - 3) * 0.6153, (ancho+3) * 0.3818, (alto - 3) * 0.3846, 170, 200, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.5454, letra.getY() + (alto - 3) * 0.6153, letra.getX() + (ancho+3) * 0.8181, letra.getY() + (alto - 3) * 0.1538); //Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3272, letra.getY() + (alto - 3) * 0.5076, (ancho+3) * 0.2363, (alto - 3) * 0.1538, 0, 360, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * -0.0363, letra.getY() + (alto - 3) * 0.4615, (ancho+3) * 0.7272, (alto - 3) * 0.7692, 0, 50, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6727, letra.getY() + (alto - 3) * 0.5076, (ancho+3) * 0.3090, (alto - 3) * 0.4615, 190, 150, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0109, letra.getY() + alto * 0.1430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4409, letra.getY() + alto * 0.1330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4409, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0429, letra.getY() + alto * 0.7530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5009, letra.getY() + alto * 0.6130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7809, letra.getY() + alto * 0.1330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5309, letra.getY() + alto * 0.5130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6609, letra.getY() + alto * 0.8230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9409, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3818, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.1538, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3090, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() +ancho*0.4062, letra.getY() +alto*0.2727, letra.getX() +ancho*0.0312, letra.getY() +alto*0.8000);
                gc.strokeArc(letra.getX() +ancho*0.0625, letra.getY() +alto*0, ancho*0.3750, alto*0.4000, -55, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.1562, letra.getY() +alto*0.1090, ancho*0.3750, alto*1.7272, 60, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.1562, letra.getY() +alto*0.7272, letra.getX() +ancho*0.0937, letra.getY() +alto*0.9818);
                gc.strokeArc(letra.getX() +ancho*0.1562, letra.getY() +alto*0.7272, ancho*0.3125, alto*0.1454, -105, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.1562, letra.getY() +alto*0.8909, ancho*0.3125, alto*0.1454, 35, 50, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3750, letra.getY() +alto*0.6181, ancho*0.5937, alto*0.3636, 230, 110, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -1.2187, letra.getY() + alto * 0.3454, ancho * 1.5625, alto * 0.5454, 310, 45, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.1818, ancho * 0.1562, alto * 0.5090, 260, 360, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.3636, letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.9818);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.7272, ancho * 0.3125, alto * 0.1454, -90, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.8909, ancho * 0.3125, alto * 0.1454, 30, 50, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.6181, ancho * 0.5312, alto * 0.3636, 230, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -1.2187, letra.getY() + (alto - 3) * 0.3454, (ancho+3) * 1.5625, (alto - 3) * 0.5454, 310, 45, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.1818, (ancho+3) * 0.1562, (alto - 3) * 0.5090, 260, 360, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.3636, letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.9818);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.7272, (ancho+3) * 0.3125, (alto - 3) * 0.1454, -90, 220, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2812, letra.getY() + (alto - 3) * 0.8909, (ancho+3) * 0.3125, (alto - 3) * 0.1454, 30, 50, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5000, letra.getY() + (alto - 3) * 0.6181, (ancho+3) * 0.5312, (alto - 3) * 0.3636, 230, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0309, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3209, letra.getY() + alto * 0.6330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.3530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.9630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2009, letra.getY() + alto * 0.7330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3209, letra.getY() + alto * 0.8530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5609, letra.getY() + alto * 0.9130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0009, letra.getY() + alto * 0.8130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.5625, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1562, letra.getY() + alto * 0.5090, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.1454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.1454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5312, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void l(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("L"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.0461, ancho * 0.2909, alto * 0.3076, -20, 170, ArcType.OPEN); //Arco
                gc.strokeLine(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.8153); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.7846, ancho * 0.2727, alto * 0.1846, 170, 360, ArcType.OPEN); //Arcos
                gc.strokeArc(letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.3076, ancho * 0.6181, alto * 0.6615, 220, 110, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.0461, ancho * 0.2909, alto * 0.3076, 0, 170, ArcType.OPEN); //Arco
                gc.strokeLine(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.8153); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.7846, ancho * 0.2727, alto * 0.1846, 170, 360, ArcType.OPEN); //Arcos
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.3076, ancho * 0.6181, alto * 0.6615, 220, 110, ArcType.OPEN);
            }

            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.0461, (ancho+3) * 0.2909, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN); //Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.1538, letra.getX() + (ancho+3) * 0.4545, letra.getY() + (alto - 3) * 0.8153); //Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1818, letra.getY() + (alto - 3) * 0.7846, (ancho+3) * 0.2727, (alto - 3) * 0.1846, 170, 360, ArcType.OPEN); //Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3636, letra.getY() + (alto - 3) * 0.3076, (ancho+3) * 0.6181, (alto - 3) * 0.6615, 220, 110, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.6709, letra.getY() + alto * 0.2130, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3709, letra.getY() + alto * 0.1930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3609, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4309, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9309, letra.getY() + alto * 0.7830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.1846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6181, letra.getY() + alto * 0.6615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() +ancho*0.5937, letra.getY() +alto*0.3090, letra.getX() +ancho*0.0312, letra.getY() +alto*0.8000);
                gc.strokeArc(letra.getX() +ancho*0.2500, letra.getY() +alto*0, ancho*0.3750, alto*0.4000, -55, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3125, letra.getY() +alto*0.1090, ancho*0.4687, alto*1.7272, 60, 95, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.3125, letra.getY() +alto*0.6545, letra.getX() +ancho*0.2343, letra.getY() +alto*0.8000);
                gc.strokeArc(letra.getX() +ancho*0.2187, letra.getY() +alto*0.4363, ancho*0.7812, alto*0.5454, 200, 135, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -1.2187, letra.getY() + alto * 0.3454, ancho * 1.5625, alto * 0.5454, 310, 45, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.1090, ancho * 0.1875, alto * 0.5454, 0, 360, ArcType.OPEN); //curva central
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.4363, ancho * 0.6875, alto * 0.5454, 180, 170, ArcType.OPEN);
            }

            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -1.2187, letra.getY() + (alto - 3) * 0.3454, (ancho+3) * 1.5625, (alto - 3) * 0.5454, 310, 45, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.1090, (ancho+3) * 0.1875, (alto - 3) * 0.5454, 0, 360, ArcType.OPEN); //curva central
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.4363, (ancho+3) * 0.6875, (alto - 3) * 0.5454, 180, 170, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0400, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2900, letra.getY() + alto * 0.6300, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9600, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.5625, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1875, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6875, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void m(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("M"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1384, ancho * 0.2181, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2272, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.9538);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.1384, ancho * 0.2909, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.9538);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.4909, letra.getY() + alto * 0.1384, ancho * 0.2545, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.7545, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.8923);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.6769, ancho * 0.2363, alto * 0.3076, 200, 110, ArcType.OPEN);//Arco 
                gc.strokeLine(letra.getX() + ancho * 0.9090, letra.getY() + alto * 0.9076, letra.getX() + ancho * 0.9687, letra.getY() + alto * 0.7692);//Línea 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1384, ancho * 0.2181, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2272, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.2272, letra.getY() + alto * 0.9538);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.1384, ancho * 0.2909, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.9538);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.4909, letra.getY() + alto * 0.1384, ancho * 0.2545, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.7545, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.7545, letra.getY() + alto * 0.8923);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.7454, letra.getY() + alto * 0.6769, ancho * 0.2363, alto * 0.3076, 200, 190, ArcType.OPEN);//Arco 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0181, letra.getY() + (alto - 3) * 0.1384, (ancho+3) * 0.2181, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2272, letra.getY() + (alto - 3) * 0.3076, letra.getX() + (ancho+3) * 0.2272, letra.getY() + (alto - 3) * 0.9538);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2181, letra.getY() + (alto - 3) * 0.1384, (ancho+3) * 0.2909, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.5000, letra.getY() + (alto - 3) * 0.3076, letra.getX() + (ancho+3) * 0.5000, letra.getY() + (alto - 3) * 0.9538);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4909, letra.getY() + (alto - 3) * 0.1384, (ancho+3) * 0.2545, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.7545, letra.getY() + (alto - 3) * 0.3076, letra.getX() + (ancho+3) * 0.7545, letra.getY() + (alto - 3) * 0.8923);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7454, letra.getY() + (alto - 3) * 0.6769, (ancho+3) * 0.2363, (alto - 3) * 0.3076, 200, 190, ArcType.OPEN);//Arco 
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0100, letra.getY() + alto * 0.2400, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2100, letra.getY() + alto * 0.2900, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2100, letra.getY() + alto * 0.9500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4900, letra.getY() + alto * 0.2900, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4900, letra.getY() + alto * 0.9500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7200, letra.getY() + alto * 0.2900, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7200, letra.getY() + alto * 0.9000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9500, letra.getY() + alto * 0.7100, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2545, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.5636, ancho*0.3125, alto*0.5090, 90, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0, letra.getY() +alto*0.4909, ancho*0.2187, alto*0.3636, -30, 70, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.2187, letra.getY() +alto*0.6909, letra.getX() +ancho*0.1562, letra.getY() +alto*0.9636);
                gc.strokeArc(letra.getX() +ancho*0.2187, letra.getY() +alto*0.5454, ancho*0.2187, alto*0.3636, -10, 120, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.4531, letra.getY() +alto*0.6363, letra.getX() +ancho*0.3750, letra.getY() +alto*0.9636);
                gc.strokeArc(letra.getX() +ancho*0.4062, letra.getY() +alto*0.5454, ancho*0.2500, alto*0.3636, -10, 140, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.6250, letra.getY() +alto*0.5454, ancho*0.2812, alto*0.4181, 180, 120, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*1.0000, letra.getY() +alto*0.8000, letra.getX() +ancho*0.7812, letra.getY() +alto*0.9687);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.5272, ancho * 0.2187, alto * 0.3636, 0, 185, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.6363, letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.9636);
                gc.strokeArc(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.5272, ancho * 0.2187, alto * 0.3636, 0, 185, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.6363, letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.9636);
                gc.strokeArc(letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.5272, ancho * 0.2187, alto * 0.3636, 0, 185, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6875, letra.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.4181, 180, 165, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.5272, (ancho+3) * 0.2187, (alto - 3) * 0.3636, 0, 185, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2500, letra.getY() + (alto - 3) * 0.6363, letra.getX() + (ancho+3) * 0.2500, letra.getY() + (alto - 3) * 0.9636);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2500, letra.getY() + (alto - 3) * 0.5272, (ancho+3) * 0.2187, (alto - 3) * 0.3636, 0, 185, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.6363, letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.9636);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.5272, (ancho+3) * 0.2187, (alto - 3) * 0.3636, 0, 185, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6875, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.3125, (alto - 3) * 0.4181, 180, 165, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0400, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2300, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2300, letra.getY() + alto * 0.9800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4500, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4500, letra.getY() + alto * 0.9800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6700, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9700, letra.getY() + alto * 0.7600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.4181, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void n(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("N"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.2307, ancho * 0.2545, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.9538); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.2307, ancho * 0.3272, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.8615); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.6769, ancho * 0.2363, alto * 0.3076, 200, 110, ArcType.OPEN);//Arco 
                gc.strokeLine(letra.getX() + ancho * 0.8545, letra.getY() + alto * 0.9076, letra.getX() + ancho * 0.9687, letra.getY() + alto * 0.7692);//Línea 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.2307, ancho * 0.2545, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.9538); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.2307, ancho * 0.3272, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.8615); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.6769, ancho * 0.2363, alto * 0.3076, 200, 190, ArcType.OPEN);//Arco
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0727, letra.getY() + (alto - 3) * 0.2307, (ancho+3) * 0.2545, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3454, letra.getY() + (alto - 3) * 0.3538, letra.getX() + (ancho+3) * 0.3454, letra.getY() + (alto - 3) * 0.9538); //Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3636, letra.getY() + (alto - 3) * 0.2307, (ancho+3) * 0.3272, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.3538, letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.8615); //Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.6769, (ancho+3) * 0.2363, (alto - 3) * 0.3076, 200, 190, ArcType.OPEN);//Arco  
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0500, letra.getY() + alto * 0.3600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.3600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.9300, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6600, letra.getY() + alto * 0.3100, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6600, letra.getY() + alto * 0.8500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8600, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2545, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.5312, ancho*0.3125, alto*0.5090, 100, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.5454, ancho*0.2187, alto*0.3636, -20, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.3437, letra.getY() +alto*0.7272, letra.getX() +ancho*0.2500, letra.getY() +alto*0.9636);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*0.5454, ancho*0.3125, alto*0.3636, -10, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.6250, letra.getY() +alto*0.5818, ancho*0.3437, alto*0.3818, 180, 160, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.3636, 0, 185, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.9636);
                gc.strokeArc(letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.3636, 0, 185, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.5818, ancho * 0.3750, alto * 0.3818, 180, 160, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.3125, (alto - 3) * 0.3636, 0, 185, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.9636);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.3125, (alto - 3) * 0.3636, 0, 185, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6562, letra.getY() + (alto - 3) * 0.5818, (ancho+3) * 0.3750, (alto - 3) * 0.3818, 180, 160, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0200, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.9800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6500, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0000, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 0.3818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void nLatina(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("Ñ"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.2307, ancho * 0.2545, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.9538); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.2307, ancho * 0.3272, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.8615); //Línea
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.6769, ancho * 0.2363, alto * 0.3076, 200, 110, ArcType.OPEN);//Arco 
                gc.strokeLine(letra.getX() + ancho * 0.8545, letra.getY() + alto * 0.9076, letra.getX() + ancho * 0.9687, letra.getY() + alto * 0.7692);//Línea 
                gc.strokeArc(letra.getX() + ancho * 0.3818, letra.getY() + alto * 0.0923, ancho * 0.1636, alto * 0.0769, 0, 170, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.5272, letra.getY() + alto * 0.0769, ancho * 0.1636, alto * 0.0769, 190, 170, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.3818, letra.getY() + alto * 0.0923, ancho * 0.1636, alto * 0.0769, 0, 170, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.5272, letra.getY() + alto * 0.0769, ancho * 0.1636, alto * 0.0769, 190, 170, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.2307, ancho * 0.2545, alto * 0.3076, 0, 170, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.9538);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.2307, ancho * 0.3272, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.3538, letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.8615);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.6769, ancho * 0.2363, alto * 0.3076, 200, 190, ArcType.OPEN);//Arco
            }          
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3818, letra.getY() + (alto - 3) * 0.0923, (ancho+3) * 0.1636, (alto - 3) * 0.0769, 0, 170, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5272, letra.getY() + (alto - 3) * 0.0769, (ancho+3) * 0.1636, (alto - 3) * 0.0769, 190, 170, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0727, letra.getY() + (alto - 3) * 0.2307, (ancho+3) * 0.2545, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3454, letra.getY() + (alto - 3) * 0.3538, letra.getX() + (ancho+3) * 0.3454, letra.getY() + (alto - 3) * 0.9538);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3636, letra.getY() + (alto - 3) * 0.2307, (ancho+3) * 0.3272, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.3538, letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.8615);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.6769, (ancho+3) * 0.2363, (alto - 3) * 0.3076, 200, 190, ArcType.OPEN);//Arco  
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0500, letra.getY() + alto * 0.3600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.3600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.9300, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6600, letra.getY() + alto * 0.3100, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6600, letra.getY() + alto * 0.8500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8600, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3400, letra.getY() + alto * 0.1200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5200, letra.getY() + alto * 0.1200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6800, letra.getY() + alto * 0.0800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.0769, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.0769, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2545, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.5312, ancho*0.3125, alto*0.5090, 100, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.5454, ancho*0.2187, alto*0.3636, -20, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.3437, letra.getY() +alto*0.7272, letra.getX() +ancho*0.2500, letra.getY() +alto*0.9636);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*0.5454, ancho*0.3125, alto*0.3636, -10, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.6250, letra.getY() +alto*0.5818, ancho*0.3437, alto*0.3818, 180, 160, ArcType.OPEN);
                gc.setLineWidth(3);
                gc.strokeArc(letra.getX() +ancho*0.0625, letra.getY() +alto*0.3636, ancho*0.2187, alto*0.1272, 30, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3125, letra.getY() +alto*0.3272, ancho*0.2187, alto*0.1272, 210, 150, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.3636, 0, 185, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.9636);
                gc.strokeArc(letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.3636, 0, 185, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.5818, ancho * 0.3750, alto * 0.3818, 180, 160, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.3636, ancho * 0.2187, alto * 0.1272, 30, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.3272, ancho * 0.2187, alto * 0.1272, 210, 150, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.3125, (alto - 3) * 0.3636, 0, 185, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.9636);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.3125, (alto - 3) * 0.3636, 0, 185, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6562, letra.getY() + (alto - 3) * 0.5818, (ancho+3) * 0.3750, (alto - 3) * 0.3818, 180, 160, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0625, letra.getY() + (alto - 3) * 0.3636, (ancho+3) * 0.2187, (alto - 3) * 0.1272, 30, 150, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.3272, (ancho+3) * 0.2187, (alto - 3) * 0.1272, 210, 150, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0200, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3200, letra.getY() + alto * 0.9800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6500, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0000, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0300, letra.getY() + alto * 0.4200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2800, letra.getY() + alto * 0.3800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5500, letra.getY() + alto * 0.3500, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 0.3818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.1272, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.1272, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void o(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("O"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.0923, ancho * 0.7272, alto * 0.8923, 65, 200, ArcType.OPEN); //Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1692, ancho * 0.7272, alto * 0.8000, 255, 130, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3909, letra.getY() + alto * 0.2307, ancho * 0.3636, alto * 0.3846, 10, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, -210, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.5230, ancho * 0.7636, alto * 0.4615, 225, 120, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.0923, ancho * 0.7272, alto * 0.8923, 85, 200, ArcType.OPEN); //Arcos
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.1692, ancho * 0.7272, alto * 0.8000, 275, 130, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3909, letra.getY() + alto * 0.1846, ancho * 0.3636, alto * 0.3846, 30, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3545, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, -230, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.5230, ancho * 0.7272, alto * 0.4615, 245, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0727, letra.getY() + (alto - 3) * 0.0923, (ancho+3) * 0.7272, (alto - 3) * 0.8923, 85, 200, ArcType.OPEN); //Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1090, letra.getY() + (alto - 3) * 0.1692, (ancho+3) * 0.7272, (alto - 3) * 0.8000, 275, 130, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3909, letra.getY() + (alto - 3) * 0.1846, (ancho+3) * 0.3636, (alto - 3) * 0.3846, 30, 150, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3545, letra.getY() + (alto - 3) * 0.1230, (ancho+3) * 0.6363, (alto - 3) * 0.8461, -230, 80, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2181, letra.getY() + (alto - 3) * 0.5230, (ancho+3) * 0.7272, (alto - 3) * 0.4615, 245, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.4600, letra.getY() + alto * 0.0700, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.9400, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7000, letra.getY() + alto * 0.2600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3700, letra.getY() + alto * 0.3700, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3800, letra.getY() + alto * 0.7400, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9100, letra.getY() + alto * 0.6800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3900, letra.getY() + alto * 0.9200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.8923, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.8461, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, -120, 210, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0781, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 140, 105, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.4375, letra.getY() +alto*0.4545, ancho*0.6562, alto*0.4181, 175, 140, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.6000, ancho * 0.6875, alto * 0.3636, 105, 330, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.4727, ancho * 0.5312, alto * 0.3636, 175, 153, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0625, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.6875, (alto - 3) * 0.3636, 105, 330, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5000, letra.getY() + (alto - 3) * 0.4727, (ancho+3) * 0.5312, (alto - 3) * 0.3636, 175, 153, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.3000, letra.getY() + alto * 0.5800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4900, letra.getY() + alto * 0.5800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9700, letra.getY() + alto * 0.7200, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6875, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5312, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void p(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("P"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1538, ancho * 0.2727, alto * 0.7692, 80, 280, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.1384, ancho * 0.6363, alto * 0.5692, 280, 200, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.4815, ancho * 0.7672, alto * 0.4615, 215, 120, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1538, ancho * 0.2727, alto * 0.7692, 100, 280, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1076, ancho * 0.6363, alto * 0.5692, 280, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0681, letra.getY() + alto * 0.4815, ancho * 0.7672, alto * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1538, (ancho+3) * 0.2727, (alto - 3) * 0.7692, 100, 280, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.6363, (alto - 3) * 0.5692, 280, 220, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0681, letra.getY() + (alto - 3) * 0.4815, (ancho+3) * 0.7672, (alto - 3) * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.3309, letra.getY() + alto * 0.4030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 0.6330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2809, letra.getY() + alto * 0.9030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8159, letra.getY() + alto * 0.6930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.5692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7672, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0, letra.getY() +alto*0.5636, ancho*0.2812, alto*0.2727, 240, 135, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.2500, letra.getY() +alto*0.6363, ancho*0.6250, alto*0.3272, -90, 240, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.2187, letra.getY() +alto*0.8363, letra.getX() +ancho*0.1562, letra.getY() +alto*1.1818);
                gc.strokeArc(letra.getX() +ancho*0.4687, letra.getY() +alto*0.9454, ancho*0.7812, alto*0.0181, 240, 30, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.5000, letra.getY() +alto*0.5818, ancho*0.5625, alto*0.3818, 280, 40, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -0.0312, letra.getY() + alto * 0.5454, ancho * 0.2500, alto * 0.2727, 260, 100, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.6363, ancho * 0.6250, alto * 0.3272, -70, 240, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.8363, letra.getX() + ancho * 0.2187, letra.getY() + alto * 1.1818);
                gc.strokeArc(letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.9454, ancho * 0.7812, alto * 0.0181, 240, 30, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.5818, ancho * 0.5625, alto * 0.3818, 280, 40, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -0.0312, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.2500, (alto - 3) * 0.2727, 260, 100, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.6363, (ancho+3) * 0.6250, (alto - 3) * 0.3272, -70, 240, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.8363, letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 1.1818);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.9454, (ancho+3) * 0.7812, (alto - 3) * 0.0181, 240, 30, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5000, letra.getY() + (alto - 3) * 0.5818, (ancho+3) * 0.5625, (alto - 3) * 0.3818, 280, 40, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0309, letra.getY() + alto * 0.8030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2109, letra.getY() + alto * 0.6430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1509, letra.getY() + alto * 0.7330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6209, letra.getY() + alto * 0.9230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 1.1830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8809, letra.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9909, letra.getY() + alto * 0.8630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.2727, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.3272, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7812, letra.getY() + alto * 0.0181, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5625, letra.getY() + alto * 0.3818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void q(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("Q"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.0923, ancho * 0.7272, alto * 0.8923, 65, 200, ArcType.OPEN); //Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1692, ancho * 0.7272, alto * 0.8000, 255, 130, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3909, letra.getY() + alto * 0.2307, ancho * 0.3636, alto * 0.3846, 10, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, -210, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.5230, ancho * 0.7636, alto * 0.4615, 225, 120, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.6461, ancho * 0.2727, alto * 0.3076, -20, 190, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0727, letra.getY() + alto * 0.0923, ancho * 0.7272, alto * 0.8923, 85, 200, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.1692, ancho * 0.7272, alto * 0.8000, 275, 130, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3909, letra.getY() + alto * 0.1846, ancho * 0.3636, alto * 0.3846, 30, 150, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3545, letra.getY() + alto * 0.1230, ancho * 0.6363, alto * 0.8461, -230, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.6461, ancho * 0.2727, alto * 0.3076, 0, 190, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.6461, ancho * 0.2727, alto * 0.3076, -180, 190, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0727, letra.getY() + (alto - 3) * 0.0923, (ancho+3) * 0.7272, (alto - 3) * 0.8923, 85, 200, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1090, letra.getY() + (alto - 3) * 0.1692, (ancho+3) * 0.7272, (alto - 3) * 0.8000, 275, 130, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3909, letra.getY() + (alto - 3) * 0.1846, (ancho+3) * 0.3636, (alto - 3) * 0.3846, 30, 150, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3545, letra.getY() + (alto - 3) * 0.1230, (ancho+3) * 0.6363, (alto - 3) * 0.8461, -230, 80, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.6461, (ancho+3) * 0.2727, (alto - 3) * 0.3076, 0, 190, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6909, letra.getY() + (alto - 3) * 0.6461, (ancho+3) * 0.2727, (alto - 3) * 0.3076, -180, 190, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.4600, letra.getY() + alto * 0.0700, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5000, letra.getY() + alto * 0.9400, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7000, letra.getY() + alto * 0.2600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3700, letra.getY() + alto * 0.3700, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3800, letra.getY() + alto * 0.7400, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3800, letra.getY() + alto * 0.8100, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6400, letra.getY() + alto * 0.7800, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9300, letra.getY() + alto * 0.7600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.8923, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.8461, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.1250, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, -30, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0781, letra.getY() +alto*0.6000, ancho*0.6250, alto*0.3636, 140, 180, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.7500, letra.getY() +alto*0.6000, letra.getX() +ancho*0.6562, letra.getY() +alto*1.2909);
                gc.strokeArc(letra.getX() +ancho*0.7500, letra.getY() +alto*0.6000, ancho*0.2812, alto*0.3818, 170, 165, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.6000, ancho * 0.6875, alto * 0.3636, 360, 360, ArcType.CHORD);
                gc.strokeLine(letra.getX() + ancho * 0.7500, letra.getY() + alto * 0.6000, letra.getX() + ancho * 0.7500, letra.getY() + alto * 1.2909);
                gc.strokeArc(letra.getX() + ancho * 0.7500, letra.getY() + alto * 0.6000, ancho * 0.2812, alto * 0.3818, 180, 160, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0625, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.6875, (alto - 3) * 0.3636, 360, 360, ArcType.CHORD);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.7500, letra.getY() + (alto - 3) * 0.6000, letra.getX() + (ancho+3) * 0.7500, letra.getY() + (alto - 3) * 1.2909);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7500, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.2812, (alto - 3) * 0.3818, 180, 160, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.7200, letra.getY() + alto * 0.5600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7200, letra.getY() + alto * 1.2600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7200, letra.getY() + alto * 0.7600, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0000, letra.getY() + alto * 0.8400, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6875, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.3818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void r(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("R"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1938, ancho * 0.2327, alto * 0.7692, 80, 280, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1538, ancho * 0.6363, alto * 0.5692, 270, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3818, letra.getY() + alto * 0.5692, ancho * 0.1636, alto * 0.1230, 0, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.5384, ancho * 0.3636, alto * 0.6153, - 10, 50, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5636, letra.getY() + alto * 0.6000, ancho * 0.3454, alto * 0.3846, 170, 150, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1938, ancho * 0.2327, alto * 0.7692, 100, 280, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1076, ancho * 0.6363, alto * 0.5692, 280, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.5384, ancho * 0.1636, alto * 0.1230, 0, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.5384, ancho * 0.3636, alto * 0.6153, 0, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.6000, ancho * 0.3090, alto * 0.3846, 170, 200, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1938, (ancho+3) * 0.2327, (alto - 3) * 0.7692, 100, 280, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.6363, (alto - 3) * 0.5692, 280, 220, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.5384, (ancho+3) * 0.1636, (alto - 3) * 0.1230, 0, 360, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2727, letra.getY() + (alto - 3) * 0.5384, (ancho+3) * 0.3636, (alto - 3) * 0.6153, 0, 60, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6363, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.3090, (alto - 3) * 0.3846, 170, 200, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.4230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1709, letra.getY() + alto * 0.1730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 0.6530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5109, letra.getY() + alto * 0.5530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6109, letra.getY() + alto * 0.8330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9309, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2327, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.5692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.6153, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3090, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*-0.8125, letra.getY() +alto*0.3272, ancho*01.1562, alto*0.5454, 300, 44, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.2812, letra.getY() +alto*0.3272, ancho*0.6250, alto*0.3636, 230, 65, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.7187, letra.getY() +alto*0.4727, ancho*0.3750, alto*0.5090, 170, 70, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*1.0000, letra.getY() +alto*0.8000, letra.getX() +ancho*0.8750, letra.getY() +alto*0.9272);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -0.7187, letra.getY() + alto * 0.3272, ancho * 0.9375, alto * 0.5454, 310, 44, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1562, letra.getY() + alto * 0.2909, ancho * 0.6250, alto * 0.3636, 230, 65, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.2545, ancho * 0.3750, alto * 0.7272, 190, 130, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -0.7187, letra.getY() + (alto - 3) * 0.3272, (ancho+3) * 0.9375, (alto - 3) * 0.5454, 310, 44, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1562, letra.getY() + (alto - 3) * 0.2909, (ancho+3) * 0.6250, (alto - 3) * 0.3636, 230, 65, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6250, letra.getY() + (alto - 3) * 0.2545, (ancho+3) * 0.3750, (alto - 3) * 0.7272, 190, 130, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0409, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1909, letra.getY() + alto * 0.6030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6009, letra.getY() + alto * 0.6430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9309, letra.getY() + alto * 0.8430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9375, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 0.7272, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void s(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("S"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() + ancho * 0.0363, letra.getY() + alto * 1, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.0769);//Líneas
                gc.strokeLine(letra.getX() + ancho * 0.4363, letra.getY() + alto * 0.0769, letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.6769);
                gc.strokeArc(letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.5384, ancho * 0.4000, alto * 0.4307, 180, 200, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.5115, ancho * 0.7272, alto * 0.4615, 235, 120, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeLine(letra.getX() + ancho * 0.0363, letra.getY() + alto * 1, letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.0769);//Líneas
                gc.strokeLine(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.0769, letra.getX() + ancho * 0.7454, letra.getY() + alto * 0.6769);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.5384, ancho * 0.4909, alto * 0.4307, 180, 200, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.2081, letra.getY() + alto * 0.5115, ancho * 0.7272, alto * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeLine(letra.getX() + (ancho+3) * 0.0363, letra.getY() + (alto - 3) * 1, letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.0769);//Líneas
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.0769, letra.getX() + (ancho+3) * 0.7454, letra.getY() + (alto - 3) * 0.6769);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2727, letra.getY() + (alto - 3) * 0.5384, (ancho+3) * 0.4909, (alto - 3) * 0.4307, 180, 200, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2081, letra.getY() + (alto - 3) * 0.5115, (ancho+3) * 0.7272, (alto - 3) * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0109, letra.getY() + alto * 0.9830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3609, letra.getY() + alto * 0.0730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7309, letra.getY() + alto * 0.6630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2609, letra.getY() + alto * 0.7330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3509, letra.getY() + alto * 0.8930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9009, letra.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4909, letra.getY() + alto * 0.4307, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*-0.5937, letra.getY() +alto*0.3454, ancho*0.9375, alto*0.5454, 290, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*-0.0625, letra.getY() +alto*0.6363, ancho*0.6250, alto*0.3636, 10, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*-0.0312, letra.getY() +alto*0.6545, ancho*0.625, alto*0.3636, -35, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*0.6181, ancho*0.6562, alto*0.3636, 230, 110, ArcType.OPEN);

            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -0.6875, letra.getY() + alto * 0.3636, ancho * 0.9375, alto * 0.5454, 310, 42, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * -0.0625, letra.getY() + alto * 0.6363, ancho * 0.6250, alto * 0.3636, 32, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * -0.0312, letra.getY() + alto * 0.6545, ancho * 0.6250, alto * 0.3636, -35, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.6181, ancho * 0.6562, alto * 0.3636, 230, 110, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -0.6875, letra.getY() + (alto - 3) * 0.3636, (ancho+3) * 0.9375, (alto - 3) * 0.5454, 310, 42, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * -0.0625, letra.getY() + (alto - 3) * 0.6363, (ancho+3) * 0.6250, (alto - 3) * 0.3636, 32, 60, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * -0.0312, letra.getY() + (alto - 3) * 0.6545, (ancho+3) * 0.6250, (alto - 3) * 0.3636, -35, 60, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.6181, (ancho+3) * 0.6562, (alto - 3) * 0.3636, 230, 110, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0309, letra.getY() + alto * 0.8230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2309, letra.getY() + alto * 0.6230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5209, letra.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9709, letra.getY() + alto * 0.8330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9375, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void t(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("T"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.0153, ancho * 0.6363, alto * 0.1846, 180, 140, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.2000, letra.getY() + alto * 0.2000, ancho * 0.8181, alto * 0.8000, 80, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.5846, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.6153);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.1692, ancho * 0.7454, alto * 0.8000, 180, 150, ArcType.OPEN);//Arco 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.0153, ancho * 0.6363, alto * 0.1846, 200, 140, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.2000, ancho * 0.8181, alto * 0.8000, 100, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.6153, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.6153);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.1692, ancho * 0.7454, alto * 0.8000, 200, 150, ArcType.OPEN);//Arco  
            }          
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.0153, (ancho+3) * 0.6363, (alto - 3) * 0.1846, 200, 140, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.2000, (ancho+3) * 0.8181, (alto - 3) * 0.8000, 100, 100, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.0909, letra.getY() + (alto - 3) * 0.6153, letra.getX() + (ancho+3) * 0.4545, letra.getY() + (alto - 3) * 0.6153);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2181, letra.getY() + (alto - 3) * 0.1692, (ancho+3) * 0.7454, (alto - 3) * 0.8000, 200, 150, ArcType.OPEN);//Arco 
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0909, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7209, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5809, letra.getY() + alto * 0.1830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 0.6030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0409, letra.getY() + alto * 0.6030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9409, letra.getY() + alto * 0.6230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.1846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8181, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7454, letra.getY() + alto * 0.8000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*-1.0937, letra.getY() +alto*0.3636, ancho*1.5625, alto*0.5454, 300, 45, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.5937, letra.getY() +alto*0.2909, letra.getX() +ancho*0.4687, letra.getY() +alto*0.6727);
                gc.strokeArc(letra.getX() +ancho*0.5312, letra.getY() +alto*0.1272, ancho*0.0625, alto*0.3818, 0, 100, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.5000, letra.getY() +alto*0.1454, ancho*0.0625, alto*1.7272, 60, 90, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.4687, letra.getY() +alto*0.2545, ancho*0.5625, alto*0.7090, 190, 130, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.2812, letra.getY() +alto*0.4545, letra.getX() +ancho*0.8125, letra.getY() +alto*0.4909);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * -1.2187, letra.getY() + alto * 0.3636, ancho * 1.5625, alto * 0.5454, 310, 45, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.1636, ancho * 0.0625, alto * 0.4545, 0, 360, ArcType.OPEN); //curva central
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.2545, ancho * 0.7500, alto * 0.7090, 190, 143, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.1250, letra.getY() + alto * 0.4545, letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.4545);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * -1.2187, letra.getY() + (alto - 3) * 0.3636, (ancho+3) * 1.5625, (alto - 3) * 0.5454, 310, 45, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.1636, (ancho+3) * 0.0625, (alto - 3) * 0.4545, 0, 360, ArcType.OPEN); //curva central
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.2545, (ancho+3) * 0.7500, (alto - 3) * 0.7090, 190, 143, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.1250, letra.getY() + (alto - 3) * 0.4545, letra.getX() + (ancho+3) * 0.6250, letra.getY() + (alto - 3) * 0.4545);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0209, letra.getY() + alto * 0.8230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3309, letra.getY() + alto * 0.6330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9909, letra.getY() + alto * 0.7530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0709, letra.getY() + alto * 0.4230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6409, letra.getY() + alto * 0.4230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.5625, letra.getY() + alto * 0.5454, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0625, letra.getY() + alto * 0.4545, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7500, letra.getY() + alto * 0.7090, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void u(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("U"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.6461, ancho * 0.4000, alto * 0.3076, 185, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.1384, letra.getX() + ancho * 0.5818, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.5818, letra.getY() + alto * 0.6307, ancho * 0.3636, alto * 0.3384, 185, 160, ArcType.OPEN);//Arco   
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.6461, ancho * 0.4000, alto * 0.3076, 185, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.1076, letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6363, letra.getY() + alto * 0.6307, ancho * 0.3272, alto * 0.3384, 185, 170, ArcType.OPEN);//Arco 
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0181, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.2181, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.3076, letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.8000);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.6461, (ancho+3) * 0.4000, (alto - 3) * 0.3076, 185, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6363, letra.getY() + (alto - 3) * 0.1076, letra.getX() + (ancho+3) * 0.6363, letra.getY() + (alto - 3) * 0.8000);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6363, letra.getY() + (alto - 3) * 0.6307, (ancho+3) * 0.3272, (alto - 3) * 0.3384, 185, 170, ArcType.OPEN);//Arco  
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0109, letra.getY() + alto * 0.2230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.2330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6209, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6209, letra.getY() + alto * 0.0930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9509, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.3384, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.6545, ancho*0.3125, alto*0.5090, 90, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0937, letra.getY() +alto*0.5818, ancho*0.2187, alto*0.3636, -30, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.2968, letra.getY() +alto*0.6181, ancho*0.4062, alto*0.3636, 180, 120, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.7187, letra.getY() +alto*0.6727, letra.getX() +ancho*0.6875, letra.getY() +alto*0.9272);
                gc.strokeArc(letra.getX() +ancho*0.6875, letra.getY() +alto*0.6000, ancho*0.3437, alto*0.3818, 180, 165, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.6545, ancho * 0.2500, alto * 0.1818, -10, 200, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2968, letra.getY() + alto * 0.6181, ancho * 0.4062, alto * 0.3636, 180, 180, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.7031, letra.getY() + alto * 0.6727, letra.getX() + ancho * 0.7031, letra.getY() + alto * 0.8000);
                gc.strokeArc(letra.getX() + ancho * 0.7031, letra.getY() + alto * 0.6000, ancho * 0.3437, alto * 0.3818, 180, 175, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.6545, (ancho+3) * 0.2500, (alto - 3) * 0.1818, -10, 200, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2968, letra.getY() + (alto - 3) * 0.6181, (ancho+3) * 0.4062, (alto - 3) * 0.3636, 180, 180, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.7031, letra.getY() + (alto - 3) * 0.6727, letra.getX() + (ancho+3) * 0.7031, letra.getY() + (alto - 3) * 0.8000);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7031, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.3437, (alto - 3) * 0.3818, 180, 175, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0209, letra.getY() + alto * 0.7830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2509, letra.getY() + alto * 0.7830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6809, letra.getY() + alto * 0.7630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6809, letra.getY() + alto * 0.6230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0109, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.1818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4062, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.3818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void v(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("V"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.6461, ancho * 0.4000, alto * 0.3076, 185, 170, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.3454, letra.getY() + alto * 0.1076, ancho * 0.3272, alto * 0.7692, 280, 140, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5818, letra.getY() + alto * 0, ancho * 0.5636, alto * 0.1538, 220, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2000, letra.getY() + alto * 0.5230, ancho * 0.7672, alto * 0.4615, 225, 120, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.6461, ancho * 0.4000, alto * 0.3076, 185, 170, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.1076, ancho * 0.3272, alto * 0.7692, 290, 140, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.0000, ancho * 0.5636, alto * 0.1538, 240, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1781, letra.getY() + alto * 0.5015, ancho * 0.7672, alto * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0181, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.2181, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.3076, letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.8000);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.6461, (ancho+3) * 0.4000, (alto - 3) * 0.3076, 185, 170, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4000, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.3272, (alto - 3) * 0.7692, 290, 140, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5454, letra.getY() + (alto - 3) * 0.0000, (ancho+3) * 0.5636, (alto - 3) * 0.1538, 240, 60, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1781, letra.getY() + (alto - 3) * 0.5015, (ancho+3) * 0.7672, (alto - 3) * 0.4615, 235, 120, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0109, letra.getY() + alto * 0.2230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.2330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6209, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5909, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9509, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3009, letra.getY() + alto * 0.8830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9209, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5636, letra.getY() + alto * 0.1538, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7672, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.6545, ancho*0.3437, alto*0.5090, 90, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0937, letra.getY() +alto*0.5818, ancho*0.2500, alto*0.3636, -30, 70, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.3437, letra.getY() +alto*0.8545, letra.getX() +ancho*0.3125, letra.getY() +alto*0.9818);
                gc.strokeLine(letra.getX() +ancho*0.4062, letra.getY() +alto*0.9818, letra.getX() +ancho*0.6875, letra.getY() +alto*0.7454);
                gc.strokeArc(letra.getX() +ancho*0.5937, letra.getY() +alto*0.3818, ancho*0.6250, alto*0.4363, 220, 67, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.6090, ancho * 0.2187, alto * 0.1818, 18, 180, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.3750, letra.getY() + alto * 0.9818);
                gc.strokeLine(letra.getX() + ancho * 0.4375, letra.getY() + alto * 0.9818, letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.7272);
                gc.strokeArc(letra.getX() + ancho * 0.5937, letra.getY() + alto * 0.3636, ancho * 0.6250, alto * 0.4363, 220, 67, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.6090, (ancho+3) * 0.2187, (alto - 3) * 0.1818, 18, 180, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2812, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.3750, letra.getY() + (alto - 3) * 0.9818);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4375, letra.getY() + (alto - 3) * 0.9818, letra.getX() + (ancho+3) * 0.6562, letra.getY() + (alto - 3) * 0.7272);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5937, letra.getY() + (alto - 3) * 0.3636, (ancho+3) * 0.6250, (alto - 3) * 0.4363, 220, 67, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0209, letra.getY() + alto * 0.7830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2509, letra.getY() + alto * 0.7030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3709, letra.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6209, letra.getY() + alto * 0.7030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9809, letra.getY() + alto * 0.7630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.1818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.4363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void w(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("W"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.6461, ancho * 0.2727, alto * 0.3076, 185, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.1538, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.4363, letra.getY() + alto * 0.6461, ancho * 0.2727, alto * 0.3076, 185, 170, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.6181, letra.getY() + alto * 0.1076, ancho * 0.1454, alto * 0.7692, 280, 140, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.0000, ancho * 0.3272, alto * 0.1538, 220, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.5115, ancho * 0.7672, alto * 0.4615, 275, 80, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.6461, ancho * 0.2727, alto * 0.3076, 185, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.1076, letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.4909, letra.getY() + alto * 0.6461, ancho * 0.2727, alto * 0.3076, 185, 170, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.6545, letra.getY() + alto * 0.1076, ancho * 0.1454, alto * 0.7692, 290, 140, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.0000, ancho * 0.3272, alto * 0.1538, 240, 60, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1981, letra.getY() + alto * 0.5115, ancho * 0.7672, alto * 0.4615, 275, 80, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0181, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.2181, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.3076, letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.8000);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.6461, (ancho+3) * 0.2727, (alto - 3) * 0.3076, 185, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.5090, letra.getY() + (alto - 3) * 0.1076, letra.getX() + (ancho+3) * 0.5090, letra.getY() + (alto - 3) * 0.8000);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4909, letra.getY() + (alto - 3) * 0.6461, (ancho+3) * 0.2727, (alto - 3) * 0.3076, 185, 170, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6545, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.1454, (alto - 3) * 0.7692, 290, 140, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7272, letra.getY() + (alto - 3) * 0.0000, (ancho+3) * 0.3272, (alto - 3) * 0.1538, 240, 60, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1981, letra.getY() + (alto - 3) * 0.5115, (ancho+3) * 0.7672, (alto - 3) * 0.4615, 275, 80, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0109, letra.getY() + alto * 0.2230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.2330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4809, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4809, letra.getY() + alto * 0.0930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7209, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9509, letra.getY() + alto * 0.1230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5709, letra.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9609, letra.getY() + alto * 0.6930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2727, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1454, letra.getY() + alto * 0.7692, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3272, letra.getY() + alto * 0.1538, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7672, letra.getY() + alto * 0.4615, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.6545, ancho*0.2812, alto*0.5090, 90, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0937, letra.getY() +alto*0.5818, ancho*0.1875, alto*0.3636, -30, 70, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.2812, letra.getY() +alto*0.7272, letra.getX() +ancho*0.2500, letra.getY() +alto*0.9818);
                gc.strokeLine(letra.getX() +ancho*0.3437, letra.getY() +alto*0.9818, letra.getX() +ancho*0.5000, letra.getY() +alto*0.7818);
                gc.strokeLine(letra.getX() +ancho*0.5312, letra.getY() +alto*0.7818, letra.getX() +ancho*0.5937, letra.getY() +alto*0.9818);
                gc.strokeLine(letra.getX() +ancho*0.8125, letra.getY() +alto*0.7272, letra.getX() +ancho*0.6562, letra.getY() +alto*0.9454);
                gc.strokeArc(letra.getX() +ancho*0.7500, letra.getY() +alto*0.3818, ancho*0.6250, alto*0.4363, 220, 40, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.6181, ancho * 0.1875, alto * 0.1818, 18, 180, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2187, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.9818);
                gc.strokeLine(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.9818, letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.7818);
                gc.strokeLine(letra.getX() + ancho * 0.4687, letra.getY() + alto * 0.7818, letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.9818);
                gc.strokeLine(letra.getX() + ancho * 0.8125, letra.getY() + alto * 0.7272, letra.getX() + ancho * 0.6562, letra.getY() + alto * 0.9454);
                gc.strokeArc(letra.getX() + ancho * 0.7500, letra.getY() + alto * 0.3818, ancho * 0.6250, alto * 0.4363, 220, 40, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.6181, (ancho+3) * 0.1875, (alto - 3) * 0.1818, 18, 180, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2187, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.2812, letra.getY() + (alto - 3) * 0.9818);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.9818, letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.7818);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4687, letra.getY() + (alto - 3) * 0.7818, letra.getX() + (ancho+3) * 0.6250, letra.getY() + (alto - 3) * 0.9818);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.8125, letra.getY() + (alto - 3) * 0.7272, letra.getX() + (ancho+3) * 0.6562, letra.getY() + (alto - 3) * 0.9454);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7500, letra.getY() + (alto - 3) * 0.3818, (ancho+3) * 0.6250, (alto - 3) * 0.4363, 220, 40, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0209, letra.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2109, letra.getY() + alto * 0.6530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2809, letra.getY() + alto * 0.9730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4709, letra.getY() + alto * 0.7430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6409, letra.getY() + alto * 0.9730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7909, letra.getY() + alto * 0.6930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0509, letra.getY() + alto * 0.7930, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1875, letra.getY() + alto * 0.1818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6250, letra.getY() + alto * 0.4363, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void x(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("X"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() + ancho * 0.1454, letra.getY() + alto * 0.9846, letra.getX() + ancho * 0.7818, letra.getY() + alto * 0.1230);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0000, letra.getY() + alto * 0.0769, ancho * 0.4000, alto * 0.3076, 0, 130, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.4090, letra.getY() + alto * 0.2153, letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.4545, letra.getY() + alto * 0.5846, ancho * 0.4181, alto * 0.3846, 200, 140, ArcType.OPEN);//Arco
            }else{ //letra normal
                gc.strokeLine(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.9846, letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.0769);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.0000, letra.getY() + alto * 0.0769, ancho * 0.4000, alto * 0.3076, 20, 130, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.4090, letra.getY() + alto * 0.2153, letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.6000, letra.getY() + alto * 0.5846, ancho * 0.3636, alto * 0.3846, 200, 150, ArcType.OPEN);//Arco     
            }       
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeLine(letra.getX() + (ancho+3) * 0.1818, letra.getY() + (alto - 3) * 0.9846, letra.getX() + (ancho+3) * 0.7272, letra.getY() + (alto - 3) * 0.0769);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0000, letra.getY() + (alto - 3) * 0.0769, (ancho+3) * 0.4000, (alto - 3) * 0.3076, 20, 130, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4090, letra.getY() + (alto - 3) * 0.2153, letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 0.8000);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 0.5846, (ancho+3) * 0.3636, (alto - 3) * 0.3846, 200, 150, ArcType.OPEN);//Arco   
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.1509, letra.getY() + alto * 0.9730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7030, letra.getY() + alto * 0.0609, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0130, letra.getY() + alto * 0.1409, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3730, letra.getY() + alto * 0.1409, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5830, letra.getY() + alto * 0.8009, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9430, letra.getY() + alto * 0.7609, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.5818, ancho*0.3125, alto*0.4909, 70, 100, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.3125, letra.getY() +alto*0.6181, letra.getX() +ancho*0.5000, letra.getY() +alto*0.8909);
                gc.strokeArc(letra.getX() +ancho*0.4375, letra.getY() +alto*0.5454, ancho*0.5812, alto*0.4128, 240, 100, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*-0.0937, letra.getY() +alto*0.6000, ancho*0.4375, alto*0.3818, 250, 50, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.6562, letra.getY() +alto*0.6727, letra.getX() +ancho*0.3125, letra.getY() +alto*0.9272);
                gc.strokeArc(letra.getX() +ancho*0.6562, letra.getY() +alto*0.6363, ancho*0.250, alto*0.1272, 60, 70, ArcType.OPEN);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.6181, ancho * 0.2500, alto * 0.3125, 50, 140, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.6545, letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.8909);
                gc.strokeArc(letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.5454, ancho * 0.3125, alto * 0.4128, 240, 110, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * -0.1875, letra.getY() + alto * 0.6000, ancho * 0.5625, alto * 0.3818, 270, 50, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.6727, letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.9090);
                gc.strokeArc(letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.6363, ancho * 0.2500, alto * 0.1272, 60, 70, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.6181, (ancho+3) * 0.2500, (alto - 3) * 0.3125, 50, 140, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2812, letra.getY() + (alto - 3) * 0.6545, letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.8909);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.5454, (ancho+3) * 0.3125, (alto - 3) * 0.4128, 240, 110, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * -0.1875, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.5625, (alto - 3) * 0.3818, 270, 50, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.6727, letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.9090);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.6363, (ancho+3) * 0.2500, (alto - 3) * 0.1272, 60, 70, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0230, letra.getY() + alto * 0.8009, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2430, letra.getY() + alto * 0.6509, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7230, letra.getY() + alto * 0.8809, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0130, letra.getY() + alto * 0.7509, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0230, letra.getY() + alto * 0.9709, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3030, letra.getY() + alto * 0.9109, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7230, letra.getY() + alto * 0.6409, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9430, letra.getY() + alto * 0.6509, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.3125, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.4128, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5625, letra.getY() + alto * 0.3818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2500, letra.getY() + alto * 0.1272, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void y(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("Y"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, -20, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.6461, ancho * 0.4727, alto * 0.3076, 185, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.1384, letra.getX() + ancho * 0.6363, letra.getY() + alto * 1.2307);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.4545, letra.getY() + alto * 1.0769, ancho * 0.1818, alto * 0.3846, 110, 250, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.5090, letra.getY() + alto * 1.0923, letra.getX() + ancho * 0.9454, letra.getY() + alto * 0.7692);//Línea 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0181, letra.getY() + alto * 0.1076, ancho * 0.2181, alto * 0.3076, 0, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.3076, letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.8000);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.2363, letra.getY() + alto * 0.6461, ancho * 0.4727, alto * 0.3076, 185, 170, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.7090, letra.getY() + alto * 0.1076, letra.getX() + ancho * 0.7090, letra.getY() + alto * 1.2307);//Línea
                gc.strokeArc(letra.getX() + ancho * 0.5272, letra.getY() + alto * 1.0769, ancho * 0.1818, alto * 0.3846, 110, 250, ArcType.OPEN);//Arco
                gc.strokeLine(letra.getX() + ancho * 0.6000, letra.getY() + alto * 1.0769, letra.getX() + ancho * 0.9454, letra.getY() + alto * 0.7692);//Línea
            }            
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0181, letra.getY() + (alto - 3) * 0.1076, (ancho+3) * 0.2181, (alto - 3) * 0.3076, 0, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.3076, letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.8000);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.2363, letra.getY() + (alto - 3) * 0.6461, (ancho+3) * 0.4727, (alto - 3) * 0.3076, 185, 170, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.7090, letra.getY() + (alto - 3) * 0.1076, letra.getX() + (ancho+3) * 0.7090, letra.getY() + (alto - 3) * 1.2307);//Línea
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5272, letra.getY() + (alto - 3) * 1.0769, (ancho+3) * 0.1818, (alto - 3) * 0.3846, 110, 250, ArcType.OPEN);//Arco
            gc.strokeLine(letra.getX() + (ancho+3) * 0.6000, letra.getY() + (alto - 3) * 1.0769, letra.getX() + (ancho+3) * 0.9454, letra.getY() + (alto - 3) * 0.7692);//Línea    
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0109, letra.getY() + alto * 0.2230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.2330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2209, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.0730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 1.2430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5609, letra.getY() + alto * 1.0730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9209, letra.getY() + alto * 0.7530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2181, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4727, letra.getY() + alto * 0.3076, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.3846, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() +ancho*0.0312, letra.getY() +alto*0.6545, ancho*0.3125, alto*0.5090, 90, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.0937, letra.getY() +alto*0.5818, ancho*0.2187, alto*0.3636, -30, 70, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.2968, letra.getY() +alto*0.6181, ancho*0.4062, alto*0.3636, 200, 130, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*0.7500, letra.getY() +alto*0.6545, letra.getX() +ancho*0.6250, letra.getY() +alto*1.3090);
                gc.strokeArc(letra.getX() +ancho*0.4062, letra.getY() +alto*1.0625, ancho*0.2500, alto*0.3272, 100, 255, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*1.0312, letra.getY() +alto*0.8545, letra.getX() +ancho*0.5312, letra.getY() +alto*1.0727);
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.0312, letra.getY() + alto * 0.6363, ancho * 0.2812, alto * 0.1818, 0, 180, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.6000, ancho * 0.4062, alto * 0.3636, 180, 180, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.7187, letra.getY() + alto * 0.6545, letra.getX() + ancho * 0.7187, letra.getY() + alto * 1.1272);
                gc.strokeArc(letra.getX() + ancho * 0.4375, letra.getY() + alto * 1.0545, ancho * 0.2812, alto * 0.2727, 110, 255, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 1.0625, letra.getY() + alto * 0.8000, letra.getX() + ancho * 0.5312, letra.getY() + alto * 1.0727);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.0312, letra.getY() + (alto - 3) * 0.6363, (ancho+3) * 0.2812, (alto - 3) * 0.1818, 0, 180, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.6000, (ancho+3) * 0.4062, (alto - 3) * 0.3636, 180, 180, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 0.6545, letra.getX() + (ancho+3) * 0.7187, letra.getY() + (alto - 3) * 1.1272);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.4375, letra.getY() + (alto - 3) * 1.0545, (ancho+3) * 0.2812, (alto - 3) * 0.2727, 110, 255, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 1.0625, letra.getY() + (alto - 3) * 0.8000, letra.getX() + (ancho+3) * 0.5312, letra.getY() + (alto - 3) * 1.0727);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0109, letra.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2909, letra.getY() + alto * 0.7230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.7630, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 0.6230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6909, letra.getY() + alto * 1.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4909, letra.getY() + alto * 1.0430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0409, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.1818, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4062, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.2727, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
    }

    public static void z(GraphicsContext gc, Abecedario letra)
    {
        int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.esLetraMinuscula(letra.getCaracter()), letra.getTam());
        int ancho = anchoAlto[0];
        int alto = anchoAlto[1];
        if (letra.getCaracter().equals("Z"))
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.0461, ancho * 0.3636, alto * 0.2153, -370, 140, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.0615, ancho * 0.4000, alto * 0.1538, 220, 120, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.9454, letra.getY() + alto * 0.1230, letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.9538);//Líneas
                gc.strokeLine(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.5076, letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.5692);
                gc.strokeArc(letra.getX() + ancho * 0.1636, letra.getY() + alto * 0.8307, ancho * 0.4000, alto * 0.2153, -360, 140, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.5454, letra.getY() + alto * 0.7846, ancho * 0.3636, alto * 0.2000, 210, 140, ArcType.OPEN); 
            }else{ //letra normal
                gc.strokeArc(letra.getX() + ancho * 0.1818, letra.getY() + alto * 0.0461, ancho * 0.3636, alto * 0.2153, -350, 140, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.5090, letra.getY() + alto * 0.0153, ancho * 0.4000, alto * 0.1538, 200, 140, ArcType.OPEN);
                gc.strokeLine(letra.getX() + ancho * 0.9090, letra.getY() + alto * 0.1230, letra.getX() + ancho * 0.1090, letra.getY() + alto * 0.9538);//Líneas
                gc.strokeLine(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.5384, letra.getX() + ancho * 0.7272, letra.getY() + alto * 0.5384);
                gc.strokeArc(letra.getX() + ancho * 0.1727, letra.getY() + alto * 0.8000, ancho * 0.4000, alto * 0.2153, -350, 140, ArcType.OPEN);//Arcos
                gc.strokeArc(letra.getX() + ancho * 0.5909, letra.getY() + alto * 0.7846, ancho * 0.3636, alto * 0.2000, 200, 140, ArcType.OPEN);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1818, letra.getY() + (alto - 3) * 0.0461, (ancho+3) * 0.3636, (alto - 3) * 0.2153, -350, 140, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5090, letra.getY() + (alto - 3) * 0.0153, (ancho+3) * 0.4000, (alto - 3) * 0.1538, 200, 140, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 0.9090, letra.getY() + (alto - 3) * 0.1230, letra.getX() + (ancho+3) * 0.1090, letra.getY() + (alto - 3) * 0.9538);//Líneas
            gc.strokeLine(letra.getX() + (ancho+3) * 0.3636, letra.getY() + (alto - 3) * 0.5384, letra.getX() + (ancho+3) * 0.7272, letra.getY() + (alto - 3) * 0.5384);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.1727, letra.getY() + (alto - 3) * 0.8000, (ancho+3) * 0.4000, (alto - 3) * 0.2153, -350, 140, ArcType.OPEN);//Arcos
            gc.strokeArc(letra.getX() + (ancho+3) * 0.5909, letra.getY() + (alto - 3) * 0.7846, (ancho+3) * 0.3636, (alto - 3) * 0.2000, 200, 140, ArcType.OPEN);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.1809, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5209, letra.getY() + alto * 0.1330, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.8809, letra.getY() + alto * 0.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.0609, letra.getY() + alto * 0.9430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3309, letra.getY() + alto * 0.5230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.7009, letra.getY() + alto * 0.5230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.5609, letra.getY() + alto * 0.8830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.9209, letra.getY() + alto * 0.8830, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.2153, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.1538, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4000, letra.getY() + alto * 0.2153, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3636, letra.getY() + alto * 0.2000, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
        }
        else
        {
            if (letra.getCursiva()){ //letra cursiva
                gc.strokeLine(letra.getX() +ancho*0.4687, letra.getY() +alto*0.6909, letra.getX() +ancho*0, letra.getY() +alto*0.8363);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*0.6727, ancho*0.3750, alto*0.2727, -110, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*0.9454, ancho*0.3125, alto*0.3636, -30, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() +ancho*0.3437, letra.getY() +alto*1.0909, ancho*0.2812, alto*0.2727, 110, 260, ArcType.OPEN);
                gc.strokeLine(letra.getX() +ancho*1, letra.getY() +alto*0.8363, letra.getX() +ancho*0.5000, letra.getY() +alto*1.0545);
            }else{ //letra normal
                gc.strokeLine(letra.getX() + ancho * 0.4375, letra.getY() + alto * 0.6545, letra.getX() + ancho * 0, letra.getY() + alto * 0.8181);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.6363, ancho * 0.3750, alto * 0.2727, -100, 220, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3437, letra.getY() + alto * 0.9454, ancho * 0.3125, alto * 0.3636, 0, 80, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 1.0727, ancho * 0.2812, alto * 0.2727, 110, 260, ArcType.OPEN);
            gc.strokeLine(letra.getX() + ancho * 1.0312, letra.getY() + alto * 0.8000, letra.getX() + ancho * 0.5000, letra.getY() + alto * 1.0545);
            }
            if (letra.getSubrayar())
            {
                gc.strokeLine(letra.getX(), letra.getY() + alto, letra.getX() + ancho, letra.getY() + alto);
            }
            if (letra.getNegrita())
            {
            gc.strokeLine(letra.getX() + (ancho+3) * 0.4375, letra.getY() + (alto - 3) * 0.6545, letra.getX() + (ancho+3) * 0, letra.getY() + (alto - 3) * 0.8181);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3125, letra.getY() + (alto - 3) * 0.6363, (ancho+3) * 0.3750, (alto - 3) * 0.2727, -100, 220, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3437, letra.getY() + (alto - 3) * 0.9454, (ancho+3) * 0.3125, (alto - 3) * 0.3636, 0, 80, ArcType.OPEN);
            gc.strokeArc(letra.getX() + (ancho+3) * 0.3750, letra.getY() + (alto - 3) * 1.0727, (ancho+3) * 0.2812, (alto - 3) * 0.2727, 110, 260, ArcType.OPEN);
            gc.strokeLine(letra.getX() + (ancho+3) * 1.0312, letra.getY() + (alto - 3) * 0.8000, letra.getX() + (ancho+3) * 0.5000, letra.getY() + (alto - 3) * 1.0545);
            }
            if (Utilidades.puntosDeControl)
            {
                gc.setStroke(color.RED);
                gc.strokeArc(letra.getX() + ancho * 0.0409, letra.getY() + alto * 0.7730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4409, letra.getY() + alto * 0.6230, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4109, letra.getY() + alto * 0.8730, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.6209, letra.getY() + alto * 1.1030, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.4509, letra.getY() + alto * 1.0430, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 1.0209, letra.getY() + alto * 0.7530, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3750, letra.getY() + alto * 0.2727, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.3125, letra.getY() + alto * 0.3636, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.strokeArc(letra.getX() + ancho * 0.2812, letra.getY() + alto * 0.2727, ancho * 0.0400, alto * 0.0400, 40, 360, ArcType.OPEN);
                gc.setStroke(Utilidades.color);
            }
            //letra.getSubrayado(); acuerdate de esto es un dato importante en caso de subrayar por caracter. (lo mismo con negritas) es para caracteres independientes
        }
    }
}

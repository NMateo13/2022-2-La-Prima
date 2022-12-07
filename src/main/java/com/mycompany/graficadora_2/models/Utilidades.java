package com.mycompany.graficadora_2.models;

//Importación librerías utilizadas
import com.mycompany.graficadora_2.controllers.GraficadoraController;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Utilidades
{
    //Atributos
    public static Color color = Color.BLACK;
    public static Boolean negrita = false;
    public static Boolean subrayado = false;
    public static Boolean cursiva = false;
    public static Boolean invertir = false;
    public static Boolean tamanos = false;
    //public static Boolean coma = false;
    public static Boolean primerTongo = false;
    public static Boolean puntosDeControl = false;
    public static Boolean banderaEstilos = false;
    public static Boolean guion = false;
    public static Boolean sepPalabras = false;
    public static Boolean dividirTexto = false;    
    
    public static int[] tamCanvas = new int[2];
    public static String texto = "";
    public static String inicioPalabraChar = "";
    public static String inicioEstilosChar = "";
    //public static int inicioPalabraInt = 2;
    //public static int inicioEstilosInt = 1;
    public static int interlineado = 45;
                    public static ArrayList<Abecedario> caracteres = new ArrayList<>();
                    public static ArrayList<Abecedario> frase = new ArrayList<>();
                    public static ArrayList<Abecedario> estilos = new ArrayList<>();
                    public static ArrayList<String> palabra = new ArrayList<>();
                    public static ArrayList<String> fraseStr = new ArrayList<>();
    public static int contadorGuion = 1;                
    public static Double grosorCaracter = 3.5;
    public static int tamCaracter = 0;
    public static int aux = 0;
    public static int inicio = 2;
    public static int contador = 1;
                    public static List<String> palabras = new ArrayList<>();
    
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
    
    public static void ajustarTexto(int tamCaracter)
    {
        if(tamanos)
        {
           
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
    
   /* public static int moverCarTildes(String caracter, int y) //PROBANDO CODIGO
    {
        if("Á".equals(caracter) || "É".equals(caracter)|| "Í".equals(caracter)
        || "Ó".equals(caracter) || "Ú".equals(caracter))
        {
            if( x == 0 && y == 0){
                return y = y+5;
            }
        }
        return y;
    } */
    

    public static void resetearConfig()
    {
        subrayado = false;
        negrita = false;
        cursiva = false;
        invertir = false;
        tamanos = false;
        tamCaracter=0;
        System.out.println("subrayado en reseteo: " + subrayado);
    }
    
    //public static void 
      
    //Método que cambia los estilos de las letras con el símbolo +
    public static int dividirTexto(int i, String caracter, ArrayList frase, 
    ArrayList caracteres, int x, int y, int ancho, int alto)
    {
        if (caracter.equals("^") && i != Utilidades.texto.length() || primerTongo) //Compara el largo del TEXTO
        {
            primerTongo = true;
            dividirTexto = true;

            //coma = false;
                   
            ArrayList<Abecedario> palabra = new ArrayList<>();
            ArrayList<Abecedario> estilos = new ArrayList<>();
            
            if ("N".equals(caracter) || "S".equals(caracter) || "K".equals(caracter) || "^".equals(caracter)
            || ",".equals(caracter)  || "+".equals(caracter))
            {
                banderaEstilos = true;
                Abecedario caracterMomentaneo = new Abecedario(caracter, Utilidades.tipoCaracter(caracter), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                estilos.add(caracterMomentaneo);
                caracteres.add(caracterMomentaneo);

            }else if (banderaEstilos && !sepPalabras)
            {
                frase.add(estilos);
                banderaEstilos = false;
            }   
            
            
            if (!banderaEstilos)
            {
               for (int inicioPalabraInt = i; inicioPalabraInt < Utilidades.texto.length(); inicioPalabraInt++) //Se posiciona en el inicio
                //de la palabra sin contar los estilos 
                {
                    String inicioPalabra = String.valueOf(Utilidades.texto.charAt(inicioPalabraInt));
                    if (" ".equals(inicioPalabra))
                    {
                        frase.add(palabra);
                        palabra.clear();
                        Abecedario caracterMomentaneo = new Abecedario(inicioPalabra, Utilidades.tipoCaracter(inicioPalabra), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                        palabra.add(caracterMomentaneo);
                        caracteres.add(caracterMomentaneo);
                        frase.add(caracterMomentaneo);
                        x += ancho;
                        
                        
                    }else
                    {
                        sepPalabras = true;
                        Abecedario caracterMomentaneo = new Abecedario(inicioPalabra, Utilidades.tipoCaracter(inicioPalabra), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                        palabra.add(caracterMomentaneo);
                        caracteres.add(caracterMomentaneo);
                        x += ancho;
                        
                    }
                    sepPalabras = false;
                    return x;
                    
                } 
            }    
            
           
            return x+= ancho;
            
            
            
            //for (int z = 0; z < Utilidades.texto.length()+1; z++) {
                
              /*if ((i+2) < Utilidades.texto.length())
              {
                for (int inicioEstilosInt = i; inicioEstilosInt < Utilidades.texto.length(); inicioEstilosInt++) {
                    String caracter = String.valueOf(Utilidades.texto.charAt(inicioEstilosInt));
                    if ("N".equals(caracter) || "S".equals(caracter) || "K".equals(caracter) || "^".equals(caracter)
                        || ",".equals(caracter)  || "+".equals(caracter) || " ".equals(caracter))
                    {
                        Abecedario caracterMomentaneo = new Abecedario(caracter, Utilidades.tipoCaracter(caracter), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                        estilos.add(caracterMomentaneo);
                        caracteres.add(caracterMomentaneo);
                        //estilosStr.add(caracter);
                        
                    }else{
                        frase.add(estilos);
                        break;
                    }   
                }
                
                for (int inicioPalabraInt = i+2; inicioPalabraInt < Utilidades.texto.length(); inicioPalabraInt++) //Se posiciona en el inicio
                //de la palabra sin contar los estilos 
                {
                    String inicioPalabra = String.valueOf(Utilidades.texto.charAt(inicioPalabraInt));
                    if (" ".equals(inicioPalabra))
                    {
                        frase.add(palabra);
                        palabra.clear();
                        Abecedario caracterMomentaneo = new Abecedario(inicioPalabra, Utilidades.tipoCaracter(inicioPalabra), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                        palabra.add(caracterMomentaneo);
                        caracteres.add(caracterMomentaneo);
                        frase.add(caracterMomentaneo);
                    }else
                    {
                        Abecedario caracterMomentaneo = new Abecedario(inicioPalabra, Utilidades.tipoCaracter(inicioPalabra), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                        palabra.add(caracterMomentaneo);
                        caracteres.add(caracterMomentaneo);
                    }    */
                    /*String inicioPalabra = String.valueOf(Utilidades.texto.charAt(inicioPalabraInt));
                    if(" ".equals(inicioPalabra)){
                        
                        for (int j = 0; j < palabra.size(); j++) {
                             Abecedario caracterMomentaneo = new Abecedario(palabra.get(i), Utilidades.tipoCaracter(palabra.get(i)), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                             frase.add(caracterMomentaneo);
                             
                        }
                        palabra.clear();
                        palabra.add(inicioPalabra);
                        Abecedario caracterMomentaneo = new Abecedario(palabra.get(i), Utilidades.tipoCaracter(palabra.get(i)), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                        frase.add(caracterMomentaneo);
                    }else
                    {
                                                Abecedario caracterMomentaneo = new Abecedario(palabra.get(i), Utilidades.tipoCaracter(palabra.get(i)), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                        palabra.add(inicioPalabra); //ArayyList   
                    
                Utilidades.caracteres = caracteres;   
                Utilidades.frase = frase;
                }  
            }*/
        }
        return x;
    }
    
    public static void validarSiglas(String caracter, int i)
    {
        
        
    
    }    
    
    /*public static void activar()
    {
        if()
    }*/
    
    /*public static String transformadorObStr(Abecedario palabra){
        
        
        
        
        
        return " ";
    }*/

    
    public static void desactivarEstilos(String caracter)
    {
        //preguntar si es un espacio para desactivar negrita subrayado o cursiva.
        if (caracter.equals("^") && primerTongo)
        {
            Utilidades.resetearConfig();
            GraficadoraController.unaConfig = false;
            GraficadoraController.dosConfig = false;
            GraficadoraController.tresConfig = false;
        }
    }
    
    public static int cuatroEstilosSimples(int i, String caracter)
    {
        //ESTILO + ESTILO + ESTILO + TAMAÑO Y COMBINACIONES POSIBLES
        //N+S+K+TXX
        if ((i + 9) < Utilidades.texto.length())
        {
            String selectorPostTongo = Utilidades.texto.substring(i + 1, i + 10);
            if (selectorPostTongo.equals("N+S+K+T10") || selectorPostTongo.equals("N+S+K+T11") 
            || selectorPostTongo.equals("N+S+K+T12") || selectorPostTongo.equals("N+S+K+T13")
            || selectorPostTongo.equals("N+S+K+T14") || selectorPostTongo.equals("N+S+K+T15"))
            {    
            Utilidades.desactivarEstilos(caracter);
                        
            int tam = Integer.parseInt(selectorPostTongo.substring(7, 9));
            Utilidades.setTamCaracter(tam);
            Utilidades.negrita = true;  
            Utilidades.subrayado = true;
            Utilidades.cursiva = true;
            Utilidades.tamanos = true;
            GraficadoraController.dibujarTongo = false;
            GraficadoraController.tresConfig = true;
            return i += 9;
            } //N+K+S+TXX
            else if (selectorPostTongo.equals("N+K+S+T10") || selectorPostTongo.equals("N+K+S+T11") 
                    || selectorPostTongo.equals("N+K+S+T12") || selectorPostTongo.equals("N+K+S+T13")
                    || selectorPostTongo.equals("N+K+S+T14") || selectorPostTongo.equals("N+K+S+T15"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(7, 9));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //S+K+N+TXX
            else if (selectorPostTongo.equals("S+K+N+T10") || selectorPostTongo.equals("S+K+N+T11") 
                    || selectorPostTongo.equals("S+K+N+T12") || selectorPostTongo.equals("S+K+N+T13")
                    || selectorPostTongo.equals("S+K+N+T14") || selectorPostTongo.equals("S+K+N+T15"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(7, 9));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //S+N+K+TXX
            else if (selectorPostTongo.equals("S+N+K+T10") || selectorPostTongo.equals("S+N+K+T11") 
                    || selectorPostTongo.equals("S+N+K+T12") || selectorPostTongo.equals("S+N+K+T13")
                    || selectorPostTongo.equals("S+N+K+T14") || selectorPostTongo.equals("S+N+K+T15"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(7, 9));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //K+N+S+TXX
            else if (selectorPostTongo.equals("K+N+S+T10") || selectorPostTongo.equals("K+N+S+T11") 
                    || selectorPostTongo.equals("K+N+S+T12") || selectorPostTongo.equals("K+N+S+T13")
                    || selectorPostTongo.equals("K+N+S+T14") || selectorPostTongo.equals("K+N+S+T15"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(7, 9));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //K+S+N+TXX    
            else if (selectorPostTongo.equals("K+S+N+T10") || selectorPostTongo.equals("K+S+N+T11") 
                    || selectorPostTongo.equals("K+S+N+T12") || selectorPostTongo.equals("K+S+N+T13")
                    || selectorPostTongo.equals("K+S+N+T14") || selectorPostTongo.equals("K+S+N+T15"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(7, 9));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //N+S+TXX+K    
            else if (selectorPostTongo.equals("N+S+T10+K") || selectorPostTongo.equals("N+S+T11+K") 
                    || selectorPostTongo.equals("N+S+T12+K") || selectorPostTongo.equals("N+S+T13+K")
                    || selectorPostTongo.equals("N+S+T14+K") || selectorPostTongo.equals("N+S+T15+K"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //N+K+TXX+S     
            else if (selectorPostTongo.equals("N+K+T10+S") || selectorPostTongo.equals("N+K+T11+S") 
                    || selectorPostTongo.equals("N+K+T12+S") || selectorPostTongo.equals("N+K+T13+S")
                    || selectorPostTongo.equals("N+K+T14+S") || selectorPostTongo.equals("N+K+T15+S"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //S+N+TXX+K    
            else if (selectorPostTongo.equals("S+N+T10+K") || selectorPostTongo.equals("S+N+T11+K") 
                    || selectorPostTongo.equals("S+N+T12+K") || selectorPostTongo.equals("S+N+T13+K")
                    || selectorPostTongo.equals("S+N+T14+K") || selectorPostTongo.equals("S+N+T15+K"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //S+K+TXX+N   
            else if (selectorPostTongo.equals("S+K+T10+N") || selectorPostTongo.equals("S+K+T11+N") 
                    || selectorPostTongo.equals("S+K+T12+N") || selectorPostTongo.equals("S+K+T13+N")
                    || selectorPostTongo.equals("S+K+T14+N") || selectorPostTongo.equals("S+K+T15+N"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //K+N+TXX+S     
            else if (selectorPostTongo.equals("K+N+T10+S") || selectorPostTongo.equals("K+N+T11+S") 
                    || selectorPostTongo.equals("K+N+T12+S") || selectorPostTongo.equals("K+N+T13+S")
                    || selectorPostTongo.equals("K+N+T14+S") || selectorPostTongo.equals("K+N+T15+S"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //K+S+TXX+N     
            else if (selectorPostTongo.equals("K+S+T10+N") || selectorPostTongo.equals("K+S+T11+N") 
                    || selectorPostTongo.equals("K+S+T12+N") || selectorPostTongo.equals("K+S+T13+N")
                    || selectorPostTongo.equals("K+S+T14+N") || selectorPostTongo.equals("K+S+T15+N"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //N+TXX+S+K   
            else if (selectorPostTongo.equals("N+T10+S+K") || selectorPostTongo.equals("N+T11+S+K") 
                    || selectorPostTongo.equals("N+T12+S+K") || selectorPostTongo.equals("N+T13+S+K")
                    || selectorPostTongo.equals("N+T14+S+K") || selectorPostTongo.equals("N+T15+S+K"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //N+TXX+K+S   
            else if (selectorPostTongo.equals("N+T10+K+S") || selectorPostTongo.equals("N+T11+K+S") 
                    || selectorPostTongo.equals("N+T12+K+S") || selectorPostTongo.equals("N+T13+K+S")
                    || selectorPostTongo.equals("N+T14+K+S") || selectorPostTongo.equals("N+T15+K+S"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //S+TXX+N+K   
            else if (selectorPostTongo.equals("S+T10+N+K") || selectorPostTongo.equals("S+T11+N+K") 
                    || selectorPostTongo.equals("S+T12+N+K") || selectorPostTongo.equals("S+T13+N+K")
                    || selectorPostTongo.equals("S+T14+N+K") || selectorPostTongo.equals("S+T15+N+K"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //S+TXX+K+N   
            else if (selectorPostTongo.equals("S+T10+K+N") || selectorPostTongo.equals("S+T11+K+N") 
                    || selectorPostTongo.equals("S+T12+K+N") || selectorPostTongo.equals("S+T13+K+N")
                    || selectorPostTongo.equals("S+T14+K+N") || selectorPostTongo.equals("S+T15+K+N"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //K+TXX+N+S   
            else if (selectorPostTongo.equals("K+T10+N+S") || selectorPostTongo.equals("K+T11+N+S") 
                    || selectorPostTongo.equals("K+T12+N+S") || selectorPostTongo.equals("K+T13+N+S")
                    || selectorPostTongo.equals("K+T14+N+S") || selectorPostTongo.equals("K+T15+N+S"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //K+TXX+S+N   
            else if (selectorPostTongo.equals("K+T10+S+N") || selectorPostTongo.equals("K+T11+S+N") 
                    || selectorPostTongo.equals("K+T12+S+N") || selectorPostTongo.equals("K+T13+S+N")
                    || selectorPostTongo.equals("K+T14+S+N") || selectorPostTongo.equals("K+T15+S+N"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //TXX+N+S+K
            else if (selectorPostTongo.equals("T10+N+S+K") || selectorPostTongo.equals("T11+N+S+K") 
                    || selectorPostTongo.equals("T12+N+S+K") || selectorPostTongo.equals("T13+N+S+K")
                    || selectorPostTongo.equals("T14+N+S+K") || selectorPostTongo.equals("T15+N+S+K"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //TXX+N+K+S
            else if (selectorPostTongo.equals("T10+N+K+S") || selectorPostTongo.equals("T11+N+K+S") 
                    || selectorPostTongo.equals("T12+N+K+S") || selectorPostTongo.equals("T13+N+K+S")
                    || selectorPostTongo.equals("T14+N+K+S") || selectorPostTongo.equals("T15+N+K+S"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //TXX+S+N+K
            else if (selectorPostTongo.equals("T10+S+N+K") || selectorPostTongo.equals("T11+S+N+K") 
                    || selectorPostTongo.equals("T12+S+N+K") || selectorPostTongo.equals("T13+S+N+K")
                    || selectorPostTongo.equals("T14+S+N+K") || selectorPostTongo.equals("T15+S+N+K"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //TXX+S+K+N
            else if (selectorPostTongo.equals("T10+S+K+N") || selectorPostTongo.equals("T11+S+K+N") 
                    || selectorPostTongo.equals("T12+S+K+N") || selectorPostTongo.equals("T13+S+K+N")
                    || selectorPostTongo.equals("T14+S+K+N") || selectorPostTongo.equals("T15+S+K+N"))
            {     
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //TXX+K+N+S
            else if (selectorPostTongo.equals("T10+K+N+S") || selectorPostTongo.equals("T11+K+N+S") 
                    || selectorPostTongo.equals("T12+K+N+S") || selectorPostTongo.equals("T13+K+N+S")
                    || selectorPostTongo.equals("T14+K+N+S") || selectorPostTongo.equals("T15+K+N+S"))
            {  
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            } //TXX+K+S+N
            else if (selectorPostTongo.equals("T10+K+S+N") || selectorPostTongo.equals("T11+K+S+N") 
                    || selectorPostTongo.equals("T12+K+S+N") || selectorPostTongo.equals("T13+K+S+N")
                    || selectorPostTongo.equals("T14+K+S+N") || selectorPostTongo.equals("T15+K+S+N"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 9;
            }      
        }
        return i;
    }        
    
    public static int tresEstilosSimples(int i, String caracter)
    {
        //ESTILO + ESTILO + TAMAÑO Y COMBINACIONES POSIBLES                
                if ((i + 7) < Utilidades.texto.length())
                { 
                    String selectorPostTongo = Utilidades.texto.substring(i + 1, i + 8);
                    //N+S+TXX
                    if (selectorPostTongo.equals("N+S+T10") || selectorPostTongo.equals("N+S+T11")
                            || selectorPostTongo.equals("N+S+T12") || selectorPostTongo.equals("N+S+T13")
                            || selectorPostTongo.equals("N+S+T14") || selectorPostTongo.equals("N+S+T15"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //N+K+TXX
                    else if (selectorPostTongo.equals("N+K+T10") || selectorPostTongo.equals("N+K+T11")
                            || selectorPostTongo.equals("N+K+T12") || selectorPostTongo.equals("N+K+T13")
                            || selectorPostTongo.equals("N+K+T14") || selectorPostTongo.equals("N+K+T15"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.cursiva = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //S+N+TXX
                    else if (selectorPostTongo.equals("S+N+T10") || selectorPostTongo.equals("S+N+T11")
                            || selectorPostTongo.equals("S+N+T12") || selectorPostTongo.equals("S+N+T13")
                            || selectorPostTongo.equals("S+N+T14") || selectorPostTongo.equals("S+N+T15"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //S+K+TXX
                    else if (selectorPostTongo.equals("S+K+T10") || selectorPostTongo.equals("S+K+T11")
                            || selectorPostTongo.equals("S+K+T12") || selectorPostTongo.equals("S+K+T13")
                            || selectorPostTongo.equals("S+K+T14") || selectorPostTongo.equals("S+K+T15"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //K+N+TXX
                    else if (selectorPostTongo.equals("K+N+T10") || selectorPostTongo.equals("K+N+T11")
                            || selectorPostTongo.equals("K+N+T12") || selectorPostTongo.equals("K+N+T13")
                            || selectorPostTongo.equals("K+N+T14") || selectorPostTongo.equals("K+N+T15"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.negrita = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //K+S+TXX
                    else if (selectorPostTongo.equals("K+S+T10") || selectorPostTongo.equals("K+S+T11")
                            || selectorPostTongo.equals("K+S+T12") || selectorPostTongo.equals("K+S+T13")
                            || selectorPostTongo.equals("K+S+T14") || selectorPostTongo.equals("K+S+T15"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(5, 7));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //N+TXX+S
                    else if (selectorPostTongo.equals("N+T10+S") || selectorPostTongo.equals("N+T11+S")
                            || selectorPostTongo.equals("N+T12+S") || selectorPostTongo.equals("N+T13+S")
                            || selectorPostTongo.equals("N+T14+S") || selectorPostTongo.equals("N+T15+S"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //N+TXX+K
                    else if (selectorPostTongo.equals("N+T10+K") || selectorPostTongo.equals("N+T11+K")
                            || selectorPostTongo.equals("N+T12+K") || selectorPostTongo.equals("N+T13+K")
                            || selectorPostTongo.equals("N+T14+K") || selectorPostTongo.equals("N+T15+K"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.cursiva = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //S+TXX+N
                    else if (selectorPostTongo.equals("S+T10+N") || selectorPostTongo.equals("S+T11+N")
                            || selectorPostTongo.equals("S+T12+N") || selectorPostTongo.equals("S+T13+N")
                            || selectorPostTongo.equals("S+T14+N") || selectorPostTongo.equals("S+T15+N"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //S+TXX+K
                    else if (selectorPostTongo.equals("S+T10+K") || selectorPostTongo.equals("S+T11+K")
                            || selectorPostTongo.equals("S+T12+K") || selectorPostTongo.equals("S+T13+K")
                            || selectorPostTongo.equals("S+T14+K") || selectorPostTongo.equals("S+T15+K"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //K+TXX+N
                    else if (selectorPostTongo.equals("K+T10+N") || selectorPostTongo.equals("K+T11+N")
                            || selectorPostTongo.equals("K+T12+N") || selectorPostTongo.equals("K+T13+N")
                            || selectorPostTongo.equals("K+T14+N") || selectorPostTongo.equals("K+T15+N"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.negrita = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //K+TXX+S
                    else if (selectorPostTongo.equals("K+T10+S") || selectorPostTongo.equals("K+T11+S")
                            || selectorPostTongo.equals("K+T12+S") || selectorPostTongo.equals("K+T13+S")
                            || selectorPostTongo.equals("K+T14+S") || selectorPostTongo.equals("K+T15+S"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //TXX+N+S
                    else if (selectorPostTongo.equals("T10+N+S") || selectorPostTongo.equals("T11+N+S")
                            || selectorPostTongo.equals("T12+N+S") || selectorPostTongo.equals("T13+N+S")
                            || selectorPostTongo.equals("T14+N+S") || selectorPostTongo.equals("T15+N+S"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //TXX+N+K
                    else if (selectorPostTongo.equals("T10+N+K") || selectorPostTongo.equals("T11+N+K")
                            || selectorPostTongo.equals("T12+N+K") || selectorPostTongo.equals("T13+N+K")
                            || selectorPostTongo.equals("T14+N+K") || selectorPostTongo.equals("T15+N+K"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.cursiva = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //TXX+S+N
                    else if (selectorPostTongo.equals("T10+S+N") || selectorPostTongo.equals("T11+S+N")
                            || selectorPostTongo.equals("T12+S+N") || selectorPostTongo.equals("T13+S+N")
                            || selectorPostTongo.equals("T14+S+N") || selectorPostTongo.equals("T15+S+N"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.negrita = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //TXX+S+K
                    else if (selectorPostTongo.equals("T10+S+K") || selectorPostTongo.equals("T11+S+K")
                            || selectorPostTongo.equals("T12+S+K") || selectorPostTongo.equals("T13+S+K")
                            || selectorPostTongo.equals("T14+S+K") || selectorPostTongo.equals("T15+S+K"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //TXX+K+N
                    else if (selectorPostTongo.equals("T10+K+N") || selectorPostTongo.equals("T11+K+N")
                            || selectorPostTongo.equals("T12+K+N") || selectorPostTongo.equals("T13+K+N")
                            || selectorPostTongo.equals("T14+K+N") || selectorPostTongo.equals("T15+K+N"))
                    {
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.negrita = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    } //TXX+K+S
                    else if (selectorPostTongo.equals("T10+K+S") || selectorPostTongo.equals("T11+K+S")
                            || selectorPostTongo.equals("T12+K+S") || selectorPostTongo.equals("T13+K+S")
                            || selectorPostTongo.equals("T14+K+S") || selectorPostTongo.equals("T15+K+S"))
                    {   
                        Utilidades.desactivarEstilos(caracter);
                        
                        int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                        Utilidades.setTamCaracter(tam);
                        Utilidades.cursiva = true;  
                        Utilidades.subrayado = true;
                        Utilidades.tamanos = true;
                        GraficadoraController.dibujarTongo = false;
                        GraficadoraController.tresConfig = true;
                        return i += 7;
                    }     
                }
                return i;
    }        
    
   public static int dosEstilosSimples(int i, String caracter)
   {
        //ESTILO + TAMAÑO Y COMBINACIONES POSIBLES                
        //ESTILO+ ESTILO+ ESTILO Y COMBINACIONES POSIBLES
        if ((i + 5) < Utilidades.texto.length())
        {
            String selectorPostTongo = Utilidades.texto.substring(i + 1, i + 6);
            //System.out.println("selectorPostTongo: " + selectorPostTongo);
            if (selectorPostTongo.equals("N+S+K") || selectorPostTongo.equals("N+K+S")
                    || selectorPostTongo.equals("K+N+S") || selectorPostTongo.equals("K+S+N")
                    || selectorPostTongo.equals("S+N+K") || selectorPostTongo.equals("S+K+N"))
            {
                Utilidades.desactivarEstilos(caracter);

                Utilidades.negrita = true;
                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.tresConfig = true;
                return i += 5;
            } //N+TXX
            else if (selectorPostTongo.equals("N+T10") || selectorPostTongo.equals("N+T11") 
                    || selectorPostTongo.equals("N+T12") || selectorPostTongo.equals("N+T13")
                    || selectorPostTongo.equals("N+T14") || selectorPostTongo.equals("N+T15"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 5;
            } //TXX+N
            else if (selectorPostTongo.equals("T10+N") || selectorPostTongo.equals("T11+N") //^TXX+N
                    || selectorPostTongo.equals("T12+N") || selectorPostTongo.equals("T13+N")
                    || selectorPostTongo.equals("T14+N") || selectorPostTongo.equals("T15+N"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.negrita = true;  
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 5;
            } //S+TXX
            else if (selectorPostTongo.equals("S+T10") || selectorPostTongo.equals("S+T11") //^S+TXX
                    || selectorPostTongo.equals("S+T12") || selectorPostTongo.equals("S+T13")
                    || selectorPostTongo.equals("S+T14") || selectorPostTongo.equals("S+T15"))
            {    
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.subrayado = true; 
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 5;
            } //TXX+S
            else if (selectorPostTongo.equals("T10+S") || selectorPostTongo.equals("T11+S") //^TXX+S
                    || selectorPostTongo.equals("T12+S") || selectorPostTongo.equals("T13+S")
                    || selectorPostTongo.equals("T14+S") || selectorPostTongo.equals("T15+S"))
            {   
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.subrayado = true; 
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 5;
            } //K+TXX
            else if (selectorPostTongo.equals("K+T10") || selectorPostTongo.equals("K+T11") //^K+TXX
                    || selectorPostTongo.equals("K+T12") || selectorPostTongo.equals("K+T13")
                    || selectorPostTongo.equals("K+T14") || selectorPostTongo.equals("K+T15"))
            {
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(3, 5));
                Utilidades.setTamCaracter(tam);
                Utilidades.cursiva = true; 
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 5;
            } //TXX+K
            else if (selectorPostTongo.equals("T10+K") || selectorPostTongo.equals("T11+K") //^TXX+K
                    || selectorPostTongo.equals("T12+K") || selectorPostTongo.equals("T13+K")
                    || selectorPostTongo.equals("T14+K") || selectorPostTongo.equals("T15+K"))
            {
                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.cursiva = true;
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 5;
            }                       
        }
        
        //TAMAÑO SOLO
        //ESTILO + ESTILO Y COMBINACIONES POSIBLES
        if ((i + 3) < Utilidades.texto.length())
        {
            String selectorPostTongo = Utilidades.texto.substring(i + 1, i + 4);
            System.out.println("selectorPostTongo: " + selectorPostTongo);
            if (selectorPostTongo.equals("N+S") || selectorPostTongo.equals("S+N"))
            {
                Utilidades.desactivarEstilos(caracter);

                Utilidades.negrita = true;
                Utilidades.subrayado = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 3;

            }
            else if (selectorPostTongo.equals("N+K") || selectorPostTongo.equals("K+N"))
            {
                Utilidades.desactivarEstilos(caracter);

                Utilidades.negrita = true;
                Utilidades.cursiva = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 3;
            }
            else if (selectorPostTongo.equals("K+S") || selectorPostTongo.equals("S+K"))
            {
                Utilidades.desactivarEstilos(caracter);

                Utilidades.subrayado = true;
                Utilidades.cursiva = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.dosConfig = true;
                return i += 3;
            }
            else if (selectorPostTongo.equals("T10") || selectorPostTongo.equals("T11")
                    || selectorPostTongo.equals("T12") || selectorPostTongo.equals("T13")
                    || selectorPostTongo.equals("T14") || selectorPostTongo.equals("T15"))
            {

                Utilidades.desactivarEstilos(caracter);

                int tam = Integer.parseInt(selectorPostTongo.substring(1, 3));
                Utilidades.setTamCaracter(tam);
                Utilidades.tamanos = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.unaConfig = true;
                return i += 3;
            }
        }
        
        return i;
   }      
   
   public static int unEstilo(int i, String caracter)
   {
        //ESTILO SOLO
        if ((i + 1) < Utilidades.texto.length() && !GraficadoraController.dosConfig
           && !GraficadoraController.tresConfig)
        {
            String selectorPostTongo = String.valueOf(Utilidades.texto.charAt(i + 1));
            System.out.println("selectorPostTongo: " + selectorPostTongo);
            if (selectorPostTongo.equals("N"))
            {

                Utilidades.desactivarEstilos(caracter);

                Utilidades.negrita = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.unaConfig = true;
                return i += 1;
            }
            else if (selectorPostTongo.equals("S"))
            {
                Utilidades.desactivarEstilos(caracter);

                Utilidades.subrayado = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.unaConfig = true;
                return i += 1;
            }
            else if (selectorPostTongo.equals("K"))
            {
                Utilidades.desactivarEstilos(caracter);

                Utilidades.cursiva = true;
                GraficadoraController.dibujarTongo = false;
                GraficadoraController.unaConfig = true;
                return i += 1;
            }
            else if (selectorPostTongo.equals("R"))
            {

                GraficadoraController.dibujarTongo = false;
                return i+=1;
            }
        }
        return i; 
   }        
   
    

    //Expresiones regulares utilizadas para validar los caracteres que se ingresan.
    //Método dónde se validan caracteres que se pueden ingresar al programa.
    public static Boolean validacionCaracter(String caracter)
    {
        //mayusculas, minusculas, Ñ, ñ, simbolos, mayusculas con tildes, minusculas con tildes
        String expresion = "[A-Za-z\\u00f1\\u00d1]|\\s|\\?|\\¿|\\!|\\¡|\\u002E|"
                + "\\u002C|\\u003B|\\u003A|\\u2026|\\u201C|\\u201D|\\u0022|"
                + "\\u2018|\\u2019|\\u0027|\\u00AB|\\u00BB|\\u0028|\\u0029|"
                + "\\u005B|\\u005D|\\u007B|\\u007D|\\u002D|\\u005F|\\u005E|"
                + "\\u002B|\\u0030|\\u0031|\\u0032|\\u0033|\\u0034|\\u0035|"
                + "\\u00C1|\\u00C9|\\u00CD|\\u00D3|\\u00DA|\\u00E1|\\u00E9|"
                + "\\u00ED|\\u00F3|\\u00FA"; 
        return Pattern.matches(expresion, caracter);
    }

    //Método para limpiar Canvas
    public static void limpiarCanvas(GraphicsContext gc, Canvas canvas)
    {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    

    public static String tipoCaracter(String caracter)
    {
        String expresion1 = "[A-Z\\u00d1\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA]"; //Ñ, Á, É, Í, Ó, Ú
        String expresion2 = "[a-z\\u00f1\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA]"; //ñ, á, é, í, ó, ú
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

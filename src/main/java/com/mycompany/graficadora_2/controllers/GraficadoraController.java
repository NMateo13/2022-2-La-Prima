package com.mycompany.graficadora_2.controllers;

//Importación librerías necesarias
import com.mycompany.graficadora_2.models.Abecedario;
import com.mycompany.graficadora_2.models.FormulasLetras;
import com.mycompany.graficadora_2.models.FormulasSimbolos;
import com.mycompany.graficadora_2.models.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GraficadoraController implements Initializable
{

    //Variables utilizadas
    @FXML
    private Canvas canvas;
    @FXML
    private TextField texto;
    @FXML
    private ColorPicker selectorColor;
    public static GraphicsContext gc;
    ArrayList<Abecedario> caracteres = new ArrayList<>();
    public static Boolean unaConfig;
    public static Boolean dosConfig;
    public static Boolean tresConfig;
    public static Boolean masConfig;
    public static Boolean dibujarTongo;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Instancias
        this.gc = canvas.getGraphicsContext2D();
        this.gc.setLineWidth(Utilidades.grosorCaracter);
        this.gc.setStroke(Utilidades.color);
    }

    @FXML
    //Método que valida los caracteres que pueden ser ingresados. 
    //Avisa por consola si el caracter es inválido.
    private void detectarTexto(KeyEvent e)
    {
        if (!Utilidades.validacionCaracter(String.valueOf(e.getCharacter())))
        {
            System.out.println("caracter ingresado no valido");
            e.consume();
        }
    }

    //Método encargado de pintar caracteres en el panel.
    private void pintar()
    {
        this.gc.setStroke(Utilidades.color);
        for (int i = 0; i < Utilidades.caracteres.size(); i++)
        {
            if (Utilidades.caracteres.get(i).getTipoCarater().equals("mayuscula"))
            {
                dibujarLetra(Utilidades.caracteres.get(i));
            }
            if (Utilidades.caracteres.get(i).getTipoCarater().equals("minuscula"))
            {
                dibujarLetra(Utilidades.caracteres.get(i));
            }
            else
            {
                dibujarSimbolo(Utilidades.caracteres.get(i));
            }
        }
    }

    //Método encargado de aplicar subrayado a los caracteres.
    private void subrayar()
    {
        Utilidades.subrayado = !Utilidades.subrayado;
        pintar();
    }

    //Método encargado de cambiar de color a los caracteres.
    @FXML
    private void cambioColor(ActionEvent e)
    {
        Utilidades.color = this.selectorColor.getValue();
        Utilidades.limpiarCanvas(this.gc, this.canvas);
        pintar();
    }

    //Método encargado de aplicar puntos de control a los caracteres./&%&%$#$%&/&%$#"#$%&%$#"#$%
    @FXML
    private void puntosDeControl(MouseEvent e)
    {
        Utilidades.puntosDeControl = !Utilidades.puntosDeControl;
        Utilidades.limpiarCanvas(this.gc, this.canvas);
        pintar();
    }

    //Método encargado de recibir los parámetros ingresados por el usuario.
    //Guarda las palabras ingresadas para luego ser dibujadas.
    //dibujar ahora tiene el poder de ingresar negrita cursiva y subrayar.
    @FXML
    private void dibujar(KeyEvent e)
    {
        Utilidades.resetearConfig(); //Resetea subrayado, negrita y cursiva
        Utilidades.texto = this.texto.getText();
        Utilidades.limpiarCanvas(this.gc, this.canvas); //Limpia el canvas
        ArrayList<Abecedario> caracteres = new ArrayList<>();
        
        int x = 0;
        int y = 0;

        for (int i = 0; i < Utilidades.texto.length(); i++)
        {
            dibujarTongo = true;
            String caracter = String.valueOf(Utilidades.texto.charAt(i)); //crea y recibe el caracter correspondiente
            

            //pregunta si es un tongo para saber si es negrita subrayado o cursiva
            //Boolean dosConfig = false;
            //Boolean tresConfig = false;
            unaConfig = false;
            dosConfig = false;
            tresConfig = false;
            
            //retorna la i para seguir con el ciclo
            i = Utilidades.estilos(i, caracter); //cambio de estilos de las palabras, con el +

            if (((caracter.equals("^") && dibujarTongo) || !caracter.equals("^"))
                    && !caracter.equals("0") && !caracter.equals("1") && !caracter.equals("2") && !caracter.equals("3") && !caracter.equals("4") && !caracter.equals("5"))
            {
                
                int[] anchoAlto = Utilidades.anchoAltoLetra(Utilidades.tipoCaracter(caracter), Utilidades.tamCaracter);
                int ancho = anchoAlto[0];
                int alto = anchoAlto[1];
                
                y = Utilidades.moverCarTildes(caracter, y); //PROBANDO CODIGO

                Abecedario caracterMomentaneo = new Abecedario(caracter, Utilidades.tipoCaracter(caracter), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                caracteres.add(caracterMomentaneo);
                //Salto y aplicacion guion
                x += ancho;
                if (x > 1150)
                {
                    for (int j = 0; j < Utilidades.texto.length(); j++)
                    {
                        if (Utilidades.texto.charAt(i) != ' ')
                        {
                            Abecedario guion = new Abecedario("-", Utilidades.tipoCaracter("-"), x, y, Utilidades.negrita, Utilidades.subrayado, Utilidades.cursiva, Utilidades.tamCaracter);
                            caracteres.add(guion);
                        }
                    }
                    y += alto + Utilidades.interlineado;
                    x = 0;
                }
            }
        }
        Utilidades.caracteres = caracteres;
        pintar();
    }

    //Método encargado de validar que símbolo será dibujado.
    private void dibujarSimbolo(Abecedario caracter)
    {
        if (caracter.getCaracter().equals("?"))
        {
            FormulasSimbolos.cierreInterrogacion(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("¿"))
        {
            FormulasSimbolos.aperturaInterrogacion(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("!"))
        {
            FormulasSimbolos.cierreExclamacion(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("¡"))
        {
            FormulasSimbolos.aperturaExclamacion(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("."))
        {
            FormulasSimbolos.punto(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals(","))
        {
            FormulasSimbolos.coma(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals(";"))
        {
            FormulasSimbolos.puntoComa(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals(":"))
        {
            FormulasSimbolos.dosPuntos(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("…"))
        {
            FormulasSimbolos.puntosSuspensivo(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("\""))
        {
            FormulasSimbolos.comillaDoble(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("“"))
        {
            FormulasSimbolos.aperturaComillaDoble(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("”"))
        {
            FormulasSimbolos.cierreComillaDoble(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("\'"))
        {
            FormulasSimbolos.comillaSimple(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("‘"))
        {
            FormulasSimbolos.aperturaComillaSimple(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("’"))
        {
            FormulasSimbolos.cierreComillaSimple(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("«"))
        {
            FormulasSimbolos.aperturaComillaEspanola(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("»"))
        {
            FormulasSimbolos.cierreComillaEspanola(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("("))
        {
            FormulasSimbolos.aperturaParentesis(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals(")"))
        {
            FormulasSimbolos.cierreParentesis(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("["))
        {
            FormulasSimbolos.aperturaCorchete(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("]"))
        {
            FormulasSimbolos.cierreCorchete(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("{"))
        {
            FormulasSimbolos.aperturaLlave(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("}"))
        {
            FormulasSimbolos.cierreLlave(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("-"))
        {
            FormulasSimbolos.guion(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("_"))
        {
            FormulasSimbolos.guionBajo(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals(" "))
        {
            FormulasSimbolos.espacio(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("^"))
        {
            FormulasSimbolos.acentoCircunflejo(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("+"))
        {
            FormulasSimbolos.signoMas(this.gc, caracter);
        }
        

    }

    //Método encargaod de validar que letra será dibujada (Sea mayúscula o minúscula).
    private void dibujarLetra(Abecedario caracter)
    {
        if (caracter.getCaracter().equals("A") || caracter.getCaracter().equals("a"))
        {
            FormulasLetras.a(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("Á") || caracter.getCaracter().equals("á")) //PROBANDO CODIGO
        {
            FormulasLetras.atildes(this.gc, caracter);
        }    
        else if (caracter.getCaracter().equals("B") || caracter.getCaracter().equals("b"))
        {
            FormulasLetras.b(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("C") || caracter.getCaracter().equals("c"))
        {
            FormulasLetras.c(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("D") || caracter.getCaracter().equals("d"))
        {
            FormulasLetras.d(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("E") || caracter.getCaracter().equals("e"))
        {
            FormulasLetras.e(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("É") || caracter.getCaracter().equals("é"))
        {
            FormulasLetras.etildes(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("F") || caracter.getCaracter().equals("f"))
        {
            FormulasLetras.f(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("G") || caracter.getCaracter().equals("g"))
        {
            FormulasLetras.g(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("H") || caracter.getCaracter().equals("h"))
        {
            FormulasLetras.h(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("I") || caracter.getCaracter().equals("i"))
        {
            FormulasLetras.i(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("Í") || caracter.getCaracter().equals("í"))
        {
            FormulasLetras.itildes(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("J") || caracter.getCaracter().equals("j"))
        {
            FormulasLetras.j(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("K") || caracter.getCaracter().equals("k"))
        {
            FormulasLetras.k(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("L") || caracter.getCaracter().equals("l"))
        {
            FormulasLetras.l(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("M") || caracter.getCaracter().equals("m"))
        {
            FormulasLetras.m(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("N") || caracter.getCaracter().equals("n"))
        {
            FormulasLetras.n(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("Ñ") || caracter.getCaracter().equals("ñ"))
        {
            FormulasLetras.nLatina(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("O") || caracter.getCaracter().equals("o"))
        {
            FormulasLetras.o(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("Ó") || caracter.getCaracter().equals("ó"))
        {
            FormulasLetras.otildes(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("P") || caracter.getCaracter().equals("p"))
        {
            FormulasLetras.p(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("Q") || caracter.getCaracter().equals("q"))
        {
            FormulasLetras.q(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("R") || caracter.getCaracter().equals("r"))
        {
            FormulasLetras.r(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("S") || caracter.getCaracter().equals("s"))
        {
            FormulasLetras.s(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("T") || caracter.getCaracter().equals("t"))
        {
            FormulasLetras.t(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("U") || caracter.getCaracter().equals("u"))
        {
            FormulasLetras.u(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("Ú") || caracter.getCaracter().equals("ú"))
        {
            FormulasLetras.utildes(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("V") || caracter.getCaracter().equals("v"))
        {
            FormulasLetras.v(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("W") || caracter.getCaracter().equals("w"))
        {
            FormulasLetras.w(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("X") || caracter.getCaracter().equals("x"))
        {
            FormulasLetras.x(this.gc, caracter);
        }
        else if (caracter.getCaracter().equals("Y") || caracter.getCaracter().equals("y"))
        {
            FormulasLetras.y(this.gc, caracter);
        }
        else
        {
            FormulasLetras.z(this.gc, caracter);
        }
    }
}

package com.mycompany.graficadora_2.models;

public class Abecedario
{

    //Atributos
    private String caracter;
    private String tipoCaracter;
    private Boolean negrita;
    private Boolean subrayar;
    private Boolean cursiva;
    private int tam;
    private int[] coordenadas = new int[2];

    //Constructor
    public Abecedario(String caracter, String tipoCaracter, int x, int y, Boolean negrita, Boolean subrayar, Boolean cursiva, int tam)
    {
        this.negrita = negrita;
        this.subrayar = subrayar;
        this.cursiva = cursiva;
        this.caracter = caracter;
        this.tipoCaracter = tipoCaracter;
        this.coordenadas[0] = x;
        this.coordenadas[1] = y;
        this.tam = tam;

    }

    //Métodos Getter & Setter de caracteres, tipos y coordenadas.
    public String getCaracter()
    {
        return this.caracter;
    }

    public void setCaracter(String caracter)
    {
        this.caracter = caracter;
    }

    public String getTipoCarater()
    {
        return this.tipoCaracter;
    }

    public void setTipoCaracter(String tipoCaracter)
    {
        this.tipoCaracter = tipoCaracter;
    }

    public int[] getCoordenadas()
    {
        return this.coordenadas;
    }

    public void setCoordenadas(int x, int y)
    {
        this.coordenadas[0] = x;
        this.coordenadas[1] = y;
    }

    public int getX()
    {
        return this.coordenadas[0];
    }

    public void setX(int x)
    {
        this.coordenadas[0] = x;
    }

    public int getY()
    {
        return this.coordenadas[1];
    }

    public void setY(int y)
    {
        this.coordenadas[1] = y;
    }

    public Boolean getNegrita()
    {
        return negrita;
    }

    public void setNegrita(Boolean negrita)
    {
        this.negrita = negrita;
    }

    public Boolean getSubrayar()
    {
        return subrayar;
    }

    public void setSubrayar(Boolean subrayar)
    {
        this.subrayar = subrayar;
    }

    public Boolean getCursiva() {
        return cursiva;
    }

    public void setCursiva(Boolean cursiva) {
        this.cursiva = cursiva;
    } 

    public int getTam()
    {
        return tam;
    }

    public void setTam(int tam)
    {
        this.tam = tam;
    }

}

package Librerias.EstructurasDatos.Modelos;

import Librerias.EstructurasDatos.Jerarquicas.NodoAB;

public interface I_ABEnteros<Integer> extends I_AB<Integer>
{
    public boolean comprobarSuma();
    public void mostrarAscendientes(int elem, NodoAB<Integer> nodo, NodoAB<Integer> padre);
    public int sumaNodosNiveles(int nivelInferior, int nivelSuperior, NodoAB<Integer> nodo, int nivel);
    public int totalImparesNivel(int nivel, NodoAB<Integer> nodo, int nivelActual);
}

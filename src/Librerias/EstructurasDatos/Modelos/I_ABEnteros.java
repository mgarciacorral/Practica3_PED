package Librerias.EstructurasDatos.Modelos;

import Librerias.EstructurasDatos.Jerarquicas.NodoAB;

public interface I_ABEnteros
{
    public boolean esVacio();
    public void vaciar();
    public NodoAB<Integer> getRaiz();
    public void insertar(int elem, int padre, char lugar);
    public void eliminar(int elem);
    public boolean pertenece(int elem);
}

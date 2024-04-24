package Librerias.EstructurasDatos.Modelos;

import Librerias.EstructurasDatos.Jerarquicas.NodoAB;

public interface I_AB <E>
{
    public boolean esVacio();
    public void vaciar();
    public NodoAB<E> getRaiz();
    public void insertar(E elem, E padre, char lugar);
    public void eliminar(E elem);
    public boolean pertenece(E elem);
}

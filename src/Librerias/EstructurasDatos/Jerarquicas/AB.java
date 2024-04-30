package Librerias.EstructurasDatos.Jerarquicas;

import Librerias.EstructurasDatos.Modelos.I_AB;

public class AB<E> implements I_AB<E>
{
    NodoAB<E> raiz;

    public AB()
    {
        this.raiz = null;
    }

    //indica si el arbol esta vacio
    public boolean esVacio()
    {
        return this.raiz == null;
    }

    //vacia el arbol
    public void vaciar()
    {
        this.raiz = null;
    }

    //devuelve la raiz del arbol
    public NodoAB<E> getRaiz()
    {
        return this.raiz;
    }

    //setea la raiz del arbol
    public void setRaiz(NodoAB<E> raiz)
    {
        this.raiz = raiz;
    }

    //inserta un elemento en el arbol
    public void insertar(E elem)
    {
        NodoAB<E> nodo = new NodoAB<E>(elem);
        if (this.raiz == null)
        {
            this.raiz = nodo;
        }
        else
        {
            this.raiz.insertar(nodo);
        }
    }

    //muestra el arbol en inorden
    public void inOrder()
    {
        if (this.raiz != null)
        {
            this.raiz.inOrder();
        }
    }

    //muestra el arbol en inorden de forma inversa
    public void inOrderConverso()
    {
        if (this.raiz != null)
        {
            this.raiz.inOrderConverso();
        }
    }

    //muestra el arbol en preorden
    public void preOrder()
    {
        if (this.raiz != null)
        {
            this.raiz.preOrder();
        }
    }

    //muestra el arbol en postorden
    public void postOrder()
    {
        if (this.raiz != null)
        {
            this.raiz.postOrder();
        }
    }

    //inserta un elemento en el arbol
    public void insertar(E elem,  E padre, char lugar)
    {
        NodoAB<E> nodo = new NodoAB<E>(elem);
        if (this.raiz == null)
        {
            this.raiz = nodo;
        }
        else
        {
            NodoAB<E> nodoPadre = buscarElemento(padre);
            if (nodoPadre != null)
            {
                if (lugar == 'I')
                {
                    nodoPadre.setIzq(nodo);
                }
                else
                {
                    nodoPadre.setDer(nodo);
                }
            }
        }
    }

    //busca un elemento dado en el arbol
    public NodoAB<E> buscarElemento(E elem)
    {
        return raiz.buscarElemento(elem);
    }

    //elimina un elemento dado del arbol
    public void eliminar(E elem)
    {
        if (this.raiz != null)
        {
            if (this.raiz.getDato().equals(elem))
            {
                this.raiz = null;
            }
            else
            {
                this.raiz.eliminar(elem);
            }
        }
    }

    //indica si un elemento dado pertenece o no al arbol de forma recursiva
    public boolean pertenece(E elem)
    {
        return raiz.buscarElemento(elem) != null;
    }

    //indica si un elemento dado pertenece o no al arbol
    public boolean pertenecePorDato(int elem, NodoAB<E> nodo){
        if(nodo != null){
            if((Integer) nodo.getDato() == elem){
                return true;
            }else{
                return pertenecePorDato(elem, nodo.getIzq()) || pertenecePorDato(elem, nodo.getDer());
            }
        }else{
            return false;
        }

    }

    //vacia el arbol de forma recursiva
    public void vaciarModo2(NodoAB<E> padre, NodoAB<E> nodo) {
        if (nodo != null) {
            if (nodo.getIzq() != null){
                vaciarModo2(nodo, nodo.getIzq());
            }
            if (nodo.getDer() != null) {
                vaciarModo2(nodo, nodo.getDer());
            }
            if (padre != null) {
                if (padre.getIzq() == nodo) {
                    padre.setIzq(null);
                } else if (padre.getDer() == nodo) {
                    padre.setDer(null);
                }
            } else{
                setRaiz(null);
            }
        }
    }

    //devuelve en numero de niveles que tiene el arbol
    public int calcularNivelArbol(NodoAB<E> nodo, int nivel){
        int nivelIzq = 0;
        int nivelDer = 0;
        if(nodo != null){
            nivelIzq = calcularNivelArbol(nodo.getIzq(), nivel + 1);
            nivelDer = calcularNivelArbol(nodo.getDer(), nivel + 1);
            if(nivelIzq > nivelDer){
                return nivelIzq;
            }else{
                return nivelDer;
            }
        }else{
            return nivel;
        }
    }
}

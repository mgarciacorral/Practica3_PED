package Librerias.EstructurasDatos.Jerarquicas;

import Librerias.EstructurasDatos.Modelos.I_AB;

public class AB<E> implements I_AB<E>
{
    NodoAB<E> raiz;

    public AB()
    {
        this.raiz = null;
    }

    public boolean esVacio()
    {
        return this.raiz == null;
    }

    public void vaciar()
    {
        this.raiz = null;
    }

    public NodoAB<E> getRaiz()
    {
        return this.raiz;
    }

    public void setRaiz(NodoAB<E> raiz)
    {
        this.raiz = raiz;
    }

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

    public void inOrder()
    {
        if (this.raiz != null)
        {
            this.raiz.inOrder();
        }
    }

    public void inOrderConverso()
    {
        if (this.raiz != null)
        {
            this.raiz.inOrderConverso();
        }
    }

    public void preOrder()
    {
        if (this.raiz != null)
        {
            this.raiz.preOrder();
        }
    }

    public void postOrder()
    {
        if (this.raiz != null)
        {
            this.raiz.postOrder();
        }
    }

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

    public NodoAB<E> buscarElemento(E elem)
    {
        return raiz.buscarElemento(elem);
    }

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

    public boolean pertenece(E elem)
    {
        return raiz.buscarElemento(elem) != null;
    }

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

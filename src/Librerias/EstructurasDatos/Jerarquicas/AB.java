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

    public void mostrarArbol(NodoAB<E> nodo){
        if(nodo != null){
            System.out.println(nodo.getDato());
            mostrarArbol(nodo.getIzq());
            mostrarArbol(nodo.getDer());
        }
    }

    public void mostrarAscendientes(int elem, NodoAB<E> nodo, NodoAB<E> padre){

        if((Integer) this.getRaiz().getDato() != elem){
            if(nodo != null){
                if((Integer) nodo.getDato() == elem){
                    if(padre != null){
                        System.out.print(padre.getDato() + " ");
                        mostrarAscendientes((Integer) padre.getDato(), this.raiz, null);
                    }
                }else{
                    if(nodo.getIzq() != null && nodo.getDer() == null){
                        mostrarAscendientes(elem, nodo.getIzq(), nodo);
                    }else if(nodo.getIzq() == null && nodo.getDer() != null){
                        mostrarAscendientes(elem, nodo.getDer(), nodo);
                    }else if(nodo.getIzq() != null && nodo.getDer() != null){
                        if((Integer) nodo.getIzq().getDato() == (Integer) nodo.getDer().getDato()){
                            mostrarAscendientes(elem, nodo.getIzq(), nodo);
                        }else{
                            mostrarAscendientes(elem, nodo.getIzq(), nodo);
                            mostrarAscendientes(elem, nodo.getDer(), nodo);
                        }
                    }
            }
        }
    }
    }

    public int sumaNodosNiveles(int nivelInferior, int nivelSuperior, NodoAB<E> nodo, int nivel){
        int suma = 0;
        if(nodo != null){
            if(nivel >= nivelInferior && nivel <= nivelSuperior){
                suma += (Integer) nodo.getDato();
            }
            suma += sumaNodosNiveles(nivelInferior, nivelSuperior, nodo.getIzq(), nivel + 1);
            suma += sumaNodosNiveles(nivelInferior, nivelSuperior, nodo.getDer(), nivel + 1);
        }
        return suma;

    }

    public int totalImparesNivel(int nivel, NodoAB<E> nodo, int nivelActual){
        int suma = 0;
        if(nodo != null){
            if(nivel == nivelActual){
                if((Integer) nodo.getDato() % 2 != 0){
                    suma++;
                }
            }
            suma += totalImparesNivel(nivel, nodo.getIzq(), nivelActual + 1);
            suma += totalImparesNivel(nivel, nodo.getDer(), nivelActual + 1);
        }
        return suma;
    }
}

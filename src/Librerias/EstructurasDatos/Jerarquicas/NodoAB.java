package Librerias.EstructurasDatos.Jerarquicas;

public class NodoAB<E>
{
    private E dato;
    private NodoAB<E> izq;
    private NodoAB<E> der;

    public NodoAB(E dato)
    {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public NodoAB(E dato, NodoAB<E> izq, NodoAB<E> der)
    {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public E getDato()
    {
        return this.dato;
    }

    public NodoAB<E> getIzq()
    {
        return this.izq;
    }

    public NodoAB<E> getDer()
    {
        return this.der;
    }

    public void setDato(E dato)
    {
        this.dato = dato;
    }

    public void setIzq(NodoAB<E> h)
    {
        this.izq = h;
    }

    public void setDer(NodoAB<E> h)
    {
        this.der = h;
    }

    public void borrarIzq()
    {
        this.izq = null;
    }

    public void borrarDer()
    {
        this.der = null;
    }

    public boolean esHoja()
    {
        return this.izq == null && this.der == null;
    }

    public boolean esVacio()
    {
        return this.dato == null;
    }

    public String toString()
    {
        return this.dato.toString();
    }

    public void insertar(NodoAB<E> nodo)
    {
        if (this.izq == null)
        {
            this.izq = nodo;
        }
        else if (this.der == null)
        {
            this.der = nodo;
        }
        else
        {
            this.izq.insertar(nodo);
        }
    }

    public int numDescendientes()
    {
        int num = 0;
        if (this.izq != null)
        {
            num += 1 + this.izq.numDescendientes();
        }
        if (this.der != null)
        {
            num += 1 + this.der.numDescendientes();
        }
        return num;
    }

    public NodoAB<E> buscarElemento(E elem)
    {
        if (this.dato.equals(elem))
        {
            return this;
        }
        else
        {
            NodoAB<E> aux = null;
            if (this.izq != null)
            {
                aux = this.izq.buscarElemento(elem);
            }
            if (aux == null && this.der != null)
            {
                aux = this.der.buscarElemento(elem);
            }
            return aux;
        }
    }

    public void eliminar(E elem)
    {
        if (this.izq != null && this.izq.getDato().equals(elem))
        {
            this.izq = null;
        }
        else if (this.der != null && this.der.getDato().equals(elem))
        {
            this.der = null;
        }
        else
        {
            if (this.izq != null)
            {
                this.izq.eliminar(elem);
            }
            if (this.der != null)
            {
                this.der.eliminar(elem);
            }
        }
    }
    public boolean comprobarClavePequeña(NodoAB<E> nodo){
        boolean clavePequeña = false;
        if(nodo != null){
            if(nodo.getIzq() != null){
                if((Integer) nodo.getDato() <= (Integer) nodo.getIzq().getDato()){
                    clavePequeña = comprobarClavePequeña(nodo.getIzq());
                }else{
                    return false;
                }
            }
            if(nodo.getDer() != null){
                if((Integer) nodo.getDato() <= (Integer) nodo.getDer().getDato()){
                    clavePequeña = comprobarClavePequeña(nodo.getDer());
                }else{
                    return false;
                }

            }else{
            return true;
        }
        }else{
            return true;
        }
        return clavePequeña;

    }



}

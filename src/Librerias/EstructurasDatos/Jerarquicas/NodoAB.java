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

    public void inOrder()
    {
        if (this.izq != null)
        {
            this.izq.inOrder();
        }
        System.out.print(this.dato + " ");
        if (this.der != null)
        {
            this.der.inOrder();
        }
    }

    public void inOrderConverso()
    {
        if (this.der != null)
        {
            this.der.inOrderConverso();
        }
        System.out.print(this.dato + " ");
        if (this.izq != null)
        {
            this.izq.inOrderConverso();
        }
    }

    public void preOrder()
    {
        System.out.print(this.dato + " ");
        if (this.izq != null)
        {
            this.izq.preOrder();
        }
        if (this.der != null)
        {
            this.der.preOrder();
        }
    }

    public void postOrder()
    {
        if (this.izq != null)
        {
            this.izq.postOrder();
        }
        if (this.der != null)
        {
            this.der.postOrder();
        }
        System.out.print(this.dato + " ");
    }

    public boolean comprobarSuma()
    {
        if(izq != null && der != null) {
            if(izq.valorNodo() == der.valorNodo()) {
                if(this.izq != null && this.der != null){
                    return this.izq.comprobarSuma() && this.der.comprobarSuma();
                } else if (this.izq != null){
                    return this.izq.valorNodo() == 0;
                } else if (this.der != null){
                    return this.der.valorNodo() == 0;
                } else {
                    return true;
                }
            }else {
                return false;
            }
        }else if (this.izq != null){
            return this.izq.valorNodo() == 0 && izq.comprobarSuma();
        } else if (this.der != null){
            return this.der.valorNodo() == 0;
        } else {
            return true;
        }
    }

    public int valorNodo()
    {
        int valor = (Integer) this.dato;
        if (this.izq != null)
        {
            valor += this.izq.valorNodo();
        }
        if (this.der != null)
        {
            valor += this.der.valorNodo();
        }
        return valor;
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

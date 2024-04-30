package Librerias.EstructurasDatos.Jerarquicas;

import Librerias.EstructurasDatos.Modelos.I_AB;
import Librerias.EstructurasDatos.Modelos.I_ABEnteros;

public class ABEnteros<Integer> extends AB<Integer> implements I_ABEnteros<Integer>
{
    public ABEnteros()
    {
        super();
    }

    //Comprueba que la suma de los nodos de las ramas izquierda y derecha de cada nodo sea igual
    public boolean comprobarSuma()
    {
        if (this.raiz != null)
        {
            return this.raiz.comprobarSuma();
        }
        return true;
    }

    //Muestra los nodos que son ascendientes de un elemento
    public void mostrarAscendientes(int elem, NodoAB<Integer> nodo, NodoAB<Integer> padre){

        if((int) this.getRaiz().getDato() != elem){
            if(nodo != null){
                if((int) nodo.getDato() == elem){
                    if(padre != null){
                        System.out.print(padre.getDato() + " ");
                        mostrarAscendientes((int) padre.getDato(), this.raiz, null);
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

    //devuelve la sume de los nodos entre dos niveles dados
    public int sumaNodosNiveles(int nivelInferior, int nivelSuperior, NodoAB<Integer> nodo, int nivel){
        int suma = 0;
        if(nodo != null){
            if(nivel >= nivelInferior && nivel <= nivelSuperior){
                suma += (int)nodo.getDato();
            }
            suma += sumaNodosNiveles(nivelInferior, nivelSuperior, nodo.getIzq(), nivel + 1);
            suma += sumaNodosNiveles(nivelInferior, nivelSuperior, nodo.getDer(), nivel + 1);
        }
        return suma;

    }

    //devuelve la cantidad de nodos impares en un nivel dado
    public int totalImparesNivel(int nivel, NodoAB<Integer> nodo, int nivelActual){
        int suma = 0;
        if(nodo != null){
            if(nivel == nivelActual){
                if((int)nodo.getDato() % 2 != 0){
                    suma++;
                }
            }
            suma += totalImparesNivel(nivel, nodo.getIzq(), nivelActual + 1);
            suma += totalImparesNivel(nivel, nodo.getDer(), nivelActual + 1);
        }
        return suma;
    }
}

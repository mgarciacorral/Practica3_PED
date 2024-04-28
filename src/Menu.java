import Librerias.EstructurasDatos.Jerarquicas.AB;
import Librerias.EstructurasDatos.Jerarquicas.NodoAB;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Menu {

    AB<Integer>[] arboles = null;
    private int indiceArbol = 0;

    public Menu(){
        bucleMenu();
    }

    public void mostrarMenu(){
        System.out.println("\tMENU AB enteros");
        System.out.println("1. Crear arbol");
        System.out.println("2. Listado de claves en InOrden");
        System.out.println("3. Listado de claves en InOrden Converso");
        System.out.println("4. Listado de claves en PreOrden");
        System.out.println("5. Listado de claves en PostOrden");
        System.out.println("6. Comprobar suma");
        System.out.println("7. Comprobar clave pequeño");
        System.out.println("8. Vaciar arbol Modo 1 (sin rercorrer el arbol");
        System.out.println("9. Vaciar arbol Modo 2 (recorriendo todos sus nodos)");
        System.out.println("10. Mostrar ascendientes");
        System.out.println("11. Suma total entre de nodos entre niveles");
        System.out.println("12. Número de nodos impares que hay en un nivel\n");
        System.out.println("0. Salir");
    }

    public void bucleMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        while (!salir){
            mostrarMenu();
            System.out.print("Introduce una opcion: ");

            try{
            opcion = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Introduce un numero valido");
                continue;
            }

            switch(opcion){
                case 1:
                    arboles = crearArboles();
                    System.out.println("Arboles creados con éxito");
                    pause();
                    break;
                case 2:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{

                    }
                    break;
                case 3:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();

                    }else{

                    }
                    break;
                case 4:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{

                    }
                    break;
                case 5:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{

                    }
                    break;
                case 6://HASTA AQUI MATI
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{

                    }
                    break;
                case 7:
                    try{
                    AB arbol = seleccionarArbol();
                    comprobarClavePequeña(arbol);
                    pause();
                    }catch (Exception e){
                        System.out.println("El arbol no existe");
                        pause();
                        continue;
                    }
                    break;
                case 8:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{
                        AB arbol = seleccionarArbol();
                        arbol.vaciar();
                        if(arbol.esVacio()){
                            System.out.println("Arbol vaciado con exito");
                            pause();
                        }else{
                            System.out.println("Error al vaciar el arbol");
                            pause();
                        }
                        break;
                    }

                case 9:
                    try{
                        AB arbol = seleccionarArbol();
                        vaciarArbolModo2(arbol);
                        pause();
                    }catch (Exception e){
                        System.out.println("El arbol no existe");
                        pause();
                        continue;
                    }
                    break;
                case 10:
                    try{
                        AB arbol = seleccionarArbol();
                        mostrarAscendientes(arbol);
                        pause();
                        break;
                    }catch (Exception e){
                        System.out.println("El arbol no existe");
                        pause();
                        continue;
                    }

                case 11:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{

                    }
                    break;
                case 12:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{

                    }
                    break;
                case 0:
                    salir = true;
                    System.out.println("Gracias por utilizar nuestro TAD ABEnteros");
                    pause();
                    break;

                default:
                    System.out.println("Opcion no valida");
                    pause();

                    break;
            }
        }

    }

    public void pause() {
        System.out.print("\nPresiona Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public AB seleccionarArbol(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tEleccion de arbol ");
        System.out.println("1. Arbol 1");
        System.out.println("2. Arbol 2");
        System.out.print("Introduce una opcion: ");
        indiceArbol = scanner.nextInt();
        return arboles[indiceArbol-1];
    }

    public static AB<Integer>[] crearArboles(){
        AB<Integer> arbol1 = new AB<Integer>();
        arbol1.setRaiz(new NodoAB<Integer>(2, new NodoAB<Integer>(6, new NodoAB<Integer>(9), new NodoAB<Integer>(7)), new NodoAB<Integer>(5, null, new NodoAB<Integer>(8))));        AB<Integer> arbol2 = new AB<Integer>();
        arbol2.setRaiz(new NodoAB<Integer>(13, new NodoAB<Integer>(12, new NodoAB<Integer>(8), new NodoAB<Integer>(4, new NodoAB<Integer>(2), new NodoAB<Integer>(2))), new NodoAB<Integer>(34, new NodoAB<Integer>(-3, new NodoAB<Integer>(0), null), new NodoAB<Integer>(-3))));
        return new AB[]{arbol1, arbol2};
    }

    public boolean arbolVacio(){
        if(arboles == null){
            return true;
        }else{
            return false;
        }
    }


    public void comprobarClavePequeña(AB arbol){
       if(arbol.getRaiz().comprobarClavePequeña(arbol.getRaiz())){
           System.out.println("El AB" + indiceArbol + " cumple la propiedad de clave pequeña en cada nodo");
        }else{
                System.out.println("El AB" + indiceArbol + " no cumple la propiedad de clave pequeña en cada nodo");
        }

    }

    public void vaciarArbolModo2(AB arbol){
        arbol.vaciarModo2(null, arbol.getRaiz());
        if(arbol.esVacio()){
            System.out.println("Arbol vaciado con exito");
        }else{
            System.out.println("Error al vaciar el arbol");
        }
    }

    public void mostrarAscendientes(AB arbol){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un elemento: ");
        int elem = scanner.nextInt();
        if(arbol.pertenecePorDato(elem, arbol.getRaiz())){
            if((Integer) arbol.getRaiz().getDato() == elem){
                System.out.println("El elemento introducido es la raiz del arbol");
            }else{
                System.out.print("Considerando el árbol AB"+ indiceArbol +" y el índice " + elem + " sus ascendientes son: ");
                arbol.mostrarAscendientes(elem, arbol.getRaiz(), null);
            }
        }else{
            System.out.println("El elemento introducido no pertenece al arbol");
        }
    }
}

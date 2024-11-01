import Librerias.EstructurasDatos.Jerarquicas.ABEnteros;
import Librerias.EstructurasDatos.Jerarquicas.NodoAB;

import java.util.Scanner;


public class Menu {

    ABEnteros[] arboles = null;
    private int indiceArbol = 0;

    public Menu(){
        bucleMenu();
    }

    //crea un menu con las opciones de los metodos
    public void mostrarMenu(){
        System.out.println("\tMENU AB enteros");
        System.out.println("1. Crear arbol");
        System.out.println("2. Listado de claves en InOrden");
        System.out.println("3. Listado de claves en InOrden Converso");
        System.out.println("4. Listado de claves en PreOrden");
        System.out.println("5. Listado de claves en PostOrden");
        System.out.println("6. Comprobar suma");
        System.out.println("7. Comprobar clave pequeña");
        System.out.println("8. Vaciar arbol Modo 1 (sin rercorrer el arbol");
        System.out.println("9. Vaciar arbol Modo 2 (recorriendo todos sus nodos)");
        System.out.println("10. Mostrar ascendientes");
        System.out.println("11. Suma total entre de nodos entre niveles");
        System.out.println("12. Número de nodos impares que hay en un nivel\n");
        System.out.println("0. Salir");
    }

    //bucle que se ejecuta hasta que el usuario decida salir
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
                        ABEnteros arbol = seleccionarArbol();
                        arbol.inOrder();
                        pause();
                    }
                    break;
                case 3:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{
                        ABEnteros arbol = seleccionarArbol();
                        arbol.inOrderConverso();
                        pause();
                    }
                    break;
                case 4:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{
                        ABEnteros arbol = seleccionarArbol();
                        arbol.preOrder();
                        pause();
                    }
                    break;
                case 5:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{
                        ABEnteros arbol = seleccionarArbol();
                        arbol.postOrder();
                        pause();
                    }
                    break;
                case 6://HASTA AQUI MATI
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                        pause();
                    }else{
                        ABEnteros arbol = seleccionarArbol();
                        if(arbol.comprobarSuma()) {
                            System.out.println("El arbol cumple la propiedad de suma");
                        }else{
                            System.out.println("El arbol no cumple la propiedad de suma");
                        }
                        pause();
                    }
                    break;
                case 7:
                    try{
                        ABEnteros arbol = seleccionarArbol();
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
                        ABEnteros arbol = seleccionarArbol();
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
                        ABEnteros arbol = seleccionarArbol();
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
                        ABEnteros arbol = seleccionarArbol();
                        mostrarAscendientes(arbol);
                        pause();
                        break;
                    }catch (Exception e){
                        System.out.println("El arbol no existe");
                        pause();
                        continue;
                    }

                case 11:
                    try {
                        ABEnteros arbol = seleccionarArbol();
                        sumaNodosNiveles(arbol);
                        pause();
                        break;
                    }catch (Exception e){
                        System.out.println("El arbol no existe");
                        pause();
                        continue;
                    }

                case 12:
                    try {
                        ABEnteros arbol = seleccionarArbol();
                        totalImparesNivel(arbol);
                        pause();
                        break;
                    }catch (Exception e){
                        System.out.println("El arbol no existe");
                        pause();
                        continue;
                    }
                case 0:
                    salir = true;
                    System.out.println("Gracias por utilizar nuestro TAD ABEnteros");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

    }

    //metodo para pausar la ejecucion del programa
    public void pause() {
        System.out.print("\nPresiona Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    //metodo para seleccionar un arbol
    public ABEnteros seleccionarArbol(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tEleccion de arbol ");
        System.out.println("1. Arbol 1");
        System.out.println("2. Arbol 2");
        System.out.print("Introduce una opcion: ");
        indiceArbol = scanner.nextInt();
        return arboles[indiceArbol-1];
    }

    //metodo para crear los arboles
    public static ABEnteros[] crearArboles(){
        ABEnteros arbol1 = new ABEnteros();
        ABEnteros arbol2 = new ABEnteros();

        arbol1.setRaiz(new NodoAB<Integer>(2, new NodoAB<Integer>(6, new NodoAB<Integer>(9), new NodoAB<Integer>(7)), new NodoAB<Integer>(5, null, new NodoAB<Integer>(8))));
        arbol2.setRaiz(new NodoAB<Integer>(13, new NodoAB<Integer>(12, new NodoAB<Integer>(8), new NodoAB<Integer>(4, new NodoAB<Integer>(2), new NodoAB<Integer>(2))), new NodoAB<Integer>(34, new NodoAB<Integer>(-3, new NodoAB<Integer>(0), null), new NodoAB<Integer>(-3))));
        return new ABEnteros[]{arbol1, arbol2};
    }

    //metodo para comprobar si hay arboles creados
    public boolean arbolVacio(){
        return arboles == null;
    }


    //comprueba que los nodos hijos siempre son menores que sus padres
    public void comprobarClavePequeña(ABEnteros arbol){
       if(arbol.getRaiz().comprobarClavePequeña(arbol.getRaiz())){
           System.out.println("El AB" + indiceArbol + " cumple la propiedad de clave pequeña en cada nodo");
        }else{
                System.out.println("El AB" + indiceArbol + " no cumple la propiedad de clave pequeña en cada nodo");
        }

    }

    //metodo para vaciar el arbol
    public void vaciarArbolModo2(ABEnteros arbol){
        arbol.vaciarModo2(null, arbol.getRaiz());
        if(arbol.esVacio()){
            System.out.println("Arbol vaciado con exito");
        }else{
            System.out.println("Error al vaciar el arbol");
        }
    }

    //muestra los ascendientes de un nodo
    public void mostrarAscendientes(ABEnteros arbol){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un elemento: ");
        int elem = scanner.nextInt();
        if(arbol.pertenecePorDato(elem, arbol.getRaiz())){
            if((Integer) arbol.getRaiz().getDato() == elem){
                System.out.println("El elemento introducido es la raiz del arbol");
            }else{
                System.out.print("Los ascendientes de " + elem + " son: ");
                arbol.mostrarAscendientes(elem, arbol.getRaiz(), null);
            }
        }else{
            System.out.println("El elemento introducido no pertenece al arbol");
        }
    }

    //suma los nodos entre dos niveles
    public void sumaNodosNiveles(ABEnteros arbol){
        System.out.println("El AB" + indiceArbol + " tiene " + arbol.calcularNivelArbol(arbol.getRaiz(), 0) + " niveles");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nivel inferior: ");
        int nivelInferior = scanner.nextInt();
        System.out.print("Introduce el nivel superior: ");
        int nivelSuperior = scanner.nextInt();
        if(nivelSuperior > arbol.calcularNivelArbol(arbol.getRaiz(), 0)){
            System.out.println("El nivel superior no puede ser mayor al nivel del arbol");
        }else if(nivelInferior < 0 || nivelSuperior < 0){
            System.out.println("Los niveles deben ser mayores o iguales a 0");
        }else{
            if(nivelInferior > nivelSuperior){
                System.out.println("El nivel inferior debe ser menor o igual al nivel superior");
            }else{
                System.out.println("La suma de elementos entre estos niveles es " + arbol.sumaNodosNiveles(nivelInferior, nivelSuperior, arbol.getRaiz(), 0));
            }
            }
    }

    //muestra el numero de nodos impares en un nivel
    public void totalImparesNivel(ABEnteros arbol) {
            System.out.println("El AB" + indiceArbol + " tiene " + arbol.calcularNivelArbol(arbol.getRaiz(), 0) + " niveles");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el nivel: ");
            int nivel = scanner.nextInt();
            if (nivel < 0 || nivel > arbol.calcularNivelArbol(arbol.getRaiz(), 0)) {
                System.out.println("El nivel debe pertenecer al árbol");
            } else {
                System.out.println("El número de nodos impares en el nivel " + nivel + " es " + arbol.totalImparesNivel(nivel, arbol.getRaiz(), 0));
            }
    }
}


import Librerias.EstructurasDatos.Jerarquicas.AB;
import Librerias.EstructurasDatos.Jerarquicas.NodoAB;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Menu {

    AB<Integer>[] arboles = null;

    public Menu(){
        bucleMenu();
    }

    public void mostrarMenu(){
        System.out.println("\tMENU AB enteros");
        System.out.println("1. Crear arbol");
        System.out.println("2. Listado de claves en InOrden");
        System.out.println("3. Listado de claves en InOrden Converson");
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
        boolean salir = false;
        while (!salir){
            mostrarMenu();
            System.out.print("Introduce una opcion: ");
            int opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                    arboles = crearArboles();
                    break;
                case 2:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 3:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 4:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 5:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 6://HASTA AQUI MATI
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 7:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 8:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    AB arbol = seleccionarArbol();
                    arbol.vaciar();
                    break;
                case 9:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 10:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 11:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 12:
                    if(arbolVacio()){
                        System.out.println("No hay arboles creados");
                    }else{

                    }
                    break;
                case 0:
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

    }


    public AB seleccionarArbol(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tEleccion de arbol ");
        System.out.println("1. Arbol 1");
        System.out.println("2. Arbol 2");
        System.out.print("Introduce una opcion: ");
        int opcion = scanner.nextInt();
        return arboles[opcion-1];
    }

    public static AB<Integer>[] crearArboles(){
        AB<Integer> arbol1 = new AB<Integer>();
        arbol1.setRaiz(new NodoAB<Integer>(2, new NodoAB<Integer>(6, new NodoAB<Integer>(9), new NodoAB<Integer>(7)), new NodoAB<Integer>(5, null, new NodoAB<Integer>(8))));
        AB<Integer> arbol2 = new AB<Integer>();
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

}

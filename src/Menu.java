import java.util.Scanner;


public class Menu {

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
        System.out.println("12. Número de nodos impares que hay en un nivel");
    }

    public void bucleMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir){
            mostrarMenu();
            System.out.println("Introduce una opcion: ");
            int opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                    //crearArbol();
                    break;
                case 2:
                    //AB arbol = seleccionarArbol();
                    //arbol.inOrden();
                    //Listado de claves en InOrden
                    break;
                case 3:
                    //Listado de claves en InOrden Converson
                    //AB arbol = seleccionarArbol();
                    //arbol.inOrdenConverso();
                    break;
                case 4:
                    //Listado de claves en PreOrden
                    //AB arbol = seleccionarArbol();
                    //arbol.preOrden();
                    break;
                case 5:
                    //Listado de claves en PostOrden
                    //AB arbol = seleccionarArbol();
                    //arbol.postOrden();
                    break;
                case 6:
                    //Comprobar suma
                    //AB arbol = seleccionarArbol();
                    //arbol.comprobarSuma();
                    break;
                case 7:
                    //Comprobar clave pequeña
                    //AB arbol = seleccionarArbol();
                    //arbol.comprobarClavePequeña();
                    break;
                case 8:
                    //Vaciar arbol Modo 1 (sin rercorrer el arbol
                    //AB arbol = seleccionarArbol();
                    //arbol.vaciarArbol();
                    break;
                case 9:
                    //Vaciar arbol Modo 2 (recorriendo todos sus nodos)
                    //AB arbol = seleccionarArbol();
                    //arbol.vaciarArbol2();
                    break;
                case 10:
                    //Mostrar ascendientes
                    //AB arbol = seleccionarArbol();
                    //arbol.mostrarAscendientes();
                    break;
                case 11:
                    //Suma total entre de nodos entre niveles
                    //AB arbol = seleccionarArbol();
                    //arbol.sumaTotalEntreNiveles();
                    break;
                case 12:
                    //Número de nodos impares que hay en un nivel
                    //AB arbol = seleccionarArbol();
                    //arbol.nodosImparesEnNivel();
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


    public void seleccionarArbol(){

    }

}

package EjemploArraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Arraylist {

    //Atributos de la clase
    public static ArrayList<Object> ejemploArrayList = new ArrayList<>();
    public static Object elemento;
    public static boolean estado = false;
    public static boolean salirMenu = false;
    public static int opcion;
    public static int confirmacion;
    public static StringBuilder mensaje;

    public static void main(String[] args) {

        do {

            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desee:\n\n"
                        + "1. Agregar elementos\n"
                        + "2. Eliminar elementos\n"
                        + "3. Mostrar elementos\n"
                        + "4. Tamaño del ArrayList\n"
                        + "5. Ordenar elementos ascendentemente\n"
                        + "6. Ordenar elementos descendentemente\n"
                        + "7. Comparar ArrayList\n"
                        + "8. Copiar ArralList\n"
                        + "9. Buscar elemento\n"
                        + "10. Verificar si el ArrayList está vacío\n"
                        + "11. Obtener el índice de la primera aparicion de un elemento\n"
                        + "12. Obtener el índice de la última aparición de un elemento\n"
                        + "13. Obtener indice(s) de elemento(s) del ArrayList\n"
                        + "14. Obtener una porción del ArrayList\n"
                        + "15. Recuperar elementos y realizar conversiones de tipo\n"
                        + "16. Salir"));

                switch (opcion) {
                    case 1:

                        agregarArrayList(ejemploArrayList);

                        break;

                    case 2:

                        eliminarArrayList(ejemploArrayList);

                        break;

                    case 3:

                        mostrarArrayList(ejemploArrayList);

                        break;

                    case 4:

                        int sizeArraylist = tamañoArrayList(ejemploArrayList);
//                        
//                        
                        if (sizeArraylist == 0) {

                            JOptionPane.showMessageDialog(null, "El ArrayList no tiene elementos, esta vacio");

                        } else {

                            JOptionPane.showMessageDialog(null, "El tamaño del ArrayList es: " + sizeArraylist);
                        }

                        break;

                    case 5:

                        ordenarAtoZ(ejemploArrayList, new MyComparator());
                        mostrarArrayList(ejemploArrayList);

                        break;

                    case 6:

                        ordenarZtoA(ejemploArrayList, new MyComparator());
                        mostrarArrayList(ejemploArrayList);

                        break;

                    case 7:

                        ArrayList<Object> arraylist2 = new ArrayList<>();

                        int opcionComparar = Integer.parseInt(JOptionPane.showInputDialog(
                                "Inbrese el valor de acuerdo a la comparacion que desea hacer:\n\n"
                                + "1. COmparar elementos del Arralist original\n"
                                + "2. Comparar elementos entre dos Arralist"));

                        switch (opcionComparar) {

                            case 1:

                                comparacionElementosArralist(ejemploArrayList);

                                break;

                            case 2:

                                agregarArrayList(arraylist2);
                                Object elementosIguales = compararArraylist(ejemploArrayList, arraylist2);
                                JOptionPane.showMessageDialog(null,
                                        "Los elementos iguales son: " + elementosIguales);

                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Elija una opcion valida del menu comparar");
                        }

                        break;

                    case 8:

                        copiarArralist(ejemploArrayList);

                        break;

                    case 9:

                        String elementoBuscar = JOptionPane.showInputDialog("Ingrese el valor a buscar");

                        buscarElemento(ejemploArrayList, elementoBuscar);

                        break;

                    case 10:

                        boolean resultadoVacio = verificarVacio(ejemploArrayList);

                        if (resultadoVacio) {

                            JOptionPane.showMessageDialog(null, "EL ArrayList esta vacio");

                        } else {

                            JOptionPane.showMessageDialog(null, "EL ArrayList tiene elementos");
                        }

                        break;

                    case 11:

                        //verificar primer elemento
                        String indiceBuscar = JOptionPane.showInputDialog(
                                "Ingrese el elemento del cual desea se proporcione el indice");

                        int indice = buscarPrimeraAparicion(ejemploArrayList, indiceBuscar);

                        if (indice != -1) {

                            JOptionPane.showMessageDialog(null, "El elemento " + "' " + indiceBuscar
                                    + " '" + " aparece la primera vez en el indice: " + indice);

                        } else {

                            JOptionPane.showMessageDialog(null, "El elemento " + "' " + indiceBuscar
                                    + " '" + " NO se encuentra en el arralist");
                        }

                        break;

                    case 12:

                        String ultimoIndice = JOptionPane.showInputDialog(
                                "Ingrese el elemento del cual desea se proporcione la ultima aparicion");

                        int ultimaAparicion = buscarUltimaAparicion(ejemploArrayList, ultimoIndice);

                        if (ultimaAparicion != -1) {

                            JOptionPane.showMessageDialog(null, "La ultima aparicion del elemento " + "' " + ultimoIndice
                                    + " '" + " se encuentra en el indice: " + ultimaAparicion);

                        } else {

                            JOptionPane.showMessageDialog(null, "El elemento " + "' " + ultimoIndice
                                    + " '" + " NO se encuentra en el arralist");
                        }

                        break;

                    case 13:

                        String elementoBuscarIndice = JOptionPane.showInputDialog(
                                "Ingrese el elemento del cual desea se busque el indice o indices");

                        List<Integer> indices = buscarIndices(ejemploArrayList, elementoBuscarIndice);

                        if (!indices.isEmpty()) {

                            JOptionPane.showMessageDialog(null, "El elemento " + "' " + elementoBuscarIndice
                                    + " '" + " se encuentra en el indice o indices: " + indices);

                        } else {

                            JOptionPane.showMessageDialog(null, "El elemento " + "' " + elementoBuscarIndice
                                    + " '" + " NO se encuentra en el arralist");
                        }

                        break;

                    case 14:

                        ArrayList<String> Imprimir = new ArrayList<>();

                        mensaje = new StringBuilder("Imprimiendo ArrayList actual:\n\n");

                        for (int i = 0; i < ejemploArrayList.size(); i++) {

                            mensaje.append("Posicion " + i + ": " + ejemploArrayList.get(i) + "\n");

                        }
                        int fromIndex = Integer.parseInt(JOptionPane.showInputDialog(mensaje.append
                                        ("\nIndique desde que indice desea la porcion del ArrayList\n "
                                         + "Ej: Desde el indice 1\n")));

                        int toIndex = Integer.parseInt(JOptionPane.showInputDialog(mensaje.append
                                        ("\nAhora hasta que indice desea el ArrayList\n"
                                         + "Ej: HAsta el indice 2\n")));
                        
                        //Le sumamos un '1' para que el limite sea incluyente para 'toIndex'
                        toIndex = toIndex + 1;

                        List<Object> sublist = porcionArrayList(ejemploArrayList,fromIndex, toIndex);
                        
                        mensaje.append("\nLos elementos del indice " + fromIndex + " al indice " + toIndex + " son:\n")
                               .append("\n" + sublist);
                        
                        JOptionPane.showMessageDialog(null, mensaje);
                        
                        break;


                    case 16:

                        estado = true;

                        break;

                    default:

                        JOptionPane.showMessageDialog(null, "INGRESE SOLO LAS OPCIONES DEL MENU");

                        break;
                }

            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "ERROR!!! INGRESE UN DATO VALIDO");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR EN LA EJECUCION: " + e.getMessage());
            }

        } while (!estado);

    }

    private static <T> void agregarArrayList(ArrayList<T> arrayList) {

        do {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Desea agregar un elemento?", "Agregar Elemento", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                int opcionAgregar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la forma de agregar el elemento\n\n"
                        + "1. Agregar con indice\n"
                        + "2. Agregar elemento en fila\n "
                        + "3. Menu principal"));

                switch (opcionAgregar) {

                    case 1:

                        int indiceAgregar = Integer.parseInt(JOptionPane.showInputDialog(
                                "\nIngrese el indice donde desea se almacene elemento:\n"));
                        Object elemento = JOptionPane.showInputDialog("\nIngrese el elemento que desee:");
                        arrayList.add(indiceAgregar, (T) elemento);

                        if (elemento == null) {

                            String str = (String) elemento;
                        }

                        JOptionPane.showMessageDialog(null, "Elemento en el índice " + indiceAgregar
                                + " Agregado.\nArrayList actualizado:\n"
                                + arrayList, "Elemento agregado", JOptionPane.INFORMATION_MESSAGE);

                        break;

                    case 2:

                        elemento = JOptionPane.showInputDialog("\nIngrese el elemento que desee:");
                        arrayList.add((T) elemento);

                        JOptionPane.showMessageDialog(null, "Elemento " + elemento
                                + " Agregado.\nArrayList actualizado:\n"
                                + arrayList, "Elemento agregado", JOptionPane.INFORMATION_MESSAGE);

                        break;

                    case 3:

                        salirMenu = true;

                        break;

                    default:

                        JOptionPane.showMessageDialog(null, "Ingrese una opcion del menu");
                        break;
                }

            } else if (confirmacion == JOptionPane.NO_OPTION) {
                salirMenu = true;
            }

        } while (!salirMenu);
    }

    private static <T> void eliminarArrayList(ArrayList<T> arraylist) {

        do {
            mensaje = new StringBuilder("Eliminar elemento del Arraylist:\n");

            for (int i = 0; i < arraylist.size(); i++) {
                mensaje.append("Posicion " + i + ": " + ejemploArrayList.get(i) + "\n");
            }

            int opcionEliminar = Integer.parseInt(JOptionPane.showInputDialog(mensaje.toString()
                    + "\nIngrese la forma de eliminar:\n\n"
                    + "1. Eliminar por indice\n"
                    + "2. Eliminar por elemento\n"
                    + "3. Retornar menu\n"));

            switch (opcionEliminar) {

                case 1:

                    int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "\n" + mensaje.toString()
                            + "\nIngrese el indice del elemento a eliminar:", "Eliminar Elemento", JOptionPane.QUESTION_MESSAGE));

                    // Verificar si el elemento está presente y eliminarlo
                    try {
                        // Verificar si el índice es válido y eliminar el elemento
                        if (indice >= 0 && indice < arraylist.size()) {
                            arraylist.remove(indice);
                            JOptionPane.showMessageDialog(null, "Elemento en el índice " + indice + " eliminado.\nArrayList actualizado:\n" + ejemploArrayList, "Elemento Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Índice no válido.", "Índice no válido", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un índice válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case 2:

                    // Mostrar la impresión del ArrayList y obtener el elemento a eliminar
                    String elemento = JOptionPane.showInputDialog(null, "\n" + mensaje.toString()
                            + "\nIngrese el elemento a eliminar:", "Eliminar Elemento", JOptionPane.QUESTION_MESSAGE);

                    // Verificar si el elemento está presente y eliminarlo
                    if (elemento != null && !elemento.isEmpty()) {
                        if (arraylist.contains(elemento)) {

                            arraylist.remove(elemento);
                            JOptionPane.showMessageDialog(null, "Elemento eliminado.\nArrayList actualizado:\n"
                                    + arraylist, "Elemento Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El elemento no se encontró en la lista.", "Elemento no encontrado", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        // El usuario cerró el cuadro de diálogo o no ingresó nada
                        salirMenu = true;
                    }

                    break;

                case 3:

                    salirMenu = true;

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Ingrese las opciones del menu");
                    break;
            }

        } while (!salirMenu);

    }

    private static <T> void mostrarArrayList(ArrayList<T> Arraylist) {

        mensaje = new StringBuilder("Imprimiendo ArrayList\n\n");

        if (ejemploArrayList.isEmpty()) {

            JOptionPane.showMessageDialog(null, "El Arraylist esta vacio");

        } else {

            for (int i = 0; i < Arraylist.size(); i++) {

                mensaje.append("posicion " + i + ": " + Arraylist.get(i) + "\n");

            }
            JOptionPane.showMessageDialog(null, mensaje);
            mensaje = new StringBuilder();
        }
    }

    private static <T> int tamañoArrayList(ArrayList<T> ArrayList) {

        return ArrayList.size();
    }

    private static <T> void ordenarAtoZ(ArrayList<Object> arrayList, Comparator<Object> comparator) {
        // Convertir elementos si es necesario antes de ordenar
        convertirElementosNumericos(arrayList);

        Collections.sort(arrayList, comparator);
    }

    private static <T> void ordenarZtoA(ArrayList<Object> arraylist, Comparator<Object> comparador) {

        convertirElementosNumericos(arraylist);
        Collections.sort(arraylist, Collections.reverseOrder(comparador));

    }

    private static void convertirElementosNumericos(ArrayList<Object> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            Object elemento = arrayList.get(i);

            if (elemento != null && !elemento.toString().isEmpty()) {
                // Solo intentar convertir si el elemento no es nulo ni vacío
                try {
                    Double.parseDouble(elemento.toString());
                } catch (NumberFormatException e) {
                    // Si no se puede convertir a número, no hacer nada
                }
            }
        }
    }

    private static boolean esNumerico(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static <T> void comparacionElementosArralist(ArrayList<T> arraylist) {
        mensaje = new StringBuilder("Comparar Elementos\n");

        // Crear un mapa para almacenar los elementos y sus posiciones
        Map<Object, List<Integer>> elementosIguales = new HashMap<>();

        for (int i = 0; i < arraylist.size(); i++) {
            Object elemento = arraylist.get(i);

            // Verificar si el elemento ya está en el mapa
            if (elementosIguales.containsKey(elemento)) {
                // Si está presente, agregar la posición a la lista existente
                elementosIguales.get(elemento).add(i);
            } else {
                // Si no está presente, crear una nueva lista con la posición
                List<Integer> posiciones = new ArrayList<>();
                posiciones.add(i);
                elementosIguales.put(elemento, posiciones);
            }
        }

        // Construir el mensaje con los elementos y sus posiciones
        for (Map.Entry<Object, List<Integer>> entry : elementosIguales.entrySet()) {
            mensaje.append("Elemento '").append(entry.getKey()).append("' en las posiciones: ");

            // Agregar las posiciones al mensaje
            List<Integer> posiciones = entry.getValue();
            for (Integer posicion : posiciones) {
                mensaje.append(posicion).append("  ");
            }

            mensaje.append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private static <T> ArrayList compararArraylist(ArrayList<T> arraylist1, ArrayList<T> arraylist2) {

        // Crear una nueva lista para almacenar los elementos iguales
        ArrayList<Object> elementosIguales = new ArrayList();

        // Iterar sobre la primera lista
        for (Object elemento : arraylist1) {

            // Verificar si el elemento está presente en la segunda lista
            if (arraylist2.contains(elemento)) {

                elementosIguales.add(elemento);
            }
        }
        return elementosIguales;
    }

    private static <T> void copiarArralist(ArrayList<T> ejemploArrayList) {

        ArrayList<Object> nuevoArraylist = new ArrayList<>(ejemploArrayList);

        mensaje.append("ARRAYLIST ORIGINAL");

        for (int i = 0; i < ejemploArrayList.size(); i++) {

            mensaje.append("Posicion " + i + ": " + ejemploArrayList.get(i) + "\n");
        }

        mensaje.append("\nARRAYLIST COPIADO\n\n");

        for (int i = 0; i < nuevoArraylist.size(); i++) {

            mensaje.append("Posicion " + i + ": " + nuevoArraylist.get(i) + "\n");
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static <T> void buscarElemento(ArrayList<T> arraylist, String elementoBuscar) {

        boolean resultadoBusqueda = arraylist.contains(elementoBuscar);

        if (resultadoBusqueda == true) {

            JOptionPane.showMessageDialog(null, "EL elemento " + elementoBuscar + " esta en el arraylist");

        } else {
            JOptionPane.showMessageDialog(null, "NO esta el elemento " + elementoBuscar + " en el arraylist");
        }

    }

    private static <T> boolean verificarVacio(ArrayList<T> arraylist) {

        boolean resultado = arraylist.isEmpty();
        return resultado;
    }

    private static <T> int buscarPrimeraAparicion(ArrayList<T> arraylist, T elemento) {

        if (elemento == null) {

            throw new IllegalArgumentException("El elemento no puede ser nulo");

        }

        int indice = arraylist.indexOf(elemento);

        return indice;

    }

    private static <T> int buscarUltimaAparicion(ArrayList<T> arraylist, T elemento) {

        if (elemento == null) {

            throw new IllegalArgumentException("El elemento no puede ser nulo");

        }

        int indice = arraylist.lastIndexOf(elemento);
        return indice;

    }

    private static <T> List<Integer> buscarIndices(ArrayList<T> arraylist, T elemento) {

        if (arraylist == null || elemento == null) {

            throw new IllegalArgumentException("El ArrayList o elemento no puede ser nulo");

        }

        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < arraylist.size(); i++) {

            if (elemento.equals(arraylist.get(i))) {
                indices.add(i);
            }
        }
        return indices;
    }

    private static List<Object> porcionArrayList(ArrayList<Object> arrayList, int fromIndex, int toIndex) {

        if (fromIndex < 0 || toIndex > arrayList.size() || fromIndex > toIndex) {
            
            throw new IllegalArgumentException("El indice no es valido");
            
        } else {
            return arrayList.subList(fromIndex, toIndex);
        }
    }

    //creamos esta clase para que funcione el metodo ordenarAtoZ y ordenarZtoA, puesto que el Arraylist es object
    //al ser object el metodo sort no sabe como compararlos para ordenarlos
    static class MyComparator implements Comparator<Object> {

        @Override
        public int compare(Object o1, Object o2) {
            // Convertir elementos nulos o vacíos a cadenas vacías
            String str1 = (o1 == null) ? "" : o1.toString();
            String str2 = (o2 == null) ? "" : o2.toString();

            // Obtener los tipos de los objetos
            String type1 = o1 != null ? o1.getClass().getSimpleName() : "";
            String type2 = o2 != null ? o2.getClass().getSimpleName() : "";

            // Comparar por tipo
            int typeComparison = type1.compareTo(type2);
            if (typeComparison != 0) {
                return typeComparison;
            }

            // Ordenar números antes que cadenas
            if (o1 instanceof Number && o2 instanceof Number) {
                // Ambos son números, comparar como números
                return Double.compare(((Number) o1).doubleValue(), ((Number) o2).doubleValue());
            } else if (isNumeric(str1) && isNumeric(str2)) {
                // Al menos uno de ellos no es un número, comparar como cadenas
                return Double.compare(Double.parseDouble(str1), Double.parseDouble(str2));
            } else {
                // Si no son números, cadenas, ordenar por otros tipos
                if (o1 instanceof Number) {
                    return -1; // o1 es un número, debería ir antes en la lista
                } else if (o2 instanceof Number) {
                    return 1;  // o2 es un número, debería ir antes en la lista
                } else if (o1 instanceof String && o2 instanceof String) {
                    // Ambos son cadenas, comparar como cadenas
                    return str1.compareTo(str2);
                } else if (o1 instanceof String) {
                    return -1; // o1 es una cadena, debería ir antes en la lista
                } else if (o2 instanceof String) {
                    return 1;  // o2 es una cadena, debería ir antes en la lista
                } else {
                    // Si ninguno de los tipos es número ni cadena, comparar por tipos
                    return type1.compareTo(type2);
                }
            }
        }

        // Función para verificar si una cadena es numérica
        private boolean isNumeric(String str) {
            if (str == null || str.isEmpty()) {
                return false;
            }
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

}

package EjemploArraylist;

import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class Arralist {

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
                        + "11. Obtener el índice de la primera aparición de un elemento\n"
                        + "12. Obtener el índice de la última aparición de un elemento\n"
                        + "13. Obtener una porción del ArrayList\n"
                        + "14. Recuperar elementos y realizar conversiones de tipo\n"
                        + "15. Salir"));

                switch (opcion) {
                    case 1:

                        do {

                            confirmacion = JOptionPane.showConfirmDialog(null,
                                    "¿Desea agregar un elemento?", "Agregar Elemento", JOptionPane.YES_NO_OPTION);

                            if (confirmacion == JOptionPane.YES_OPTION) {

                                elemento = JOptionPane.showInputDialog("\nIngrese el elemento que desee:");
                                ejemploArrayList.add(elemento);

                            } else if (confirmacion == JOptionPane.NO_OPTION) {
                                salirMenu = true;
                            }

                        } while (!salirMenu);

                        break;

                    case 2:

                        do {
                            mensaje = new StringBuilder("Eliminar elemento del Arraylist:\n");

                            for (int i = 0; i < ejemploArrayList.size(); i++) {
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
                                        if (indice >= 0 && indice < ejemploArrayList.size()) {
                                            ejemploArrayList.remove(indice);
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
                                        if (ejemploArrayList.contains(elemento)) {

                                            ejemploArrayList.remove(elemento);
                                            JOptionPane.showMessageDialog(null, "Elemento eliminado.\nArrayList actualizado:\n"
                                                    + ejemploArrayList, "Elemento Eliminado", JOptionPane.INFORMATION_MESSAGE);
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
                            }

                        } while (!salirMenu);

                        break;

                    case 3:

                        if (ejemploArrayList.isEmpty()) {
                            
                            JOptionPane.showMessageDialog(null, "El Arraylist esta vacio");
                            
                        } else {
                            
                            mostrarArrayList(ejemploArrayList);
                        }
                        
                        

                        break;

                    case 15:

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

    private static void mostrarArrayList(ArrayList<Object> Arraylist) {

        mensaje = new StringBuilder("Imprimiendo ArrayList\n\n");

        for (int i = 0; i < Arraylist.size(); i++) {

            mensaje.append("posicion " + i + ": " + Arraylist.get(i) + "\n");

        }
        JOptionPane.showMessageDialog(null, mensaje);
        mensaje = new StringBuilder();
    }

}

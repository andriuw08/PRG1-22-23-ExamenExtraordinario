import java.util.Scanner;

public class VisiCalc {
    public static void main(String[] args) {
        final int NUM_COLUMNAS = 10;
        final int NUM_FILAS = 15;
        final int LONGITUD_MAXIMA = 6;
        String[][] hojaCalculo = new String[NUM_FILAS][NUM_COLUMNAS];
        int filaActual = 0;
        int columnaActual = 0;

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        do {
            System.out.println("Por favor seleciona alguno de los siguientes comandos (w/a/s/d) o f para finalizar el programa");
            inputUsuario = entrada.nextLine().charAt(0);

            switch (inputUsuario) {
                case 'w', 'W':
                    if (filaActual > 0) {
                        filaActual--;
                    }
                    break;
                case 's', 'S':
                    if (filaActual < NUM_FILAS - 1) {
                        filaActual++;
                    }
                    break;
                case 'a', 'A':
                    if (columnaActual > 0) {
                        columnaActual--;
                    }
                    break;
                case 'd', 'D':
                    if (columnaActual < NUM_COLUMNAS - 1) {
                        columnaActual++;
                    }
                    break;
                case 'f', 'F':
                System.out.println("Ha finalizado el programa");
                    terminar = true;
                default:
                    System.out.println("Texto o numero");
                    String contenido = entrada.nextLine();
                    hojaCalculo[filaActual][columnaActual] = formatearContenido(contenido);
                    break;
            }
        } while (!terminar);

        private static String formatearContenido(String contenido) {
            if (contenido.length() > LONGITUD_MAXIMA) {
                return contenido.substring(0, LONGITUD_MAXIMA);
            } else {
                StringBuilder sb = new StringBuilder(contenido);
                while (sb.length() < LONGITUD_MAXIMA) {
                    sb.insert(0, " ");
                }
                return sb.toString();
            }
        }

        private static void mostrarHojaDeCalculo(String[][] hojaCalculo) {
            for (int fila = 0; fila < NUM_FILAS; fila++){
                for (int columna = 0; columna < NUM_COLUMNAS; columna++) {
                    System.out.println(hojaCalculo[fila][columna] + " ");
                }
                System.out.println();
            }
        }

    }
}
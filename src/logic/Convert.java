package logic;

import java.util.ArrayList;

/**
 * Clase encargada de realizar las conversiones de las formulas
 *
 * @author xJoni
 * @version 1.0
 */
public class Convert {

    /**
     * Identifica cuando es una formula en forma polaca
     */
    public static final int POLISH_FORMULA = 1;

    /**
     * Identifica cuando es una formula en forma infija
     */
    public static final int INFIX_FORMULA = 2;

    /**
     * Cantidad de atomos que debe tener la formula
     */
    public static final int NUMBER_ATOMS = 5;

    static String aux;

    /**
     * Se encarga de llamar las funciones de validacion de que la formula este
     * bien formada y retornar este valor a la interfaz grafica
     *
     * @param formula Formula a analizar
     * @param typeFormula Forma en la que se envio la formula
     * @return true si esta bien formada, false en caso contrario
     */
    public static boolean checkFormula(String formula, int typeFormula) {
        if (typeFormula == POLISH_FORMULA) {
            return validatePolishFormula(formula);
        } else {
            return validateInfixFormula(formula);
        }
    }

    /**
     * Se encarga de validar si la formula recibida esta bien formada de forma
     * recursiva
     *
     * @param formula es la expresion que se recibe por medio de la interfaz
     * grafica
     * @return true en caso de ser una formula bien formada y false en caso
     * contrario
     */
    private static boolean validateInfixFormula(String formula) {
        aux = formula;

        // Tomamos la cantidad de letras que tiene la formula
        int tamanoFormula = formula.length();

        if (aux.length() == 2 || aux.length() == 0) {
            return false;
        }

        if (aux.length() == 1 && (aux.charAt(0) == 'p' || aux.charAt(0) == 'r' || aux.charAt(0) == 'q'
                || aux.charAt(0) == 's' || aux.charAt(0) == 't' || aux.charAt(0) == 'u' || aux.charAt(0) == 'w'
                || aux.charAt(0) == 'v' || aux.charAt(0) == 'x' || aux.charAt(0) == 'y' || aux.charAt(0) == 'z')) {

            return true;

        } else if ((aux.charAt(0) != '¬') && (aux.charAt(0) != '(')) {

            return false;

        }
        if (aux.charAt(0) == '¬') { // Cuando comienza por negado ¬
            aux = aux.substring(2, tamanoFormula - 1);
            return validateInfixFormula(aux);

        } else if (aux.charAt(0) == '(') {// Cuando comienza por (

            /**
             * Variable que me guarda la posiciOn del operador principal de la
             * expresi0n, que es determinado por el MEtodo buscarPosicionOpePPal
             */
            int posicion = buscarPosicionOpePpal(aux);

            if (posicion + 3 > aux.length()) {
                return false;
            }
            if ((aux.charAt(posicion) != '\u2192') && (aux.charAt(posicion) != '^') && (aux.charAt(posicion) != 'V')
                    && (aux.charAt(posicion) != '\u2194')) {
                System.out.println(
                        "El operador ''" + aux.charAt(posicion) + "'' es invalido (Debe ser un operador binario)");
                return false;
            }

            /**
             * Variable auxiliar que guarda la expresion que se encuentra en la
             * variable aux
             */
            String aux3 = aux;
            aux = aux.substring(1, posicion - 1);
            aux3 = aux3.substring(posicion + 2, tamanoFormula - 1);
            return validateInfixFormula(aux) & validateInfixFormula(aux3);
        }

        return true;

    }

    private static boolean validatePolishFormula(String formula) {

        return false;
    }

    /**
     * Se encarga de validar que la formula tenga la cantidad de atomos
     * especificados en el requerimiento
     *
     * @param formula La formula a evaluar
     * @return true en caso de cumplir con el numero de atomos, false en caso
     * contrario
     */
    public static boolean validateNumberAtoms(String formula) {

        ArrayList<Character> atoms = new ArrayList<>();

        // Recorremos cada caracter de la formula
        for (int i = 0; i < formula.length(); i++) {

            // Se valida que sea una letra el caracter
            if (Character.isLetter(formula.charAt(i))) {

                // Bandera para saber si agregar o no el atomo
                boolean existe = false;

                // Recorremos los atomos previamente agregados para no agregarlo
                for (int j = 0; j < atoms.size(); j++) {

                    // Si ya existe se marca y continua con la siguiente operacion
                    if (formula.charAt(i) == atoms.get(j)) {
                        existe = true;
                        break;
                    }
                }

                // Si no existe el atomo lo agregamos
                if (!existe) {
                    atoms.add(formula.charAt(i));
                }
            }
        }

        return atoms.size() >= NUMBER_ATOMS;
    }

    public static char buscarOpPrincipal(String aux) {
        int pos = buscarPosicionOpePpal(aux);
        if (pos == 0) {
            return aux.charAt(0);
        }
        if (aux.charAt(pos) == '(') {
            return aux.charAt(pos - 1);
        } else {
            return aux.charAt(pos);
        }
    }

    public static int buscarPosicionOpePpal(String aux) {

        /**
         * Cuenta , sumando o restando dependiendo si se encuentra con un
         * parentesis izquierdo o derecho
         */
        int con = 0;

        /**
         * Guarda la posicion en la que se encuentra el operador principal
         */
        int posicion = 0;

        if (aux.charAt(0) == '¬') {
            return 0;
        }
        for (int i = 0; i < aux.length(); i++) {

            if (aux.charAt(i) == '(') {
                con = con + 1;
            }
            if (aux.charAt(i) == ')') {
                con = con - 1;
            }
            posicion = i + 1;
            if (con == 0) {
                break;
            }
        }

        return posicion;
    }

    public static ArrayList<String> OrdenarArray(ArrayList<String> lista) {

        /**
         * Variables que ayudan en el metodo de ordenamiento del ArrayList
         */
        int p, j;

        /**
         * Variable que guarda temporalmente el elemento que se quiere mover de
         * posicion dentro del ArrayList
         */
        String aux;
        for (p = 1; p < lista.size(); p++) { // Desde el segundo elemento hasta
            aux = lista.get(p); // el final, guardamos el elemento y
            j = p - 1; // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux.length() < lista.get(j).length())) { // Mientras
                // queden
                // posiciones
                // y
                // el
                // valor de aux sea menor que los
                lista.remove(j + 1);
                lista.add(j + 1, lista.get(j));
                // de la izquierda, se desplaza a
                j--; // la derecha
            }
            lista.remove(j + 1);
            lista.add(j + 1, aux); // Colocamos aux en su sitio
        }
        return lista;

    }
}

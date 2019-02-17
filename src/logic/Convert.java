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

        int formulaSize = formula.length() - 1;
        
        // Casos basicos para determinar si esta o no bien formada la formula
        if (formula.length() == 2 || formula.length() == 0) {
            return false;
        } else if (formula.length() == 1 && (formula.charAt(0) == 'p' || formula.charAt(0) == 'r' || formula.charAt(0) == 'q'
                || formula.charAt(0) == 's' || formula.charAt(0) == 'w'
                || formula.charAt(0) == 'x' || formula.charAt(0) == 'y' || formula.charAt(0) == 'z')) {
            return true;
        } else if (formula.charAt(0) != '¬' && formula.charAt(0) != '(') {
            return false;
        } else if(formula.length() == 1 && (formula.charAt(0) == '¬' || formula.charAt(0) == '(' || formula.charAt(0) == ')')) {
            return false;
        }
        
        // Cuando comienza por negado ¬
        if (formula.charAt(0) == '¬') {
            formula = formula.substring(2, formulaSize);
            return validateInfixFormula(formula);
        } else if (formula.charAt(0) == '(') { // Cuando comienza por (

            // Tomamos la posicion del operador principal
            int posicion = searchPositionOperatorPrincipal(formula);

            if (posicion + 3 > formula.length()) {
                return false;
            }
            if ((formula.charAt(posicion) != '\u2192') && (formula.charAt(posicion) != '^') && (formula.charAt(posicion) != 'V')
                    && (formula.charAt(posicion) != '\u2194')) {
                System.out.println(
                        "El operador ''" + formula.charAt(posicion) + "'' es invalido (Debe ser un operador binario)");
                return false;
            }

            /**
             * Variable auxiliar que guarda la expresion que se encuentra en la
             * variable aux
             */
            String auxFormula = formula;
            formula = formula.substring(1, posicion - 1);
            auxFormula = auxFormula.substring(posicion + 2, formulaSize);
            return validateInfixFormula(formula) & validateInfixFormula(auxFormula);
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
        int pos = searchPositionOperatorPrincipal(aux);
        if (pos == 0) {
            return aux.charAt(0);
        }
        if (aux.charAt(pos) == '(') {
            return aux.charAt(pos - 1);
        } else {
            return aux.charAt(pos);
        }
    }

    public static int searchPositionOperatorPrincipal(String aux) {

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

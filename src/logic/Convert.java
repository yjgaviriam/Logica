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

        // Casos basicos para determinar si esta o no bien formada la formula
        if (formula.length() == 1 && (formula.charAt(0) == 'p' || formula.charAt(0) == 'r' || formula.charAt(0) == 'q' || formula.charAt(0) == 's'
                || formula.charAt(0) == 'w' || formula.charAt(0) == 'x' || formula.charAt(0) == 'y' || formula.charAt(0) == 'z')) {
            return true;
        } else if (formula.length() == 2 && (formula.charAt(0) == '¬' && ((formula.charAt(1) == 'p' || formula.charAt(1) == 'r' || formula.charAt(1) == 'q'
                || formula.charAt(1) == 's' || formula.charAt(1) == 'w' || formula.charAt(1) == 'x' || formula.charAt(1) == 'y' || formula.charAt(1) == 'z')))) {
            return true;
        } else if ((formula.length() == 2 && (formula.charAt(0) != '¬')) || formula.length() == 0) {
            return false;
        } else if (formula.charAt(0) != '¬' && formula.charAt(0) != '(') {
            return false;
        } else if (formula.length() == 1 && (formula.charAt(0) == '¬' || formula.charAt(0) == '(' || formula.charAt(0) == ')')) {
            return false;
        }

        // Cuando comienza por negado ¬
        if (formula.charAt(0) == '¬') {
            formula = formula.substring(2, formula.length() - 1);
            return validateInfixFormula(formula);
        } else if (formula.charAt(0) == '(') { // Cuando comienza por (

            // Tomamos la posicion del operador principal
            int positionOperatorPrincipal = searchPositionOperatorPrincipal(formula);

            // En caso de superar la longitud de la formula desde la posicion del operador principal
            if (positionOperatorPrincipal + 3 > formula.length()) {
                return false;
            }

            // Si la posicion del operador principal encontrado no es un operador binario
            if ((formula.charAt(positionOperatorPrincipal) != '\u2192') && (formula.charAt(positionOperatorPrincipal) != '^') && (formula.charAt(positionOperatorPrincipal) != 'v')
                    && (formula.charAt(positionOperatorPrincipal) != '\u2194')) {
                return false;
            }

            // Se toma la siguiente parte de la formula a trabajar
            String auxFormula = formula.substring(positionOperatorPrincipal + 2, formula.length() - 1);
            String auxFormula2 = formula.substring(1, positionOperatorPrincipal - 1);

            return validateInfixFormula(auxFormula) & validateInfixFormula(auxFormula2);
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

    /**
     * Identifica el operador principal de la porcion de formula recibida
     *
     * @param formula Porcion de la formula original
     * @return posicion donde se encontro el operador
     */
    public static int searchPositionOperatorPrincipal(String formula) {

        // Si es una negacion se devuelve de una vez el operador en la posicion inicial
        if (formula.charAt(0) == '¬') {
            return 0;
        }

        //Cuenta, sumando o restando dependiendo si se encuentra con un parentesis izquierdo o derecho
        int count = 0;

        //Guarda la posicion en la que se encuentra el operador principal
        int position = 0;

        // Recorremos la formula
        for (int i = 0; i < formula.length(); i++) {

            // Contamos parentesis abiertos
            if (formula.charAt(i) == '(') {
                count = count + 1;
            }

            // Descontamos cada parentesis cerrado
            if (formula.charAt(i) == ')') {
                count = count - 1;
            }

            position = i + 1;

            // Al cerrar los parentesis termina de leerse la formula
            if (count == 0) {
                break;
            }
        }

        return position;
    }
}

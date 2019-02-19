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
     * Almacena la formula en prefijo
     */
    public static String prefixFormula;

    /**
     * Almacena la formula restante de polaca
     */
    private static String polishFormula;

    /**
     * Contiene la lista de formulas
     */
    public static ArrayList<Formula> formulas;

    /**
     * Contiene la lista de formulas
     */
    public static ArrayList<Character> charactersFormulas;

    /**
     * Nodo con toda la estructura del arbol de la formula
     */
    public static Node root;

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
            charactersFormulas = new ArrayList<>();
            // Casos basicos para determinar si esta o no bien formada la formula
            if (formula.length() == 1 && isAtom(formula.charAt(0))) {
                return true;
            } else if (formula.length() == 2 && (formula.charAt(0) == 'N' && (isAtom(formula.charAt(1))))) {
                return true;
            } else if ((formula.length() == 2 && (formula.charAt(0) != 'N')) || formula.length() == 0) {
                return false;
            } else if (formula.length() > 1 && !isOperatorPolishFormula(formula.charAt(0))) {
                // revisar
                return false;
            } else if (formula.length() == 1 && isOperatorPolishFormula(formula.charAt(0))) {
                return false;
            }

            return validatePolishFormula(formula, formula.length() - 1);
        } else {
            return validateInfixFormula(formula);
        }
    }

    /**
     * Se encarga de realizar el borrado del listado de caracteres, con esto
     * saber si la formula esta bien formada
     *
     * @param number Numero de caracteres a eliminar
     * @return true si se pudo borrar y sigue estando bien formada, false en
     * caso de excepcion(mal formada)
     */
    private static boolean deleteCharacter(int number) {

        // Retorna que toco ocurrio bien al terminar de borrar la cantidad de caracteres especificados
        if (number == 0) {
            return true;
        }

        // Tratamos de eliminar en caso de no encontrar la posicion esta mal formada y retornamos el false
        try {
            number = number - 1;
            charactersFormulas.remove(number);
            return deleteCharacter(number);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    /**
     * Indica si un operador recibido como parametro es un operador en forma
     * polaca
     *
     * @param character Operador a validar
     * @return true si es un operador de formula en forma polaca, false en caso
     * contrario
     */
    private static boolean isOperatorPolishFormula(char character) {
        return (character == 'A' || character == 'E' || character == 'C' || character == 'K' || character == 'N');
    }

    /**
     * Indica si un operador recibido como parametro es un operador en forma
     * infija
     *
     * @param character Operador a validar
     * @return true si es un operador de formula en forma infija, false en caso
     * contrario
     */
    private static boolean isOperatorInfixFormula(char character) {
        return (character == 'v' || character == '\u2194' || character == '\u2192' || character == '^' || character == '¬');
    }

    /**
     * Indica si un operador recibido como parametro es un atomo
     *
     * @param character Operador a validar
     * @return true si es un atomo, false en caso contrario
     */
    private static boolean isAtom(char character) {
        return (character == 'p' || character == 'r' || character == 'q' || character == 's' || character == 'w' || character == 'x' || character == 'y' || character == 'z');
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
            if (Character.isLetter(formula.charAt(i)) && !isOperatorPolishFormula(formula.charAt(i))) {

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
     * Se encarga de validar que una formula en forma polaca esta bien formada
     *
     * @param formula Formula en forma polaca a probar
     * @return true si esta bien formada, false en caso contrario
     */
    private static boolean validatePolishFormula(String formula, int i) {

        // Cuando termino de recorrer la formula
        if (i == 0 && !isOperatorPolishFormula(formula.charAt(i))) {
            return false;
        } else if (i == 0 && formula.charAt(i) == 'N' && charactersFormulas.size() == 1) {
            return true;
        } else if (i == 0 && isOperatorPolishFormula(formula.charAt(i)) && formula.charAt(i) != 'N' && charactersFormulas.size() == 2) {
            return true;
        } else if (i == 0) {
            return false;
        }

        // En caso de ser la negacion, solo se borra una formula del listado
        if (formula.charAt(i) == 'N') {
            // Si responde bien quiere decir que habia la cantidad necesaria para borrar y sigue estando bien formada
            if (deleteCharacter(1)) {
                charactersFormulas.add('F');
                return validatePolishFormula(formula, i - 1);
            } else {
                return false;
            }
        }

        // Si es un operador vamos a eliminar formulas del arrayList
        if (isOperatorPolishFormula(formula.charAt(i))) {
            // Si responde bien quiere decir que habia la cantidad necesaria para borrar y sigue estando bien formada
            if (deleteCharacter(2)) {
                charactersFormulas.add('F');
                return validatePolishFormula(formula, i - 1);
            } else {
                return false;
            }
        } else {
            charactersFormulas.add('F');
            return validatePolishFormula(formula, i - 1);
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
        if (formula.length() == 1 && isAtom(formula.charAt(0))) {
            return true;
        } else if (formula.length() == 2 && (formula.charAt(0) == '¬' && (isAtom(formula.charAt(1))))) {
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

            /*System.out.println("positionOperatorPrincipal -> " + positionOperatorPrincipal);
            System.out.println("formula -> " + formula);
            System.out.println("formula.substring(positionOperatorPrincipal + 2, formula.length() - 1) -> " + formula.substring(positionOperatorPrincipal + 2, formula.length() - 1));
            System.out.println("formula.substring(1, positionOperatorPrincipal - 1) -> " + formula.substring(1, positionOperatorPrincipal - 1));*/
            // Se toma la siguiente parte de la formula a trabajar
            String auxFormula = formula.substring(1, positionOperatorPrincipal - 1);
            String auxFormula2 = formula.substring(positionOperatorPrincipal + 2, formula.length() - 1);

            return validateInfixFormula(auxFormula) & validateInfixFormula(auxFormula2);
        }

        return true;

    }

    /**
     * Identifica el operador principal de la porcion de formula recibida
     *
     * @param formula Porcion de la formula original
     * @return posicion donde se encontro el operador
     */
    private static int searchPositionOperatorPrincipal(String formula) {

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

    /**
     * Funcion de convertir una formula segun el tipo de forma recibido
     *
     * @param formula Formula a convertir
     * @param typeFormula Forma en la que se encuentra la formula a convertir
     * @return La formula convertida
     */
    public static String convertFormula(String formula, int typeFormula) {
        if (typeFormula == POLISH_FORMULA) {
            return convertPolishToInfix(formula);
        } else {
            return convertInfixToPolish(formula);
        }
    }

    /**
     * Se encarga de construir la formula a infija desde polaca
     *
     * @param formula a convertir a infija
     * @return formula en infija
     */
    private static String convertPolishToInfix(String formula) {

        root = new Node("" + formula.charAt(0));

        Node lastNode = convertPolishToInfixFirstBranch(formula.substring(1), root);

        convertPolishToInfix(polishFormula, lastNode);

        return createPolishFormula(root);
    }

    /**
     * Se encarga en crear la primera rama del arbol
     *
     * @param polishFormula Formula a convertir en arbol
     * @param nodeActual Nodo que se esta operando
     * @return el ultimo nodo que es el atomo
     */
    private static Node convertPolishToInfixFirstBranch(String polishFormula, Node nodeActual) {

        if (polishFormula.length() == 1) {
            Node nodeAux = new Node("" + polishFormula.charAt(0));
            nodeAux.setNegation(nodeActual);
            nodeActual.setLeft(nodeAux);

            Convert.polishFormula = "";
            return null;
        }

        Node nodeAux = new Node("" + polishFormula.charAt(0));
        nodeAux.setNegation(nodeActual);

        nodeActual.setLeft(nodeAux);

        if (isAtom(polishFormula.charAt(0))) {
            Convert.polishFormula = polishFormula.substring(1);
            return nodeAux;
        }

        return convertPolishToInfixFirstBranch(polishFormula.substring(1), nodeAux);
    }

    /**
     * Se encarga de continuar creando el arbol apartir de la primera rama ya
     * creada
     *
     * @param polishFormula Formula que resta por convertir al arbol
     * @param nodeActual Nodo en que se va operando el arbol
     * @return null
     */
    private static Node convertPolishToInfix(String polishFormula, Node nodeActual) {

        if (polishFormula.length() == 1) {
            Node nodeAux = new Node("" + polishFormula.charAt(0));

            if (isAtom(nodeActual.getValue().charAt(0))) {
                return convertPolishToInfix(polishFormula, nodeActual.getNegation());
            } else if (nodeActual.getValue().charAt(0) == 'N') {
                if (nodeActual.getLeft() == null) {
                    nodeActual.setLeft(nodeAux);
                    nodeAux.setNegation(nodeActual);
                    return null;
                } else {
                    return convertPolishToInfix(polishFormula, nodeActual.getNegation());
                }
            } else if (isOperatorPolishFormula(nodeActual.getValue().charAt(0)) && nodeActual.getValue().charAt(0) != 'N') {
                if (nodeActual.getLeft() == null) {
                    nodeActual.setLeft(nodeAux);
                    nodeAux.setNegation(nodeActual);
                    return null;
                } else if (nodeActual.getRight() == null) {
                    nodeActual.setRight(nodeAux);
                    nodeAux.setNegation(nodeActual);
                    return null;
                } else {
                    return convertPolishToInfix(polishFormula, nodeActual.getNegation());
                }
            } else if (nodeActual.getNegation() == null) {
                return null;
            }

            return null;
        }

        Node nodeAux = new Node("" + polishFormula.charAt(0));

        // Si es atomo
        if (isAtom(nodeActual.getValue().charAt(0))) {
            return convertPolishToInfix(polishFormula, nodeActual.getNegation());
        } else if (nodeActual.getValue().charAt(0) == 'N') {
            if (nodeActual.getLeft() == null) {
                nodeActual.setLeft(nodeAux);
                nodeAux.setNegation(nodeActual);
                return convertPolishToInfix(polishFormula.substring(1), nodeAux);
            } else {
                return convertPolishToInfix(polishFormula, nodeActual.getNegation());
            }
        } else if (isOperatorPolishFormula(nodeActual.getValue().charAt(0)) && nodeActual.getValue().charAt(0) != 'N') {
            if (nodeActual.getLeft() == null) {
                nodeActual.setLeft(nodeAux);
                nodeAux.setNegation(nodeActual);
                return convertPolishToInfix(polishFormula.substring(1), nodeAux);
            } else if (nodeActual.getRight() == null) {
                nodeActual.setRight(nodeAux);
                nodeAux.setNegation(nodeActual);
                return convertPolishToInfix(polishFormula.substring(1), nodeAux);
            } else {
                return convertPolishToInfix(polishFormula, nodeActual.getNegation());
            }
        } else if (nodeActual.getNegation() == null) {
            return null;
        }

        return convertPolishToInfix(polishFormula.substring(1), nodeAux);
    }

    /**
     * Se encarga de construir la formula en polaca apartir del arbol
     * @param node Nodo que va iterando
     * @return 
     */
    private static String createPolishFormula(Node node) {

        // Casos de parada
        if (node.getValue().charAt(0) == 'N' && isAtom(node.getLeft().getValue().charAt(0))) {
            return convertOperatorPolishToInfix(node.getValue().charAt(0)) + "(" + node.getLeft().getValue() + ")";
        } else if (node.getValue().charAt(0) == 'N' && isOperatorPolishFormula(node.getLeft().getValue().charAt(0))) {
            return convertOperatorPolishToInfix(node.getValue().charAt(0)) + "(" + createPolishFormula(node.getLeft()) + ")";
        } else if (isOperatorPolishFormula(node.getValue().charAt(0)) && node.getValue().charAt(0) != 'N') {
            return "(" + createPolishFormula(node.getLeft()) + ")" + convertOperatorPolishToInfix(node.getValue().charAt(0)) + "(" + createPolishFormula(node.getRight()) + ")";
        } else {
            return node.getValue();
        }
    }

    /**
     * Se encarga de llamar la funcion recursiva que convierte la formula y arma
     * la respuesta
     *
     * @param formula Formula en forma infija
     * @return Formula en forma polaca
     */
    private static String convertInfixToPolish(String formula) {
        // Reiniciamos el listado de formulas
        formulas = new ArrayList<>();

        // Convertimos la formula
        convertInfixToPolish(formula, null, 0);

        // Formula convertida
        String value = "";

        // Reiniciamos el valor de la formula en forma prefija
        prefixFormula = "";

        // Recorremos el listado de formulas para formar la formula en forma prefija
        for (int i = 0; i < formulas.size(); i++) {
            if (isOperatorInfixFormula(formulas.get(i).getValue())) {
                value += convertOperatorInfixToPolish(formulas.get(i).getValue());
            } else {
                value += (formulas.get(i).getValue());
            }

            prefixFormula += formulas.get(i).getValue();
        }

        return value;
    }

    /**
     * Convierte la formula infija a polaca de forma recursiva, crea el arbol
     *
     * @param infixFormula Formula infija a convertir
     * @param nodeActual Nodo del arbol que se esta operando
     * @param orientation Direccion hacia donde va el siguiente nodo
     */
    private static void convertInfixToPolish(String infixFormula, Node nodeActual, int orientation) {

        // Casos basicos para determinar si esta o no bien formada la formula
        if (infixFormula.length() == 1) {
            //System.out.println(infixFormula.charAt(0));
            Formula f = new Formula(infixFormula.charAt(0), infixFormula, false);
            formulas.add(f);
            Node node = new Node("" + infixFormula.charAt(0));
            if (nodeActual == null) {
                root = node;
                f.setOrientation(0);
            } else {
                switch (orientation) {
                    case 0:
                        nodeActual.setLeft(node);
                        f.setOrientation(orientation);
                        break;
                    case 1:
                        nodeActual.setRight(node);
                        f.setOrientation(orientation);
                        break;
                    default:
                        nodeActual.setNegation(node);
                        f.setOrientation(orientation);
                        break;
                }
            }
        }

        // Cuando comienza por negado ¬
        if (infixFormula.charAt(0) == '¬') {
            String auxFormula = infixFormula.substring(2, infixFormula.length() - 1);

            Formula f = new Formula('¬', infixFormula, true);

            formulas.add(f);

            Node node = new Node("¬");

            if (nodeActual == null) {
                root = node;
                f.setOrientation(-1);
            } else {
                switch (orientation) {
                    case 0:
                        nodeActual.setLeft(node);
                        f.setOrientation(orientation);
                        break;
                    case 1:
                        nodeActual.setRight(node);
                        f.setOrientation(orientation);
                        break;
                    default:
                        nodeActual.setNegation(node);
                        f.setOrientation(orientation);
                        break;
                }

            }

            convertInfixToPolish(auxFormula, node, -1);
        } else if (infixFormula.charAt(0) == '(') { // Cuando comienza por (

            // Tomamos la posicion del operador principal
            int positionOperatorPrincipal = searchPositionOperatorPrincipal(infixFormula);

            // Convertimos el operador
            //char operatorConvert = convertOperatorInfixToPolish(infixFormula.charAt(positionOperatorPrincipal));
            //System.out.println(operatorConvert);
            Formula f = new Formula(infixFormula.charAt(positionOperatorPrincipal), infixFormula, true);
            formulas.add(f);

            Node node = new Node("" + infixFormula.charAt(positionOperatorPrincipal));

            if (nodeActual == null) {
                root = node;
                f.setOrientation(1);
            } else {
                switch (orientation) {
                    case 0:
                        nodeActual.setLeft(node);
                        f.setOrientation(orientation);
                        break;
                    case 1:
                        nodeActual.setRight(node);
                        f.setOrientation(orientation);
                        break;
                    default:
                        nodeActual.setNegation(node);
                        f.setOrientation(orientation);
                        break;
                }
            }

            // Se toma la siguiente parte de la infixFormula a trabajar
            String auxFormula = infixFormula.substring(1, positionOperatorPrincipal - 1);
            String auxFormula2 = infixFormula.substring(positionOperatorPrincipal + 2, infixFormula.length() - 1);

            convertInfixToPolish(auxFormula, node, 0);
            convertInfixToPolish(auxFormula2, node, 1);
        }
    }

    /**
     * Convierte un operador binario de forma infija a polaca
     *
     * @param character Operador a convertir
     * @return El operador convertido
     */
    private static char convertOperatorInfixToPolish(char character) {

        switch (character) {
            case '¬':
                return 'N';
            case '\u2192':
                return 'C';
            case '\u2194':
                return 'E';
            case 'v':
                return 'A';
            case '^':
                return 'K';
            default:
                return ' ';
        }
    }

    /**
     * Convierte un operador binario de forma polaca a infija
     *
     * @param character Operador a convertir
     * @return El operador convertido
     */
    private static char convertOperatorPolishToInfix(char character) {

        switch (character) {
            case 'N':
                return '¬';
            case 'C':
                return '\u2192';
            case 'E':
                return '\u2194';
            case 'A':
                return 'v';
            case 'K':
                return '^';
            default:
                return ' ';
        }
    }
}

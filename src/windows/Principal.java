package windows;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import logic.Convert;

/**
 * Ventana principal de la aplicación
 *
 * @author xJoni
 * @version 1.0
 */
public class Principal extends javax.swing.JFrame {

    /**
    /**
     * Variable tipo nodo del arbol
     */
    //private Nodo arbolS;
    /**
     * Instancia del analizador proposicional
     */
    // private AnalizadorProposicional analizador;
    /**
     * Metodo constructor de la ventana
     */
    public Principal() {
        // Se inician los componentes graficos de java swing
        initComponents();
        // Deshabilitamos las teclas que no se usan en las formulas de los text area
        disableKeyboard();
    }

    /**
     * Permite validar que teclas se permitirán en los campos de ingreso de
     * formulas
     */
    private void disableKeyboard() {

        // Text area de formula en forma infija
        txtAreaInfix.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                // Se limpia e inhabilita el textArea que no se esta trabajando
                disableClearTextArea(txtAreaPolish);

                // Validacion para no tomar las teclas que no tienen que ver con la formula
                if ((e.getKeyChar() < 112 || e.getKeyChar() > 122 || (e.getKeyChar() > 115 && e.getKeyChar() < 119)) && (e.getKeyChar() != 40 && e.getKeyChar() != 41)) {
                    e.consume();
                }
            }
        });

        // Text area de formula en forma polaca
        txtAreaPolish.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                // Se limpia e inhabilita el textArea que no se esta trabajando
                disableClearTextArea(txtAreaInfix);

                // Validacion para no tomar las teclas que no tienen que ver con la formula
                if ((e.getKeyChar() != 78 && e.getKeyChar() != 65 && e.getKeyChar() != 75 && e.getKeyChar() != 67 && e.getKeyChar() != 69)
                        && ((e.getKeyChar() < 112 || e.getKeyChar() > 122 || (e.getKeyChar() > 115 && e.getKeyChar() < 119)) && (e.getKeyChar() != 40 && e.getKeyChar() != 41))) {
                    e.consume();
                }
            }
        }
        );
    }

    /**
     * Se encarga de adiccionar al text area recibido como parametro el texto
     * del boton presionado
     *
     * @param text Texto del boton presionado
     * @param textArea Area de texto correspondiente al boton presionado
     */
    private void writeTextArea(String text, JTextArea textAreaWrite, JTextArea textAreaClear) {
        try {
            // Se limpia e inhabilita el textArea que no se esta trabajando
            disableClearTextArea(textAreaClear);
            // Se escribe en el textArea que se presiono el boton
            textAreaWrite.getDocument().insertString(textAreaWrite.getCaretPosition(), text, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al intentar escribir!", ex);
            JOptionPane.showMessageDialog(null, "Error al intentar escribir!");
        }
    }

    /**
     * Se encarga de limpiar las cajas de texto y habilitarlas
     */
    private void enableClearTextArea(JTextArea textArea) {
        textArea.setText("");
        textArea.setEnabled(true);
    }

    /**
     * Se encarga de deshabilitar y limpiar el texto del text area indicado
     *
     * @param textArea
     */
    private void disableClearTextArea(JTextArea textArea) {
        textArea.setText("");
        textArea.setEnabled(false);
    }

    /**
     * Valida que la formula ingresada en los campos este bien formada antes de
     * realizar las operaciones
     *
     * @param txtArea Es la caja de la cual se va tomar la formula
     * @param typeFormula Indica si es formula en forma infija o polaca
     */
    private void convertFormulas(JTextArea txtArea, int typeFormula) {

        // Tomamos la formula de la caja recibida por parametro
        String formula = txtArea.getText().replace(" ", "");

        // Se valida que sea una formula bien formada
        if (Convert.checkFormula(formula, typeFormula)) {

            // Se valida que contenga al menos 5 atomos la formula
            if (Convert.validateNumberAtoms(formula)) {
                Convert.convertFormula(formula, typeFormula);
            } else {
                JOptionPane.showMessageDialog(this, "Debe Ingresar Mínimo 5 \nFormas Proposicionales Atómicas");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresó una fórmula mal formada");
        }
    }

    /**
     * Metodo que permite dibujar el arbol
     */
    /*private void dibujarArbol() {
        try {
            paint(getGraphics());
            boolean sintactico = false;

            analizador = new AnalizadorProposicional();
            arbolS = analizador.crearArbolSintactico(cVisorFormula.getText());

            System.out.println("pArbolSintactico.getHeight() " + jPanel2.getHeight());
            if (sintactico == false) {
                arbolS.dibujarSubformula(arbolS,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 420,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 420,
                        jPanel2, Color.GREEN);

                System.out.println("arbol " + arbolS);

            } else if (sintactico == true) {
                arbolS.dibujarArbolSintactico(jPanel2.getGraphics(), arbolS,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 420,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 420,
                        jPanel2, Color.GREEN);

            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInfix = new javax.swing.JTextArea();
        btnOperatorInclusive = new javax.swing.JButton();
        btnOperatorConjunction = new javax.swing.JButton();
        btnOperatorEntonces = new javax.swing.JButton();
        btnOperatorNegation = new javax.swing.JButton();
        btnOperatorOnlyIf = new javax.swing.JButton();
        btnLetterR = new javax.swing.JButton();
        btnParentesis = new javax.swing.JButton();
        btnLetterY = new javax.swing.JButton();
        btnLetterP = new javax.swing.JButton();
        btnLetterQ = new javax.swing.JButton();
        btnLetterZ = new javax.swing.JButton();
        btnLetterW = new javax.swing.JButton();
        btnLetterS = new javax.swing.JButton();
        btnLetterX = new javax.swing.JButton();
        btnConvertInfix = new javax.swing.JButton();
        btnClearInfix = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaPolish = new javax.swing.JTextArea();
        btnClearPolish = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnLetterPPolish = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnLetterQPolish = new javax.swing.JButton();
        btnLetterYPolish = new javax.swing.JButton();
        btnLetterZPolish = new javax.swing.JButton();
        btnLetterWPolish = new javax.swing.JButton();
        btnLetterSPolish = new javax.swing.JButton();
        btnLetterXPolish = new javax.swing.JButton();
        btnConvertPolish = new javax.swing.JButton();
        btnOperatorInclusivePolish = new javax.swing.JButton();
        btnOperatorConjunctionPolish = new javax.swing.JButton();
        btnOperatorEntoncesPolish = new javax.swing.JButton();
        btnOperatorNegationPolish = new javax.swing.JButton();
        btnOperatorOnlyIfPolish = new javax.swing.JButton();
        btnLetterRPolish = new javax.swing.JButton();
        jmbMain = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Infija");

        txtAreaInfix.setColumns(20);
        txtAreaInfix.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        txtAreaInfix.setLineWrap(true);
        txtAreaInfix.setRows(5);
        jScrollPane1.setViewportView(txtAreaInfix);

        btnOperatorInclusive.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorInclusive.setText("( ) v ( )");
        btnOperatorInclusive.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorInclusive.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorInclusive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorInclusiveActionPerformed(evt);
            }
        });

        btnOperatorConjunction.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorConjunction.setText("( ) ^ ( )");
        btnOperatorConjunction.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorConjunction.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorConjunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorConjunctionActionPerformed(evt);
            }
        });

        btnOperatorEntonces.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorEntonces.setText("( ) → ( )");
        btnOperatorEntonces.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorEntonces.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorEntonces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorEntoncesActionPerformed(evt);
            }
        });

        btnOperatorNegation.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorNegation.setText("¬( )");
        btnOperatorNegation.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorNegation.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorNegation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorNegationActionPerformed(evt);
            }
        });

        btnOperatorOnlyIf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorOnlyIf.setText("( ) ↔ ( )");
        btnOperatorOnlyIf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOperatorOnlyIf.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorOnlyIf.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorOnlyIf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorOnlyIfActionPerformed(evt);
            }
        });

        btnLetterR.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterR.setText("r");
        btnLetterR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterRActionPerformed(evt);
            }
        });

        btnParentesis.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnParentesis.setText("( )");
        btnParentesis.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnParentesis.setPreferredSize(new java.awt.Dimension(51, 30));
        btnParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParentesisActionPerformed(evt);
            }
        });

        btnLetterY.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterY.setText("y");
        btnLetterY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterYActionPerformed(evt);
            }
        });

        btnLetterP.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterP.setText("p");
        btnLetterP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterPActionPerformed(evt);
            }
        });

        btnLetterQ.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterQ.setText("q");
        btnLetterQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterQActionPerformed(evt);
            }
        });

        btnLetterZ.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterZ.setText("z");
        btnLetterZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterZActionPerformed(evt);
            }
        });

        btnLetterW.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterW.setText("w");
        btnLetterW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterWActionPerformed(evt);
            }
        });

        btnLetterS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterS.setText("s");
        btnLetterS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterSActionPerformed(evt);
            }
        });

        btnLetterX.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterX.setText("x");
        btnLetterX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterXActionPerformed(evt);
            }
        });

        btnConvertInfix.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnConvertInfix.setText("Convertir");
        btnConvertInfix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertInfixActionPerformed(evt);
            }
        });

        btnClearInfix.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnClearInfix.setText("Limpiar");
        btnClearInfix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearInfixActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Operadores");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Formas Atómicas");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Polaca");

        txtAreaPolish.setColumns(20);
        txtAreaPolish.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        txtAreaPolish.setLineWrap(true);
        txtAreaPolish.setRows(5);
        jScrollPane3.setViewportView(txtAreaPolish);

        btnClearPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnClearPolish.setText("Limpiar");
        btnClearPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearPolishActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Operadores");

        btnLetterPPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterPPolish.setText("p");
        btnLetterPPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterPPolishActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Formas Atómicas");

        btnLetterQPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterQPolish.setText("q");
        btnLetterQPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterQPolishActionPerformed(evt);
            }
        });

        btnLetterYPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterYPolish.setText("y");
        btnLetterYPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterYPolishActionPerformed(evt);
            }
        });

        btnLetterZPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterZPolish.setText("z");
        btnLetterZPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterZPolishActionPerformed(evt);
            }
        });

        btnLetterWPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterWPolish.setText("w");
        btnLetterWPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterWPolishActionPerformed(evt);
            }
        });

        btnLetterSPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterSPolish.setText("s");
        btnLetterSPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterSPolishActionPerformed(evt);
            }
        });

        btnLetterXPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterXPolish.setText("x");
        btnLetterXPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterXPolishActionPerformed(evt);
            }
        });

        btnConvertPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnConvertPolish.setText("Convertir");
        btnConvertPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertPolishActionPerformed(evt);
            }
        });

        btnOperatorInclusivePolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorInclusivePolish.setText("A");
        btnOperatorInclusivePolish.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorInclusivePolish.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorInclusivePolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorInclusivePolishActionPerformed(evt);
            }
        });

        btnOperatorConjunctionPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorConjunctionPolish.setText("K");
        btnOperatorConjunctionPolish.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorConjunctionPolish.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorConjunctionPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorConjunctionPolishActionPerformed(evt);
            }
        });

        btnOperatorEntoncesPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorEntoncesPolish.setText("C");
        btnOperatorEntoncesPolish.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorEntoncesPolish.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorEntoncesPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorEntoncesPolishActionPerformed(evt);
            }
        });

        btnOperatorNegationPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorNegationPolish.setText("N");
        btnOperatorNegationPolish.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorNegationPolish.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorNegationPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorNegationPolishActionPerformed(evt);
            }
        });

        btnOperatorOnlyIfPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorOnlyIfPolish.setText("E");
        btnOperatorOnlyIfPolish.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOperatorOnlyIfPolish.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorOnlyIfPolish.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorOnlyIfPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorOnlyIfPolishActionPerformed(evt);
            }
        });

        btnLetterRPolish.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLetterRPolish.setText("r");
        btnLetterRPolish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterRPolishActionPerformed(evt);
            }
        });

        jmFile.setText("Archivo");
        jmFile.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jmiExit.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmiExit.setText("Salir");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmFile.add(jmiExit);

        jmbMain.add(jmFile);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(360, 360, 360)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel6)))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btnOperatorNegation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnOperatorInclusive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorOnlyIf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOperatorConjunction, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorEntonces, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLetterW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnLetterX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterZ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLetterP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterQ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConvertInfix, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearInfix, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOperatorNegationPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOperatorInclusivePolish, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOperatorConjunctionPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOperatorOnlyIfPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnOperatorEntoncesPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConvertPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLetterWPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnLetterXPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterYPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterZPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLetterPPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterQPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterRPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLetterSPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLetterW, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterZ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorInclusive, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorConjunction, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnOperatorNegation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLetterP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLetterQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLetterR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLetterS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConvertInfix, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClearInfix, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnOperatorEntonces, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnOperatorOnlyIf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnOperatorNegationPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorInclusivePolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLetterWPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterXPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterYPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterZPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorConjunctionPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorOnlyIfPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLetterPPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLetterQPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLetterRPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLetterSPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConvertPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClearPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOperatorEntoncesPolish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOperatorInclusiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorInclusiveActionPerformed
        writeTextArea(btnOperatorInclusive.getText().replace(" ", ""), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnOperatorInclusiveActionPerformed

    private void btnOperatorOnlyIfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorOnlyIfActionPerformed
        writeTextArea(btnOperatorOnlyIf.getText().replace(" ", ""), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnOperatorOnlyIfActionPerformed

    private void btnOperatorConjunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorConjunctionActionPerformed
        writeTextArea(btnOperatorConjunction.getText().replace(" ", ""), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnOperatorConjunctionActionPerformed

    private void btnOperatorNegationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorNegationActionPerformed
        writeTextArea(btnOperatorNegation.getText().replace(" ", ""), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnOperatorNegationActionPerformed

    private void btnParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParentesisActionPerformed
        writeTextArea(btnParentesis.getText().replace(" ", ""), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnParentesisActionPerformed

    private void btnOperatorEntoncesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorEntoncesActionPerformed
        writeTextArea(btnOperatorEntonces.getText().replace(" ", ""), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnOperatorEntoncesActionPerformed

    private void btnConvertInfixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertInfixActionPerformed
        convertFormulas(txtAreaInfix, Convert.INFIX_FORMULA);
    }//GEN-LAST:event_btnConvertInfixActionPerformed

    private void btnLetterPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterPActionPerformed
        writeTextArea(btnLetterP.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterPActionPerformed

    private void btnLetterQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterQActionPerformed
        writeTextArea(btnLetterQ.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterQActionPerformed

    private void btnLetterRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterRActionPerformed
        writeTextArea(btnLetterR.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterRActionPerformed

    private void btnLetterSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterSActionPerformed
        writeTextArea(btnLetterS.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterSActionPerformed

    private void btnLetterWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterWActionPerformed
        writeTextArea(btnLetterW.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterWActionPerformed

    private void btnLetterXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterXActionPerformed
        writeTextArea(btnLetterX.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterXActionPerformed

    private void btnLetterYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterYActionPerformed
        writeTextArea(btnLetterY.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterYActionPerformed

    private void btnLetterZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterZActionPerformed
        writeTextArea(btnLetterZ.getText(), txtAreaInfix, txtAreaPolish);
    }//GEN-LAST:event_btnLetterZActionPerformed

    private void btnClearInfixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearInfixActionPerformed
        enableClearTextArea(txtAreaInfix);
    }//GEN-LAST:event_btnClearInfixActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void btnClearPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearPolishActionPerformed
        enableClearTextArea(txtAreaPolish);
    }//GEN-LAST:event_btnClearPolishActionPerformed

    private void btnLetterYPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterYPolishActionPerformed
        writeTextArea(btnLetterYPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterYPolishActionPerformed

    private void btnLetterPPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterPPolishActionPerformed
        writeTextArea(btnLetterPPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterPPolishActionPerformed

    private void btnLetterQPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterQPolishActionPerformed
        writeTextArea(btnLetterQPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterQPolishActionPerformed

    private void btnLetterZPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterZPolishActionPerformed
        writeTextArea(btnLetterZPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterZPolishActionPerformed

    private void btnLetterWPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterWPolishActionPerformed
        writeTextArea(btnLetterWPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterWPolishActionPerformed

    private void btnLetterSPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterSPolishActionPerformed
        writeTextArea(btnLetterSPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterSPolishActionPerformed

    private void btnLetterXPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterXPolishActionPerformed
        writeTextArea(btnLetterXPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterXPolishActionPerformed

    private void btnConvertPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertPolishActionPerformed
        convertFormulas(txtAreaPolish, Convert.POLISH_FORMULA);
    }//GEN-LAST:event_btnConvertPolishActionPerformed

    private void btnOperatorInclusivePolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorInclusivePolishActionPerformed
        writeTextArea(btnOperatorInclusivePolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnOperatorInclusivePolishActionPerformed

    private void btnOperatorConjunctionPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorConjunctionPolishActionPerformed
        writeTextArea(btnOperatorConjunctionPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnOperatorConjunctionPolishActionPerformed

    private void btnOperatorEntoncesPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorEntoncesPolishActionPerformed
        writeTextArea(btnOperatorEntoncesPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnOperatorEntoncesPolishActionPerformed

    private void btnOperatorNegationPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorNegationPolishActionPerformed
        writeTextArea(btnOperatorNegationPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnOperatorNegationPolishActionPerformed

    private void btnOperatorOnlyIfPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorOnlyIfPolishActionPerformed
        writeTextArea(btnOperatorOnlyIfPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnOperatorOnlyIfPolishActionPerformed

    private void btnLetterRPolishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterRPolishActionPerformed
        writeTextArea(btnLetterRPolish.getText(), txtAreaPolish, txtAreaInfix);
    }//GEN-LAST:event_btnLetterRPolishActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearInfix;
    private javax.swing.JButton btnClearPolish;
    private javax.swing.JButton btnConvertInfix;
    private javax.swing.JButton btnConvertPolish;
    private javax.swing.JButton btnLetterP;
    private javax.swing.JButton btnLetterPPolish;
    private javax.swing.JButton btnLetterQ;
    private javax.swing.JButton btnLetterQPolish;
    private javax.swing.JButton btnLetterR;
    private javax.swing.JButton btnLetterRPolish;
    private javax.swing.JButton btnLetterS;
    private javax.swing.JButton btnLetterSPolish;
    private javax.swing.JButton btnLetterW;
    private javax.swing.JButton btnLetterWPolish;
    private javax.swing.JButton btnLetterX;
    private javax.swing.JButton btnLetterXPolish;
    private javax.swing.JButton btnLetterY;
    private javax.swing.JButton btnLetterYPolish;
    private javax.swing.JButton btnLetterZ;
    private javax.swing.JButton btnLetterZPolish;
    private javax.swing.JButton btnOperatorConjunction;
    private javax.swing.JButton btnOperatorConjunctionPolish;
    private javax.swing.JButton btnOperatorEntonces;
    private javax.swing.JButton btnOperatorEntoncesPolish;
    private javax.swing.JButton btnOperatorInclusive;
    private javax.swing.JButton btnOperatorInclusivePolish;
    private javax.swing.JButton btnOperatorNegation;
    private javax.swing.JButton btnOperatorNegationPolish;
    private javax.swing.JButton btnOperatorOnlyIf;
    private javax.swing.JButton btnOperatorOnlyIfPolish;
    private javax.swing.JButton btnParentesis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JTextArea txtAreaInfix;
    private javax.swing.JTextArea txtAreaPolish;
    // End of variables declaration//GEN-END:variables
}

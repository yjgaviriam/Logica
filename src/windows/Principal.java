package windows;

/*import logica.AnalizadorProposicional;
import logica.Nodo;
import logica.Parser;*/
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

/**
 * Ventana principal de la aplicación
 *
 * @author xJoni
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Cadena que guarda la formula ingresada
     */
    // public String formula = "";
    /**
     * Arraylist de la formula
     */
    // ArrayList<String> formulas = new ArrayList<>();
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
        initComponents();
        disableKeyboard();
    }

    private void writeTextArea(String text, JTextArea textArea) {
        try {
            textArea.getDocument().insertString(textArea.getCaretPosition(), text, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "No se logro escribir en Display", ex);
        }
    }

    /**
     * Permite validar que teclas se permitirán en los campos de ingreso de
     * formulas
     *
     * @see
     * http://www.javacreed.com/how-to-capture-key-events-with-jframe-or-window/
     */
    private void disableKeyboard() {

        // Text area de formula en forma infija
        txtAreaInfija.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() < 112 || e.getKeyChar() > 122) {
                    e.consume();
                }
            }
        });

        // Text area de formula en forma polaca
        txtAreaPolaca.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() < 112 || e.getKeyChar() > 122) {
                    e.consume();
                }
            }
        });
    }

    /**
     * Metodo que analiza la formula que se le ingresa a traves del textArea
     */
    private void analizarFormulas() {
        // formulas.clear();
        //Parser.hallarFormulas(cVisorFormula.getText().replace(" ", ""));
        //formulas = Parser.getFormulas();
        /*if (Parser.bienFormada(formulas)) {

            Parser.encontrarFormulasRepetidas();
            Parser.literales(formulas);

            if (Parser.getAtomos().size() >= 5) {
                boolean sa = Parser.verSatisfacibilidad(Parser.getTabla());
                if (sa) {
                    estad[3] = "Es satisfacible";
                    dibujarArbol();
                } else {
                    estad[3] = "No es satisfacible";
                }

                imprimirTablaConsola();
                estadistica();
            } else {
                JOptionPane.showMessageDialog(this, "Debe Ingresar Mínimo 5\nFormas Proposicionales Atómicas");
                jLEstad.setText("");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingresó una fórmula mal formada");
        }*/
    }

    /**
     * Metodo que recopila la informacion de la formula guardada en un arreglo y
     * la muestra en la interfaz
     */
    /*public void estadistica() {
        char op = Parser.buscarOpPrincipal(Parser.getFormulas().get(0));
        estad[0] = "Operador principal: " + op;
        int num = Parser.getAtomos().size();
        estad[1] = "N° átomos: " + num;
        System.out.println("Caracter: " + op);
        jLEstad.setText("Estadistica: " + estad[0] + " | " + estad[1] + " | " + estad[2] + " | " + estad[3]);

    }*/
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

        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInfija = new javax.swing.JTextArea();
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
        btnConvertInfija = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaPolaca = new javax.swing.JTextArea();
        jmbMain = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiExit = new javax.swing.JMenuItem();

        jButton7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton7.setText("()^()");

        jButton8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton8.setText("()V()");

        jButton9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton9.setText("()V()");

        jButton10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton10.setText("()^()");

        jButton11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton11.setText("()V()");

        jButton17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton17.setText("()V()");

        jButton18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton18.setText("()^()");

        jButton19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton19.setText("()^()");

        jButton20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton20.setText("()V()");

        jButton21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton21.setText("()V()");

        jButton22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton22.setText("()V()");

        jButton23.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton23.setText("()^()");

        jButton24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton24.setText("()V()");

        jButton25.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton25.setText("()^()");

        jButton26.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton26.setText("()V()");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Infija");

        txtAreaInfija.setColumns(20);
        txtAreaInfija.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        txtAreaInfija.setLineWrap(true);
        txtAreaInfija.setRows(5);
        jScrollPane1.setViewportView(txtAreaInfija);

        btnOperatorInclusive.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorInclusive.setText("( )v( )");
        btnOperatorInclusive.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorInclusive.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorInclusive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorInclusiveActionPerformed(evt);
            }
        });

        btnOperatorConjunction.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorConjunction.setText("()^()");
        btnOperatorConjunction.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorConjunction.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorConjunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorConjunctionActionPerformed(evt);
            }
        });

        btnOperatorEntonces.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorEntonces.setText("()→()");
        btnOperatorEntonces.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorEntonces.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorEntonces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorEntoncesActionPerformed(evt);
            }
        });

        btnOperatorNegation.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorNegation.setText("¬()");
        btnOperatorNegation.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOperatorNegation.setPreferredSize(new java.awt.Dimension(51, 30));
        btnOperatorNegation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorNegationActionPerformed(evt);
            }
        });

        btnOperatorOnlyIf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOperatorOnlyIf.setText("()↔()");
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

        btnConvertInfija.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnConvertInfija.setText("Convertir");
        btnConvertInfija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertInfijaActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tableaux", jPanel2);

        btnClear.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Operadores");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Formas Atómicas");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Polaca");

        txtAreaPolaca.setColumns(20);
        txtAreaPolaca.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        txtAreaPolaca.setLineWrap(true);
        txtAreaPolaca.setRows(5);
        jScrollPane3.setViewportView(txtAreaPolaca);

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
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(btnOperatorEntonces, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
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
                        .addComponent(btnConvertInfija, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorNegation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnOperatorInclusive, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorConjunction, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOperatorEntonces, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOperatorOnlyIf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLetterP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLetterW, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLetterZ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConvertInfija, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOperatorInclusiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorInclusiveActionPerformed
        writeTextArea(btnOperatorInclusive.getText().replace(" ", ""), txtAreaInfija);
    }//GEN-LAST:event_btnOperatorInclusiveActionPerformed

    private void btnOperatorOnlyIfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorOnlyIfActionPerformed
        writeTextArea(btnOperatorOnlyIf.getText().replace(" ", ""), txtAreaInfija);
    }//GEN-LAST:event_btnOperatorOnlyIfActionPerformed

    private void btnOperatorConjunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorConjunctionActionPerformed
        writeTextArea(btnOperatorConjunction.getText().replace(" ", ""), txtAreaInfija);
    }//GEN-LAST:event_btnOperatorConjunctionActionPerformed

    private void btnOperatorNegationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorNegationActionPerformed
        writeTextArea(btnOperatorNegation.getText().replace(" ", ""), txtAreaInfija);
    }//GEN-LAST:event_btnOperatorNegationActionPerformed

    private void btnParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParentesisActionPerformed
        writeTextArea(btnParentesis.getText().replace(" ", ""), txtAreaInfija);
    }//GEN-LAST:event_btnParentesisActionPerformed

    private void btnOperatorEntoncesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorEntoncesActionPerformed
        writeTextArea(btnOperatorEntonces.getText().replace(" ", ""), txtAreaInfija);
    }//GEN-LAST:event_btnOperatorEntoncesActionPerformed

    private void btnConvertInfijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertInfijaActionPerformed
        analizarFormulas();
    }//GEN-LAST:event_btnConvertInfijaActionPerformed

    private void btnLetterPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterPActionPerformed
        writeTextArea(btnLetterP.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterPActionPerformed

    private void btnLetterQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterQActionPerformed
        writeTextArea(btnLetterQ.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterQActionPerformed

    private void btnLetterRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterRActionPerformed
        writeTextArea(btnLetterR.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterRActionPerformed

    private void btnLetterSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterSActionPerformed
        writeTextArea(btnLetterS.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterSActionPerformed

    private void btnLetterWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterWActionPerformed
        writeTextArea(btnLetterW.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterWActionPerformed

    private void btnLetterXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterXActionPerformed
        writeTextArea(btnLetterX.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterXActionPerformed

    private void btnLetterYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterYActionPerformed
        writeTextArea(btnLetterY.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterYActionPerformed

    private void btnLetterZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterZActionPerformed
        writeTextArea(btnLetterZ.getText(), txtAreaInfija);
    }//GEN-LAST:event_btnLetterZActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtAreaInfija.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConvertInfija;
    private javax.swing.JButton btnLetterP;
    private javax.swing.JButton btnLetterQ;
    private javax.swing.JButton btnLetterR;
    private javax.swing.JButton btnLetterS;
    private javax.swing.JButton btnLetterW;
    private javax.swing.JButton btnLetterX;
    private javax.swing.JButton btnLetterY;
    private javax.swing.JButton btnLetterZ;
    private javax.swing.JButton btnOperatorConjunction;
    private javax.swing.JButton btnOperatorEntonces;
    private javax.swing.JButton btnOperatorInclusive;
    private javax.swing.JButton btnOperatorNegation;
    private javax.swing.JButton btnOperatorOnlyIf;
    private javax.swing.JButton btnParentesis;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JTextArea txtAreaInfija;
    private javax.swing.JTextArea txtAreaPolaca;
    // End of variables declaration//GEN-END:variables
}

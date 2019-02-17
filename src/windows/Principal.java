package windows;

/*import logica.AnalizadorProposicional;
import logica.Nodo;
import logica.Parser;*/
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        validarTeclado();
    }


    private void escribir(String valor) {
        try {
            txtAreaInfija.getDocument().insertString(txtAreaInfija.getCaretPosition(), valor, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "No se logro escribir en Display", ex);
        }
    }

    /**
     * Metodo que permite escribir e identificar la letra presionada
     *
     * @param evt evento del teclado
     */
    private void escribir(java.awt.event.KeyEvent evt) {
        //97 = a q= 113 z=122
        String form = txtAreaInfija.getText();
        System.out.println("Tecla Presionada ..." + evt.getKeyCode());
//        if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90) {
//            escribir(String.valueOf(evt.getKeyChar()));
//        }else{
//            evt.consume();
//        }

        if (evt.getKeyCode() < 65 && evt.getKeyChar() > 90) {
            evt.consume();
        }
    }

    /**
     * Metodo que valida el texto ingresado, y limita lo que se desea ingresar
     *
     * @see
     * http://www.javacreed.com/how-to-capture-key-events-with-jframe-or-window/
     */
    private void validarTeclado() {
        txtAreaInfija.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int c = e.getKeyChar();
                //System.out.println("Tecla presionada " + c);
                if (c < 112 || c > 122) {
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
        operatorInclusive = new javax.swing.JButton();
        operatorConjunction = new javax.swing.JButton();
        operator = new javax.swing.JButton();
        operatorNegation = new javax.swing.JButton();
        operatorOnlyIf = new javax.swing.JButton();
        leterR = new javax.swing.JButton();
        btParentesis = new javax.swing.JButton();
        btnY = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnZ = new javax.swing.JButton();
        btnW = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btAnalizar = new javax.swing.JButton();
        jLEstad = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVerdad = new javax.swing.JTable();
        btAnalizar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cVisorFormula1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

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
        txtAreaInfija.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtAreaInfija.setLineWrap(true);
        txtAreaInfija.setRows(5);
        txtAreaInfija.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaInfijaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaInfija);

        operatorInclusive.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        operatorInclusive.setText("( )v( )");
        operatorInclusive.setMargin(new java.awt.Insets(0, 0, 0, 0));
        operatorInclusive.setPreferredSize(new java.awt.Dimension(51, 30));
        operatorInclusive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatorInclusiveActionPerformed(evt);
            }
        });

        operatorConjunction.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        operatorConjunction.setText("()^()");
        operatorConjunction.setMargin(new java.awt.Insets(0, 0, 0, 0));
        operatorConjunction.setPreferredSize(new java.awt.Dimension(51, 30));
        operatorConjunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatorConjunctionActionPerformed(evt);
            }
        });

        operator.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        operator.setText("()→()");
        operator.setMargin(new java.awt.Insets(0, 0, 0, 0));
        operator.setPreferredSize(new java.awt.Dimension(51, 30));
        operator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatorActionPerformed(evt);
            }
        });

        operatorNegation.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        operatorNegation.setText("¬()");
        operatorNegation.setMargin(new java.awt.Insets(0, 0, 0, 0));
        operatorNegation.setPreferredSize(new java.awt.Dimension(51, 30));
        operatorNegation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatorNegationActionPerformed(evt);
            }
        });

        operatorOnlyIf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        operatorOnlyIf.setText("()↔()");
        operatorOnlyIf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        operatorOnlyIf.setMargin(new java.awt.Insets(0, 0, 0, 0));
        operatorOnlyIf.setPreferredSize(new java.awt.Dimension(51, 30));
        operatorOnlyIf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatorOnlyIfActionPerformed(evt);
            }
        });

        leterR.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        leterR.setText("r");
        leterR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leterRActionPerformed(evt);
            }
        });

        btParentesis.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btParentesis.setText("( )");
        btParentesis.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btParentesis.setPreferredSize(new java.awt.Dimension(51, 30));
        btParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParentesisActionPerformed(evt);
            }
        });

        btnY.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnY.setText("y");
        btnY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYActionPerformed(evt);
            }
        });

        btnP.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnP.setText("p");
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });

        btnQ.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnQ.setText("q");
        btnQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQActionPerformed(evt);
            }
        });

        btnZ.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnZ.setText("z");
        btnZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZActionPerformed(evt);
            }
        });

        btnW.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnW.setText("w");
        btnW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWActionPerformed(evt);
            }
        });

        btnS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnS.setText("s");
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        btnX.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnX.setText("x");
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        btAnalizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btAnalizar.setText("Convertir");
        btAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnalizarActionPerformed(evt);
            }
        });

        jLEstad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLEstad.setText("Estadística: ");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaVerdad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaVerdad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tabla de Verdad", jPanel1);

        btAnalizar1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btAnalizar1.setText("Limpiar");
        btAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnalizar1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Operadores");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Formas Atómicas");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Polaca");

        cVisorFormula1.setColumns(20);
        cVisorFormula1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        cVisorFormula1.setLineWrap(true);
        cVisorFormula1.setRows(5);
        cVisorFormula1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cVisorFormula1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(cVisorFormula1);

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLEstad, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(operatorNegation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(operatorInclusive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(operatorOnlyIf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(operatorConjunction, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(operator, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(leterR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAnalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(operatorNegation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(operatorInclusive, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(operatorConjunction, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(operator, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(operatorOnlyIf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(leterR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnW, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btAnalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLEstad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void operatorInclusiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatorInclusiveActionPerformed
        escribir(operatorInclusive.getText());
//        formula = Parser.ingresar(formula, btY.getText());
//        cVisorFormula.setText(formula);
    }//GEN-LAST:event_operatorInclusiveActionPerformed

    private void operatorOnlyIfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatorOnlyIfActionPerformed
        escribir(operatorOnlyIf.getText());
    }//GEN-LAST:event_operatorOnlyIfActionPerformed

    private void operatorConjunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatorConjunctionActionPerformed
        escribir(operatorConjunction.getText());
    }//GEN-LAST:event_operatorConjunctionActionPerformed

    private void operatorNegationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatorNegationActionPerformed
        escribir(operatorNegation.getText());
    }//GEN-LAST:event_operatorNegationActionPerformed

    private void txtAreaInfijaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaInfijaKeyReleased
        //noRecibirLetras(evt);
        //escribir(evt);
    }//GEN-LAST:event_txtAreaInfijaKeyReleased

    private void btParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParentesisActionPerformed
        escribir(btParentesis.getText());
    }//GEN-LAST:event_btParentesisActionPerformed

    private void operatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatorActionPerformed
        escribir(operator.getText());
    }//GEN-LAST:event_operatorActionPerformed

    private void btAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnalizarActionPerformed
        analizarFormulas();
    }//GEN-LAST:event_btAnalizarActionPerformed

    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPActionPerformed
        escribir(btnP.getText());
//        formula = Parser.ingresar(formula, btnP.getText());
//        cVisorFormula.setText(formula);
    }//GEN-LAST:event_btnPActionPerformed

    private void btnQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQActionPerformed
        escribir(btnQ.getText());
    }//GEN-LAST:event_btnQActionPerformed

    private void leterRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leterRActionPerformed
        escribir(leterR.getText());
    }//GEN-LAST:event_leterRActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        escribir(btnS.getText());
    }//GEN-LAST:event_btnSActionPerformed

    private void btnWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWActionPerformed
        escribir(btnW.getText());
    }//GEN-LAST:event_btnWActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        escribir(btnX.getText());
    }//GEN-LAST:event_btnXActionPerformed

    private void btnYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYActionPerformed
        escribir(btnY.getText());
    }//GEN-LAST:event_btnYActionPerformed

    private void btnZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZActionPerformed
        escribir(btnZ.getText());
    }//GEN-LAST:event_btnZActionPerformed

    private void btAnalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnalizar1ActionPerformed
        txtAreaInfija.setText("");
        jLEstad.setText("");
        tablaVerdad.setModel(new DefaultTableModel());
    }//GEN-LAST:event_btAnalizar1ActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void cVisorFormula1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cVisorFormula1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cVisorFormula1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnalizar;
    private javax.swing.JButton btAnalizar1;
    private javax.swing.JButton btParentesis;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnQ;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnW;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnY;
    private javax.swing.JButton btnZ;
    private javax.swing.JTextArea cVisorFormula1;
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
    private javax.swing.JLabel jLEstad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton leterR;
    private javax.swing.JButton operator;
    private javax.swing.JButton operatorConjunction;
    private javax.swing.JButton operatorInclusive;
    private javax.swing.JButton operatorNegation;
    private javax.swing.JButton operatorOnlyIf;
    private javax.swing.JTable tablaVerdad;
    private javax.swing.JTextArea txtAreaInfija;
    // End of variables declaration//GEN-END:variables
}

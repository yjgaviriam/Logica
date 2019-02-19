package windows;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import logic.Node;

public class TreePolish extends JPanel {

    private Node root;

    public TreePolish(Node root) {
        this.root = root;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawTree(this.root, 350, 40, 350, 40, graphics, Color.CYAN, true, "linea");
        drawTree(this.root, 350, 40, 350, 40, graphics, Color.CYAN, true, "oval");
    }

    public void drawTree(Node nodeActual, int x, int y, int x2, int y2, Graphics g, Color colorP, boolean isFirstNode, String figura) {

        if (nodeActual != null) {

            if (figura.equals("linea")) {
                g.setColor(Color.BLACK);
                g.drawLine(x2 + 15, y2 + 15, x + 15, y + 15);
            } else {

                //el dibujo del circulo dependiendo la cantidad de letras y simbolos
                g.setColor(colorP);
                g.fillOval(x, y, 30, 30);
                g.setColor(Color.BLACK);
                g.drawString("" + nodeActual.getValue(), (x) + 14, (y) + 20);
            }

            if (nodeActual.getNegation() != null) {
                drawTree(nodeActual.getNegation(), x, y + 60, x, y, g, colorP, false, figura);
            }

            if (nodeActual.getRight() != null) {
                drawTree(nodeActual.getRight(), x + 60, y, x, y, g, colorP, false, figura);
            }
        }

    }
}

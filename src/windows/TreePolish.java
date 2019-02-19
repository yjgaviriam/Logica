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

            if (nodeActual.getLeft()!= null) {
                drawTree(nodeActual.getLeft(), x, y + (width(height(nodeActual))), x, y, g, colorP, false, figura);
            }

            if (nodeActual.getRight() != null) {
                drawTree(nodeActual.getRight(), x + (width(height(nodeActual))), y, x, y, g, colorP, false, figura);
            }
        }

    }
    
    public int height(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else {
            int p1 = (node.getLeft() == null) ? 0 : height(node.getLeft());
            int p2 = (node.getRight() == null) ? 0 : height(node.getRight());

            return Math.max(p1, p2) + 1;
        }
    }

    public int width(int n) {

        if (n == 6) {
            return 500;
        }
        if (n == 5) {
            return 400;
        }
        if (n == 4) {
            return 300;
        }
        if (n == 3) {
            return 200;
        }
        if (n == 2) {
            return 100;
        }
        if (n == 1) {
            return 0;
        }
        return 0;
    }
}

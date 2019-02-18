package windows;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import logic.Node;

public class Tree extends JPanel {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        dibujarSubformula(this.root, 350, 40, 90, 55, graphics, Color.ORANGE, true);
    }

    public void dibujarSubformula(Node nodeActual, int x, int y, int x2, int y2, Graphics g, Color colorP, boolean isFirstNode) {

        if (nodeActual != null) {

            if (!isFirstNode) {
                g.setColor(Color.BLACK);
                g.drawLine(x + 15, y + 3, x2 + 15, y2 + 30);
            }

            //el dibujo del circulo dependiendo la cantidad de letras y simbolos
            g.setColor(colorP);
            g.fillOval(x, y, 30, 30);
            g.setColor(Color.BLACK);
            g.drawString("" + nodeActual.getValue(), (x) + 11, (y) + 20);

            if (nodeActual.getNegation() != null) {
                dibujarSubformula(nodeActual.getNegation(), (x) - (anchoX(altura(nodeActual))), y + 100, x, y, g, colorP, false);
            }

            if (nodeActual.getLeft() != null) {
                dibujarSubformula(nodeActual.getLeft(), (x) - (anchoX(altura(nodeActual))), y + 100, x, y, g, colorP, false);

            }

            if (nodeActual.getRight() != null) {
                dibujarSubformula(nodeActual.getRight(), (x) + (anchoX(altura(nodeActual))), y + 100, x, y, g, colorP, false);
            }

        }

    }

    public int altura(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else {
            int p1 = (node.getLeft() == null) ? 0 : altura(node.getLeft());
            int p2 = (node.getRight() == null) ? 0 : altura(node.getRight());

            return Math.max(p1, p2) + 1;
        }
    }

    public int anchoX(int n) {

        if (n == 6) {
            return 300;
        }
        if (n == 5) {
            return 180;
        }
        if (n == 4) {
            return 130;
        }
        if (n == 3) {
            return 80;
        }
        if (n == 2) {
            return 30;
        }
        if (n == 1) {
            return 0;
        }
        return 0;
    }

}

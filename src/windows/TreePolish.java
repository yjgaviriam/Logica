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
        drawTree(this.root, 20, 20, 20, 20, graphics, Color.CYAN, "linea");
        drawTree(this.root, 20, 20, 20, 20, graphics, Color.CYAN, "oval");
    }

    public void drawTree(Node nodeActual, int x, int y, int x2, int y2, Graphics g, Color colorP, String figura) {

        if (figura.equals("linea")) {
            g.setColor(Color.BLACK);
            g.drawLine(x2 + 12, y2 + 12, x + 12, y + 12);
        } else {

            //el dibujo del circulo dependiendo la cantidad de letras y simbolos
            g.setColor(colorP);
            g.fillOval(x, y, 24, 24);
            g.setColor(Color.BLACK);
            g.drawString("" + nodeActual.getValue(), (x) + 8, (y) + 15);
        }

        if (nodeActual.getLeft() != null) {
            drawTree(nodeActual.getLeft(), x, y + (height(nodeActual, 0) * 30), x, y, g, colorP, figura);
        }

        if (nodeActual.getRight() != null) {
            drawTree(nodeActual.getRight(), x + (width(nodeActual, 0) * 30), y, x, y, g, colorP, figura);
        }
    }

    public int height(Node node, int level) {
        if (node.getLeft() == null) {
            return level;
        } else {
            return height(node.getLeft(), level + 1);
        }
    }

    public int width(Node node, int level) {
        if (node.getRight() == null) {
            return level;
        } else {
            return width(node.getRight(), level + 1);
        }
    }
}

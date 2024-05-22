import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GraphPanel extends JPanel {
    // Define nodes and their positions
    private int[][] nodePositions = {
        {100, 150}, // City A
        {200, 50},  // City B
        {200, 250}, // City C
        {300, 150}, // City D
        {400, 150}  // City E
    };
    
    // Define edges and their travel times
    private int[][] edges = {
        {0, 1, 4},  // A to B (4)
        {0, 2, 2},  // A to C (2)
        {1, 2, 5},  // B to C (5)
        {1, 3, 10}, // B to D (10)
        {2, 3, 3},  // C to D (3)
        {3, 4, 11}, // D to E (11)
        {2, 4, 4}   // C to E (4)
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw edges
        g2d.setStroke(new BasicStroke(2));
        for (int[] edge : edges) {
            int x1 = nodePositions[edge[0]][0];
            int y1 = nodePositions[edge[0]][1];
            int x2 = nodePositions[edge[1]][0];
            int y2 = nodePositions[edge[1]][1];
            g2d.drawLine(x1, y1, x2, y2);
            String label = String.valueOf(edge[2]);
            g2d.drawString(label, (x1 + x2) / 2, (y1 + y2) / 2);
        }

        // Draw nodes
        for (int i = 0; i < nodePositions.length; i++) {
            g2d.fill(new Ellipse2D.Double(nodePositions[i][0] - 15, nodePositions[i][1] - 15, 30, 30));
            g2d.setColor(Color.WHITE);
            g2d.drawString("City " + (char) ('A' + i), nodePositions[i][0] - 10, nodePositions[i][1] + 5);
            g2d.setColor(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Directed Graph Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GraphPanel());
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

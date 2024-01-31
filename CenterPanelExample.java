import javax.swing.*;
import java.awt.*;

public class CenterPanelExample extends JFrame {

    public CenterPanelExample() {
        setTitle("Center JPanel Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel outerPanel = new JPanel(new GridBagLayout());
        JPanel innerPanel = new JPanel();

        // Set a border just for visualization
        innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        outerPanel.add(innerPanel, gbc);

        // Add components to the innerPanel as needed
        JButton button = new JButton("Click me");
        innerPanel.add(button);

        // Set the content pane of the JFrame
        setContentPane(outerPanel);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CenterPanelExample().setVisible(true);
        });
    }
}


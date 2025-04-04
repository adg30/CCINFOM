package view;

import controller.RestaurantController;
import util.StyledComponents;
import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
    private final RestaurantController controller;
    private final JTabbedPane tabbedPane;
    private final OrderPanel orderPanel;
    private final PaymentPanel paymentPanel;
    private final ShiftManagementPanel shiftPanel;
    private final JButton helpButton;

    public TransactionsPanel(RestaurantController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        // Create help button
        helpButton = StyledComponents.createStyledButton("Help", new Color(108, 117, 125));
        helpButton.addActionListener(e -> showHelp());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(helpButton);
        add(topPanel, BorderLayout.NORTH);

        // Initialize panels
        orderPanel = new OrderPanel(controller);
        paymentPanel = new PaymentPanel(controller);
        shiftPanel = new ShiftManagementPanel(controller);

        // Create tabbed pane with custom styling
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font(tabbedPane.getFont().getName(), Font.BOLD, 14));
        tabbedPane.setBackground(new Color(240, 240, 240));
        tabbedPane.setForeground(new Color(50, 50, 50));
        
        // Add tabs without icons
        tabbedPane.addTab("Orders", orderPanel);
        tabbedPane.addTab("Payments", paymentPanel);
        tabbedPane.addTab("Shifts", shiftPanel);

        // Add components
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void showHelp() {
        String helpText = """
            Transactions Management Help:
            
            1. Orders Tab:
               • Create and manage customer orders
               • Add items to orders
               • Track order status
               • View order history
            
            2. Payments Tab:
               • Process payments for orders
               • View unpaid orders
               • Generate receipts
               • Track payment status
            
            3. Shifts Tab:
               • Manage employee shifts
               • Track attendance
               • View shift schedules
               • Monitor employee hours
            
            4. Additional Features:
               • Switch between tabs for different functions
               • Use the help button in each tab for specific guidance
               • All changes are saved automatically
            """;
        
        JOptionPane.showMessageDialog(this,
            helpText,
            "Transactions Management Help",
            JOptionPane.INFORMATION_MESSAGE);
    }
} 
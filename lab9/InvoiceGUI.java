package labs.lab9;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InvoiceGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InvoiceGUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Invoicer - Emily Navarro - 12345678");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Customer Info Panel
        JPanel customerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));

        customerPanel.add(new JLabel("Bill To:"));
        customerPanel.add(new JLabel("Ship To:"));

        JTextArea billToArea = new JTextArea(4, 20);
        billToArea.setText("Emily Navarro\nP.O. Box 283\nHappy Hills, CA 12345");
        JScrollPane billScroll = new JScrollPane(billToArea);

        JTextArea shipToArea = new JTextArea(4, 20);
        shipToArea.setText("Robert's Pet Store\n0101 Furry Friends Dr.\nSuite 203\nWagville, CA 54321\nUSA");
        JScrollPane shipScroll = new JScrollPane(shipToArea);

        customerPanel.add(billScroll);
        customerPanel.add(shipScroll);

        customerPanel.add(new JLabel("State:"));
        JComboBox<String> stateDropdown = new JComboBox<>(new String[]{"CA", "NY", "TX", "FL"});
        customerPanel.add(stateDropdown);

        JCheckBox premiumCustomer = new JCheckBox("Premium Customer?");
        customerPanel.add(premiumCustomer);

        // Coupon Selection
        JPanel couponPanel = new JPanel();
        couponPanel.setBorder(BorderFactory.createTitledBorder("Coupon"));
        ButtonGroup couponGroup = new ButtonGroup();
        String[] discounts = {"None", "5%", "10%", "15%", "20%"};
        for (String discount : discounts) {
            JRadioButton rb = new JRadioButton(discount);
            couponGroup.add(rb);
            couponPanel.add(rb);
        }

        // Invoice Info Panel
        JPanel invoicePanel = new JPanel(new GridLayout(3, 2));
        invoicePanel.setBorder(BorderFactory.createTitledBorder("Invoice Info"));
        invoicePanel.add(new JLabel("Invoice Number: 1"));
        invoicePanel.add(new JLabel("Invoice Date: 2024-10-15"));
        invoicePanel.add(new JLabel("Due Date: 2024-11-14"));

        // Items Panel
        JTextArea itemsArea = new JTextArea(6, 40);
        itemsArea.setText("stuffed elephant ($14.00 x 5 = $70.00)\n"
                + "twisted rope toy ($9.54 x 11 = $104.94)\n"
                + "Pumpkin doggie treats ($5.40 x 19 = $102.60)\n"
                + "Turkey jerky ($1.50 x 250 = $375.00)\n"
                + "Snuggly fleece blanket ($1,500.49 x 1 = $1,500.49)\n"
                + "Diamond-encrusted collar ($4,000.00 x 1 = $4,000.00)\n"
                + "Ugly Christmas sweater for dog ($19.99 x 4 = $79.96)");
        JScrollPane itemsScroll = new JScrollPane(itemsArea);

        JPanel itemsPanel = new JPanel();
        itemsPanel.setBorder(BorderFactory.createTitledBorder("Items"));
        itemsPanel.setLayout(new BorderLayout());
        itemsPanel.add(itemsScroll, BorderLayout.CENTER);
        JButton addItemButton = new JButton("Add Item");
        itemsPanel.add(addItemButton, BorderLayout.SOUTH);

        // Totals Panel
        JPanel totalsPanel = new JPanel(new GridLayout(4, 2));
        totalsPanel.add(new JLabel("Subtotal: "));
        totalsPanel.add(new JLabel("$6,331.99"));
        totalsPanel.add(new JLabel("Sales Tax (8.85%): "));
        totalsPanel.add(new JLabel("$560.38"));
        totalsPanel.add(new JLabel("Discount: "));
        totalsPanel.add(new JLabel("-$1,276.40"));
        totalsPanel.add(new JLabel("TOTAL: "));
        totalsPanel.add(new JLabel("$5,615.97"));

        // Adding components to main panel
        mainPanel.add(customerPanel);
        mainPanel.add(couponPanel);
        mainPanel.add(invoicePanel);
        mainPanel.add(itemsPanel);
        mainPanel.add(totalsPanel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

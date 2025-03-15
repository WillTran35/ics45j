package labs.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoicer extends JFrame {
    private JTextArea billToTextArea, shipToTextArea;
    private JComboBox<String> stateComboBox;
    private JCheckBox premiumCustomerCheckBox;
    private JRadioButton noneRadioButton, fivePercentRadioButton, tenPercentRadioButton, fifteenPercentRadioButton, twentyPercentRadioButton;
    private JLabel invoiceNumberLabel, invoiceDateLabel, dueDateLabel;
    private JList<String> itemsList;
    private DefaultListModel<String> itemsListModel;
    private JLabel subtotalLabel, salesTaxLabel, discountLabel, totalLabel;
    private int invoiceNumber = 1;
    private double subtotal = 0.0;
    private Map<String, Double> stateTaxRates;

    public Invoicer() {
        setTitle("Invoice - William Tran - 62406040");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        stateTaxRates = new HashMap<>();
        stateTaxRates.put("AK", 1.82);
        stateTaxRates.put("CA", 8.85);
        stateTaxRates.put("HI", 4.50);
        stateTaxRates.put("ID", 6.03);
        stateTaxRates.put("IL", 8.85);
        stateTaxRates.put("IN", 7.00);
        stateTaxRates.put("LA", 9.56);
        stateTaxRates.put("MI", 6.00);
        stateTaxRates.put("NY", 8.53);
        stateTaxRates.put("WI", 5.70);


        JPanel customerInfoPanel = createCustomerInfoPanel();
        JPanel invoiceInfoPanel = createInvoiceInfoPanel();
        JPanel itemsAndTotalsPanel = createItemsAndTotalsPanel();


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(customerInfoPanel);
        mainPanel.add(invoiceInfoPanel);
        mainPanel.add(itemsAndTotalsPanel);


        add(mainPanel, BorderLayout.CENTER);


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);


        JMenu newInvoiceMenu = new JMenu("Invoice");
        JMenuItem newInvoiceMenuItem = new JMenuItem("New Invoice");
        newInvoiceMenu.add(newInvoiceMenuItem);
        menuBar.add(newInvoiceMenu);


        setJMenuBar(menuBar);


        newInvoiceMenuItem.addActionListener(e -> resetInvoice());
        exitMenuItem.addActionListener(e -> System.exit(0));
    }

    private JPanel createCustomerInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Customer Info"));


        JPanel billAndShipPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, with gaps


        JPanel billToPanel = new JPanel(new BorderLayout());
        billToPanel.add(new JLabel("Bill To:"), BorderLayout.NORTH);
        billToTextArea = new JTextArea(5, 20);
        JScrollPane billToScrollPane = new JScrollPane(billToTextArea);
        billToPanel.add(billToScrollPane, BorderLayout.CENTER);


        JPanel shipToPanel = new JPanel(new BorderLayout());
        shipToPanel.add(new JLabel("Ship To:"), BorderLayout.NORTH);
        shipToTextArea = new JTextArea(5, 20);
        JScrollPane shipToScrollPane = new JScrollPane(shipToTextArea);
        shipToPanel.add(shipToScrollPane, BorderLayout.CENTER);

        billAndShipPanel.add(billToPanel);
        billAndShipPanel.add(shipToPanel);


        JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statePanel.add(new JLabel("State:"));
        stateComboBox = new JComboBox<>(stateTaxRates.keySet().toArray(new String[0]));
        stateComboBox.addActionListener(e -> updateTotals());
        statePanel.add(stateComboBox);


        JPanel premiumPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        premiumPanel.add(new JLabel("Premium Customer:"));
        premiumCustomerCheckBox = new JCheckBox();
        premiumCustomerCheckBox.addActionListener(e -> updateTotals());
        premiumPanel.add(premiumCustomerCheckBox);


        JPanel couponPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        couponPanel.add(new JLabel("Coupon:"));
        ButtonGroup couponGroup = new ButtonGroup();
        noneRadioButton = new JRadioButton("None", true);
        fivePercentRadioButton = new JRadioButton("5%");
        tenPercentRadioButton = new JRadioButton("10%");
        fifteenPercentRadioButton = new JRadioButton("15%");
        twentyPercentRadioButton = new JRadioButton("20%");

        // Add ActionListener to each coupon radio button
        ActionListener couponListener = e -> updateTotals();
        noneRadioButton.addActionListener(couponListener);
        fivePercentRadioButton.addActionListener(couponListener);
        tenPercentRadioButton.addActionListener(couponListener);
        fifteenPercentRadioButton.addActionListener(couponListener);
        twentyPercentRadioButton.addActionListener(couponListener);

        couponGroup.add(noneRadioButton);
        couponGroup.add(fivePercentRadioButton);
        couponGroup.add(tenPercentRadioButton);
        couponGroup.add(fifteenPercentRadioButton);
        couponGroup.add(twentyPercentRadioButton);
        couponPanel.add(noneRadioButton);
        couponPanel.add(fivePercentRadioButton);
        couponPanel.add(tenPercentRadioButton);
        couponPanel.add(fifteenPercentRadioButton);
        couponPanel.add(twentyPercentRadioButton);


        panel.add(billAndShipPanel);
        panel.add(statePanel);
        panel.add(premiumPanel);
        panel.add(couponPanel);

        return panel;
    }

    private JPanel createInvoiceInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with gaps
        panel.setBorder(BorderFactory.createTitledBorder("Invoice Info"));

        invoiceNumberLabel = new JLabel("Invoice Number: " + invoiceNumber);
        invoiceDateLabel = new JLabel("Invoice Date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dueDateLabel = new JLabel("Due Date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000)));

        panel.add(invoiceNumberLabel);
        panel.add(invoiceDateLabel);
        panel.add(dueDateLabel);

        return panel;
    }



    private JPanel createItemsAndTotalsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Items Panel
        JPanel itemsPanel = new JPanel(new BorderLayout());
        itemsPanel.setBorder(BorderFactory.createTitledBorder("Items"));

        itemsListModel = new DefaultListModel<>();
        itemsList = new JList<>(itemsListModel);
        JScrollPane itemsScrollPane = new JScrollPane(itemsList);


        JButton addItemButton = new JButton("Add Item");
        addItemButton.setPreferredSize(new Dimension(100, 30)); // Set button size
        addItemButton.setBackground(new Color(0, 120, 215)); // Set background color (modern blue)
        addItemButton.setForeground(Color.WHITE); // Set text color
        addItemButton.setFont(new Font("Arial", Font.BOLD, 12)); // Set font
        addItemButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Add padding
        addItemButton.setFocusPainted(false); // Remove the focus border
        addItemButton.setContentAreaFilled(true); // Ensure the background color is visible
        addItemButton.setOpaque(true); // Make the button opaque


        addItemButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), // Outer border
                BorderFactory.createEmptyBorder(5, 15, 5, 15) // Inner padding
        ));


        addItemButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(c.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 15, 15); // Rounded corners with radius 15
                super.paint(g2, c);
                g2.dispose();
            }
        });

        addItemButton.addActionListener(e -> addItem());


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addItemButton);


        JPanel totalsPanel = new JPanel();
        totalsPanel.setLayout(new BoxLayout(totalsPanel, BoxLayout.Y_AXIS));

        subtotalLabel = new JLabel("Subtotal: $0.00");
        salesTaxLabel = new JLabel("Sales Tax: $0.00");
        discountLabel = new JLabel("Discount: $0.00");
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(totalLabel.getFont().deriveFont(Font.BOLD));
        totalsPanel.add(subtotalLabel);
        totalsPanel.add(Box.createVerticalStrut(10));
        totalsPanel.add(salesTaxLabel);
        totalsPanel.add(Box.createVerticalStrut(10));
        totalsPanel.add(discountLabel);
        totalsPanel.add(Box.createVerticalStrut(10));
        totalsPanel.add(totalLabel);
        totalsPanel.add(Box.createVerticalStrut(10));


        JPanel buttonAndTotalsPanel = new JPanel(new BorderLayout());
        buttonAndTotalsPanel.add(buttonPanel, BorderLayout.CENTER); // Add the wrapped button panel
        buttonAndTotalsPanel.add(totalsPanel, BorderLayout.EAST); // Totals on the right


        itemsPanel.add(itemsScrollPane, BorderLayout.CENTER);
        itemsPanel.add(buttonAndTotalsPanel, BorderLayout.SOUTH); // Add button and totals below the items

        panel.add(itemsPanel, BorderLayout.CENTER);

        return panel;
    }

    private void addItem() {
        while (true) { // Loop until valid input is provided or the user cancels
            JTextField descriptionField = new JTextField();
            JTextField unitPriceField = new JTextField();
            JTextField quantityField = new JTextField();

            JPanel panel = new JPanel(new GridLayout(3, 2));
            panel.add(new JLabel("Description:"));
            panel.add(descriptionField);
            panel.add(new JLabel("Unit Price:"));
            panel.add(unitPriceField);
            panel.add(new JLabel("Quantity:"));
            panel.add(quantityField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Add Item", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String description = descriptionField.getText();
                    double unitPrice = Double.parseDouble(unitPriceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());


                    if (description.isEmpty() || unitPrice <= 0 || quantity <= 0) {
                        JOptionPane.showMessageDialog(this, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        continue; // Redisplay the dialog
                    }


                    double total = unitPrice * quantity;
                    itemsListModel.addElement(String.format("%s ($%.2f x %d = $%.2f)", description, unitPrice, quantity, total));
                    subtotal += total;
                    updateTotals();
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            } else {

                break;
            }
        }
    }

    private void updateTotals() {
        double salesTaxRate = stateTaxRates.get(stateComboBox.getSelectedItem().toString());
        double salesTax = subtotal * salesTaxRate / 100;

        double discount = 0.0;
        if (fivePercentRadioButton.isSelected()) discount = subtotal * 0.05;
        else if (tenPercentRadioButton.isSelected()) discount = subtotal * 0.10;
        else if (fifteenPercentRadioButton.isSelected()) discount = subtotal * 0.15;
        else if (twentyPercentRadioButton.isSelected()) discount = subtotal * 0.20;

        if (premiumCustomerCheckBox.isSelected()) discount += 10.0;

        double total = subtotal + salesTax - discount;

        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
        salesTaxLabel.setText(String.format("Sales Tax (%.2f%%): $%.2f", salesTaxRate, salesTax));
        discountLabel.setText(String.format("Discount: $%.2f", discount));
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    private void resetInvoice() {
        invoiceNumber++;
        invoiceNumberLabel.setText("Invoice Number: " + invoiceNumber);
        invoiceDateLabel.setText("Invoice Date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dueDateLabel.setText("Due Date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000)));

        billToTextArea.setText("");
        shipToTextArea.setText("");
        stateComboBox.setSelectedIndex(0);
        premiumCustomerCheckBox.setSelected(false);
        noneRadioButton.setSelected(true);
        itemsListModel.clear();
        subtotal = 0.0;
        updateTotals();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Invoicer frame = new Invoicer();
            frame.setVisible(true);
        });
    }
}
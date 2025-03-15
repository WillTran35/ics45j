package labs.lab9;

import javax.swing.*;
import java.awt.*;

public class CustomerInfoUI {
    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("Customer Info");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create main panel with border
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Spacing between elements

        // Bill To JTextArea
        JTextArea billTo = new JTextArea("Emily Navarro\nP.O. Box 283\nHappy Hills, CA 12345", 4, 15);
        billTo.setBorder(BorderFactory.createTitledBorder("Bill To:"));
        billTo.setLineWrap(true);
        billTo.setWrapStyleWord(true);

        // Ship To JTextArea
        JTextArea shipTo = new JTextArea("Robert's Pet Store\n0101 Furry Friends Dr.\nSuite 203\nWagville, CA 54321\nUSA", 4, 15);
        shipTo.setBorder(BorderFactory.createTitledBorder("Ship To:"));
        shipTo.setLineWrap(true);
        shipTo.setWrapStyleWord(true);

        // Panel for Address Fields
        JPanel addressPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        addressPanel.add(billTo);
        addressPanel.add(shipTo);

        // State Selection (JComboBox)
        JLabel stateLabel = new JLabel("State:");
        String[] states = {"CA", "NY", "TX", "FL", "WA"};
        JComboBox<String> stateComboBox = new JComboBox<>(states);

        // Premium Customer Checkbox
        JCheckBox premiumCheck = new JCheckBox("Premium Customer?");
        premiumCheck.setSelected(true); // Default checked

        // Coupon Selection (JRadioButtons)
        JLabel couponLabel = new JLabel("Coupon:");
        JRadioButton none = new JRadioButton("None");
        JRadioButton five = new JRadioButton("5%");
        JRadioButton ten = new JRadioButton("10%");
        JRadioButton fifteen = new JRadioButton("15%");
        JRadioButton twenty = new JRadioButton("20%");
        twenty.setSelected(true); // Default selected

        // Grouping radio buttons
        ButtonGroup couponGroup = new ButtonGroup();
        couponGroup.add(none);
        couponGroup.add(five);
        couponGroup.add(ten);
        couponGroup.add(fifteen);
        couponGroup.add(twenty);

        // Panel for Coupons
        JPanel couponPanel = new JPanel();
        couponPanel.add(none);
        couponPanel.add(five);
        couponPanel.add(ten);
        couponPanel.add(fifteen);
        couponPanel.add(twenty);

        // Adding components to GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(addressPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(stateLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(stateComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(premiumCheck, gbc);

        gbc.gridy = 3;
        mainPanel.add(couponLabel, gbc);

        gbc.gridy = 4;
        mainPanel.add(couponPanel, gbc);

        // Adding main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

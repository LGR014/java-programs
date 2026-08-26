import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.getRootFrame;

public class Main {

    static String[] cars = {"Elantra N", "IONIQ 5", "Tucson", "Sonata", "Santa Fe"};
    static double[] prices = {32999, 45000, 35000, 28000, 42000};
    static boolean[] bought = {false, false, false, false, false};
    static String[] carPhotoFiles = {"IMG_2343.JPG", "IMG_2348.JPG", "IMG_2382.jpeg", "IMG_2634.JPG"};

    static double budget = 75000;
    static int totalCarsPurchasedAllTime = 0;
    static double totalMoneySpentAllTime = 0;


    static JLabel budgetLabel;
    static JPanel carContainerPanel;

    public static void main(String[] args) {

        JFrame welcomeFrame = new JFrame("Vehicle Showroom");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(640, 320);
        welcomeFrame.getContentPane().setBackground(new Color(23, 32, 42));
        welcomeFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));

        JLabel title = new JLabel("🚗 Welcome to the Dealership!");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JButton enterButton = new JButton("Enter Showroom");
        enterButton.setFont(new Font("Arial", Font.BOLD, 16));
        enterButton.setBackground(new Color(0, 153, 255));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFocusPainted(false);
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        enterButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        enterButton.setOpaque(true);

        welcomeFrame.add(title);
        welcomeFrame.add(enterButton);

        enterButton.addActionListener(e -> {
            welcomeFrame.dispose();
            openShowroom();

        });
            welcomeFrame.setLocationRelativeTo(null);
            welcomeFrame.setVisible(true);
    }
        private static void openShowroom() {
        JFrame gameFrame = new JFrame("Hyundai Showroom");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(600, 520);
        gameFrame.setLayout(new BorderLayout(10, 10));
        gameFrame.getContentPane().setBackground(new Color(235, 238, 242));


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(new Color(23, 32, 42));
        topPanel.setBorder(BorderFactory.createEmptyBorder(16, 10, 16, 10));
        budgetLabel = new JLabel("💰 Budget: $" + String.format("%.2f", budget));
        budgetLabel.setFont(new Font("Arial", Font.BOLD, 22));
        budgetLabel.setForeground(new Color(80, 220, 120));
            topPanel.add(budgetLabel);
            gameFrame.add(topPanel, BorderLayout.NORTH);

            carContainerPanel = new JPanel();
            carContainerPanel.setLayout(new BoxLayout(carContainerPanel, BoxLayout.Y_AXIS));
            carContainerPanel.setBackground(new Color(235, 238, 242));
            carContainerPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
            carContainerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            updateShowroomUI();

            JScrollPane scrollPane = new JScrollPane(carContainerPanel);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            scrollPane.getViewport().setBackground(new Color(235, 238, 242));
            gameFrame.add(scrollPane, BorderLayout.CENTER);

            gameFrame.setLocationRelativeTo(null);
            gameFrame.setVisible(true);
        }

    private static ImageIcon loadCarIcon(int index, int width, int height) {
        String fileName = carPhotoFiles[index % carPhotoFiles.length];
        java.net.URL imageUrl = Main.class.getResource("/images/" + fileName);
        ImageIcon icon = new ImageIcon(imageUrl);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private static void updateShowroomUI() {
        carContainerPanel.removeAll();

        for (int i = 0; i < cars.length; i++) {
            final int index = i;

            JPanel row = new JPanel(new BorderLayout(15, 5));
            row.setBackground(Color.WHITE);
            row.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(210, 214, 220), 1, true),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)));
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
            row.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel photoLabel = new JLabel(loadCarIcon(index, 110, 70));
            photoLabel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));

            JLabel nameLabel = new JLabel(cars[index]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 17));

            String statusText = "$" + String.format("%,.0f", prices[index]);
            JButton actionButton = new JButton();

            if (bought[index]) {
                statusText += "  •  ✅ OWNED";
                actionButton.setText("Sell (80%)");
                actionButton.setBackground(new Color(230, 80, 80));
            } else if (budget < prices[index]) {
                statusText += "  •  ⚠ Insufficient funds";
                actionButton.setText("Buy");
                actionButton.setEnabled(false);
            } else {
                actionButton.setText("Buy Car");
                actionButton.setBackground(new Color(40, 180, 99));
            }
            actionButton.setForeground(Color.WHITE);
            actionButton.setFont(new Font("Arial", Font.BOLD, 13));
            actionButton.setFocusPainted(false);
            actionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            actionButton.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
            actionButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
            actionButton.setOpaque(true);

            JLabel priceLabel = new JLabel(statusText);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 13));
            priceLabel.setForeground(new Color(90, 95, 100));

            JPanel infoPanel = new JPanel();
            infoPanel.setBackground(Color.WHITE);
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            infoPanel.add(nameLabel);
            infoPanel.add(Box.createVerticalStrut(4));
            infoPanel.add(priceLabel);
            infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));

            actionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!bought[index]) {
                        budget -= prices[index];
                        bought[index] = true;
                        totalMoneySpentAllTime++;
                        totalCarsPurchasedAllTime++;
                        JOptionPane.showMessageDialog(carContainerPanel, "You successfully bought the " + cars[index] + "!", "Purchase Complete", JOptionPane.INFORMATION_MESSAGE, loadCarIcon(index, 110, 70));
                    } else {
                        double resaleValue = prices[index] * 0.80;
                        budget += resaleValue;
                        bought[index] = false;
                        JOptionPane.showMessageDialog(carContainerPanel, "You sold your " + cars[index] + " back for $" + String.format("%.2f", resaleValue));
                    }

                    budgetLabel.setText("💰 Budget: $" + String.format("%.2f", budget));
                    updateShowroomUI();
                    checkGameOverCondition();
                }
            });

            row.add(photoLabel, BorderLayout.WEST);
            row.add(infoPanel, BorderLayout.CENTER);
            row.add(actionButton, BorderLayout.EAST);
            carContainerPanel.add(row);
            carContainerPanel.add(Box.createVerticalStrut(10));
        }

        carContainerPanel.revalidate();
        carContainerPanel.repaint();
    }

    private static void checkGameOverCondition() {
        boolean canAffordAnything = false;
        int purchasedCount = 0;
        double totalSpent = 0;

        for (int i = 0; i < cars.length; i++) {
            if (bought[i]) {
                purchasedCount++;
                totalSpent += prices[i];
            }
            if (!bought[i] && budget >= prices[i]) {
                canAffordAnything = true;
            }
        }

        boolean bought = budget < 28000;
        if (!canAffordAnything && purchasedCount == 0 && budget < 28000) {
            String summaryMessage = "Your budget isn't sufficient for any more vehicles!\n\n" +
                    "Total Vehicles Purchased: " + totalCarsPurchasedAllTime + "\n" +
                    "Total Value Spent: $" + String.format("%.2f", totalMoneySpentAllTime) + "\n\n" +
                    "Thank you for visiting Kanata Hyundai!";

            JOptionPane.showMessageDialog(null, summaryMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}






package cz.osu;

import javax.swing.*;

public class MainWindow {
    private JPanel mainPanel;
    private JLabel libraryLabel;
    private JLabel communityLabel;
    private JLabel nicknameLabel;
    private JButton friendsListButton;
    private JButton addGameButton;
    private JButton downloadedButton;
    private JTextPane textPane;
    private JLabel storeLabel;

    public static void main(String[] args) {
        MainWindow window = new MainWindow();

        setApplication(window);
    }

    public MainWindow() {
        Localizer localizer = new Localizer();
        setControls(localizer);
    }

    private static void setApplication(MainWindow window) {
        JFrame frame = new JFrame("SteamFake");
        frame.setSize(1280,720);
        frame.setContentPane(window.mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setControls(Localizer localizer) {
        storeLabel.setText(localizer.getValue("Store"));
        libraryLabel.setText(localizer.getValue("Library"));
        communityLabel.setText(localizer.getValue("Community"));
        nicknameLabel.setText("David Miko");
        friendsListButton.setText(localizer.getValue("FriendList"));
        addGameButton.setText(localizer.getValue("AddGame"));
        downloadedButton.setText(localizer.getValue("Download"));
    }
}

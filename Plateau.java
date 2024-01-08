import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Plateau extends JFrame {
    // Initialisation des attributs de la classe Plateau
    protected List<Projets> projets;
    protected List<Cases> plateau;
    protected static List<Cases> allCases;
    protected static List<Pions> pions;
    private static JFrame frame;
    private int countNbThrowDe = 0;
    private Button throwDe;
    private Label nomJoueurTour;
    private Label numeroDe;
    private int currentPlayerIndex = 0;
    private CountDownLatch turnLatch;
    private Cases[][] casesGrid;
    private List<JLabel> playerInfoLabels;

    public Plateau() {
        // Définir la taille de la grille et la taille de la fenêtre
        int gridSize = 11;
        int windowWidth = 1500;
        int windowHeight = 800;
        playerInfoLabels = new ArrayList<>();

        // Créer la grille de cases
        casesGrid = new Cases[gridSize][gridSize];
        casesGrid[10][10] = new Cases("<- Départ");
        casesGrid[10][9] = new Backend();
        casesGrid[10][8] = new Cases("chance", Cases.CaseType.CHANCE);
        casesGrid[10][7] = new Frontend();
        casesGrid[10][6] = new Cases("mystère", Cases.CaseType.MYSTERE);
        casesGrid[10][5] = new MisterKebab();
        casesGrid[10][4] = new Design();
        casesGrid[10][3] = new Cases("chance", Cases.CaseType.CHANCE);
        casesGrid[10][2] = new Algorithme();
        casesGrid[10][1] = new ManagemenTkinter();
        casesGrid[10][0] = new Cases("Ionis");
        casesGrid[9][0] = new SSR();
        casesGrid[8][0] = new Cases("mystère", Cases.CaseType.MYSTERE);
        casesGrid[7][0] = new Gia();
        casesGrid[6][0] = new ManagementCyber();
        casesGrid[5][0] = new Crous();
        casesGrid[4][0] = new Materiel();
        casesGrid[3][0] = new Cases("chance", Cases.CaseType.CHANCE);
        casesGrid[2][0] = new Loco();
        casesGrid[1][0] = new ManagementIot();
        casesGrid[0][0] = new Cases("Parc gratuit");
        casesGrid[0][1] = new Devapp();
        casesGrid[0][2] = new Cases("mystère", Cases.CaseType.MYSTERE);
        casesGrid[0][3] = new Gpq();
        casesGrid[0][4] = new ManagementJava();
        casesGrid[0][5] = new Subway();
        casesGrid[0][6] = new Devia();
        casesGrid[0][7] = new Er();
        casesGrid[0][8] = new Cases("chance", Cases.CaseType.CHANCE);
        casesGrid[0][9] = new ManagementIa();
        casesGrid[0][10] = new Cases("Aller vers Ionis");
        casesGrid[1][10] = new Devvr();
        casesGrid[2][10] = new Exppro();
        casesGrid[3][10] = new Cases("mystère", Cases.CaseType.MYSTERE);
        casesGrid[4][10] = new ManagementVr();
        casesGrid[5][10] = new Boulangerie();
        casesGrid[6][10] = new Cases("chance", Cases.CaseType.CHANCE);
        casesGrid[7][10] = new Dev();
        casesGrid[8][10] = new Cases("mystère", Cases.CaseType.MYSTERE);
        casesGrid[9][10] = new ManagementVisionPro();

        // Ajouter les cases de projet à la liste de projets
        Projets tweb = new TWeb();
        tweb.addcase(casesGrid[10][9]);
        tweb.addcase(casesGrid[10][7]);
        Projets tkinter = new Tkinter();
        tkinter.addcase(casesGrid[10][4]);
        tkinter.addcase(casesGrid[10][2]);
        tkinter.addcase(casesGrid[10][1]);
        Projets cyber = new Cybersecurite();
        cyber.addcase(casesGrid[9][0]);
        cyber.addcase(casesGrid[7][0]);
        cyber.addcase(casesGrid[6][0]);
        Projets iot = new IOT();
        iot.addcase(casesGrid[4][0]);
        iot.addcase(casesGrid[2][0]);
        iot.addcase(casesGrid[1][0]);
        Projets java = new Java();
        java.addcase(casesGrid[0][1]);
        java.addcase(casesGrid[0][3]);
        java.addcase(casesGrid[0][4]);
        Projets ia = new IA();
        ia.addcase(casesGrid[0][6]);
        ia.addcase(casesGrid[0][7]);
        ia.addcase(casesGrid[0][9]);
        Projets vr = new VR();
        vr.addcase(casesGrid[1][10]);
        vr.addcase(casesGrid[2][10]);
        vr.addcase(casesGrid[4][10]);
        Projets vp = new VisionPro();
        vp.addcase(casesGrid[7][10]);
        vp.addcase(casesGrid[9][10]);
        Projets fastFood = new FastFood();
        fastFood.addcase(casesGrid[10][5]);
        fastFood.addcase(casesGrid[5][0]);
        fastFood.addcase(casesGrid[0][5]);
        fastFood.addcase(casesGrid[5][10]);

        // Ajouter les cases de projet à la liste de projets
        allCases = new ArrayList<>();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Cases currentCase = casesGrid[i][j];
                if (currentCase != null) {
                    allCases.add(currentCase);
                }
            }
        }

        // Trier les cases par rank
        Collections.sort(allCases, Comparator.comparingInt(Cases::getRank));
        pions = new ArrayList<>();

        // Demander le nombre de joueurs et créer les pions correspondants
        int numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Entrez le nombre de joueurs : "));
        if (numberOfPlayers == 1) {
            JOptionPane.showMessageDialog(null, "Vous ne pouvez pas jouer seul !", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else if (numberOfPlayers > 4) {
            JOptionPane.showMessageDialog(null, "Vous ne pouvez pas jouer à plus de 4 !", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else if (numberOfPlayers <= 0) {
            JOptionPane.showMessageDialog(null, "Vous ne pouvez pas jouer à moins de 2 !", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        throwDe = new Button("Lancer le dé");

        pions = new ArrayList<>();
        // Ajouter les joueurs à la liste pions
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = JOptionPane.showInputDialog("Entrez le nom du joueur " + (i + 1) + " : ");
            if (name == null || name.isEmpty() || name.isBlank() || name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Vous devez entrer un nom !", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            Pions pion = new Pions(name, i + 1);
            pions.add(pion);
        }

        // Créer la fenêtre et ajouter les cases à la grille
        frame = new JFrame("Grille avec Bordures");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(11, 11));
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JPanel panel = new JPanel(new BorderLayout());
                // Ajouter une bordure à chaque panneau pour que les panneaux soient séparés
                panel.setPreferredSize(new Dimension(windowWidth / gridSize, windowHeight / gridSize));

                // Limiter la grid à se placer seulement sur les extremitees de la fenetre
                if (i == 0 || i == gridSize - 1 || j == 0 || j == gridSize - 1) {
                    // Ajouter une bordure aux carrés en bordure
                    panel.setBorder(new LineBorder(Color.BLACK));

                    JPanel pionPanel = new JPanel(new GridLayout(2, 2));
                    // Ajouter les pions aux cases de départ (en bas à droite)
                    for (Pions pion : pions) {
                        if (casesGrid[i][j] == casesGrid[pion.getX()][pion.getY()]) {
                            ImageIcon icon = new ImageIcon(pion.getImage());
                            JLabel label = new JLabel(icon);
                            pionPanel.add(label);
                        }
                    }

                    // Ajouter le JLabel du nom de la case en bas du panneau
                    if (casesGrid[i][j] != null) {
                        panel.add(new JLabel(casesGrid[i][j].getName()), BorderLayout.NORTH);
                        panel.setBackground(casesGrid[i][j].getColor());
                        if (casesGrid[i][j].getPrice() != 0) {
                            panel.add(new JLabel(Integer.toString(casesGrid[i][j].getPrice())), BorderLayout.SOUTH);
                        }
                        if (casesGrid[i][j].getOwner() != null) {
                            panel.add(new JLabel((casesGrid[i][j].getOwner().getName())), BorderLayout.SOUTH);
                        }
                    }

                    panel.add(pionPanel, BorderLayout.CENTER);
                } else {
                    // Mettre le fond des cases en violet
                    panel.setBackground(new Color(241, 223, 255));
                }

                if (i == 5 && j == 5) {
                    // Ajouter le bouton pour lancer le dé
                    throwDe = new Button("Lancer le dé");
                    throwDe.setVisible(true);
                    panel.add(throwDe);
                }
                if (i == 6 && j == 5) {
                    // Ajouter le JLabel pour le nom du joueur dont c'est le tour
                    nomJoueurTour = new Label("Tour : personne");
                    panel.add(nomJoueurTour);
                }
                if (i == 7 && j == 5) {
                    // Ajouter le JLabel pour le numéro du dé
                    numeroDe = new Label("Dé : 0");
                    panel.add(numeroDe);
                }

                // Ajouter les informations des joueurs dans des panneaux
                int iMoney = 2;
                Random random = new Random();
                for (Pions pion : pions) {
                    if (i == 2 && j == iMoney) {
                        JPanel playerInfoPanel = new JPanel(new GridLayout(2, 1));
                        playerInfoPanel.setBorder(new LineBorder(Color.BLACK));
                        JLabel infoPlayerLabel = new JLabel(pion.getName() + " : " + pion.getEpicoins() + " Epicoins");
                        playerInfoPanel.add(infoPlayerLabel);
                        ImageIcon icon = new ImageIcon(pion.getImage());
                        JLabel label = new JLabel(icon);
                        playerInfoPanel.add(label);
                        playerInfoPanel.setBackground(
                                new Color(random.nextInt(254) + 1, random.nextInt(254) + 1, random.nextInt(254) + 1));
                        panel.add(playerInfoPanel, BorderLayout.CENTER);

                        // Ajouter le JLabel correspondant à la liste
                        playerInfoLabels.add(infoPlayerLabel);
                    }
                    iMoney += 2;
                }

                frame.add(panel);
            }
        }

        frame.setSize(windowWidth, windowHeight);
        frame.setVisible(true);

        // Boucle de jeu principale qui continue jusqu'à ce que le jeu soit terminé
        while (!gameIsOver()) {
            turnLatch = new CountDownLatch(1);
            Pions currentPlayer = pions.get(currentPlayerIndex);
            if (currentPlayer.isInIonis()) {
                currentPlayer.setInIonis(false);
                JOptionPane.showMessageDialog(null,
                        "Vous êtes sorti de Ionis !",
                        "Ionis",
                        JOptionPane.INFORMATION_MESSAGE);
                // turnLatch.countDown(); permet de passer au joueur suivant
                turnLatch.countDown();
            } else {
                // Si le joueur n'est pas en Ionis, il peut jouer son tour
                jouerTour(currentPlayer);
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % pions.size();
        }

        JOptionPane.showMessageDialog(null, "La partie est terminée. " +
                pions.get(0).getName() + " a gagné !");
        System.exit(0);
    }

    // Méthode qui vérifie si le jeu est terminé (qu'il ne reste qu'un seul joueur)
    private boolean gameIsOver() {
        return pions.size() == 1;
    }

    // Méthode qui permet de jouer le tour d'un joueur (lance le dé, déplace le
    // pion, etc.)
    private void jouerTour(Pions pion) {
        System.out.println("C'est le tour de " + pion.getName() + "\n");
        nomJoueurTour.setText("Tour : " + pion.getName());
        pion.update();
        // Ajoutez le dé à la caseGrille et lancez le dé
        throwDe.setVisible(true);
        throwDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removePionFromPanel(pion);
                De de = new De();
                de.throwDe();

                SwingUtilities.invokeLater(() -> {
                    if (de.isDouble()) {
                        countNbThrowDe++;
                        if (countNbThrowDe < 3) {
                            pion.numberDe(de.getValue());
                            numeroDe.setText("Dé : " + de.getValue());
                            throwDe.setVisible(true);
                        }
                        if (countNbThrowDe >= 3) {
                            pion.setInIonis(true);
                            System.out.println("Ionis !!");
                            pion.moveToPrison(pion);
                            JOptionPane.showMessageDialog(null,
                                    "Vous avez fait 3 doubles d'affilé, Ionis vous attend !",
                                    "Ionis",
                                    JOptionPane.INFORMATION_MESSAGE);
                            numeroDe.setText("Dé : " + de.getValue());
                            countNbThrowDe = 0;
                            throwDe.setVisible(false);
                            throwDe.removeActionListener(this);
                            turnLatch.countDown();
                        }
                    } else {
                        countNbThrowDe = 0;
                        pion.numberDe(de.getValue());
                        numeroDe.setText("Dé : " + de.getValue());
                        pion.update();
                        throwDe.setVisible(false);
                        throwDe.removeActionListener(this);
                        turnLatch.countDown();

                    }

                    for (JLabel infoPlayerLabel : playerInfoLabels) {
                        int playerIndex = playerInfoLabels.indexOf(infoPlayerLabel);
                        Pions currentPlayer = pions.get(playerIndex);
                        infoPlayerLabel
                                .setText(currentPlayer.getName() + " : " + currentPlayer.getEpicoins() + " Epicoins");
                    }
                });
            }
        });

        // Attendre que le joueur ait fini son tour
        try {
            turnLatch.await();
            turnLatch = new CountDownLatch(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // Méthode qui permet de retirer un pion d'une case (pour le déplacer)
    public static void removePionFromPanel(Pions pion) {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = (JPanel) frame.getContentPane().getComponent(pion.getX() * 11 + pion.getY());
            // System.out.println(panel);

            // Supprimer le pion du panel
            // Vérifiez si le JPanel contient un JLabel avec une ImageIcon
            Component[] components = panel.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel) {
                    JPanel pionPanel = (JPanel) component;
                    Component[] pionComponents = pionPanel.getComponents();
                    for (Component pionComponent : pionComponents) {
                        if (pionComponent instanceof JLabel) {
                            JLabel pionLabel = (JLabel) pionComponent;
                            Icon icon = pionLabel.getIcon();
                            if (icon instanceof ImageIcon) {
                                ImageIcon imageIcon = (ImageIcon) icon;
                                Image image = imageIcon.getImage();
                                if (image == pion.getImage()) {
                                    pionPanel.remove(pionLabel);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            frame.revalidate();
            frame.repaint();
        });
    }

    // Méthode qui permet d'ajouter un pion à une case (pour le déplacer)
    public static void addPionToPanel(Pions pion) {
        SwingUtilities.invokeLater(() -> {
            int index = pion.getX() * 11 + pion.getY();
            JPanel panel = (JPanel) frame.getContentPane().getComponent(index);

            boolean pionAlreadyExists = false;
            JPanel pionPanel = null;

            Component[] components = panel.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel) {
                    pionPanel = (JPanel) component;
                    Component[] pionComponents = pionPanel.getComponents();
                    for (Component pionComponent : pionComponents) {
                        if (pionComponent instanceof JLabel) {
                            pionAlreadyExists = true;
                            break;
                        }
                    }
                }
            }

            if (!pionAlreadyExists) {
                pionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Utilise FlowLayout avec orientation
                                                                         // horizontale
                panel.add(pionPanel, BorderLayout.NORTH);
            }

            // Ajouter le pion au panel pour que le joueur puisse voir son pion
            ImageIcon icon = new ImageIcon(pion.getImage());
            JLabel label = new JLabel(icon);
            pionPanel.add(label);

            frame.revalidate();
            frame.repaint();
        });
    }

    // Méthode qui permet de récupérer la liste des cases
    public List<Cases> getAllCases() {
        return allCases;
    }

    public static void main(String[] args) {
        Plateau p = new Plateau();
    }
}
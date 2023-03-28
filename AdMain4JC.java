/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminvoter;

import com.placeholder.PlaceHolder;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.*;
import javax.swing.JPanel;

/**
 *
 * @author abhimanyuyadav
 */
public class AdMain4JC extends javax.swing.JFrame {

    /**
     * Creates new form AdMain4JC
     */
    PlaceHolder ph;
    JFrame jf[];
    JLabel jl[];
    ArrayList<String> hbimages;
    ArrayList<String> hbname;
    ArrayList<String> hbhouse;

    ArrayList<String> hgimages;
    ArrayList<String> hgname;
    ArrayList<String> hghouse;

    ArrayList<String> scbimages;
    ArrayList<String> scbname;
    ArrayList<String> scbhouse;

    ArrayList<String> scgimages;
    ArrayList<String> scgname;
    ArrayList<String> scghouse;
    
    ArrayList<String> arbimages;
    ArrayList<String> arbname;
    ArrayList<String> arbhouse;

    ArrayList<String> argimages;
    ArrayList<String> argname;
    ArrayList<String> arghouse;
    
    ArrayList<String> bibimages;
    ArrayList<String> bibname;
    ArrayList<String> bibhouse;

    ArrayList<String> bigimages;
    ArrayList<String> bigname;
    ArrayList<String> bighouse;
    
    ArrayList<String> habimages;
    ArrayList<String> habname;
    ArrayList<String> habhouse;

    ArrayList<String> hagimages;
    ArrayList<String> hagname;
    ArrayList<String> haghouse;
    
    ArrayList<String> mabimages;
    ArrayList<String> mabname;
    ArrayList<String> mabhouse;

    ArrayList<String> magimages;
    ArrayList<String> magname;
    ArrayList<String> maghouse;
    JFileChooser jc;

    JTextField hbName[] = new JTextField[6];
    JComboBox hbHouse[] = new JComboBox[6];
    JButton hbFile[] = new JButton[6];
    JLabel hbPreview[] = new JLabel[6];
    JTextField hbcode[] = new JTextField[6];

    JTextField hgName[] = new JTextField[6];
    JComboBox hgHouse[] = new JComboBox[6];
    JButton hgFile[] = new JButton[6];
    JLabel hgPreview[] = new JLabel[6];
    JTextField hgcode[] = new JTextField[6];

    JTextField scbName[] = new JTextField[6];
    JComboBox scbHouse[] = new JComboBox[6];
    JButton scbFile[] = new JButton[6];
    JLabel scbPreview[] = new JLabel[6];
    JTextField scbcode[] = new JTextField[6];
    
    JTextField arbName[] = new JTextField[6];
    JComboBox arbHouse[] = new JComboBox[6];
    JButton arbFile[] = new JButton[6];
    JLabel arbPreview[] = new JLabel[6];
    JTextField arbcode[] = new JTextField[6];
    
    JTextField argName[] = new JTextField[6];
    JComboBox argHouse[] = new JComboBox[6];
    JButton argFile[] = new JButton[6];
    JLabel argPreview[] = new JLabel[6];
    JTextField argcode[] = new JTextField[6];
    
    JTextField bibName[] = new JTextField[6];
    JComboBox bibHouse[] = new JComboBox[6];
    JButton bibFile[] = new JButton[6];
    JLabel bibPreview[] = new JLabel[6];
    JTextField bibcode[] = new JTextField[6];
    
    JTextField bigName[] = new JTextField[6];
    JComboBox bigHouse[] = new JComboBox[6];
    JButton bigFile[] = new JButton[6];
    JLabel bigPreview[] = new JLabel[6];
    JTextField bigcode[] = new JTextField[6];
    
    JTextField habName[] = new JTextField[6];
    JComboBox habHouse[] = new JComboBox[6];
    JButton habFile[] = new JButton[6];
    JLabel habPreview[] = new JLabel[6];
    JTextField habcode[] = new JTextField[6];
    
    JTextField hagName[] = new JTextField[6];
    JComboBox hagHouse[] = new JComboBox[6];
    JButton hagFile[] = new JButton[6];
    JLabel hagPreview[] = new JLabel[6];
    JTextField hagcode[] = new JTextField[6];
    
    JTextField mabName[] = new JTextField[6];
    JComboBox mabHouse[] = new JComboBox[6];
    JButton mabFile[] = new JButton[6];
    JLabel mabPreview[] = new JLabel[6];
    JTextField mabcode[] = new JTextField[6];
    
    JTextField magName[] = new JTextField[6];
    JComboBox magHouse[] = new JComboBox[6];
    JButton magFile[] = new JButton[6];
    JLabel magPreview[] = new JLabel[6];
    JTextField magcode[] = new JTextField[6];
    
    JTextField scgName[] = new JTextField[6];
    JComboBox scgHouse[] = new JComboBox[6];
    JButton scgFile[] = new JButton[6];
    JLabel scgPreview[] = new JLabel[6];
    JTextField scgcode[] = new JTextField[6];
    
    

    public AdMain4JC() {

        this.setExtendedState(MAXIMIZED_BOTH);
        initializePreview();
        initComponents();
        place_H();
        jc = new JFileChooser();
        hbimages = new ArrayList<>();
        hbname = new ArrayList<>();
        hbhouse = new ArrayList<>();

    }

    private void getAndSendCandiates() {
        // Stores the names and house
        int ctr = 0;
        for (int i = 0; i < 6; i++) {
            if (!(hbName[i].getText().contains("Candidate"))) {
                ctr++;
                hbname.add(i, hbName[i].getText());
                hbhouse.add(i, hbHouse[i].getSelectedItem().toString());
                System.out.println(hbname.get(i));
                System.out.println(hbhouse.get(i));
            }
        }
        System.out.println(ctr);
        // Writing the values in the database.
        try {
            String url = "jdbc:mysql://localhost:3306/TBS?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String pass = "TBS@admin123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tbs.candidate (`NAME`, HOUSE, PHOTO) VALUES (?, ?, ?)");

            FileInputStream fis;
            for (int i = 0; i < ctr; i++) {

                fis = new FileInputStream(hbimages.get(i));
                pstmt.setString(1, hbname.get(i));
                pstmt.setString(2, hbhouse.get(i));
                pstmt.setBlob(3, fis);

                pstmt.execute();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdMain4JC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ActionListener hbImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (hbFile[i] == e.getSource()) {
                    setImage(i, hbimages);
                }
            }
        }

    };
    MouseListener hbPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (hbPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    ActionListener hgImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (hgFile[i] == e.getSource()) {
                    setImage(i, hgimages);
                }
            }
        }

    };
    MouseListener hgPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (hgPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    ActionListener scbImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (scbFile[i] == e.getSource()) {
                    setImage(i, scbimages);
                }
            }
        }

    };
    MouseListener scbPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (scbPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    ActionListener scgImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (scgFile[i] == e.getSource()) {
                    setImage(i, scgimages);
                }
            }
        }

    };
    MouseListener scgPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (scgPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    ActionListener argImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (argFile[i] == e.getSource()) {
                    setImage(i, argimages);
                }
            }
        }

    };
    MouseListener argPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (argPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    ActionListener arbImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (arbFile[i] == e.getSource()) {
                    setImage(i, arbimages);
                }
            }
        }

    };
    MouseListener arbPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (arbPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    //Bishops
    ActionListener bigImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (bigFile[i] == e.getSource()) {
                    setImage(i, bigimages);
                }
            }
        }

    };
    MouseListener bigPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (bigPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    ActionListener bibImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (bibFile[i] == e.getSource()) {
                    setImage(i, bibimages);
                }
            }
        }

    };
    MouseListener bibPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (bibPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    //Harding
    
    
    ActionListener hagImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (hagFile[i] == e.getSource()) {
                    setImage(i, hagimages);
                }
            }
        }

    };
    MouseListener hagPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (hagPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    ActionListener habImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (habFile[i] == e.getSource()) {
                    setImage(i, habimages);
                }
            }
        }

    };
    MouseListener habPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (habPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    // mansfield
    
    ActionListener magImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (magFile[i] == e.getSource()) {
                    setImage(i, magimages);
                }
            }
        }

    };
    MouseListener magPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (magPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    ActionListener mabImageChooser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Searches for the button which was pressed-
            // and returns to set the image
            for (int i = 0; i < 6; i++) {
                if (mabFile[i] == e.getSource()) {
                    setImage(i, mabimages);
                }
            }
        }

    };
    MouseListener mabPreviewer = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < 6; i++) {
                if (mabPreview[i] == e.getSource()) {
                    jf[i].setVisible(true);
                    jl[i].setVisible(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    };

    private void setImage(int i, ArrayList<String> images) {
        try {
            jc.setSelectedFile(null);
            jc.showOpenDialog(null);
            File f = jc.getSelectedFile();
            ImageIcon img = new ImageIcon(f.getAbsolutePath());

            jl[i].setIcon(img);
            images.add(i, f.getAbsolutePath());

        } catch (Exception e) {

        }
    }

    private void initializePanels(JPanel panel, JTextField canName[], JComboBox canHouse[], JButton canFile[], JLabel canPreview[], JTextField cancode[], int size) {
        // Intialising each value to it's respective class (Avoids NullPointerException).
        for (int i = 0; i < size; i++) {
            canName[i] = new JTextField();
            canHouse[i] = new JComboBox();
            canFile[i] = new JButton();
            canPreview[i] = new JLabel();
            cancode[i] = new JTextField();
        }

        // Setting the location
        for (int i = 0; i < size; i++) {
            canName[i].setBounds(0, 50 + 35 * i, 160, 35);
            
            cancode[i].setBounds(400, 50+35*i, 60, 30);
            cancode[i].setToolTipText("Enter Computer Code");
            ph = new PlaceHolder(cancode[i], "code");
            
            canHouse[i].setBounds(165, 50 + 35 * i + 5, 100, 25);
            canHouse[i].setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"House*", "Arnould", "Bishops", "Harding", "Mansfield"}));
            canFile[i].setText("Choose File");
            canFile[i].setFont(new java.awt.Font("Lucida Grande", 0, 9));
            canFile[i].setBounds(275, 50 + 35 * i + 5, 90, 20);
            Image image;
            try {
                image = ImageIO.read(getClass().getResourceAsStream("eyeicn2.png"));
                ImageIcon img = new ImageIcon(image);
                canPreview[i].setIcon(img);
            } catch (IOException ex) {
                Logger.getLogger(AdMain4JC.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            canPreview[i].setBounds(375, 50 + 35 * i, 30, 30);
            canPreview[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            
        }

        // Adding Action Listener and MouseListener and Adding it to the hbPanel
        for (int i = 0; i < size; i++) {
            canName[i].setVisible(true);
            canHouse[i].setVisible(true);
            canFile[i].setVisible(true);
            canPreview[i].setVisible(true);
            cancode[i].setVisible(true);

            panel.add(canName[i]);
            panel.add(canHouse[i]);
            panel.add(canFile[i]);
            panel.add(canPreview[i]);
            panel.add(cancode[i]);

            canFile[i].addActionListener(hbImageChooser);
            canPreview[i].addMouseListener(hbPreviewer);
            canFile[i].addActionListener(hgImageChooser);
            canPreview[i].addMouseListener(hgPreviewer);
            canFile[i].addActionListener(scbImageChooser);
            canPreview[i].addMouseListener(scbPreviewer);
            
            canFile[i].addActionListener(scgImageChooser);
            canPreview[i].addMouseListener(scgPreviewer);
            
            canFile[i].addActionListener(arbImageChooser);
            canPreview[i].addMouseListener(arbPreviewer);
            canFile[i].addActionListener(argImageChooser);
            canPreview[i].addMouseListener(argPreviewer);
            
            canFile[i].addActionListener(bibImageChooser);
            canPreview[i].addMouseListener(bibPreviewer);
            canFile[i].addActionListener(bigImageChooser);
            canPreview[i].addMouseListener(bigPreviewer);
            
            canFile[i].addActionListener(habImageChooser);
            canPreview[i].addMouseListener(habPreviewer);
            canFile[i].addActionListener(hagImageChooser);
            canPreview[i].addMouseListener(hagPreviewer);
            
            canFile[i].addActionListener(mabImageChooser);
            canPreview[i].addMouseListener(mabPreviewer);
            canFile[i].addActionListener(magImageChooser);
            canPreview[i].addMouseListener(magPreviewer);
            

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jDialog5 = new javax.swing.JDialog();
        jFrame2 = new javax.swing.JFrame();
        jDialog6 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        hbPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        hgPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        scbPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        scgPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog6Layout = new javax.swing.GroupLayout(jDialog6.getContentPane());
        jDialog6.getContentPane().setLayout(jDialog6Layout);
        jDialog6Layout.setHorizontalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 919));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        /*
        jScrollPane2.setToolTipText("");
        */
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(7);
        jScrollPane2.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );

        jPanel4.setForeground(new java.awt.Color(153, 153, 153));

        hbPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(hbPanel,hbName,hbHouse,hbFile,hbPreview, hbcode,6);

        jLabel2.setFont(new java.awt.Font("Times", 1, 27)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HEAD BOY");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout hbPanelLayout = new javax.swing.GroupLayout(hbPanel);
        hbPanel.setLayout(hbPanelLayout);
        hbPanelLayout.setHorizontalGroup(
            hbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hbPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        hbPanelLayout.setVerticalGroup(
            hbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hbPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 367, Short.MAX_VALUE))
        );

        jPanel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel17,argName,argHouse,argFile,argPreview, argcode,6);

        jLabel27.setFont(new java.awt.Font("PT Serif Caption", 1, 30)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Girls");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 392, Short.MAX_VALUE))
        );

        jPanel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel24,arbName,arbHouse,arbFile,arbPreview, arbcode,6);

        jLabel40.setFont(new java.awt.Font("PT Serif Caption", 1, 30)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Boys");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
        );

        jPanel34.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel34,bibName,bibHouse,bibFile,bibPreview, bibcode,6);

        jLabel59.setFont(new java.awt.Font("PT Serif Caption", 1, 30)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Boys");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel59)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        jPanel44.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel44,bigName,bigHouse,bigFile,bigPreview, bigcode,6);

        jLabel78.setFont(new java.awt.Font("PT Serif Caption", 1, 30)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Girls");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        hgPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(hgPanel,hgName,hgHouse,hgFile,hgPreview, hgcode,6);

        jLabel3.setFont(new java.awt.Font("Times", 1, 27)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HEAD GIRL");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout hgPanelLayout = new javax.swing.GroupLayout(hgPanel);
        hgPanel.setLayout(hgPanelLayout);
        hgPanelLayout.setHorizontalGroup(
            hgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        hgPanelLayout.setVerticalGroup(
            hgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hgPanelLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 368, Short.MAX_VALUE))
        );

        scbPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(scbPanel,scbName,scbHouse,scbFile,scbPreview, scbcode,6);

        jLabel5.setFont(new java.awt.Font("Times", 1, 27)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SPORTS CAPTAIN(B)");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout scbPanelLayout = new javax.swing.GroupLayout(scbPanel);
        scbPanel.setLayout(scbPanelLayout);
        scbPanelLayout.setHorizontalGroup(
            scbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scbPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );
        scbPanelLayout.setVerticalGroup(
            scbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scbPanelLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 328, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ARNOULD HOUSE");

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BISHOPS HOUSE");

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 36)); // NOI18N
        jLabel7.setText("HARDING HOUSE");

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel3,hagName,hagHouse,hagFile,hagPreview, hagcode,6);

        jLabel8.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Girls");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel5,habName,habHouse,habFile,habPreview, habcode,6);

        jLabel9.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Boys");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MANSFIELD HOUSE");

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel6,mabName,mabHouse,mabFile, mabPreview, mabcode,6);

        jLabel11.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Boys");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(jPanel7,magName,magHouse,magFile,magPreview, magcode,6);

        jLabel12.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Girls");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scgPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        initializePanels(scgPanel,scgName,scgHouse,scgFile,scgPreview, scgcode,6);

        jLabel13.setFont(new java.awt.Font("Times", 1, 27)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("SPORTS CAPTAIN(G)");
        jLabel13.setToolTipText("");

        javax.swing.GroupLayout scgPanelLayout = new javax.swing.GroupLayout(scgPanel);
        scgPanel.setLayout(scgPanelLayout);
        scgPanelLayout.setHorizontalGroup(
            scgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        scgPanelLayout.setVerticalGroup(
            scgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scgPanelLayout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 353, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(468, 468, 468)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(93, 93, 93)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(549, 549, 549)
                        .addComponent(jButton3)))
                .addGap(0, 970, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(988, 988, 988))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(364, 364, 364))
        );

        jScrollPane2.setViewportView(jPanel4);

        jPanel2.setBackground(new java.awt.Color(163, 29, 36));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminvoter/BLogo1 (1).png"))); // NOI18N
        jLabel1.setText("                 THE BISHOP'S SCHOOL,PUNE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1449, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 1378, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 3026, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1449, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 3205, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AdMain2().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Do you want to save this form?", "Confirm Save", JOptionPane.OK_CANCEL_OPTION);
        if (response == JOptionPane.OK_OPTION) {
            getAndSendCandiates();

            try {
                new AdMain4JCExtend().setVisible(true);
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(AdMain4JC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void initializePreview() {
        jf = new JFrame[100];
        jl = new JLabel[100];
        for (int i = 0; i < 100; i++) {
            jf[i] = new JFrame();
            jl[i] = new JLabel();
            jf[i].setBounds(550, 200, 275, 325);

            jf[i].setTitle("Preview ");
            jl[i].setBounds(900, 400, 233, 300);
            jf[i].add(jl[i]);
            jl[i].setAlignmentX(CENTER_ALIGNMENT);
            jl[i].setAlignmentY(CENTER_ALIGNMENT);
            jl[i].setVisible(true);
        }

    }

    public static byte[] convertFileContentToBlob(String filePathStr) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePathStr, "r");
        // initialize byte array with size equal to the size of the file
        byte[] fileContent = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(fileContent);
        randomAccessFile.close();
        return fileContent;
    }

    public void place_H() {

        for (int i = 0; i < 6; i++) {
            ph = new PlaceHolder(hbName[i], "Candidate " + (i + 1));
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(AdMain4JC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(AdMain4JC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(AdMain4JC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(AdMain4JC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            // System.out.println(UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdMain4JC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdMain4JC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdMain4JC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdMain4JC.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new AdMain4JC().setVisible(true);
        });
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel hbPanel;
    private javax.swing.JPanel hgPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel scbPanel;
    private javax.swing.JPanel scgPanel;
    // End of variables declaration//GEN-END:variables
}
/*
int i = 4;
            setImage(i);
            if(jl[i].getDisabledIcon() != null)
            {
                file5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                file5.setText("Edit image");
                file5.setBorder(null);
            }


int i=5;
        jf[i].setVisible(true);
        jl[i].setVisible(true);
*/

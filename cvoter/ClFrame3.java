/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvoter;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author abhimanyuyadav
 * @author dhirodaattosarkar // Designed the card UI
 */
public class ClFrame3 extends javax.swing.JFrame {

    ArrayList<JPanel> candidate;
    ArrayList<JLabel> candidateImage;
    ArrayList<JLabel> candidateName;
    ArrayList<JLabel> candidateHouse;
    ArrayList<JCheckBox> candidateSelection;
    
    ArrayList<String> name;
    ArrayList<String> house;
    ArrayList<Image> photo;
  
   int x = 0;
    
    public ClFrame3() {
        
        initDisplayElements();
        initComponents();
        
        
    }
    
    public ClFrame3(int a, ArrayList<String> name, ArrayList<String> house, ArrayList<Image> photo) {
        
        // Initialising Display Elements
        initDisplayElements();
        
        //Initialising the values received
        this.name = name;
        this.house = house;
        this.photo = photo;
        
        x = a;
       initComponents();
        
        
    }
    private void initDisplayElements()
    {
        this.candidate = new ArrayList<>();
        this.candidateImage = new ArrayList<>();
        this.candidateName = new ArrayList<>();
        this.candidateHouse = new ArrayList<>();
        this.candidateSelection = new ArrayList<>();
    }
    
    private void displayer(int n) // private void displayer(int n, ArrayList<String> name)
    {
        for(int i=0;i<n;i++)
        {
         // Name.add(name.get(i));   
            groupInitialiser(i);
            
        }
        for(int i=0;i<n;i++)
        {
           groupDisplayer(i);
        }
    }
    
    private void groupInitialiser(int i) // private void masterInitialiser(int i, Image img, String nam, String house)
    {
        candidate.add(initialisePanel(i));
        candidateImage.add(initialiseImage());
        candidateName.add(initialiseName());
        candidateHouse.add(initialiseHouse());
        candidateSelection.add(initialiseSelection());
        
    }
    private void groupDisplayer(int i)
    {
         displayPanel(candidate.get(i));
         displayImage(candidateImage.get(i),i);
         displayName(i);
         displayHouse(i);
         displaySelection(i);
    }
    
    // initializes a single panel with spacing and returns it.
    private JPanel initialisePanel(int i)
    {
        int j =i;
        double i1 = i;
        j = i%6;
        
        double yValD = Math.floor(i1/6.0);
        int yVal = (int)yValD;
        JPanel panel = new JPanel();
        
            panel.setBounds(35+(j*224), 20+245*yVal, 224, 245);
           
        
        
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        javax.swing.GroupLayout Panel = new javax.swing.GroupLayout(panel);
        panel.setLayout(Panel);
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        
        return panel;
    }
    
    private JLabel initialiseImage()
    {
        JLabel jl = new JLabel();
        try {
            
            jl.setBounds(36, 12, 150, 150);
            jl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            jl.setSize(150, 150);
            File f = new File("/Users/abhimanyuyadav/Desktop/191234.jpg");
            BufferedImage bi = ImageIO.read(f);
            Image ic = bi;
            ic = resizeImage(ic,150,150);
            ImageIcon icon = new ImageIcon(ic);
            jl.setIcon(icon);
            jl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            return jl;
        } catch (IOException ex) {
            Logger.getLogger(ClFrame3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jl;
    }
    
    private JLabel initialiseName()
    {
        JLabel jl = new JLabel();
        jl.setBounds(0, 170, 224, 23);
        jl.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // if(s.length()>22) -> {jl.setFont(new java.awt.Font("Helvetica Neue", 0, 12));}
        jl.setText("Abhimanyu Yadav");
        jl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        return jl;
    }
    
    private JLabel initialiseHouse()
    {
        JLabel jl = new JLabel();
        jl.setBounds(36, 199, 150, 20);
        jl.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        jl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl.setText("Mansfield");
        jl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        

        return jl;
    }
    
    private JCheckBox initialiseSelection()
    {
        JCheckBox jb = new JCheckBox();
        jb.setBounds(98, 218, 25, 20);
        jb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb.addActionListener(al);
        
        return jb;
    }
    
    private void displayPanel(JPanel panel)
    {
        jPanel5.add(panel);
        panel.setVisible(true);
    }
    
   private void displayImage(JLabel jl,int i)
   {
       candidate.get(i).add(jl);
       jl.setVisible(true);
   }
   
   private void displayName(int i)
   {
       candidate.get(i).add(candidateName.get(i));
       candidateName.get(i).setVisible(true);
   }
   
   private void displayHouse(int i)
   {
       candidate.get(i).add(candidateHouse.get(i));
       candidateHouse.get(i).setVisible(true);
   }
   
   private void displaySelection(int i)
   {
       candidate.get(i).add(candidateSelection.get(i));
       candidateSelection.get(i).setVisible(true);
   }
    

   
   public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        //below three lines are for RenderingHints for better image quality at cost of higher processing time
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
   
   ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            candidateSelection.stream().filter((jb) -> (e.getSource() == jb)).forEachOrdered((jb) -> {
                for(int i=0;i<candidateSelection.size();i++)
                    if(candidateSelection.get(i) == jb) {
                } else
                        candidateSelection.get(i).setSelected(false);
            });
        }
           
           };
   
   
/**
     * Creates new form ClFrame3
     */
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(163, 29, 36));

        jPanel3.setBackground(new java.awt.Color(163, 29, 36));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientvoter/BLogo1 (1).png"))); // NOI18N
        jLabel1.setText("                 THE BISHOP'S SCHOOL,PUNE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(1840, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(7);
        jScrollPane2.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );

        displayer(x);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1430, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1087, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ClFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            //</editor-fold>
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClFrame3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ClFrame3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClFrame3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClFrame3.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClFrame3().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

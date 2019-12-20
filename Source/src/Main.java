import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Progetto.
 * @author Bruno Gomes
 * @version 4/10/2019
 */
public class Main extends javax.swing.JFrame {

    /**
     * Verifica quale è l'item scelto nel comboBox.
     */
    private int selected;
    
    /**
     * Metodo Costruttore del JFrame Main.
     */
    public Main() {
        initComponents();
        this.setSize(400,300);
        this.setMinimumSize(this.getSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fioccoPanel = new FioccoPanel();
        jPanel1 = new javax.swing.JPanel();
        previewButton = new javax.swing.JButton();
        caricaButton = new javax.swing.JButton();
        salvaButton = new javax.swing.JButton();
        imageSVG = new javax.swing.JButton();
        imagePNG = new javax.swing.JButton();
        sizePNG = new javax.swing.JComboBox<>();
        generaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 768));

        fioccoPanel.setMinimumSize(new java.awt.Dimension(400, 728));
        fioccoPanel.setPreferredSize(new java.awt.Dimension(400, 728));

        javax.swing.GroupLayout fioccoPanelLayout = new javax.swing.GroupLayout(fioccoPanel);
        fioccoPanel.setLayout(fioccoPanelLayout);
        fioccoPanelLayout.setHorizontalGroup(
            fioccoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fioccoPanelLayout.setVerticalGroup(
            fioccoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(fioccoPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        previewButton.setText("Preview");
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });
        jPanel1.add(previewButton);

        caricaButton.setText("Carica Punti");
        caricaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caricaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(caricaButton);

        salvaButton.setText("Salva Punti");
        salvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(salvaButton);

        imageSVG.setText("Salva SVG");
        imageSVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageSVGActionPerformed(evt);
            }
        });
        jPanel1.add(imageSVG);

        imagePNG.setText("Salva PNG");
        imagePNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagePNGActionPerformed(evt);
            }
        });
        jPanel1.add(imagePNG);

        sizePNG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500px", "1000px" }));
        sizePNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizePNGActionPerformed(evt);
            }
        });
        jPanel1.add(sizePNG);

        generaButton.setText("Genera");
        generaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(generaButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo richiamato quando il tasto viene premuto.
     * @param evt variabile del evento
     */
    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        fioccoPanel.getIntersected(false, false);
    }//GEN-LAST:event_previewButtonActionPerformed

    /**
     * Metodo richiamato quando il tasto viene premuto.
     * @param evt variabile del evento
     */
    private void generaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaButtonActionPerformed
        fioccoPanel.getIntersected(true, false);        
    }//GEN-LAST:event_generaButtonActionPerformed

    /**
     * Metodo richiamato quando il tasto viene premuto.
     * @param evt variabile del evento
     */
    private void salvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showDialog(null, "Save");
        try{
            String path = new String(fc.getSelectedFile().toPath().toString());
            System.out.println(path);
            File file = new File(path);
            fioccoPanel.salvaPunti(file);
        }catch(Exception e){}
    }//GEN-LAST:event_salvaButtonActionPerformed

    /**
     * Metodo richiamato quando il tasto viene premuto.
     * @param evt variabile del evento
     */
    private void caricaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caricaButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showDialog(null, "Open");
        try{
            String path = new String(fc.getSelectedFile().toPath().toString());
            System.out.println(path);
            File file = new File(path);
            fioccoPanel.caricaPunti(file);
        }catch(Exception e){}
    }//GEN-LAST:event_caricaButtonActionPerformed

    /**
     * Metodo richiamato quando il tasto viene premuto.
     * @param evt variabile del evento
     */
    private void imageSVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageSVGActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter ff = new FileNameExtensionFilter("SVG File (*.svg)", "SVG");
        fc.setFileFilter(ff);
        fc.showDialog(null, "Save");
        try{
            String path = new String(fc.getSelectedFile().toPath().toString());
            fioccoPanel.creaSVG(path);
        }catch(NoClassDefFoundError | Exception e){}
    }//GEN-LAST:event_imageSVGActionPerformed

    /**
     * Metodo richiamato quando il tasto viene premuto.
     * @param evt variabile del evento
     */
    private void imagePNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagePNGActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("PNG File (*.png)", "PNG");
        fc.setFileFilter(fnf);
        fc.showDialog(null, "Save");
        try{
            String path = new String(fc.getSelectedFile().toPath().toString());
            if(selected == 0){
                fioccoPanel.creaPNG(path, 500);
            }else{
                fioccoPanel.creaPNG(path, 1000);
            }
        }catch(Exception e){}
    }//GEN-LAST:event_imagePNGActionPerformed

    /**
     * Metodo richiamato quando un item viene scelto.
     * @param evt variabile del evento
     */
    private void sizePNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizePNGActionPerformed
        selected = sizePNG.getSelectedIndex();
    }//GEN-LAST:event_sizePNGActionPerformed
    
    /**
     * Metodo Main.
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton caricaButton;
    private FioccoPanel fioccoPanel;
    private javax.swing.JButton generaButton;
    private javax.swing.JButton imagePNG;
    private javax.swing.JButton imageSVG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton previewButton;
    private javax.swing.JButton salvaButton;
    private javax.swing.JComboBox<String> sizePNG;
    // End of variables declaration//GEN-END:variables
}

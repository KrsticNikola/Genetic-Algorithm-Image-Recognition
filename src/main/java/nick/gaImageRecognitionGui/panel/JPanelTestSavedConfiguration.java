/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.panel;

import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.util.ConfigurationUtil;
import nick.gaImageRecognitionCore.util.IOUtil;
import nick.gaImageRecognitionCore.util.ScannerUtil;
import nick.gaImageRecognitionGui.configuration.RuntimeConfiguration;
import nick.gaImageRecognitionGui.util.StringConstants;
import nick.gaImageRecognitionGui.util.Util;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Nick
 */
public class JPanelTestSavedConfiguration extends BasePanel {

    /**
     * Creates new form JPanelTestLoadedData
     * @param topPanel
     */
    public JPanelTestSavedConfiguration(JPanelTopPanel topPanel) {
        super(topPanel);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testImagesFolderLocation = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonSelectImagesFolder = new javax.swing.JButton();
        jButtonLoadDefaultLoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaResults = new javax.swing.JTextArea();
        jButtonStartTest = new javax.swing.JButton();
        configurationsFolderLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonSelectConfigurationFolder = new javax.swing.JButton();
        testFalseImagesFolderLocation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonSelectFalseImagesFolder1 = new javax.swing.JButton();
        jButtonCleanJTextArea = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));

        testImagesFolderLocation.setEditable(false);
        testImagesFolderLocation.setText("Not loaded..");

        jLabel1.setText("Images folder: ");

        jButtonSelectImagesFolder.setText("Select..");
        jButtonSelectImagesFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectImagesFolderActionPerformed(evt);
            }
        });

        jButtonLoadDefaultLoc.setText("Load last settings");
        jButtonLoadDefaultLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadDefaultLocActionPerformed(evt);
            }
        });

        jTextAreaResults.setColumns(20);
        jTextAreaResults.setRows(5);
        jScrollPane1.setViewportView(jTextAreaResults);

        jButtonStartTest.setText("Start");
        jButtonStartTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartTestActionPerformed(evt);
            }
        });

        configurationsFolderLocation.setEditable(false);
        configurationsFolderLocation.setText("Not loaded..");

        jLabel2.setText("Configurations folder:");

        jButtonSelectConfigurationFolder.setText("Select..");
        jButtonSelectConfigurationFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectConfigurationFolderActionPerformed(evt);
            }
        });

        testFalseImagesFolderLocation.setEditable(false);
        testFalseImagesFolderLocation.setText("Not loaded..");

        jLabel3.setText("False images folder: ");

        jButtonSelectFalseImagesFolder1.setText("Select..");
        jButtonSelectFalseImagesFolder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectFalseImagesFolder1ActionPerformed(evt);
            }
        });

        jButtonCleanJTextArea.setText("Clean");
        jButtonCleanJTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanJTextAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStartTest)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonCleanJTextArea)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLoadDefaultLoc)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonSelectFalseImagesFolder1)
                                            .addGap(40, 40, 40)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel3)
                                                .addComponent(testFalseImagesFolderLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonSelectImagesFolder)
                                            .addGap(40, 40, 40)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(testImagesFolderLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addComponent(jButtonSelectConfigurationFolder)
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(configurationsFolderLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(59, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButtonLoadDefaultLoc)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButtonSelectImagesFolder))
                        .addGap(18, 18, 18)
                        .addComponent(testImagesFolderLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButtonSelectConfigurationFolder))
                        .addGap(18, 18, 18)
                        .addComponent(configurationsFolderLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonSelectFalseImagesFolder1))
                .addGap(18, 18, 18)
                .addComponent(testFalseImagesFolderLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStartTest)
                    .addComponent(jButtonCleanJTextArea))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectImagesFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectImagesFolderActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setCurrentDirectory(new java.io.File("."));
        fc.setDialogTitle(StringConstants.SELECT_TEST_IMAGES_FOLDER);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            RuntimeConfiguration.getInstance().setTestImagesFolderLocation(path);
            testImagesFolderLocation.setText(path);
        } else {
            String path = RuntimeConfiguration.getInstance().getTestImagesFolderLocation();
            if (StringUtils.isNotBlank(path)) {
                testImagesFolderLocation.setText(path);
            }
        }
    }//GEN-LAST:event_jButtonSelectImagesFolderActionPerformed

    private void jButtonLoadDefaultLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadDefaultLocActionPerformed

        String testImagesFolder = Util.getPreferences(StringConstants.TEST_IMAGES_FOLDER_LOCATION_PREF_KEY);
        String testFalseImagesFolder = Util.getPreferences(StringConstants.TEST_FALSE_IMAGES_FOLDER_LOCATION_PREF_KEY);
        String configurationFolder = Util.getPreferences(StringConstants.TEST_CONFIGURATION_FOLDER_LOCATION_PREF_KEY);

        if (StringUtils.isNotBlank(testImagesFolder)) {
            testImagesFolderLocation.setText(testImagesFolder);
        }
        if (StringUtils.isNotBlank(testFalseImagesFolder)) {
            testFalseImagesFolderLocation.setText(testFalseImagesFolder);
        }
        if (StringUtils.isNotBlank(configurationFolder)) {
            configurationsFolderLocation.setText(configurationFolder);
        }
    }//GEN-LAST:event_jButtonLoadDefaultLocActionPerformed

    private void jButtonStartTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartTestActionPerformed

        String testFolder = testImagesFolderLocation.getText();
        String testFalsePositivesFolder = testFalseImagesFolderLocation.getText();
        String configurationFolder = configurationsFolderLocation.getText();

        Util.savePreferences(StringConstants.TEST_IMAGES_FOLDER_LOCATION_PREF_KEY, testFolder);
        Util.savePreferences(StringConstants.TEST_FALSE_IMAGES_FOLDER_LOCATION_PREF_KEY, testFalsePositivesFolder);
        Util.savePreferences(StringConstants.TEST_CONFIGURATION_FOLDER_LOCATION_PREF_KEY, configurationFolder);

        Individual[] individualsJoined = ConfigurationUtil.readConfigurationsFromFolder(configurationFolder);
        
        List<BufferedImage> faceImages = IOUtil.getImagesFromFolder(testFolder);
        List<BufferedImage> nonFaceImages = IOUtil.getImagesFromFolder(testFalsePositivesFolder);

        BufferedImage[] faces = faceImages.toArray(new BufferedImage[faceImages.size()]);
        BufferedImage[] nonFaces = nonFaceImages.toArray(new BufferedImage[nonFaceImages.size()]);
        double foundPercentageFaces = ScannerUtil.scannImages(faces, individualsJoined);
        double foundPercentageNonFace = ScannerUtil.scannImages(nonFaces, individualsJoined);
        
        long numberOfPostitives = (long) (faces.length * foundPercentageFaces);
        long sizeOfFailedPositives = nonFaces.length;
        long numberOfFailedPositives = (long) (nonFaces.length * foundPercentageNonFace);
        long sizeOfPostitives = faces.length;
        long TP = numberOfPostitives;
        long TN = sizeOfFailedPositives - numberOfFailedPositives;
        long FN = numberOfFailedPositives;
        long FP = sizeOfPostitives - numberOfPostitives;
//        float statisticalAccuracy = ((float)(numberOfPostitives+(sizeOfFailedPositives-numberOfFailedPositives))/(sizeOfPostitives + sizeOfFailedPositives));
        double mcc = ((TP * TN - FP * FN) / Math.sqrt((TP+FP)*(TP+FN)*(TN+FP)*(TN+FN)));
        double accuracy = ((double)(TP+TN)/(TP+FP+FN+TN));
        jTextAreaResults.append("----------------------------");
        jTextAreaResults.append(System.lineSeparator());
        jTextAreaResults.append("Test faces found (size): " + numberOfPostitives);
        jTextAreaResults.append(System.lineSeparator());
        jTextAreaResults.append("Test non faces found (size): " + numberOfFailedPositives);
        jTextAreaResults.append(System.lineSeparator());
        jTextAreaResults.append("Test faces found (%): " + foundPercentageFaces);
        jTextAreaResults.append(System.lineSeparator());
        jTextAreaResults.append("Test non faces found (%): " + foundPercentageNonFace);
        jTextAreaResults.append(System.lineSeparator());
        jTextAreaResults.append("Matthews correlation coefficient : " + mcc);
        jTextAreaResults.append(System.lineSeparator());
        jTextAreaResults.append("Accuracy : " + accuracy);
        jTextAreaResults.append(System.lineSeparator());
        jTextAreaResults.append("----------------------------");


    }//GEN-LAST:event_jButtonStartTestActionPerformed

    private void jButtonSelectConfigurationFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectConfigurationFolderActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setCurrentDirectory(new java.io.File("."));
        fc.setDialogTitle(StringConstants.SELECT_TEST_IMAGES_FOLDER);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            RuntimeConfiguration.getInstance().setTestConfigurationsFolderLocation(path);
            configurationsFolderLocation.setText(path);
        } else {
            String path = RuntimeConfiguration.getInstance().getTestConfigurationsFolderLocation();
            if (StringUtils.isNotBlank(path)) {
                configurationsFolderLocation.setText(path);
            }
        }
    }//GEN-LAST:event_jButtonSelectConfigurationFolderActionPerformed

    private void jButtonSelectFalseImagesFolder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectFalseImagesFolder1ActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setCurrentDirectory(new java.io.File("."));
        fc.setDialogTitle(StringConstants.SELECT_TEST_IMAGES_FOLDER);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            RuntimeConfiguration.getInstance().setTestFalseImagesFolderLocation(path);
            testFalseImagesFolderLocation.setText(path);
        } else {
            String path = RuntimeConfiguration.getInstance().getTestFalseImagesFolderLocation();
            if (StringUtils.isNotBlank(path)) {
                testFalseImagesFolderLocation.setText(path);
            }
        }
    }//GEN-LAST:event_jButtonSelectFalseImagesFolder1ActionPerformed

    private void jButtonCleanJTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanJTextAreaActionPerformed
        jTextAreaResults.setText(StringUtils.EMPTY);
    }//GEN-LAST:event_jButtonCleanJTextAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField configurationsFolderLocation;
    private javax.swing.JButton jButtonCleanJTextArea;
    private javax.swing.JButton jButtonLoadDefaultLoc;
    private javax.swing.JButton jButtonSelectConfigurationFolder;
    private javax.swing.JButton jButtonSelectFalseImagesFolder1;
    private javax.swing.JButton jButtonSelectImagesFolder;
    private javax.swing.JButton jButtonStartTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaResults;
    private javax.swing.JTextField testFalseImagesFolderLocation;
    private javax.swing.JTextField testImagesFolderLocation;
    // End of variables declaration//GEN-END:variables

    @Override
    void initLabelValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
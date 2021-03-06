/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.panel;

import nick.gaImageRecognitionCore.api.ApiTrainer;
import nick.gaImageRecognitionCore.api.IApiTrainer;
import nick.gaImageRecognitionCore.individual.IndividualType;
import nick.gaImageRecognitionCore.util.IOUtil;
import nick.gaImageRecognitionCore.util.TrainingRules;
import nick.gaImageRecognitionCore.util.TrainingRulesDefault;
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
public class JPanelTraining extends BasePanel {

    private final TrainingRules trainingRules;
    /**
     * Creates new form JPanelTraining
     *
     * @param topPanel
     */
    public JPanelTraining(JPanelTopPanel topPanel) {
        super(topPanel);
        initComponents();
        initLabelValues();
        initIndividualTypes();
        trainingRules = TrainingRulesDefault.getDefaultTrainingRules();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSelectTrainingFolder = new javax.swing.JButton();
        jButtonSelectFalseImages = new javax.swing.JButton();
        jButtonTrain = new javax.swing.JButton();
        jButtonLoadDefaultLoc = new javax.swing.JButton();
        jComboBoxIndividualType = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerPopSize = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerMaxNumberOfIterations = new javax.swing.JSpinner();
        trainingFolderLocation = new javax.swing.JTextField();
        falseImagesFolderLoc = new javax.swing.JTextField();
        jButtonSetTrainingRules = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setText("Training folder: ");

        jLabel2.setText("False images folder: ");

        jButtonSelectTrainingFolder.setText("Select..");
        jButtonSelectTrainingFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectTrainingFolderActionPerformed(evt);
            }
        });

        jButtonSelectFalseImages.setText("Select..");
        jButtonSelectFalseImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectFalseImagesActionPerformed(evt);
            }
        });

        jButtonTrain.setText("Train");
        jButtonTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrainActionPerformed(evt);
            }
        });

        jButtonLoadDefaultLoc.setText("Load last settings");
        jButtonLoadDefaultLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadDefaultLocActionPerformed(evt);
            }
        });

        jComboBoxIndividualType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Population size");

        jLabel4.setText("Max number of iterations");

        jLabel5.setText("Individual type");

        trainingFolderLocation.setEditable(false);
        trainingFolderLocation.setText("Not loaded..");

        falseImagesFolderLoc.setEditable(false);
        falseImagesFolderLoc.setText("Not loaded..");

        jButtonSetTrainingRules.setText("Set training rules");
        jButtonSetTrainingRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetTrainingRulesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSelectFalseImages)
                            .addComponent(jButtonSelectTrainingFolder))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(trainingFolderLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(falseImagesFolderLoc, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxIndividualType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jSpinnerMaxNumberOfIterations, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(jSpinnerPopSize, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLoadDefaultLoc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSetTrainingRules)
                                .addGap(147, 147, 147)
                                .addComponent(jButtonTrain)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButtonLoadDefaultLoc)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButtonSelectTrainingFolder)
                        .addComponent(jLabel5))
                    .addComponent(jComboBoxIndividualType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(trainingFolderLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButtonSelectFalseImages)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jSpinnerMaxNumberOfIterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(falseImagesFolderLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSetTrainingRules)
                            .addComponent(jButtonTrain))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3))
                            .addComponent(jSpinnerPopSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectTrainingFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectTrainingFolderActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setCurrentDirectory(new java.io.File("."));
        fc.setDialogTitle(StringConstants.SELECT_TRAINING_FOLDER);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            RuntimeConfiguration.getInstance().setTrainingFolderPath(path);
            trainingFolderLocation.setText(path);
        } else {
            String path = RuntimeConfiguration.getInstance().getTrainingFolderPath();
            if (StringUtils.isNotBlank(path)) {
                trainingFolderLocation.setText(path);
            }
        }

    }//GEN-LAST:event_jButtonSelectTrainingFolderActionPerformed

    private void jButtonTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrainActionPerformed

        IApiTrainer trainer = initTrainer();

        saveSettings();

        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        final JDialog frame = new JDialog(topFrame, false);
        JPanelTrainingInProgress trainingPanel = new JPanelTrainingInProgress(trainer);
        frame.getContentPane().add(trainingPanel);
        frame.pack();
        Util.centreWindow(frame);
        frame.setVisible(true);


    }//GEN-LAST:event_jButtonTrainActionPerformed

    private void jButtonSelectFalseImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectFalseImagesActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setCurrentDirectory(new java.io.File("."));
        fc.setDialogTitle(StringConstants.SELECT_TRAINING_FOLDER);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            RuntimeConfiguration.getInstance().setTrainingFalseImagesFolderPath(path);
            falseImagesFolderLoc.setText(path);
        } else {
            String path = RuntimeConfiguration.getInstance().getTrainingFalseImagesFolderPath();
            if (StringUtils.isNotBlank(path)) {
                falseImagesFolderLoc.setText(path);
            }
        }
    }//GEN-LAST:event_jButtonSelectFalseImagesActionPerformed

    private void jButtonLoadDefaultLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadDefaultLocActionPerformed

        String popSizeString = Util.getPreferences(StringConstants.POPULATION_SIZE_PREF_KEY);
        String IndividualTypeString = Util.getPreferences(StringConstants.INDIVIDUAL_TYPE_PREF_KEY);
        String trainingLoc = Util.getPreferences(StringConstants.TRAINING_FOLDER_LOCATION_PREF_KEY);
        String falseImagesLoc = Util.getPreferences(StringConstants.FALSE_IMAGES_FOLDER_LOC_PREF_KEY);
        String maxNumberOfIterationsString = Util.getPreferences(StringConstants.MAX_NUMBER_OF_ITERATIONS_PREF_KEY);

        if (StringUtils.isNotBlank(trainingLoc) && StringUtils.isNotBlank(falseImagesLoc) && StringUtils.isNotBlank(popSizeString) && StringUtils.isNotBlank(IndividualTypeString) && StringUtils.isNotBlank(maxNumberOfIterationsString)) {
            int popSize = Integer.valueOf(popSizeString);
            int maxNumberOfIterations = Integer.valueOf(maxNumberOfIterationsString);
            IndividualType IndividualType = nick.gaImageRecognitionCore.individual.IndividualType.typeAsEnum(Integer.valueOf(IndividualTypeString));

            trainingFolderLocation.setText(trainingLoc);
            falseImagesFolderLoc.setText(falseImagesLoc);
            jComboBoxIndividualType.setSelectedItem(IndividualType);
            jSpinnerPopSize.setValue(popSize);
            jSpinnerMaxNumberOfIterations.setValue(maxNumberOfIterations);
        }

    }//GEN-LAST:event_jButtonLoadDefaultLocActionPerformed

    private void jButtonSetTrainingRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetTrainingRulesActionPerformed

        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        final JDialog frame = new JDialog(topFrame, true);
        JPanelSetTrainingRules setTrainingrules = new JPanelSetTrainingRules(trainingRules);
        frame.getContentPane().add(setTrainingrules);
        frame.pack();
        Util.centreWindow(frame);
        frame.setVisible(true);
        
    }//GEN-LAST:event_jButtonSetTrainingRulesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField falseImagesFolderLoc;
    private javax.swing.JButton jButtonLoadDefaultLoc;
    private javax.swing.JButton jButtonSelectFalseImages;
    private javax.swing.JButton jButtonSelectTrainingFolder;
    private javax.swing.JButton jButtonSetTrainingRules;
    private javax.swing.JButton jButtonTrain;
    private javax.swing.JComboBox jComboBoxIndividualType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner jSpinnerMaxNumberOfIterations;
    private javax.swing.JSpinner jSpinnerPopSize;
    private javax.swing.JTextField trainingFolderLocation;
    // End of variables declaration//GEN-END:variables

    @Override
    final void initLabelValues() {
        String trainingPath = RuntimeConfiguration.getInstance().getTrainingFolderPath();
        if (StringUtils.isNotBlank(trainingPath)) {
            trainingFolderLocation.setText(trainingPath);
        } else {
            trainingFolderLocation.setText(StringConstants.NOT_LOADED_RED_HTML);
        }

        String falseImagesPath = RuntimeConfiguration.getInstance().getTrainingFalseImagesFolderPath();
        if (StringUtils.isNotBlank(falseImagesPath)) {
            falseImagesFolderLoc.setText(falseImagesPath);
        } else {
            falseImagesFolderLoc.setText(StringConstants.NOT_LOADED_RED_HTML);
        }

    }

    private ApiTrainer initTrainer() {
        int populationSize = (int) jSpinnerPopSize.getValue();
        int maxNumberOfIterations = (int) jSpinnerMaxNumberOfIterations.getValue();
        IndividualType indType = (IndividualType) jComboBoxIndividualType.getSelectedItem();
        
        //here we will set individual type!
        trainingRules.setIndividualType(indType);
        
        int NUMBER_OF_ITERATIONS_AUTOCONFIG = 50;

        List<BufferedImage> trainingImages = IOUtil.getImagesFromFolder(trainingFolderLocation.getText());
        List<BufferedImage> falseImages = IOUtil.getImagesFromFolder(falseImagesFolderLoc.getText());

        return new ApiTrainer(populationSize, maxNumberOfIterations, trainingImages, falseImages, trainingRules);
    }

    private void saveSettings() {
        String trainingLoc = trainingFolderLocation.getText();
        String falseImagesLoc = falseImagesFolderLoc.getText();
        if (StringUtils.isNotBlank(trainingLoc) && StringUtils.isNotBlank(falseImagesLoc)) {
            Util.savePreferences(StringConstants.TRAINING_FOLDER_LOCATION_PREF_KEY, trainingLoc);
            Util.savePreferences(StringConstants.FALSE_IMAGES_FOLDER_LOC_PREF_KEY, falseImagesLoc);
            IndividualType individualType = (IndividualType) jComboBoxIndividualType.getSelectedItem();
            Util.savePreferences(StringConstants.INDIVIDUAL_TYPE_PREF_KEY, String.valueOf(IndividualType.typeAsInt(individualType)));
            Util.savePreferences(StringConstants.POPULATION_SIZE_PREF_KEY, String.valueOf(jSpinnerPopSize.getValue()));
            Util.savePreferences(StringConstants.MAX_NUMBER_OF_ITERATIONS_PREF_KEY, String.valueOf(jSpinnerMaxNumberOfIterations.getValue()));
        }
    }

    private void initIndividualTypes() {
        jComboBoxIndividualType.removeAllItems();
        jComboBoxIndividualType.addItem(IndividualType.FOUR_SIDE_INDIVIDUAL);
        jComboBoxIndividualType.addItem(IndividualType.LEFT_RIGHT_INDIVIDUAL);
        jComboBoxIndividualType.addItem(IndividualType.TOP_BOTTOM_INDIVIDUAL);
        jComboBoxIndividualType.addItem(IndividualType.MIDDLE_LEFT_RIGHT_INDIVIDUAL);
    }
}

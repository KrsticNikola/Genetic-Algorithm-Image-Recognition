/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.panel;

import nick.gaImageRecognitionCore.util.TrainingRules;
import nick.gaImageRecognitionGui.util.StringConstants;
import nick.gaImageRecognitionGui.util.Util;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.NumberFormatter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Nick
 */
public class JPanelSetTrainingRules extends BasePanel {

    //TODO zavrsi ovo zapoceto
    private final TrainingRules trainingRules;
    //zavrsi ovo zapoceto

    /**
     * Creates new form JPanelTraining
     *
     * @param trainingRules
     */
    public JPanelSetTrainingRules(TrainingRules trainingRules) {
        super(null);
        this.trainingRules = trainingRules;
        initComponents();
        initLabelValues();
        initFormatters();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLoadDefaultLoc = new javax.swing.JButton();
        jButtonSaveSettings = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFTextFieldTrashholdMedian = new javax.swing.JFormattedTextField();
        jFTextFieldMinFeaturePercentage = new javax.swing.JFormattedTextField();
        jFTextFieldMinTrashhold = new javax.swing.JFormattedTextField();
        jFTextFieldMaxTrashhold = new javax.swing.JFormattedTextField();
        jFTextFieldMaxNumberOfFeatures = new javax.swing.JFormattedTextField();
        jFTextFieldPicWidth = new javax.swing.JFormattedTextField();
        jFTextFieldPicHeight = new javax.swing.JFormattedTextField();
        jFTextFieldAutoIncrementDefaultValue = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabelSavedSuccess = new javax.swing.JLabel();
        jCheckBoxAutoAjust = new javax.swing.JCheckBox();
        jFTextFieldAutoIncrementGenCounter = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));

        jButtonLoadDefaultLoc.setText("Load last settings");
        jButtonLoadDefaultLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadDefaultLocActionPerformed(evt);
            }
        });

        jButtonSaveSettings.setText("Save");
        jButtonSaveSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveSettingsActionPerformed(evt);
            }
        });

        jLabel1.setText("TRASHHOLD_MEDIAN_PERCENTAGE");

        jLabel2.setText("MIN_TRASHHOLD");

        jLabel3.setText("MAX_TRASHHOLD");

        jLabel4.setText("MAX_NUMBER_OF_FEATURES");

        jLabel5.setText("PIC_WIDTH");

        jLabel6.setText("PIC_HEIGHT");

        jLabel7.setText("MIN_FEATURE_PERCENTAGE");

        jFTextFieldTrashholdMedian.setText("not loaded..");

        jFTextFieldMinFeaturePercentage.setText("not loaded..");

        jFTextFieldMinTrashhold.setText("not loaded..");

        jFTextFieldMaxTrashhold.setText("not loaded..");

        jFTextFieldMaxNumberOfFeatures.setText("not loaded..");

        jFTextFieldPicWidth.setText("not loaded..");

        jFTextFieldPicHeight.setText("not loaded..");

        jFTextFieldAutoIncrementDefaultValue.setText("not loaded..");

        jLabel8.setText("autoIncrementDefaultValue");

        jLabelSavedSuccess.setForeground(new java.awt.Color(0, 153, 102));
        jLabelSavedSuccess.setText("Saved successful");

        jCheckBoxAutoAjust.setText("Automatic increment");

        jFTextFieldAutoIncrementGenCounter.setText("not loaded..");

        jLabel9.setText("autoIncrementGenerationCounter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLoadDefaultLoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxAutoAjust))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonSaveSettings)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSavedSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jFTextFieldPicHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFTextFieldPicWidth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFTextFieldMaxNumberOfFeatures, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTextFieldMaxTrashhold, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTextFieldMinTrashhold, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTextFieldMinFeaturePercentage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTextFieldTrashholdMedian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTextFieldAutoIncrementDefaultValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTextFieldAutoIncrementGenCounter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadDefaultLoc)
                    .addComponent(jCheckBoxAutoAjust))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFTextFieldTrashholdMedian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFTextFieldMinTrashhold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFTextFieldMaxTrashhold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFTextFieldMaxNumberOfFeatures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFTextFieldPicWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFTextFieldPicHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFTextFieldMinFeaturePercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFTextFieldAutoIncrementDefaultValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jFTextFieldAutoIncrementGenCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveSettings)
                    .addComponent(jLabelSavedSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoadDefaultLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadDefaultLocActionPerformed

        float TRASHHOLD_MEDIAN_PERCENTAGE = Float.valueOf(Util.getPreferences(StringConstants.TRASHHOLD_MEDIAN_PERCENTAGE));
        int autoIncrementDefaultValue = Integer.valueOf(Util.getPreferences(StringConstants.autoIncrementDefaultValue));
        int MIN_TRASHHOLD = Integer.valueOf(Util.getPreferences(StringConstants.MIN_TRASHHOLD));
        int MAX_TRASHHOLD = Integer.valueOf(Util.getPreferences(StringConstants.MAX_TRASHHOLD));
        int MAX_NUMBER_OF_FEATURES = Integer.valueOf(Util.getPreferences(StringConstants.MAX_NUMBER_OF_FEATURES));
        int PIC_WIDTH = Integer.valueOf(Util.getPreferences(StringConstants.PIC_WIDTH));
        int PIC_HEIGHT = Integer.valueOf(Util.getPreferences(StringConstants.PIC_HEIGHT));
        float MIN_FEATURE_PERCENTAGE = Float.valueOf(Util.getPreferences(StringConstants.MIN_FEATURE_PERCENTAGE));
        boolean autoIncrement = Boolean.valueOf(Util.getPreferences(StringConstants.AUTO_INCREMENT_ON));
        int autoIncrementGenCounter = Integer.valueOf(Util.getPreferences(StringConstants.AUTO_INCREMENT_GEN_COUNTER));

        trainingRules.setTRASHHOLD_MEDIAN_PERCENTAGE(TRASHHOLD_MEDIAN_PERCENTAGE);
        trainingRules.setAutoIncrementDefaultValue(autoIncrementDefaultValue);
        trainingRules.setMIN_TRASHHOLD(MIN_TRASHHOLD);
        trainingRules.setMAX_TRASHHOLD(MAX_TRASHHOLD);
        trainingRules.setMAX_NUMBER_OF_FEATURES(MAX_NUMBER_OF_FEATURES);
        trainingRules.setPIC_WIDTH(PIC_WIDTH);
        trainingRules.setPIC_HEIGHT(PIC_HEIGHT);
        trainingRules.setMIN_FEATURE_PERCENTAGE(MIN_FEATURE_PERCENTAGE);
        trainingRules.setMIN_FEATURE_PERCENTAGE(MIN_FEATURE_PERCENTAGE);
        trainingRules.setAutoIncrement(autoIncrement);
        trainingRules.setAutoIncrementGenerationCounter(autoIncrementGenCounter);
        initLabelValues();
    }//GEN-LAST:event_jButtonLoadDefaultLocActionPerformed

    private void jButtonSaveSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveSettingsActionPerformed

        //save to system config
        Util.savePreferences(StringConstants.autoIncrementDefaultValue, jFTextFieldAutoIncrementDefaultValue.getText());
        Util.savePreferences(StringConstants.MAX_NUMBER_OF_FEATURES, jFTextFieldMaxNumberOfFeatures.getText());
        Util.savePreferences(StringConstants.MAX_TRASHHOLD, jFTextFieldMaxTrashhold.getText());
        Util.savePreferences(StringConstants.MIN_FEATURE_PERCENTAGE, jFTextFieldMinFeaturePercentage.getText());
        Util.savePreferences(StringConstants.MIN_TRASHHOLD, jFTextFieldMinTrashhold.getText());
        Util.savePreferences(StringConstants.PIC_HEIGHT, jFTextFieldPicHeight.getText());
        Util.savePreferences(StringConstants.PIC_WIDTH, jFTextFieldPicWidth.getText());
        Util.savePreferences(StringConstants.TRASHHOLD_MEDIAN_PERCENTAGE, jFTextFieldTrashholdMedian.getText());
        Util.savePreferences(StringConstants.AUTO_INCREMENT_ON, String.valueOf(jCheckBoxAutoAjust.isSelected()));
        Util.savePreferences(StringConstants.AUTO_INCREMENT_GEN_COUNTER, String.valueOf(jFTextFieldAutoIncrementGenCounter.getText()));

        //load to local training rules
        float TRASHHOLD_MEDIAN_PERCENTAGE = Float.valueOf(jFTextFieldTrashholdMedian.getText());
        int autoIncrementDefaultValue = Integer.valueOf(jFTextFieldAutoIncrementDefaultValue.getText());
        int MIN_TRASHHOLD = Integer.valueOf(jFTextFieldMinTrashhold.getText());
        int MAX_TRASHHOLD = Integer.valueOf(jFTextFieldMaxTrashhold.getText());
        int MAX_NUMBER_OF_FEATURES = Integer.valueOf(jFTextFieldMaxNumberOfFeatures.getText());
        int PIC_WIDTH = Integer.valueOf(jFTextFieldPicWidth.getText());
        int PIC_HEIGHT = Integer.valueOf(jFTextFieldPicHeight.getText());
        float MIN_FEATURE_PERCENTAGE = Float.valueOf(jFTextFieldMinFeaturePercentage.getText());
        boolean autoIncrement = jCheckBoxAutoAjust.isSelected();
        int autoIncrementGenCounter = Integer.valueOf(jFTextFieldAutoIncrementGenCounter.getText());

        trainingRules.setTRASHHOLD_MEDIAN_PERCENTAGE(TRASHHOLD_MEDIAN_PERCENTAGE);
        trainingRules.setAutoIncrementDefaultValue(autoIncrementDefaultValue);
        trainingRules.setMIN_TRASHHOLD(MIN_TRASHHOLD);
        trainingRules.setMAX_TRASHHOLD(MAX_TRASHHOLD);
        trainingRules.setMAX_NUMBER_OF_FEATURES(MAX_NUMBER_OF_FEATURES);
        trainingRules.setPIC_WIDTH(PIC_WIDTH);
        trainingRules.setPIC_HEIGHT(PIC_HEIGHT);
        trainingRules.setMIN_FEATURE_PERCENTAGE(MIN_FEATURE_PERCENTAGE);
        trainingRules.setMIN_FEATURE_PERCENTAGE(MIN_FEATURE_PERCENTAGE);
        trainingRules.setAutoIncrement(autoIncrement);
        trainingRules.setAutoIncrementGenerationCounter(autoIncrementGenCounter);

        //save to system data
        jLabelSavedSuccess.setVisible(true);
    }//GEN-LAST:event_jButtonSaveSettingsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLoadDefaultLoc;
    private javax.swing.JButton jButtonSaveSettings;
    private javax.swing.JCheckBox jCheckBoxAutoAjust;
    private javax.swing.JFormattedTextField jFTextFieldAutoIncrementDefaultValue;
    private javax.swing.JFormattedTextField jFTextFieldAutoIncrementGenCounter;
    private javax.swing.JFormattedTextField jFTextFieldMaxNumberOfFeatures;
    private javax.swing.JFormattedTextField jFTextFieldMaxTrashhold;
    private javax.swing.JFormattedTextField jFTextFieldMinFeaturePercentage;
    private javax.swing.JFormattedTextField jFTextFieldMinTrashhold;
    private javax.swing.JFormattedTextField jFTextFieldPicHeight;
    private javax.swing.JFormattedTextField jFTextFieldPicWidth;
    private javax.swing.JFormattedTextField jFTextFieldTrashholdMedian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSavedSuccess;
    // End of variables declaration//GEN-END:variables

    private void initFormatters() {

        AbstractFormatterFactory formatterInteger = new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat longFormat = NumberFormat.getIntegerInstance();
                longFormat.setGroupingUsed(false);
                NumberFormatter numberFormatter = new NumberFormatter(longFormat);
                numberFormatter.setValueClass(Integer.class); //optional, ensures you will always get a long value
                numberFormatter.setAllowsInvalid(false); //this is the key!!
                numberFormatter.setMinimum(0l); //Optional

                InternationalFormatter formatter = new InternationalFormatter(numberFormatter.getFormat());
                return formatter;
            }
        };

        AbstractFormatterFactory formatterDecimal = new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setGroupingUsed(false);
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(1000.00);
                return formatter;
            }
        };
        jFTextFieldMaxNumberOfFeatures.setFormatterFactory(formatterInteger);
        jFTextFieldMaxTrashhold.setFormatterFactory(formatterInteger);
        jFTextFieldMinFeaturePercentage.setFormatterFactory(formatterDecimal);
        jFTextFieldMinTrashhold.setFormatterFactory(formatterInteger);
        jFTextFieldPicHeight.setFormatterFactory(formatterInteger);
        jFTextFieldPicWidth.setFormatterFactory(formatterInteger);
        jFTextFieldTrashholdMedian.setFormatterFactory(formatterDecimal);
        jFTextFieldAutoIncrementDefaultValue.setFormatterFactory(formatterInteger);
        jFTextFieldAutoIncrementGenCounter.setFormatterFactory(formatterInteger);
    }

    @Override
    final void initLabelValues() {

        jFTextFieldMaxNumberOfFeatures.setValue(trainingRules.getMAX_NUMBER_OF_FEATURES());
        jFTextFieldMaxTrashhold.setValue(trainingRules.getMAX_TRASHHOLD());
        jFTextFieldMinFeaturePercentage.setValue(trainingRules.getMIN_FEATURE_PERCENTAGE());
        jFTextFieldMinTrashhold.setValue(trainingRules.getMIN_TRASHHOLD());
        jFTextFieldPicHeight.setValue(trainingRules.getPIC_HEIGHT());
        jFTextFieldPicWidth.setValue(trainingRules.getPIC_WIDTH());
        jFTextFieldTrashholdMedian.setValue(trainingRules.getTRASHHOLD_MEDIAN_PERCENTAGE());
        jFTextFieldAutoIncrementDefaultValue.setValue(trainingRules.getAutoIncrementDefaultValue());
        jCheckBoxAutoAjust.setSelected(trainingRules.isAutoIncrement());
        jFTextFieldAutoIncrementGenCounter.setValue(trainingRules.getAutoIncrementGenerationCounter());

        jLabelSavedSuccess.setVisible(false);
    }

}

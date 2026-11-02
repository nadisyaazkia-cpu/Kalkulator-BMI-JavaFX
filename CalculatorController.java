package com.mycompany.kalkulatorbmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField txtBerat;

    @FXML
    private TextField txtTinggi;

    @FXML
    private Label lblHasilBMI;

    @FXML
    private Label lblKategori;

    @FXML
    public void btnHitungAction(ActionEvent event) {
        try {
            double berat = Double.parseDouble(txtBerat.getText());
            double tinggiCm = Double.parseDouble(txtTinggi.getText());

            double tinggiM = tinggiCm / 100.0;
            double bmi = berat / (tinggiM * tinggiM);

            lblHasilBMI.setText(String.format("%.2f", bmi));

            String kategori;
            if (bmi < 18.5) {
                kategori = "Kekurangan Berat Badan (Underweight)";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                kategori = "Berat Badan Normal (Ideal)";
            } else if (bmi >= 25.0 && bmi < 29.9) {
                kategori = "Kelebihan Berat Badan (Overweight)";
            } else {
                kategori = "Obesitas (Obesity)";
            }

            lblKategori.setText(kategori);

        } catch (NumberFormatException e) {
            lblHasilBMI.setText("-");
            lblKategori.setText("Masukkan angka yang valid!");
        }
    }

    @FXML
    public void btnResetAction(ActionEvent event) {
        txtBerat.clear();
        txtTinggi.clear();
        lblHasilBMI.setText("0.0");
        lblKategori.setText("-");
    }
}
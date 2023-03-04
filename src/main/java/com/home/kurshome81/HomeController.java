package com.home.kurshome81;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HomeController
{

        @FXML
        private TextField text_in;

        @FXML
        private ChoiceBox<String> spisok;

        @FXML
        private TextField text_gram;

        @FXML
        private TextField text_kilo;

        @FXML
        private TextField text_ton;

        @FXML
        void initialize()
        {
                ObservableList<String> spisokV = FXCollections.observableArrayList("Граммы", "Килограммы", "Тонны");
                spisok.setItems(spisokV);
                spisok.setValue("Граммы");

        }

        @FXML
        void onActionVes(KeyEvent event)
        {
                        String spisok_res = spisok.getValue();
                if(!text_in.equals(""))
                {
                        Float value = Float.valueOf(text_in.getText());
                        if (spisok_res == "Граммы") {
                                text_gram.setText(String.valueOf(value));
                                text_kilo.setText(String.valueOf(value / 1000));
                                text_ton.setText(String.valueOf(value / 1000000));
                        }
                        if (spisok_res == "Килограммы") {
                                float x = 1000f;
                                text_gram.setText(String.valueOf(value * x));
                                text_kilo.setText(String.valueOf(value));
                                text_ton.setText(String.valueOf(value / x));
                        }
                        if (spisok_res == "Тонны") {
                                text_gram.setText(String.valueOf(value * 1000000));
                                text_kilo.setText(String.valueOf(value * 1000));
                                text_ton.setText(String.valueOf(value));
                        }
                }
        }

        @FXML
        void onVibor(MouseEvent event)
        {
                spisok.getSelectionModel().selectedIndexProperty().addListener( new ChangeListener<Number>() {
                        public void changed(ObservableValue ov, Number value, Number new_value)
                        {
                                String spisok_res = spisok.getValue();
                                Float value1 = Float.valueOf(text_in.getText());
                                if (spisok_res == "Граммы") {
                                        text_gram.setText(String.valueOf(value1));
                                        text_kilo.setText(String.valueOf(value1 / 1000));
                                        text_ton.setText(String.valueOf(value1 / 1000000));
                                }
                                if (spisok_res == "Килограммы") {
                                        float x = 1000f;
                                        text_gram.setText(String.valueOf(value1 * x));
                                        text_kilo.setText(String.valueOf(value1));
                                        text_ton.setText(String.valueOf(value1 / x));
                                }
                                if (spisok_res == "Тонны") {
                                        text_gram.setText(String.valueOf(value1 * 1000000));
                                        text_kilo.setText(String.valueOf(value1 * 1000));
                                        text_ton.setText(String.valueOf(value1));
                                }
                        }
                });
        }

}
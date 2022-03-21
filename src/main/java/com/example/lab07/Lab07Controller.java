package com.example.lab07;

import java.io.*;
import java.util.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;

import java.net.URL;

public class Lab07Controller implements Initializable {
    @FXML
    private PieChart pieChart = new PieChart();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String path = "E:\\Workspace\\Intelj\\Lab07\\src\\main\\resources\\com\\example\\lab07\\weatherwarnings-2015.csv";
        String line = "";
        List<String> data = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                String[] value = line.split(",");
                 data.add(value[5]);
            }
            String[] crisis = new String[data.size()];
            crisis = data.toArray(new String[0]);
            String[] crisislist = new HashSet<String>(Arrays.asList(crisis)).toArray(new String[0]);
            int[] crisisCount = new int[crisislist.length];
            for(int i=0; i< 29195; i++){
                if(crisis[i].equals(crisislist[0])){
                    crisisCount[0] = crisisCount[0] + 1;
                }
                else if(crisis[i].equals(crisislist[1])){
                    crisisCount[1] = crisisCount[1] + 1;
                }
                else if(crisis[i].equals(crisislist[2])){
                    crisisCount[2] = crisisCount[2] + 1;
                }
                else if(crisis[i].equals(crisislist[3])){
                    crisisCount[3] = crisisCount[3] + 1;
                }
            }

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
            for (int i=0; i<4; i++) {
                pieChartData.add(new PieChart.Data(crisislist[i], crisisCount[i]));
            }
            pieChart.setData(pieChartData);
            pieChart.setBackground(Background.EMPTY);
            pieChart.setLegendVisible(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.*;
import java.util.AbstractMap;
import java.util.List;

public class Chart {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JFXPanel jfxPanel = new JFXPanel();
        frame.add(jfxPanel);
        frame.setVisible(true);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(
                () -> {
                    initFx(jfxPanel);
                }
        );
        
    }

    private static void initFx(JFXPanel jfxPanel) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        AbstractMap.SimpleEntry<List<Integer>, List<Double>> res = Main.calcFun(5);
        List<Integer> x = res.getKey();
        List<Double> y = res.getValue();
        System.out.println("RES:"+res);
        for(int i = 0; i < x.size(); i++){
            series.getData().add(new XYChart.Data<>(x.get(i),y.get(i)));
        }
        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(new NumberAxis(),new NumberAxis());
        lineChart.getData().add(series);
        Scene scene = new Scene(lineChart);
        jfxPanel.setScene(scene);
    }

}

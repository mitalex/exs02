import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.AbstractMap;
import java.util.List;

public class ChatFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

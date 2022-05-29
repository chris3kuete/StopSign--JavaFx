/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawpolygon;

import javafx.scene.paint.Color;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sa
 */
public class DrawPolygon extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new MyPolygon(), 300, 250); 
        primaryStage.setTitle("Stop Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class MyPolygon extends StackPane {
    private void paint(){
        Polygon p = new Polygon();
        p.setFill(Color.RED);
        p.setStroke(Color.BLACK);
        p.setRotate(22);
        ObservableList<Double> list = p.getPoints();
        
        double centerX = getWidth()/2, centerY = getHeight()/2;
        double radius = Math.min(getWidth(), getHeight())*0.4;
        
        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI /8));
            list.add(centerY + radius * Math.sin(2 * i * Math.PI /8));
            
            
        }
        Text t = new Text(150,300,"STOP");
        t.setFont(Font.font("Courier", FontPosture.REGULAR, 100));
        t.setFill(Color.WHITE);
        getChildren().clear();
        getChildren().addAll(p,t);
        p.rotationAxisProperty();
    }
    @Override
    public void setWidth(double width){
       super.setWidth(500);
       paint();
    }
    @Override
    public void setHeight(double height){
        super.setHeight(600);
        paint();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

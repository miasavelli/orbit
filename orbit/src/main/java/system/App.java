package system;

import java.util.Date;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Circle myCircle = new Circle(500.0f, 500.0f, 301.0f); 
        Circle fill = new Circle(500, 500, 299); 
        fill.setFill(Color.WHITE);
        Circle sun = new Circle(500, 500, 30); 
        sun.setFill(Color.ORANGE); 
        Circle earth = new Circle(200, 500, 10);
        earth.setFill(Color.BLUE);
        
        Circle m1 = new Circle(500, 500, 451);
        Circle m2 = new Circle(500, 500, 449);
        Shape marsOrbit = Shape.subtract(m1, m2);

        Circle mars = new Circle(50, 500, 7);
        mars.setFill(Color.ORANGERED); 

        Circle v1 = new Circle(500, 500, 218); 
        Circle v2 = new Circle(500, 500, 216); 
        Shape venusOrbit = Shape.subtract(v1, v2);
        Circle venus = new Circle(283, 500, 9); 
        venus.setFill(Color.YELLOW);

        Circle mc1 = new Circle(500, 500, 117); 
        Circle mc2 = new Circle(500, 500, 115);
        Shape mercuryOrbit = Shape.subtract(mc1,mc2);
        Circle mercury = new Circle(384, 500, 9); 
        mercury.setFill(Color.SILVER);

        int day = 0; 
        String days = "Day: " + day;
        Label dayCount = new Label(days);

        Polygon triangle1 = new Polygon(); 
        triangle1.setFill(Color.BLUEVIOLET);

        Group root = new Group(myCircle, fill, sun, earth, marsOrbit, mars, venusOrbit, venus, mercuryOrbit, mercury, triangle1); 

        //VBox box = new VBox(dayCount, root);
        //box.setPrefHeight(1000);
        //box.setPrefWidth(1000);

        Scene scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.show();

        


        Thread loop = new Thread( () -> {

            double x = 300.0; 
            double y = 500.0; 
            double r = 300.0;
            double ang = 180.0; 

            double mx = 50; 
            double my = 500; 
            double mr = 450; 
            double mang = 180; 

            double vx = 283; 
            double vy = 500;
            double vr = 217; 
            double vang = 180; 

            double mcx = 384;
            double mcy = 500; 
            double mcr = 116; 
            double mcang = 180; 
            float counter = 0;
            int d = 0; 
        
            while (true) {

                triangle1.getPoints().setAll(
                    x,y,
                    mx, my, 
                    vx, vy
                );

                long start = new Date().getTime(); 
                while (new Date().getTime() - start < 9L ){}; 

                ang = ang + 0.1; 
                double radians = Math.toRadians(ang);
                x = ((Math.cos(radians) * r) + 500);
                y = ((Math.sin(radians) * r) + 500);

                System.out.println(x + " " + y); 
            
                //earth.relocate(x, y);
                earth.setCenterX(x);
                earth.setCenterY(y);
                dayCount.setText("Day: " + d);
                mang = mang + 0.080926; 
                double mRadians = Math.toRadians(mang); 
                mx = ((Math.cos(mRadians) * mr) + 500);
                my = ((Math.sin(mRadians) * mr) + 500); 

                mars.setCenterX(mx);
                mars.setCenterY(my); 

                vang = vang + 0.1175957;
                double vRadians = Math.toRadians(vang);
                vx = ((Math.cos(vRadians) * vr) + 500);
                vy = ((Math.sin(vRadians) * vr) + 500); 

                venus.setCenterX(vx);
                venus.setCenterY(vy);

                mcang = mcang + 0.15903;
                double mcRadians = Math.toRadians(mcang); 
                mcx = ((Math.cos(mcRadians) * mcr) + 500);
                mcy = ((Math.sin(mcRadians) * mcr) + 500);

                mercury.setCenterX(mcx);
                mercury.setCenterY(mcy);
            
            }
        });

        loop.setDaemon(true);
        loop.start(); 

    }

    public static void main(String[] args) {
        launch();
    }

}
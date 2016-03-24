import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class EulersMethod extends Application {
    /*
     * Estimates solution curves for the system
     * dx/dt = y; dy/dt = -x - 2y in the fourth quadrant
     * This is a linear system with a repeated
     * eigenvalue of -1. Only the fourth quadrant is shown,
     * so assume the top of the window is the
     * positive x-axis and the left border is the negative y-axis.
     *
     * TODO: show all 4 quadrants.
     */
    private static LinearSystem system;

    private static double tStep = 0.05;
    private static double X = 5.0;
    private static double Y = 0.0;
    private static double t = 0.0;

    //center at (400,300)
    private static double xCoord(double x) {return (x+4.0) * 100.0;}
    private static double yCoord(double y) {return ((-1*y) + 3.0) * 100.0;}

    public void start(Stage primaryStage) {
	Group root = new Group();
	Scene scene = new Scene(root, 800, 600, Color.WHITE);
	
	for(int c=0; c<18; c++) {
	    
	    if (c<=8) {
		X = (double) c - 4.0;
		Y = 3.0;
	    }else { // 9->17
		X = (double) c - 13.0;
		Y = -3.0;
	    }
	    t = 0.0;
	    

	    Path path = new Path();
	    path.setStrokeWidth(1);
	
	    MoveTo moveTo = new MoveTo();
	    moveTo.setX(xCoord(X));
	    moveTo.setY(yCoord(Y));
	    path.getElements().addAll(moveTo);
	    for(int i=0; i<750; i++) {
		t += tStep;
		LineTo lineTo = new LineTo();
		X = system.nextX(X,Y,tStep);
		Y = system.nextY(X,Y,tStep);
		//System.out.println(X + ", " + Y); //this spits out an unholy amount of data
		lineTo.setX(xCoord(X));
		lineTo.setY(yCoord(Y));
		path.getElements().addAll(lineTo);
	    }
	    root.getChildren().add(path);
	}
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args) {

	if (args.length != 1) {
	    System.out.println("Usage: java EulersMethod [arg]\n" +
			       "Options:\n\tRepeated\n\tSaddle\n\t" +
			       "Sink\n\tSource\n\tSpiral");
	    System.exit(0);
	}
	
	switch (args[0]) {
	case "Repeated":
	    system = new Repeated();
	    break;
	case "Saddle":
	    system = new Saddle();
	    break;
	case "Source":
	    system = new Source();
	    break;
	case "Sink":
	    system = new Sink();
	    break;
	case "Spiral":
	    system = new Spiral();
	    break;
	default:
	    System.out.println("Usage: java EulersMethod [arg]\n" +
			       "Options:\n\tRepeated\n\tSaddle\n\t" +
			       "Sink\n\tSource\n\tSpiral");
	    System.exit(0);
	}
	launch(args);
    }

}
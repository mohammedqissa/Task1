import java.io.File;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Driver extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane root = new Pane();
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		File file = new File("data.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
			Shape shape ;
			String[] arr = scan.nextLine().split("[,]");

			for (int i = 0; i < arr.length; i++) {
				arr[i] = arr[i].trim();
			}

			if(arr[0].equalsIgnoreCase("ellipse")){
				Ellipse ellipse = new Ellipse();
				ellipse.setCenterX(Integer.parseInt(arr[1]));
				ellipse.setCenterY(Integer.parseInt(arr[2]));
				ellipse.setRadiusX(Integer.parseInt(arr[3]));
				ellipse.setRadiusY(Integer.parseInt(arr[4]));
				setcolor(ellipse,arr[5].trim());

				root.getChildren().add(ellipse);

			}
			else if(arr[0].equalsIgnoreCase("Rectangle")){
				Rectangle r = new Rectangle();
				r.setX(Integer.parseInt(arr[1]));
				r.setY(Integer.parseInt(arr[2]));
				r.setWidth(Integer.parseInt(arr[3]));
				r.setHeight(Integer.parseInt(arr[4]));
				setcolor(r,arr[5].trim());

				root.getChildren().add(r);
			}
			else if(arr[0].equalsIgnoreCase("circle")){
				Circle circle = new Circle();

				circle.setCenterX(Integer.parseInt(arr[1]));
				circle.setCenterY(Integer.parseInt(arr[2]));
				circle.setRadius(Integer.parseInt(arr[3]));
				setcolor(circle,arr[4].trim());

				root.getChildren().add(circle);
			}
			else if(arr[0].equalsIgnoreCase("line")){
				Line line = new Line();
				line.setStartX(Integer.parseInt(arr[1]));
				line.setStartY(Integer.parseInt(arr[2]));
				line.setEndX(Integer.parseInt(arr[3]));
				line.setEndY(Integer.parseInt(arr[4]));
				root.getChildren().add(line);
			}
			else if(arr[0].equalsIgnoreCase("text")) {
				Text text = new Text(Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),arr[3]);
				root.getChildren().add(text);
			}

		}
		stage.setScene(scene);
		stage.show();
	}


	private static void setcolor(Shape x , String color){


		if (color.equals("YELLOW")){
			x.setFill(Color.YELLOW);
			return;}
		else if(color.equals("BROWN")){
			x.setFill(Color.BROWN);
			return;}
		else if(color.equals("LIGHTGRAY")){
			x.setFill(Color.LIGHTGRAY);
			return;}
		else if(color.equals("WHITE")){
			x.setFill(Color.WHITE);
			return;}
		else if(color.equals("LIGHTBLUE")){
			x.setFill(Color.LIGHTBLUE);
			return;}
		else if(color.equals("BURLYWOOD")){
			x.setFill(Color.BURLYWOOD);
			return;}
		else if(color.equals("ALICEBLUE")){
			x.setFill(Color.ALICEBLUE);
			return;
		}
	}
}

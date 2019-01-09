package fxTwoButton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class JavaFxTwoButtonDemo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) throws Exception {
		
		Label label = new Label("Please Push a Button!");
		Button button1 = new Button("First");
		Button button2 = new Button("Second");
		
		myStage.setTitle("Introducing Buttonts and Events!");
		FlowPane pane = new FlowPane(10, 10);
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane,300,100);
		myStage.setScene(scene);
		
		button1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				label.setText("First button is pressed!");
				
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent e) {
				label.setText("Second button is pressed!");
				
			}
			
		});
		
		
		pane.getChildren().addAll(button1, button2, label);
		
		myStage.show();
		
		
		
	}

}
package fxCheckBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.String;

public class FXCheckBox extends Application{

	String[] food = new String[] {"Burger", "Coke", "Fries"};
	CheckBox[] cbs = new CheckBox[food.length];
	TextArea textarea = new TextArea("Here is your order:\n");
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	 primaryStage.setTitle("Food order example!");
	 primaryStage.setWidth(350);
	 primaryStage.setHeight(350);
	
	 textarea.setMinSize(150,125);
	 textarea.setMaxSize(200,125);
	 
	 FlowPane pane = new FlowPane();
	// Create padding between my textarea and vbox
	 pane.setPadding(new Insets(10, 10, 10, 10));
	 pane.setVgap(4);
	 pane.setHgap(4);
	
	 // To make sure all checkboxes are aligned 
	final VBox vbox = new VBox(); 
	 
	for(int i =0 ;i<food.length; i++) {
			CheckBox cb = cbs[i] = new CheckBox(food[i]);
			
			// Add listener for each individual checkbox item, you can remove from here:
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					textarea.clear();
					
				StringBuilder sb = new StringBuilder("Your current order:\n");
				
				for(CheckBox cbox: cbs) {
						
						if(cbox.isSelected())
							sb.append(cbox.getText()+"\n");
						
					}
					
				textarea.appendText(sb.toString());
					
				}
				
			 });
			 
			
			vbox.getChildren().add(cb);
			
		}

		
		
		pane.getChildren().addAll(textarea,vbox);
		Scene scene = new Scene(pane,300,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
}

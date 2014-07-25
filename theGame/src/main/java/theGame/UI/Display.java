package theGame.UI;

import java.util.ArrayList;
import java.util.List;

public class Display {
	
	private List<Widget> widgets;
	
	public Display(){
		widgets = new ArrayList<>();
	}
	
	public void addWidget(Widget widget){
		widgets.add(widget);
	}
	
	public void drawDisplay(){
		for(Widget widget: widgets){
			widget.draw();
		}
	}

}

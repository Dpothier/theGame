package engine.display.widgets;

import java.util.List;

import engine.display.Point;
import engine.display.Widget;

public class View implements Widget{
	
	private List<Widget> widgets;
	private Point origin;

	public View(List<Widget> widget, Point origin){
		this.widgets = widget;
		this.origin = origin;
	}

	public void render(Point parentOrigin) {
		for(Widget widget: widgets){
			widget.render(origin.add(parentOrigin));
		}
	}

}

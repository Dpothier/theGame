package engine.display.widgets;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import engine.display.Point;
import engine.display.Widget;

import engine.display.widgets.View;

@RunWith(MockitoJUnitRunner.class)
public class ViewTest {
	
	private View view;
	
	@Mock
	private Point viewOrigin, parentViewOrigin, addedPoint;
	
	@Mock
	private Widget firstWidget, secondWidget;
	
	@Mock
	private View firstSubview, secondSubview;
	
	private ArrayList<Widget> widgets;
	
	@Before
	public void setUp(){
		when(viewOrigin.add(parentViewOrigin)).thenReturn(addedPoint);
	}
	
	@Test
	public void whenViewIsRenderedAllInnerWidgetsAreRendered(){
		view = viewWithWidgets();
		view.render(parentViewOrigin);
		
		verify(firstWidget).render(any(Point.class));
		verify(secondWidget).render(any(Point.class));
	}
	

	@Test
	public void widgetsCanBeSubviews(){
		view = viewWithSubviews();
		view.render(parentViewOrigin);
		
		verify(firstSubview).render(any(Point.class));
	}
	
	@Test
	public void widgetsAreToldAbsoluteCoordinatesOfParent(){
		view = viewWithWidgets();
		view.render(parentViewOrigin);
		verify(firstWidget).render(addedPoint);
	}
	

	private View viewWithWidgets() {
		widgets = new ArrayList<>();
		widgets.add(firstWidget);
		widgets.add(secondWidget);
		return new View(widgets, viewOrigin);
	}
	
	private View viewWithSubviews() {
		widgets = new ArrayList<>();
		widgets.add(firstSubview);
		widgets.add(secondSubview);
		return new View(widgets, viewOrigin);
	}

}

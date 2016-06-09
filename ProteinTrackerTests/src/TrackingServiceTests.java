
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.voytovych.junit.TrackingService;

public class TrackingServiceTests {
	
	private TrackingService service;
	
	@Before
	public void setUp(){
		System.out.println("Before");
		service = new TrackingService();
	}
	
	@After
	public void tearDown(){
		System.out.println("After");
	}

	@Test
	public void newTrackingServiceTotalIsZero(){
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	public void whenAddingProteinTotalIncreasesByThatAmount(){
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
	
	@Test
	public void whenRemovingProteinTotalRemainsZero(){
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
}

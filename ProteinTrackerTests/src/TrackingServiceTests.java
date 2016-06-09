import org.junit.Test;

import ua.voytovych.junit.TrackingService;
import static org.junit.Assert.*;

public class TrackingServiceTests {
	
	@Test
	public void NewTrackingServiceTotalIsZero(){
		TrackingService service = new TrackingService();
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	public void WhenAddingProteinTotalIncreasesByThatAmount(){
		TrackingService service = new TrackingService();
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
}

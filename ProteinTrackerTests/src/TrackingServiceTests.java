
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ua.voytovych.junit.InvalidGoalException;
import ua.voytovych.junit.TrackingService;

public class TrackingServiceTests {
	
	private TrackingService service;
	
	@BeforeClass
	public static void before() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("After Class");
	}
	
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
	@Category({GoodTestCategory.class, BadCategory.class})
	public void newTrackingServiceTotalIsZero(){
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Ignore
	@Category(GoodTestCategory.class)
	public void whenAddingProteinTotalIncreasesByThatAmount(){
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void whenRemovingProteinTotalRemainsZero(){
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Test(expected = InvalidGoalException.class)
	public void whenGoalIsSetToLessThenZeroExceptionIsThrown() throws InvalidGoalException{
		service.setGoal(-5);
	}
	
	@Test(timeout = 500)
	public void badTest() {
		for (int i = 0; i < 1000000; i++) {
			service.addProtein(1);
		}
	}
}






























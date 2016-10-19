import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	@Test
	public void test_createPlanet_5x5() {
		PlanetExplorer explorer = new PlanetExplorer(5, 5, null);
		
		assertEquals("(5,5)", explorer.getSize());
	}
	
	@Test
	public void test_createPlanet_100x100() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String size = explorer.getSize();
		
		assertEquals("(100,100)", size);
	}
	
	@Test
	public void test_landExplorer_Initial_Position_0_0_F() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String result = explorer.executeCommand("");
		
		assertEquals("(0,0,N)", result);
	}
}

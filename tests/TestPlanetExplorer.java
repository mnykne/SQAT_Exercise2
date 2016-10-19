import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_createPlanet_5x5() {
		PlanetExplorer explorer = new PlanetExplorer(5, 5, null);
		
		assertEquals("(5, 5)", explorer.getSize());
	}
}

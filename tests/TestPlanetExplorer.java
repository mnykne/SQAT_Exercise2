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
	public void test_landExplorer_Initial_Position_0_0_Facing_North() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String result = explorer.executeCommand("");
		
		assertEquals("(0,0,N)", result);
	}
	
	@Test
	public void test_landExplorer_Turn_Right_Facing_East() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String result = explorer.executeCommand("r");
		
		assertEquals("(0,0,E)", result);
	}

	@Test
	public void test_landExplorer_Turn_Left_Facing_West() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String result = explorer.executeCommand("l");
		
		assertEquals("(0,0,W)", result);
	}
	
	@Test
	public void test_landExplorer_Move_Forward_Facing_North() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String result = explorer.executeCommand("f");
		
		assertEquals("(0,0,N)", result);
	}
}

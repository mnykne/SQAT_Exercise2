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
	public void test_setExplorer_Position_7_7_Facing_North() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		explorer.setExplorer(7, 7, 'S');
		
		String result = explorer.executeCommand("");
		
		assertEquals("(7,7,S)", result);
	}

	@Test
	public void test_landExplorer_Move_Forward_1_Step_Facing_North() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);

		String result = explorer.executeCommand("f");
		
		assertEquals("(0,1,N)", result);
	}

	@Test
	public void test_landExplorer_Move_Forward_From_7_6_N_To_7_7_N() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		explorer.setExplorer(7, 6, 'N');
		
		String result = explorer.executeCommand("f");
		
		assertEquals("(7,7,N)", result);
	}

	@Test
	public void test_landExplorer_Move_Forward_From_5_8_E_To_6_8_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		explorer.setExplorer(5, 8, 'E');
		
		String result = explorer.executeCommand("f");
		
		assertEquals("(6,8,E)", result);
	}
	
	@Test
	public void test_landExplorer_Move_Backward_From_5_8_E_To_4_8_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		explorer.setExplorer(5, 8, 'E');
		
		String result = explorer.executeCommand("b");
		
		assertEquals("(4,8,E)", result);
	}

	@Test
	public void test_landExplorer_Sequence_FFRFF_From_0_0_N_To_2_2_E() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);
		
		String result = explorer.executeCommand("ffrff");
		
		assertEquals("(2,2,E)", result);
	}
	
	@Test
	public void test_landExplorer_Move_Negative_Y_Spawn_Opposite_Y() {
		PlanetExplorer explorer = new PlanetExplorer(100, 100, null);

		String result = explorer.executeCommand("b");
		
		assertEquals("(0,99,N)", result);
	}
}

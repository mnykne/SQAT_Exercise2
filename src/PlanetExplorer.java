import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 115
// Finish time:

public class PlanetExplorer {
	private class Cell {
		boolean obstacle = false;
	}
	
	private enum Direction {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
	
	Cell[][] mCells;

	int mWidth;
	int mHeight;
	
	int mExplorerX;
	int mExplorerY;
	Direction mExplorerDirection;
	
	public PlanetExplorer(int x, int y, String obstacles) throws PlanetExplorerException{
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		
		mCells = new Cell[y][x];
		
		if (obstacles != null) {
			for (int i = 0; i < obstacles.length(); i++) {
				int coordX = -1;
				int coordY = -1;
				String strX = "";
				String strY = "";
				
				if (obstacles.charAt(i) == '(') {
					++i;
					for (int j = i; j < obstacles.length(); j++) {
						if (obstacles.charAt(j) == ',') {
							i = j + 1;
							break;
						}
						if (obstacles.charAt(j) >= '0' && obstacles.charAt(j) <= '9') {
							strX += obstacles.charAt(j);
						}
					}
					
					if (obstacles.charAt(i) == '(') {
						++i;
						for (int j = i; j < obstacles.length(); j++) {
							if (obstacles.charAt(j) == ')') {
								i = j + 1;
								break;
							}
							if (obstacles.charAt(j) >= '0' && obstacles.charAt(j) <= '9') {
								strY += obstacles.charAt(j);
							}
						}
					
					} else {
					}
				
				} else {
				}
				
				if (strX.isEmpty() || strY.isEmpty()) {
				}
	
				coordX = Integer.parseInt(strX);
				coordY = Integer.parseInt(strY);
				
				mCells[coordY][coordX].obstacle = true;
			}
		}
		
		mWidth = x;
		mHeight = y;
		
		mExplorerX = 0;
		mExplorerY = 0;
		mExplorerDirection = Direction.NORTH;
	}
	
	public String executeCommand(String command) {
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		for (char c : command.toCharArray()) {
			switch (c) {
			case 'r':
				switch (mExplorerDirection) {
				case NORTH: mExplorerDirection = Direction.EAST; break;
				case EAST:  mExplorerDirection = Direction.NORTH; break;
				case SOUTH: mExplorerDirection = Direction.WEST; break;
				case WEST:  mExplorerDirection = Direction.NORTH; break;
				}
				break;
			case 'l':
				switch (mExplorerDirection) {
				case NORTH: mExplorerDirection = Direction.WEST; break;
				case EAST:  mExplorerDirection = Direction.NORTH; break;
				case SOUTH: mExplorerDirection = Direction.EAST; break;
				case WEST:  mExplorerDirection = Direction.SOUTH; break;
				}
				break;
			case 'f':
				switch (mExplorerDirection) {
				case NORTH: ++mExplorerY; break;
				case EAST:  ++mExplorerX; break;
				case SOUTH: --mExplorerY; break;
				case WEST:  --mExplorerX; break;
				}
				break;
			case 'b':
				switch (mExplorerDirection) {
				case NORTH: --mExplorerY; break;
				case EAST:  --mExplorerX; break;
				case SOUTH: ++mExplorerY; break;
				case WEST:  ++mExplorerX; break;
				}
				break;
			}
			
			if (mExplorerY < 0) {
				mExplorerY = mHeight - 1;
			}
			
			if (mExplorerX < 0) {
				mExplorerX = mWidth - 1;
			}
		}
		
		return "(" + mExplorerX + "," + mExplorerY + "," + getDirectionAsString(mExplorerDirection) + ")";
	}
	
	public void setExplorer(int x, int y, char direction) {
		mExplorerX = x;
		mExplorerY = y;
		switch (direction) {
		case 'N': mExplorerDirection = Direction.NORTH; break;
		case 'E':  mExplorerDirection = Direction.EAST; break;
		case 'S': mExplorerDirection = Direction.SOUTH; break;
		case 'W':  mExplorerDirection = Direction.WEST; break;
		}
	}
	
	String getSize() {
		return "(" + mWidth + "," + mHeight + ")";
	}
	
	private String getDirectionAsString(Direction direction) {
		switch (direction) {
		case NORTH: return "N";
		case EAST:  return "E";
		case SOUTH: return "S";
		case WEST:  return "W";
		default:    return "?";
		}
	}
}

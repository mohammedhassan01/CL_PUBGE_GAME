package com.auto1.puzzel.viwer;


import com.auto1.puzzel.domain.PlayeZone;
import com.auto1.puzzel.domain.Player;
import com.auto1.puzzel.domain.RealmCell;
import com.auto1.puzzel.domain.RealmCellType;

public class CLGameViewBuilder {
	private PlayeZone playeZone;
	private Player player;
	
	public static final String ROW_HEADER = "|";
	public static final String COLUMN_HEADER = "-";

	public CLGameViewBuilder(PlayeZone playZone, Player player) {
		this.playeZone = playZone;
		this.player = player;
	}

	public String viewMap() {
		StringBuilder mapBuilder = new StringBuilder();
		RealmCell[][] map = playeZone.getYardMap();
		appendTailHeader(mapBuilder, map[0].length);

		for (int y = 0; y < map.length; y++) {
			appendRowsHeader(mapBuilder, ROW_HEADER);
			for (int x = 0; x < map[y].length; x++) {
				String grideLetter = getCellGridLetter(map[x][y]);
				mapBuilder.append(grideLetter);
			}
			appendRowsHeader(mapBuilder, ROW_HEADER);
			mapBuilder.append("\n");
		}
		appendTailHeader(mapBuilder, map[0].length);
		return mapBuilder.toString();

	}

	private String getCellGridLetter(RealmCell cell) {
		String result;
		if (player.getCoordinates().equals(cell.getCoordinates())) {
			if (cell.getFighter() != null && cell.getFighter().isLive()
					&& player.getCoordinates().equals(cell.getCoordinates())) {
				result = RealmCellType.FIGHTING.getGridLetter();
			} else {
				result = RealmCellType.PLAYER.getGridLetter();
			}
		} else {
			result = cell.getType().getGridLetter();
		}
		return result;
	}

	private void appendTailHeader(StringBuilder sb, int colsNumber) {
		sb.append(" ");
		for (int i = 0; i < colsNumber; i++) {
			sb.append(COLUMN_HEADER);
		}
		sb.append("\n");
	}


	private void appendRowsHeader(StringBuilder sb, String y) {
		sb.append(y);
	}

	

	
}

package com.auto1.puzzel.rules;

import com.auto1.puzzel.configration.PlayerConfiguration;
import com.auto1.puzzel.exception.GameBussinesException;
import com.auto1.puzzel.io.utility.NumbersUtilis;
import com.auto1.puzzel.io.utility.StringUtilis;

public class GameRulesValidator {

	public static boolean isValidPlayerConfiguration(PlayerConfiguration playerConfiguration)
			throws GameBussinesException {
		StringBuilder validationMsg = new StringBuilder();
		boolean valid = true;
		if (StringUtilis.isEmptyString(playerConfiguration.getName())) {
			valid = false;
			validationMsg.append("Player Name Can't be Empty");
		}
		if (NumbersUtilis.isNotWithinRangeInclusive(playerConfiguration.getHealthPoints(), GameRules.MIN_HEALTH_POINTS,
				GameRules.MAX_HEALTH_POINTS)) {
			valid = false;
			validationMsg.append(
					"health points must between" + GameRules.MIN_HEALTH_POINTS + "and " + GameRules.MAX_HEALTH_POINTS);
		}
		if (NumbersUtilis.isNotWithinRangeInclusive(playerConfiguration.getFightingPower(), GameRules.MIN_HEALTH_POINTS,
				GameRules.MAX_HEALTH_POINTS)) {
			valid = false;
			validationMsg.append("fighting power must between" + GameRules.MIN_FIGHTING_POWER + "and "
					+ GameRules.MAX_FIGHTING_POWER);
		}
		if (!valid) {
			throw new GameBussinesException(validationMsg.toString());
		}
		return valid;
	}
}

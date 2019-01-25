package com.auto1.puzzel.menu;

import com.auto1.puzzel.domain.NonPlayerCharacter;

public interface PlayingMenu extends BaseOneOptionMenu<PlayingMenuOptions> {
	public void showEnemyInfo(NonPlayerCharacter enemy);
}

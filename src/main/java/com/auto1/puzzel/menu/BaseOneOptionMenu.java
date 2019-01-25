package com.auto1.puzzel.menu;

public interface BaseOneOptionMenu<MenuType> {
	void showMessage(String message);

    void printAllOptionsWithHeader(String message);

    void printAllOptions();

    MenuType selectOption();

    MenuType showMenuToSelect();
}

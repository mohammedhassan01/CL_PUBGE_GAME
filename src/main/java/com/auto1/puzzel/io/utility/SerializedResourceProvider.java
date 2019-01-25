package com.auto1.puzzel.io.utility;

import java.io.IOException;

public interface SerializedResourceProvider <T> {
	public void Save()throws IOException;
	public T Load() throws IOException;
}

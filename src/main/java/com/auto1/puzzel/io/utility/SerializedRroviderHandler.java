package com.auto1.puzzel.io.utility;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.auto1.puzzel.exception.GameIOException;

public abstract class SerializedRroviderHandler<T> implements SerializedResourceProvider<T> {
	public SerializedRroviderHandler() {
		
	}

	@Override
	public void Save() throws GameIOException {
		try {
			ObjectOutputStream objectOutputStream = IOUtilis.objectOutputStream(getFileName());
			objectOutputStream.writeObject(getResource());
		}
		catch (Exception e) {
			throw new GameIOException("Save resource faild");
		}
	}
	
	protected abstract String getFileName();
	protected abstract T getResource();

	@Override
	public T Load() throws GameIOException {
		try {
			ObjectInputStream objectInputStream = IOUtilis.objectInputStream(getFileName());
			T resouce = (T) objectInputStream.readObject();
			return resouce;
		}catch (Exception e) {
			throw new GameIOException("Load Status with Name " + getFileName() + " faild");
		}
	}

}

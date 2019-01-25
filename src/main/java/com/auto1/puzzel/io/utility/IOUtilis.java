package com.auto1.puzzel.io.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

public class IOUtilis {

	private static final String RESOURCES_PATH = "src/main/resources/";

	private IOUtilis() {
	}

	public static ObjectOutputStream objectOutputStream( String filename) throws IOException {
		File file = createFileIfDoesNotExist(absolutePath(filename));
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		return new ObjectOutputStream(fileOutputStream);
	}

	public static ObjectInputStream objectInputStream(String filename) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(absolutePath(filename));
		return new ObjectInputStream(fileInputStream);
	}


	protected static String absolutePath( String pathToFile) {
		return Paths.get(RESOURCES_PATH, pathToFile).toAbsolutePath().toString();
	}

	private static File createFileIfDoesNotExist(String absolutePath) throws IOException {
		File file = new File(absolutePath);
		if (file.exists()) {
			return file;
		}

		file.getParentFile().mkdirs();
		file.createNewFile();
		return file;
	}
}

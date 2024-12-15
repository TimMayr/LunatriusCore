package com.github.lunatrius.core.util;

import com.github.lunatrius.core.reference.Reference;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	// http://stackoverflow.com/a/3758880/1166946
	public static String humanReadableByteCount(long bytes) {
		int unit = 1024;
		if (bytes < unit) {
			return bytes + " B";
		}

		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = "KMGTPE".charAt(exp - 1) + "i";

		return String.format("%3.0f %sB", bytes / Math.pow(unit, exp), pre);
	}

	public static boolean contains(File root, String filename) {
		return contains(root, new File(root, filename));
	}

	// http://stackoverflow.com/q/18227634/1166946
	public static boolean contains(File root, File file) {
		try {
			return file.getCanonicalPath().startsWith(root.getCanonicalPath() + File.separator);
		} catch (IOException e) {
			Reference.logger.error("", e);
		}

		return false;
	}
}
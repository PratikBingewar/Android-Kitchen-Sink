package dev.learn.phoenix.app.androidkitchensink.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sudhar on 8/2/17.
 */

public class Metadata {
	private static Map<String, Map<String, Class>> metadataMap;

	public static void init() {
		metadataMap = new LinkedHashMap<String, Map<String, Class>>();
	}

	public static Map<String, Class> getSection(String key) {

	}

	private void loadMap() {
		
	}
}

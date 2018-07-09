package common.resources;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceLoader {

	public Path getResource(String relativeToClassesFolder) {
		try {
			return Paths.get(getClass().getClassLoader()
					.getResource(relativeToClassesFolder).toURI());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

// This class exists because of the kotlin dsl not being able to find anything outside of the default package in the plugins block.
import org.gradle.api.Project;
import org.gradle.api.artifacts.Dependency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class E {
    public static final Properties p;
    static {
        System.out.println("Loading");
        Project project = null;
        Properties properties = new Properties();
        try {
            Path path = Path.of(System.getProperty("rootDir")).resolve("gradle.properties");
            properties.load(Files.newInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p = properties;
    }
}

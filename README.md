This project is a template for "stand alone" tests that need to be packed into a `jar` and also that need to be run using `mvn test`

Main characteristics:
1. Test is developed under `test` module
2. Source and resource are defined using the `build-helper-maven-plugin`:
```xml
  <plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>build-helper-maven-plugin</artifactId>
    <version>3.3.0</version>
    <executions>

        <execution>
            <id>add-sources</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>add-source</goal>
            </goals>
            <configuration>
                <sources>
                    <source>src/test/java</source>
                </sources>
            </configuration>
        </execution>

        <execution>
            <id>add-resource</id>
            <phase>generate-resources</phase>
            <goals>
                <goal>add-resource</goal>
            </goals>
            <configuration>
                <resources>
                    <resource>
                        <directory>src/test/resources</directory>
                    </resource>
                </resources>
            </configuration>
        </execution>

    </executions>
</plugin> 
```
3. `maven-assembly-plugin` is added to pom to specify main class and to include dependencies in jar:
```xml
<plugin>
    <artifactId>maven-assembly-plugin</artifactId>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <archive>
            <manifest>
                <addClasspath>true</addClasspath>
                <mainClass>run.TestMainRunner</mainClass>
            </manifest>
        </archive>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
    </configuration>
</plugin> 
```
4. Finally, to be able to run directly from the IDE, make sure the resources directory is specified:
```xml
<build>
    <!-- Required to execute from IDE when running feature directly -->
    <resources>
        <resource>
            <directory>src/test/resources</directory>
        </resource>
    </resources>
</build>
```
5. To generate jar, run from terminal:
```shell
mvn clean compile assembly:single
```
`jar` file is output to `target` folder

5. And also `mvn test` can be executed

Note: When executing `mvn test`, `classes` and `test-classes` are generated with same content. That might cause throwing some warning during execution, probably nothing to worry (its the downside of this approach) 
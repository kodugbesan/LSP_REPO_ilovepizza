Prompt: how do I set up JUnit in my project so I can run JUnit 5 tests in VS Code? I only saw tutorials for maven,gradle and eclipse

Response:
Since you're not using Maven, Gradle, or Eclipse project setup tools, JUnit is not automatically included in your project. You need to manually add it.

First, download the JUnit Platform Console Standalone JAR from the official Maven repository website:
https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone

Then follow these steps:

1. Select a stable version 
2. Download the standalone JAR file.
3. Create a folder called lib in the root of your project 
4. Place the downloaded JAR file inside the lib folder.
5. Open VS Code and press Ctrl + Shift + P.
6. Run "Java: Configure Classpath".
7. Add the JAR file from the lib folder as an external library.
8. Restart VS Code if needed so the Java language server recognizes it.

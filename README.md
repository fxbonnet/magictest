A simple example on how to artificially increase your code coverage with a stupid unit test that calls automatically constructors and getters/setters.

Do not use in the real life! Except from increasing the code coverage statistics, it is totally useless.

Try it:

   * copy MagicTest class to your project's /src/test/java/ folder
   * add a test dependency to [guava](http://search.maven.org/#artifactdetails%7Ccom.google.guava%7Cguava%7C18.0%7Cbundle)
   * add [cobertura-maven-plugin](http://search.maven.org/#artifactdetails%7Corg.codehaus.mojo%7Ccobertura-maven-plugin%7C2.7%7Cmaven-plugin) to the project
   * mvn cobertura:cobertura
   * have a look a the result at /target/site/cobertura/index.html

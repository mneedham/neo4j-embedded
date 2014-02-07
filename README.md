# Build the JAR

    mvn clean compile assembly:single

# Launch neo4j server

    java -cp target/embedded-1.0-jar-with-dependencies.jar GraphConnect
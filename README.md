# Build the JAR

    mvn clean compile assembly:single

# Launch neo4j server

    java -cp target/embedded-1.0-jar-with-dependencies.jar GraphConnect

    Feb 07, 2014 3:45:25 PM org.neo4j.server.logging.Logger log
    ...
    15:45:27.530 [main] INFO  o.e.j.server.handler.ContextHandler - Started o.e.j.s.ServletContextHandler@2b40b499{/,null,AVAILABLE}
    15:45:27.539 [main] INFO  o.e.jetty.server.ServerConnector - Started ServerConnector@1ed5eb39{HTTP/1.1}{localhost:7474}
    Feb 07, 2014 3:45:27 PM org.neo4j.server.logging.Logger log
    INFO: Remote interface ready and available at [http://localhost:7474/]    
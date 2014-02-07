import org.neo4j.graphdb.*;
import org.neo4j.server.CommunityNeoServer;
import org.neo4j.server.helpers.CommunityServerBuilder;

import java.io.IOException;

public class GraphConnect {
    private static final String GRAPH_DB_PATH="C:/Development/Programs/neo4j-community-2.0.0-RC1";

    GraphDatabaseService graphDb;
    Node myFirstNode;
    Node mySecondNode;
    Relationship relationship;

    public static void main(final String args[]) throws IOException {
        final GraphConnect myGraphConnect = new GraphConnect();
        myGraphConnect.createDb();

        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
//                myGraphConnect.removeData();
                myGraphConnect.shutDown();
            }
        } );
    }

    private void createDb() throws IOException {
        CommunityNeoServer server = CommunityServerBuilder.server().usingDatabaseDir(GRAPH_DB_PATH).build();
        server.start();
        graphDb = server.getDatabase().getGraph();

    }

    public enum RelationshipTypes implements RelationshipType {
        KNOWS
    }

    private void shutDown() {
        graphDb.shutdown();
        System.out.println("graph db is shut down");

    }


    private void removeData() {
        final Transaction transaction = graphDb.beginTx();
        try{

            myFirstNode.getSingleRelationship(RelationshipTypes.KNOWS, Direction.OUTGOING).delete();
            System.out.println("Removing nodes");
            myFirstNode.delete();
            mySecondNode.delete();
            transaction.success();
        }
        finally{
            transaction.finish();
        }
    }
}

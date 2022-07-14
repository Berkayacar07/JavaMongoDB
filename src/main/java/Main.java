import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create
                ("mongodb+srv://berkayacar07:190307@cluster0.ckosjqr.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("sampleDB");
        MongoCollection col = db.getCollection("sampleCollection");

//        MongoCursor<String> dbsCursor = client.listDatabaseNames().iterator();
//        while (dbsCursor.hasNext()){
//            System.out.println(dbsCursor.next());
//        }
        List<Integer> books = Arrays.asList(27464, 747854);
        Document person = new Document("_id", "2")
                .append("name","Berkay" )
                .append("address", new BasicDBObject("street", "Ulusoy St.")
                        .append("city", "Antalya")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", books);
        col.insertOne(person);
    }
}

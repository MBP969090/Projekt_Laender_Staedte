import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 * Created by bf on 10.11.17.
 * sudo mongod -> starten der DB
 * mongo -> starten der Shell
 */



public class MongoDB_Databasemanagement implements IDatarepository {
  MongoClient mongo;
  MongoDatabase database;
  MongoCollection<Document> country_collection;
  MongoCollection<Document> city_collection;
  MongoCollection<Document> counters_collection;
  BasicDBObject whereQuery = new BasicDBObject();

  public MongoDB_Databasemanagement() {
    connect_to_database();
    select_cities();
  }

  private void connect_to_database(){
    try {
      this.mongo = new MongoClient( "localhost" , 27017 );
      this.database = mongo.getDatabase("countries_cities");
      this.country_collection = database.getCollection("country");
      this.city_collection = database.getCollection("city");
      this.counters_collection = database.getCollection("counters");
    } catch (MongoException mongoe){
      mongoe.printStackTrace();
    }
  }

  @Override
  public ArrayList<City> select_cities() {
    ArrayList<City> cities = new ArrayList<City>();
    MongoCursor<Document> cursor = this.city_collection.find().iterator();
    try {
      while (cursor.hasNext()) {
        Document singleBson = cursor.next();
        int city_id = singleBson.getInteger("_id_city");
        String city_name = singleBson.getString("city_name");
        int country_id = singleBson.getInteger("_id_country");
        cities.add(new City(city_id, city_name, country_id));
      }
    } finally {
      cursor.close();
    }
    return cities;
  }

  @Override
  public ArrayList<Country> select_countries() {
    ArrayList<Country> countries = new ArrayList<Country>();
    MongoCursor<Document> cursor = this.country_collection.find().iterator();
    try {
      while (cursor.hasNext()) {
        Document singleBson = cursor.next();
        int country_id = singleBson.getInteger("_id_country");
        String coumtry_name = singleBson.getString("country_name");
        countries.add(new Country(country_id, coumtry_name));
      }
    } finally {
      cursor.close();
    }
    return countries;
  }

  @Override
  public City select_city(int city_id) {
    try {
      this.whereQuery.put("_id_city", city_id);
      Document singleBson = this.city_collection.find(this.whereQuery).first();
      String city_name = singleBson.getString("city_name");
      int country_id = singleBson.getInteger("_id_country");
      return new City(city_id, city_name, country_id);
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
    return null;
  }

  @Override
  public Country select_country(int country_id) {
    try {
      this.whereQuery.put("_id_country", country_id);
      Document singleBson = this.country_collection.find(this.whereQuery).first();
      String country_name = singleBson.getString("country_name");
      return new Country(country_id, country_name);
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
    return null;
  }

  @Override
  public void insert_city(String city_name, int country_id) {
    try{
      int city_id = select_city_counter();
      update_city_counter(city_id);
      Document singleBson = new Document("_id_city", city_id)
          .append("city_name", city_name)
          .append("_id_country", country_id);
      city_collection.insertOne(singleBson);
    } catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }

  @Override
  public void insert_country(String country_name) {
    try{
      int country_id = select_country_counter();
      update_country_counter(country_id);
      Document singleBson = new Document("_id_country", country_id)
          .append("country_name", country_name);
      country_collection.insertOne(singleBson);
    } catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }

  @Override
  public void update_city(String city_name, int city_id) {
    try {
      this.whereQuery.put("_id_city", city_id);
      BasicDBObject singleBson = new BasicDBObject();
      singleBson.append("$set", new BasicDBObject().append("city_name", city_name));
      this.country_collection.updateOne(this.whereQuery, singleBson);
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }

  @Override
  public void update_country(String country_name, int country_id) {
    try {
      this.whereQuery.put("_id_country", country_id);
      BasicDBObject singleBson = new BasicDBObject();
      singleBson.append("$set", new BasicDBObject().append("country_name", country_name));
      this.country_collection.updateOne(this.whereQuery, singleBson);
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }

  @Override
  public void delete_city(int city_id) {
    try {
      this.whereQuery.put("_id_city", city_id);
      this.city_collection.deleteOne(this.whereQuery);
    } catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }

  @Override
  public void delete_country(int country_id) {
    try {
      this.whereQuery.put("_id_country", country_id);
      this.city_collection.deleteOne(this.whereQuery);
    } catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }

  public int select_city_counter(){
    try {
      this.whereQuery.put("_id", "city_id");
      Document singleBson = this.counters_collection.find(this.whereQuery).first();
      int city_id = singleBson.getInteger("seq") + 1;
      return city_id;
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
    return -1;
  }

  public int select_country_counter(){
    try {
      this.whereQuery.put("_id", "country_id");
      Document singleBson = this.counters_collection.find(this.whereQuery).first();
      int country_id = singleBson.getInteger("seq") + 1;
      return country_id;
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
    return -1;
  }

  public void update_city_counter(int city_id){
    try {
      this.whereQuery.put("_id", "city_id");
      BasicDBObject singleBson = new BasicDBObject();
      singleBson.append("$set", new BasicDBObject().append("seq", city_id));
      this.counters_collection.updateOne(this.whereQuery, singleBson);
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }

  public void update_country_counter(int country_id){
    try {
      this.whereQuery.put("_id", "country_id");
      BasicDBObject singleBson = new BasicDBObject();
      singleBson.append("$set", new BasicDBObject().append("seq", country_id));
      this.counters_collection.updateOne(this.whereQuery, singleBson);
    }catch (MongoException mongoe) {
      mongoe.printStackTrace();
    }
  }
}

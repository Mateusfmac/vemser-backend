import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {
    
    public static void main(String[] args) {
        
        String uri = "mongodb+srv://USER:****@cluster0.pz6cy.mongodb.net/test";
        MongoClient mongoClient = MongoClients.create(uri);
        
        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemser-dbc");
        
        MongoCollection<Document> funcionario = mongoDatabase.getCollection("funcionario");
        
        
        // Novo aluno
        Document novoFuncinario1 = new Document("nome", "Mateus")
                .append("id_usuario", 1)
                .append("matricula", "0001")
                .append("salario", 12000)
                .append("comissao", 0);
        
        Document novoFuncinario2 = new Document("nome", "Julia")
                .append("id_usuario", 2)
                .append("matricula", "0002")
                .append("salario", 10000)
                .append("comissao", 0);
        
        Document novoFuncinario3 = new Document("nome", "Vanessa")
                .append("id_usuario", 3)
                .append("matricula", "0003")
                .append("salario", 8000)
                .append("comissao", 0);
        
        Document novoFuncinario4 = new Document("nome", "Willian")
                .append("id_usuario", 4)
                .append("matricula", "0004")
                .append("salario", 12500)
                .append("comissao", 0);
        
        
        //insert
        funcionario.insertOne(novoFuncinario1);
        funcionario.insertOne(novoFuncinario2);
        funcionario.insertMany(List.of(novoFuncinario3, novoFuncinario4));
        
        //find
        System.out.println(funcionario.find(new Document("nome", "Mateus")).first());
        funcionario.find().sort(Sorts.ascending("salario")).iterator().forEachRemaining(System.out::println);
        
        //update
        funcionario.updateOne(Filters.eq("nome", "Mateus"), new Document("$set", new Document("salario", 25000)));
        funcionario.updateOne(Filters.eq("nome", "Julia"), new Document("$set", new Document("comissao", 100)));
        
        //delete
        funcionario.deleteOne(Filters.eq("nome", "Willian"));
        funcionario.deleteOne(Filters.eq("matricula", "0003"));
    
        
        funcionario.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$salario", Accumulators.sum("salarios", 1))))
                        .iterator().forEachRemaining(System.out::println);
    
        funcionario.aggregate(
                Arrays.asList(
                        match(Filters.eq("nome", "Mateus")),
                        group("$nome", Accumulators.sum("nome", "$nome"))
                )).iterator().forEachRemaining(System.out::println);
        
        //projections
        funcionario.find()
                .projection(Projections.exclude("_id", "id_usuario", "matricula", "salario"))
                .iterator()
                .forEachRemaining(System.out::println);
    
        funcionario.find()
                .projection(Projections.exclude( "id_usuario", "salario", "comissao"))
                .iterator()
                .forEachRemaining(System.out::println);
    
    
    
        // Agrega dados
       /* System.out.println("-- Cursos");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$curso.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));
        
        System.out.println("-- Orders");
        orders.aggregate(
                Arrays.asList(
                        match(Filters.eq("status", "urgent")),
                        group("$productName", Accumulators.sum("sumQuantity", "$quantity"))
                )).forEach(doc -> System.out.println(doc.toJson()));
        
        System.out.println("-- Orders sem Cadeira");
        orders.aggregate(
                Arrays.asList(
                        match(new Document("status", "urgent")
                                .append("productName", new Document("$nin", Arrays.asList("Cadeira")))),
                        group("$productName", Accumulators.sum("sumQuantity", "$quantity"))
                )).forEach(doc -> System.out.println(doc.toJson()));*/
        
        mongoClient.close();
    }
}

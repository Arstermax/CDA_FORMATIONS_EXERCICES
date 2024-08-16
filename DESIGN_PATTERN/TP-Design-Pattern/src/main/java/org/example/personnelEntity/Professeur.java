package org.example.personnelEntity;

import org.example.entity.Document;

import java.util.ArrayList;
import java.util.List;


public class Professeur extends Personne {

    private String matiere;
    private static List<Document> listDocument = new ArrayList<>();

    public void addDocument(Document document){
        try{
            listDocument.add(document);
        }catch (Exception e){
            throw new Error(e);
        }
    }

    public  void removeDocument(int documentId){
        listDocument.remove(documentId);
    }

}

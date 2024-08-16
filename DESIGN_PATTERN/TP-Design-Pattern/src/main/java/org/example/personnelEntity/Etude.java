package org.example.personnelEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.DocumentListener;
import org.example.entity.Document;

import java.util.ArrayList;
import java.util.List;


@Data
public class Etude implements DocumentListener {

    private static List<Professeur> listProfesseur = new ArrayList<>();


    @Override
    public void onDocumentCreated(Document document) {

    }

    @Override
    public void onDocumentModified(Document document) {

    }
}

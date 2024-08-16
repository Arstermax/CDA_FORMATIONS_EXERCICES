package org.example.personnelEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.DocumentListener;
import org.example.entity.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personne implements DocumentListener {
    public String name;

    @Override
    public void onDocumentCreated(Document document) {
    }

    @Override
    public void onDocumentModified(Document document) {
    }
}

package org.example.factory;

import org.example.entity.Document;
import org.example.entity.DocumentEventManager;
import org.example.entity.implementation.AbstractDocumentBuilder;

public class DocumentFactory<T extends Document>
{
	public T createDocument(AbstractDocumentBuilder<T> builder)
	{
		T document = builder.build();
		DocumentEventManager.onDocumentCreated(document);
		return document;
	}
}

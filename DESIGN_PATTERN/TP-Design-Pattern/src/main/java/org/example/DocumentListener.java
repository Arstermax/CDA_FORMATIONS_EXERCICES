package org.example;

import org.example.entity.Document;

public interface DocumentListener
{
	void onDocumentCreated(Document document);

	void onDocumentModified(Document document);
}

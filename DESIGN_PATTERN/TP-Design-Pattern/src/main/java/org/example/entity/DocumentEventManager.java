package org.example.entity;

import org.example.DocumentListener;

import java.util.ArrayList;
import java.util.List;

public class DocumentEventManager
{
	private static final List<DocumentListener> listeners = new ArrayList<>();

	private DocumentEventManager()
	{
	}

	public static void addListener(DocumentListener listener)
	{
		listeners.add(listener);
	}

	public static void removeListener(DocumentListener listener)
	{
		listeners.remove(listener);
	}

	public static void onDocumentCreated(Document document)
	{
		for (DocumentListener listener : listeners)
		{
			listener.onDocumentCreated(document);
		}
	}
}

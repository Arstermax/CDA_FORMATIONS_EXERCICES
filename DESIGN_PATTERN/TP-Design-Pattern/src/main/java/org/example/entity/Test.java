package org.example.entity;

import org.example.DocumentListener;

public class Test implements DocumentListener
{
	@Override
	public void onDocumentCreated(Document document)
	{
		System.out.println(document + " created");
	}

	@Override
	public void onDocumentModified(Document document)
	{

	}
}

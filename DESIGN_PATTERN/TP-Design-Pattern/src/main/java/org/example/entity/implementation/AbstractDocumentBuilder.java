package org.example.entity.implementation;

import org.example.entity.Document;
import org.example.entity.Subject;

public abstract class AbstractDocumentBuilder<T extends Document>
{
	String title;
	String description;

	Subject subject;

	int sizeOctet;

	public AbstractDocumentBuilder<T> title(String title)
	{
		this.title = title;
		return this;
	}

	public AbstractDocumentBuilder<T> description(String description)
	{
		this.description = description;
		return this;
	}

	public AbstractDocumentBuilder<T> subject(Subject subject)
	{
		this.subject = subject;
		return this;
	}

	public AbstractDocumentBuilder<T> sizeOctet(int sizeOctet)
	{
		this.sizeOctet = sizeOctet;
		return this;
	}

	public abstract T build();
}

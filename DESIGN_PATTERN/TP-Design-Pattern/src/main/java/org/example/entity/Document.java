package org.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Document
{
	protected String title;
	protected String description;

	protected Subject subject;

	protected int sizeOctet;

	protected abstract void read();
}

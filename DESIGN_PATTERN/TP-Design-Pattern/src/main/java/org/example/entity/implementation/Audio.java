package org.example.entity.implementation;

import org.example.entity.Multimedia;

public class Audio extends Multimedia
{
	private Audio(AudioBuilder builder)
	{
		this.title = builder.title;
		this.description = builder.description;
		this.subject = builder.subject;
		this.sizeOctet = builder.sizeOctet;
	}

	@Override
	public void read()
	{
		System.out.println("Playing Audio");
	}

	public static class AudioBuilder extends AbstractDocumentBuilder<Audio>
	{
		@Override
		public Audio build()
		{
			return new Audio(this);
		}
	}
}

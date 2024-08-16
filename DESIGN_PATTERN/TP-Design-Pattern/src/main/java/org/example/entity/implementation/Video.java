package org.example.entity.implementation;

import org.example.entity.Multimedia;

public class Video extends Multimedia
{
	private Video(VideoBuilder builder)
	{
		this.title = builder.title;
		this.description = builder.description;
		this.subject = builder.subject;
		this.sizeOctet = builder.sizeOctet;
	}

	@Override
	public void read()
	{
		System.out.println("Playing Video");
	}

	public static class VideoBuilder extends AbstractDocumentBuilder<Video>
	{
		@Override
		public Video build()
		{
			return new Video(this);
		}
	}
}

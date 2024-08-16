package org.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Multimedia extends Document
{
	protected String format;
	protected int durationSecond;
}

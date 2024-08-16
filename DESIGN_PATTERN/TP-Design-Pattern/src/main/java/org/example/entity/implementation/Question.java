package org.example.entity.implementation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Question
{
	String question;
	List<String> answers;

	private Question(QuestionBuilder builder)
	{
		this.question = builder.question;
		this.answers = builder.answers;
	}

	public static class QuestionBuilder
	{
		String question;
		List<String> answers = new ArrayList<>();

		public QuestionBuilder question(String question)
		{
			this.question = question;
			return this;
		}

		public QuestionBuilder answer(String answer)
		{
			this.answers.add(answer);
			return this;
		}

		public Question build()
		{
			return new Question(this);
		}
	}
}

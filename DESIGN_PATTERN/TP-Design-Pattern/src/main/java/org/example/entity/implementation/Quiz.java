package org.example.entity.implementation;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Quiz extends Document
{
	List<Question> questionList = new ArrayList<>();

	private Quiz(QuizBuilder builder)
	{
		this.title = builder.title;
		this.description = builder.description;
		this.subject = builder.subject;
		this.sizeOctet = builder.sizeOctet;
		this.questionList = builder.questionList;
	}

	@Override
	public void read()
	{
		for (Question question : questionList)
		{
			System.out.println(question.question);

			for (String answer : question.answers)
			{
				System.out.println(answer);
			}
		}
	}

	public static class QuizBuilder extends AbstractDocumentBuilder<Quiz>
	{
		List<Question> questionList = new ArrayList<>();

		public QuizBuilder question(Question question)
		{
			questionList.add(question);
			return this;
		}

		@Override
		public Quiz build()
		{
			return new Quiz(this);
		}
	}
}

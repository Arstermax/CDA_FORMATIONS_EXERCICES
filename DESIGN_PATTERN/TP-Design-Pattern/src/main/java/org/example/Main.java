package org.example;

import org.example.entity.DocumentEventManager;
import org.example.entity.Subject;
import org.example.entity.Test;
import org.example.entity.implementation.Audio;
import org.example.entity.implementation.Question;
import org.example.entity.implementation.Quiz;
import org.example.entity.implementation.Video;
import org.example.factory.DocumentFactory;

public class Main
{
	public static void main(String[] args)
	{
		Test test = new Test();
		DocumentEventManager.addListener(test);

		Quiz quiz1 = new DocumentFactory<Quiz>().createDocument(new Quiz.QuizBuilder()
				.question(new Question.QuestionBuilder()
						.question("What is 1 + 1?")
						.answer("1")
						.answer("2")
						.answer("3")
						.answer("4")
						.build())
				.title("Quiz 1")
				.description("Quiz 1 description")
				.subject(Subject.MATH)
				.sizeOctet(100));

		quiz1.read();

		Video video1 = new DocumentFactory<Video>().createDocument(new Video.VideoBuilder()
				.title("Video 1")
				.description("Video 1 description")
				.subject(Subject.ENGLISH)
				.sizeOctet(200));

		video1.read();

		Audio audio1 = new DocumentFactory<Audio>().createDocument(new Audio.AudioBuilder()
				.title("Audio 1")
				.description("Audio 1 description")
				.subject(Subject.HISTORY)
				.sizeOctet(300));

		audio1.read();

	}
}

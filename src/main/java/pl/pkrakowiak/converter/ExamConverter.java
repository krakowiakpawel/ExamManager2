package pl.pkrakowiak.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.pkrakowiak.entity.Exam;
import pl.pkrakowiak.repo.ExamRepo;

public class ExamConverter implements Converter<String, Exam> {
	@Autowired
	ExamRepo examRepo;

	@Override
	public Exam convert(String source) {
		Exam exam = examRepo.findById(Integer.parseInt(source));
		return exam;
	}

}

package pl.pkrakowiak.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pkrakowiak.entity.Exam;

public interface ExamRepo extends JpaRepository<Exam, Integer> {

	public Exam findById(int id);
}

package pl.pkrakowiak.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pkrakowiak.entity.ComMember;

public interface ComMemberRepo extends JpaRepository<ComMember, Integer> {

	public ComMember findById(int id);
}

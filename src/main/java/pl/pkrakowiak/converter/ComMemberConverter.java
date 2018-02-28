package pl.pkrakowiak.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.pkrakowiak.entity.ComMember;
import pl.pkrakowiak.repo.ComMemberRepo;

public class ComMemberConverter implements Converter<String, ComMember> {
	@Autowired
	ComMemberRepo comMemberRepo;

	@Override
	public ComMember convert(String source) {
		ComMember comMember = comMemberRepo.findById(Integer.parseInt(source));
		return comMember;
	}
}
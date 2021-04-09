package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.repositry.SubjectRepository;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Override
	public Subject addSubject(Subject s) {
		
		return subjectRepository.save(s);
	}

	@Override
	public Subject updateSubject(Subject s) {
		
		return subjectRepository.save(s);
	}

	@Override
	public void deleteSubject(int id) {
		subjectRepository.deleteById(id);
		
	}

	@Override
	public Optional<Subject> retrieveSubject(int id) {
		return subjectRepository.findById(id);
		
	}

	@Override
	public List<Subject> retrieveAllSubject() {
		List<Subject> subjects = (List<Subject>) subjectRepository.findAll();
		return subjects;
	}

	@Override
	public Optional<Subject> retrieveSubjectByName(String name) {
		Optional<Subject> subject = subjectRepository.findByName(name);
		return subject;
	}

}

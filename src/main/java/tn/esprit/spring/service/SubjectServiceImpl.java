package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.repositry.SubjectRepository;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	private static final Logger Log = LogManager.getLogger(SubjectServiceImpl.class);
	
	
	@Override
	public Subject addSubject(Subject s) {
		Log.info("adding subject{}",s.getName_Subject());
		if(subjectRepository.existsBySubjectName(s.getName_Subject())) {
			Log.warn("subject {} already exists.",s.getName_Subject());
			throw new UsernameAlreadyExistsException(
					String.format("subject %s already exists", s.getName_Subject()));
		}
		
		return subjectRepository.save(s);
	}

	@Override
	public Subject updateSubject(Subject s,int id) {
		Log.info("updating subject {}",s.getName_Subject());
		Subject s1 = subjectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("this subject doesn't exist"));
		s1.setDesc_Subject(s.getDesc_Subject());
		s1.setName_Subject(s.getName_Subject());
		s1.setTheme_Subject(s.getTheme_Subject());
		return subjectRepository.save(s1);
	}

	@Override
	public void deleteSubject(int id) {
		Log.info("deleting subject by id {}", id);
		subjectRepository.deleteById(id);
		
	}

	@Override
	public Optional<Subject> retrieveSubject(int id) {
		Log.info("retrieving subject by id {}", id);
		return subjectRepository.findById(id);
		
	}

	@Override
	public List<Subject> retrieveAllSubject() {
		Log.info("retriving all subjects");
		List<Subject> subjects = (List<Subject>) subjectRepository.findAll();
		return subjects;
	}

	@Override
	public Optional<Subject> retrieveSubjectByName(String name) {
		Log.info("retrieving subject by name {}", name);
		Optional<Subject> subject = subjectRepository.findByName(name);
		return subject;
	}

}

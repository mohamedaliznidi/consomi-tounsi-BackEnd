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
		Log.info("adding subject {}",s.getNamesubject());
		if(subjectRepository.existsByNamesubject(s.getNamesubject())) {
			Log.warn("subject {} already exists.",s.getNamesubject());
			throw new UsernameAlreadyExistsException(
					String.format("subject %s already exists", s.getNamesubject()));
		}
		
		
		return subjectRepository.save(s);
	}

	@Override
	public Subject updateSubject(Subject s,int id) {
		Log.info("updating subject {}",s.getNamesubject());
		Subject s1 = subjectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("this subject doesn't exist"));
		s1.setDescsubject(s.getDescsubject());
		s1.setNamesubject(s.getNamesubject());
		s1.setThemesubject(s.getThemesubject());
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
		Optional<Subject> subject = subjectRepository.findByNamesubject(name);
		return subject;
	}

}

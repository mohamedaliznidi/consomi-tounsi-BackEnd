package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Sheet;
import tn.esprit.spring.repositry.Sheetrepositry;

@Service
public class SheetService implements ISheetService{
	@Autowired
	public Sheetrepositry sht ;

	public Sheet save(Sheet Sheet) {
		return sht.save(Sheet);
	}
	
	public Sheet getSheetById(int id) {
		return sht.findById(id).orElse(null);
	}
	
	public String deleteSheet(int id) {
		sht.deleteById(id);
		return "Sheet removed!!"+id;
	}
	
	public List<Sheet> retrieveAllSheet(){
		List<Sheet> Sheet = (List<Sheet>) sht.findAll();

		return Sheet;
		
		}
	public Sheet updateSheet(Sheet Sheet) {
		Sheet existingsheet=sht.findById(Sheet.getId()).orElse(null);
		existingsheet.setStudent(Sheet.isStudent());
		existingsheet.setKids(Sheet.isKids());
		existingsheet.setOldPerson(Sheet.isOldPerson());
		existingsheet.setOldPHealthP(Sheet.isOldPHealthP());
		existingsheet.setKidsN(Sheet.getKidsN());
		existingsheet.setWorkCapacity(Sheet.isWorkCapacity());
		existingsheet.setOldPerson(Sheet.isOldPerson());
		existingsheet.setWorkCapacity(Sheet.isWorkCapacity());
		existingsheet.setMonoParent(Sheet.isMonoParent());
		existingsheet.setHandicap(Sheet.isHandicap());
		existingsheet.setPregnant(Sheet.isPregnant());
		existingsheet.setCategory1(Sheet.getCategory1());
		existingsheet.setCategory2(Sheet.getCategory2());
		existingsheet.setCategory3(Sheet.getCategory3());
		return sht.save(Sheet);
}
}

package tn.esprit.spring.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Sheet;
import tn.esprit.spring.service.SheetService;

@RestController
@RequestMapping("sheet")
public class Sheetcontroller {
	@Autowired
	private SheetService service;
	/*@Autowired
	private iSheetService service1;*/
	
	
	@PostMapping("/addsheet")
	public Sheet addsheet(@RequestBody Sheet sheet) {
		return service.save(sheet);
	}
	
	@GetMapping("/sheet/{id}")
	public Sheet findById(@PathVariable int id) {
		return service.getSheetById(id);
	}
	
	@PutMapping("/update")
	public Sheet updateSheet(@RequestBody Sheet sheet) {
		return service.updateSheet(sheet);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSheet(@PathVariable int id) {
		return service.deleteSheet(id);
	}
	@GetMapping("/sheets")
	public Iterable<Sheet> getAll(){
		return service.retrieveAllSheet();
	}
}

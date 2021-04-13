package tn.esprit.spring.controler;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Ray;
import tn.esprit.spring.exception.RayNotFoundException;
import tn.esprit.spring.repositry.RayRepository;
import tn.esprit.spring.service.RayServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/rayon")
public class RayController {

	@Autowired
	tn.esprit.spring.service.RayServiceImpl RaySer;
	@Autowired
	tn.esprit.spring.repositry.RayRepository ray_rep;
	private byte[] bytes;
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	@PostMapping("/addRay")
	public Ray ADD(@RequestBody @Valid Ray ray) {
		ray.setRayonImg(this.bytes);
		RaySer.addRay(ray);
		this.bytes = null;
		return ray;
	}

	@GetMapping("/showRay")
	public List<Ray> Show() throws tn.esprit.spring.exception.RayNotFoundException 
	{ 
		return RaySer.showAll();
	}



	@DeleteMapping("/deleteRay/{ID}")
	public void DeleteById(@PathVariable("ID") Long RayId) {
		RaySer.DeleteById(RayId);
	}

	@DeleteMapping("/deleteAll")
	public void DeleteAll() {
		RaySer.DeleteAll();
	}
	@PutMapping("/updateRay")
	void update (@RequestBody Ray ray) {
		RaySer.updateRay(ray);
	}

	@GetMapping("/notif")
	public String notif(){
		List<Ray> ray = ray_rep.findAll();
		for (int i = 0; i < ray.size(); i++) {
			if (ray.get(i).getCapacity()<ray.get(i).getCapacity()/2) {
				return "vous devez remplir votre rayon"+ ray.get(i).getRayName();

			}
		}
		return "";
	}
	
	
	


}

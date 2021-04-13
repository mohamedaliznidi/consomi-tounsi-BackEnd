package projet.pi.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

import projet.pi.entity.Ray;
import projet.pi.exception.RayNotFoundException;
import projet.pi.repository.RayRepository;
import projet.pi.service.RayServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/rayon")
public class RayController {

	@Autowired
	RayServiceImpl RaySer;
	@Autowired
	RayRepository ray_rep;
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
	public List<Ray> Show() throws RayNotFoundException 
	{ 
		return RaySer.showAll();
	}

	/*@GetMapping("getAllRays")
		//public List<Ray> getAllRays ()
		//{ 
			//return RaySer.getAllRays();
		//}*/

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
			if (ray.get(i).getCapacity()<50) {
				return "vous devez remplir votre rayon "+ ray.get(i).getRayName();

			}
		}
		return "";
	}
	@GetMapping("/FindRayByCategory/{category}")
	public List<String> FindRayByCategory(@PathVariable("category") String Category) throws RayNotFoundException{
		return RaySer.findByCategory(Category);
	}
	@PutMapping("updateRayonCapacity")
	public String updateRayonCapacity(){
		RaySer.UpdateCapacity();
		return "rayon capacity updated";
	}
	
	


}

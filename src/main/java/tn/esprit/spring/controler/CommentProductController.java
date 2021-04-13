package tn.esprit.spring.controler;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.service.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("commentproduct")



//revoir delete comment

public class CommentProductController {
@Autowired
	
	private ICommentProductService commentproductservice;
@Autowired

private IProductService productservice;
	
	@PostMapping ("/addcomment/{idclient}/{idproduct}")
	public void add(@RequestBody CommentProduct p,@PathVariable ("idclient") int idclient , @PathVariable ("idproduct") int idproduct){
		Date date = new Date();

		CommentProduct comment = new CommentProduct(p.getRate(),p.getContent());
		CommentProductId id = new CommentProductId();
		id.setDate(date);
		id.setIdClient(idclient);
		id.setIdProduct(idproduct);
		comment.setCommentproductid(id);
		this.commentproductservice.addCommentProduct(comment);
		
	}
	
	@GetMapping("/comments")
	public Iterable<CommentProduct> getAll(){
		return this.commentproductservice.retrieveAllCommentProduct();
	}
	
	@DeleteMapping("/removecomment/{idclient}/{idproduct}/{date}")
	@ResponseBody
	public void removeProductCategory(@PathVariable ("idclient") int idclient , @PathVariable ("idproduct") int idproduct,@PathVariable ("date") Date date ) {
		commentproductservice.deleteCommentProduct(idclient,idproduct,date);
	}
	
	@GetMapping(value ="/findproductcomments/{idProduct}")
	@ResponseBody
	public List<CommentProduct> retrieveCommentProduct(@PathVariable("idProduct") int idProduct) {
		

	return  commentproductservice.RetrieveByProduct(idProduct);
	}
	
	

}

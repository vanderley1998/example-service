package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class RestserviceApplication {

	@Component
	class Estado {
		private Long id;
		private String nome;


		Estado (){}

		public Long getId(){
			return this.id;
		}

		public void setId(Long id){
			this.id = id;
		}

		public String getNome(){
			return this.nome;
		}

		public String setNome(String nome){
			return this.nome;
		}

	}

	@Component
	class Cidade {
		private Long id;
		private String nome;
		private Estado estado;

		Cidade (){}

		public Long getId(){
			return this.id;
		}

		public void setId(Long id){
			this.id = id;
		}

		public String getNome(){
			return this.nome;
		}

		public String setNome(String nome){
			return this.nome;
		}

		public Estado getEstado(){
			return this.estado;
		}

		public void setEstado(Estado estado){
			this.estado = estado;
		}

	}

	@Component
	class CidadeDAO {

		private List<Cidade> cidades = new ArrayList<>();

		public boolean create(Cidade cidade){
			return false;
		}

		public List<Cidade> cidades(){
			Estado e1 = new Estado();
			e1.setId(new Long(1));
			e1.setNome("Paraná");

			Cidade c1 = new Cidade();
			c1.setId(new Long(1));
			c1.setNome("Cornélio Procópio");
			c1.setEstado(e1);

			cidades.add(c1);

			return cidades;
		}

		public boolean update(Cidade cidade){
			return false;
		}

		public boolean delete(Cidade cidade){
			return false;
		}
	}

	@Controller
	class RestController{

		private CidadeDAO cidadeDAO;

		RestController(CidadeDAO cidadeDAO){
			this.cidadeDAO = cidadeDAO;
		}

		@PostMapping("/cidade")
		public Cidade create(@RequestBody Cidade cidade){
			return cidade;
		}

		@GetMapping("/cidade")
		public List<Cidade> cidades(){
			return cidadeDAO.cidades();
		}

		@PutMapping("/cidade")
		public Cidade update(@RequestBody Cidade cidade){
			return cidade;
		}

		@DeleteMapping("/cidade")
		public int delete(@PathVariable int id){
			return 200;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}
}

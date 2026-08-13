package br.com.mesquita;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mesquita.dao.ConsultaDao;
import br.com.mesquita.model.Consulta;

@Controller
@RequestMapping("/")
public class WebController {
	
	private final ConsultaDao consultaDao;

	public WebController(ConsultaDao consultaDao) {
		this.consultaDao = consultaDao;
	}
	
	@GetMapping
	public String batata(Model model) {
		List<Consulta> listaConsulta = consultaDao.listarConsulta();
		
		model.addAttribute("listaConsulta", listaConsulta);
		
		return "index";
	}
}

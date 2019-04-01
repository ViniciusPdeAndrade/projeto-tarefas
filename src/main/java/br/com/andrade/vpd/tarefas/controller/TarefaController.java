package br.com.andrade.vpd.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrade.vpd.tarefas.exception.RegistroNaoEncontradoException;
import br.com.andrade.vpd.tarefas.model.Tarefa;
import br.com.andrade.vpd.tarefas.service.TarefaService;
import br.com.andrade.vpd.tarefas.sistema.PageData;
import br.com.andrade.vpd.tarefas.sistema.ParametroData;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@PostMapping("/find")
	public PageData find(@RequestBody ParametroData entrada) throws RegistroNaoEncontradoException{
		PageData saida = new PageData();
		try {
			Tarefa tarefa = service.find(entrada.getId());
			saida.setEntidade(tarefa);
			saida.setErro(false);
		}catch(Exception e) {
			saida.setErro(true);
			saida.setMensagem(String.format("Não foi possivel recuperar a tarefa erro[%s]",e.getMessage()));
		}
		return saida;
	}
	
	@PostMapping("/save")
	public PageData save(@RequestBody ParametroData entrada) throws RegistroNaoEncontradoException{
		PageData saida = new PageData();
		try {
			Tarefa tarefa = entrada.getParametro("tarefa", Tarefa.class);
			service.save(tarefa);
			saida.setMensagem("Tarefa incluida com sucesso");
			saida.setErro(false);
		}catch(Exception e) {
			saida.setErro(true);
			saida.setMensagem(String.format("Não foi possivel incluir a tarefa erro[%s]", e.getMessage()));
		}
		return saida;
	}

	@PostMapping("/update")
	public PageData update(@RequestBody ParametroData entrada) throws RegistroNaoEncontradoException{
		PageData saida = new PageData();
		try {
			Tarefa tarefa = entrada.getParametro("tarefa", Tarefa.class);
			service.update(tarefa);
			saida.setMensagem("Tarefa alterada com sucesso");
			saida.setErro(false);
		}catch(Exception e) {
			saida.setErro(true);
			saida.setMensagem(String.format("Não foi possivel alterar a tarefa erro[%s]", e.getMessage()));
		}
		return saida;
	}

	
	@PostMapping("/delete")
	public PageData delete(@RequestBody ParametroData entrada) throws RegistroNaoEncontradoException{
		PageData saida = new PageData();
		try {
			Tarefa tarefa = service.find(entrada.getId());
			service.remove(tarefa);
			saida.setMensagem("Tarefa excluída com sucesso");
			saida.setErro(false);
		}catch(Exception e) {
			saida.setErro(true);
			saida.setMensagem(String.format("Não foi possivel excluir a tarefa erro[%s]", e.getMessage()));
		}
		return saida;
	}
	@PostMapping("/list")
	public PageData list(@RequestBody ParametroData entrada) throws RegistroNaoEncontradoException{
		PageData saida = new PageData();
		try {
			List<Tarefa> list = service.listAll();
			saida.setLista(list);
			saida.setErro(false);
		}catch(Exception e) {
			saida.setErro(true);
			saida.setMensagem( e.getMessage());
		}
		return saida;
	}
}

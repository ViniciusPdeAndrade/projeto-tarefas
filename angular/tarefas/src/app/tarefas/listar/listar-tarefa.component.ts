import { Component, OnInit } from '@angular/core';
import { TarefaService, Tarefa } from '../shared';

@Component({
  selector: 'app-listar-tarefa',
  templateUrl: './listar-tarefa.component.html',
  styleUrls: ['./listar-tarefa.component.css']
})
export class ListarTarefaComponent implements OnInit {

  tarefas: Tarefa[];

  constructor(private tarefaService: TarefaService) { }

  ngOnInit() {

    this.tarefas = this.listarTodos();

  }

    listarTodos(): Tarefa[]{
    return this.tarefaService.listarTodos();
  }
  // recebe um event ele é um objto padrao do navegador, utilizado para evitar o comportamento de atualizar a pagina
  remover($event: any, tarefa: Tarefa): void {
    $event.preventDefault(); // ele q faz isso, nome padrao
    if(confirm('Deseja remover a tarefa "' + tarefa.nome + '"?')) // ao clicar recebe uma msg com o confirm como alerta, é boolean
    this.tarefaService.remover(tarefa.id); // caso true remove pelo id
    this.tarefas = this.tarefaService.listarTodos(); // apos listar todos
  }

 // pegamos a tarefa
 alterarStatus(tarefa: Tarefa): void{ 
  if (confirm('Deseja alterar o status da tarefa "' + Tarefa.name +'"?')) // msg de confirmação
   this.tarefaService.alterarStatus(tarefa.id); // true o servico é alterado
   this.tarefas = this.tarefaService.listarTodos(); // após listar todos
}
}
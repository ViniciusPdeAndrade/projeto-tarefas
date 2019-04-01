import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Tarefa, TarefaService } from '../shared';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-tarefas',
  templateUrl: './editar-tarefas.component.html',
  styleUrls: ['./editar-tarefas.component.css']
})
export class EditarTarefasComponent implements OnInit {

  @ViewChild('formTarefa') formTarefa: NgForm;
  tarefa: Tarefa;

  constructor(
      private tarefaService: TarefaService,
      private route: ActivatedRoute, // utilizaremos para obter o paramentro
      private router: Router) { }

  ngOnInit() {
    // crio uma variavel let ou const, atraves do modulo route temos o snapshot e params o + faz uma conversão para numerico
    const id = +this.route.snapshot.params['id'];
    this.tarefa=this.tarefaService.buscarPorId(id); // carrega o valor da tarefa por id
  }

  atualizar():void{ // ele valida o formulario
    if(this.formTarefa.form.valid){ 
      this.tarefaService.atualizar(this.tarefa); // chama o metodo atualizar
      this.router.navigate(['/tarefas']); // direciona para tela de tarefas
    }
  }
}

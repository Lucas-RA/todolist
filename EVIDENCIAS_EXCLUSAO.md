# Evidências — Confirmação de exclusão de tarefas

Capturas reais do emulador **Pixel 9 (Android Studio)** executando o aplicativo To-Do List após a implementação do diálogo de confirmação de exclusão.

Tarefa selecionada em todo o fluxo: **"Enviar atividade"**.

## 1. Lista antes da exclusão

![Lista com quatro tarefas antes da exclusão](docs/images/exclusao/01-lista-antes.png)

A lista contém quatro tarefas: "Entregar prova pratica" (com prazo vencido, destacado em vermelho), "Revisar Compose", "Enviar atividade" e "Estudar Room". A tarefa com prazo aparece primeiro, mantendo a ordenação existente.

## 2. Diálogo aberto com a tarefa selecionada

![Diálogo de confirmação mostrando a tarefa Enviar atividade](docs/images/exclusao/02-dialogo-aberto.png)

Ao tocar na lixeira de "Enviar atividade", a tarefa **não** é excluída imediatamente. O diálogo "Excluir tarefa?" abre sobre a própria tela da lista e mostra o título da tarefa selecionada, com as ações "Cancelar" e "Excluir".

## 3. Resultado ao cancelar

![Lista inalterada após tocar em Cancelar](docs/images/exclusao/03-resultado-cancelar.png)

Após tocar em "Cancelar", o diálogo fecha e **a tarefa "Enviar atividade" permanece na lista**. As quatro tarefas continuam iguais.

## 4. Nova abertura do diálogo

![Diálogo reaberto para a mesma tarefa](docs/images/exclusao/04-dialogo-reaberto.png)

A lixeira de "Enviar atividade" é tocada novamente e o diálogo reabre com o título da mesma tarefa.

## 5. Resultado após confirmar a exclusão

![Lista após confirmar a exclusão](docs/images/exclusao/05-resultado-excluir.png)

Após tocar em "Excluir", o diálogo fecha e **somente a tarefa "Enviar atividade" foi removida**. "Entregar prova pratica", "Revisar Compose" e "Estudar Room" permanecem na lista, com prazo, destaque de atraso e ordenação preservados.

# medcontrol-api
Sistema Fullstack para gerenciamento de pacientes e observações médicas desenvolvido com Java, Spring Boot, Angular e PostgreSQL.

O projeto permite que médicos realizem autenticação segura, gerenciem seus próprios pacientes e registrem observações clínicas, garantindo que cada profissional tenha acesso apenas aos seus próprios dados.

# Funcionalidades
##### Autenticação
##### Cadastro de médicos
##### Login com JWT  
##### Rotas protegidas
##### Controle de acesso baseado no médico autenticado

# Pacientes
#### Criar paciente
#### Listar pacientes do médico logado
#### Buscar paciente por ID
#### Editar paciente
#### Excluir paciente

# Observações
#### Criar observações para pacientes
#### Listar observações de um paciente

# Segurança
#### Spring Security
#### JWT Authentication
#### Interceptor Angular para envio automático do token
#### Guard Angular para proteção de rotas
#### Restrição de acesso aos próprios pacientes

# Tecnologias Utilizadas
## Backend
#### Java 21
#### Spring Boot
#### Spring Security
#### JWT
#### Spring Data JPA
#### PostgreSQL
#### Maven

## Frontend
#### Angular
#### TypeScript
#### Reactive Forms
#### Angular Router
#### Guards
#### Interceptors
#### HttpClient

## Estrutura do Projeto
medcontrol/
│
├── backend/
│   └── Spring Boot
│
└── frontend/
    └── Angular
# Imagens do sistema
# Login
![Login](docs/screenshots/login.jpg)

# Painel de pacientes
![Detalhes](docs/screenshots/painelpacientes.jpg)

# Detalhes do paciente
![Anotacoes](docs/screenshots/anotacoesdesktop.jpg)
![Anotacoes](docs/screenshots/anotacoesmobile.jpg)
![Anotacoes](docs/screenshots/anotacoesnotebook.jpg)


    


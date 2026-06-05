# medcontrol-api
Sistema Fullstack para gerenciamento de pacientes e observações médicas desenvolvido com Java, Spring Boot, Angular e PostgreSQL.

O projeto permite que médicos realizem autenticação segura, gerenciem seus próprios pacientes e registrem observações clínicas, garantindo que cada profissional tenha acesso apenas aos seus próprios dados.

## Aplicação Online
### Frontend
https://medcontrol-api.vercel.app

### Backend
https://medcontrol-api-up93.onrender.com

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

# Fluxo de Autenticação
#### Médico realiza login.
#### Backend gera um token JWT.
#### Frontend armazena o token.
#### Interceptor envia o token automaticamente em cada requisição.
#### Backend identifica o médico autenticado.
#### Apenas pacientes pertencentes ao médico logado podem ser acessados. 

# Banco de Dados

### Relacionamentos:

Medico
 └── Pacientes
      └── Observacoes

# Executando o Backend

#### Clone o projeto:

#### git clone URL_DO_REPOSITORIO

#### Acesse a pasta:

#### cd backend

#### Configure o PostgreSQL em:

#### application.properties

#### Execute:

#### ./mvnw spring-boot:run


# Executando o Frontend

#### Acesse a pasta:

#### cd frontend

#### Instale as dependências:

#### npm install

#### Execute:

#### ng serve

#### A aplicação estará disponível em:

#### http://localhost:4200 

# Principais Endpoints
## Autenticação
#### POST /auth/login
## Médicos
#### POST /medicos
## Pacientes
#### GET    /pacientes/me
#### GET    /pacientes/{id}
#### POST   /pacientes
#### PUT    /pacientes/{id}
#### DELETE /pacientes/{id}
## Observações
#### GET    /pacientes/{pacienteId}/observacoes
#### POST   /pacientes/{pacienteId}/observacoes

# Melhorias Futuras
#### Dashboard com indicadores
#### Pesquisa de pacientes
#### Upload de documentos
#### Agendamento de consultas
#### Testes automatizados
#### Docker
#### Deploy em produção


# Imagens do sistema
# Login
![Login](docs/screenshots/login.jpg)

# Painel de pacientes
![Detalhes](docs/screenshots/painelpacientes.jpg)

# Detalhes do paciente
![Anotacoes](docs/screenshots/anotacoesdesktop.jpg)
![Anotacoes](docs/screenshots/anotacoesmobile.jpg)
![Anotacoes](docs/screenshots/anotacoesnotebook.jpg)

## 📚 Aprendizados

Durante o desenvolvimento deste projeto foram praticados:

- Arquitetura em camadas
- DTOs e Mappers
- Relacionamentos JPA
- Autenticação JWT
- Spring Security
- Angular Standalone Components
- Guards e Interceptors
- Consumo de APIs REST
- Dockerização de aplicações
- Configuração de variáveis de ambiente
- Deploy de aplicações Fullstack
- Integração com PostgreSQL em nuvem

# Autor

Rafael Dos Santos

Desenvolvedor Fullstack Java | Angular

Santarém - PA
    


<div align="center">
  <h1>Guardian — Gerenciador de Dispositivos</h1>
  <p><b>Case Técnico Mobile (Android • Kotlin • Jetpack Compose • Koin)</b></p>

  <p>
    <img src="https://img.shields.io/badge/Platform-Android-brightgreen?style=flat-square&logo=android" alt="Platform Android">
    <img src="https://img.shields.io/badge/Kotlin-2.0.21-blue?style=flat-square&logo=kotlin" alt="Kotlin">
    <img src="https://img.shields.io/badge/Compose-Jetpack-blueviolet?style=flat-square&logo=jetpackcompose" alt="Jetpack Compose">
    <img src="https://img.shields.io/badge/DI-Koin-orange?style=flat-square" alt="Koin DI">
    <img src="https://img.shields.io/badge/Architecture-Clean%20%2B%20MVVM-success?style=flat-square" alt="Clean Architecture">
    <img src="https://img.shields.io/badge/Database-Room%20SSOT-informational?style=flat-square" alt="Room DB">
  </p>
</div>

---

## Sobre o Projeto

O **Guardian** é um aplicativo nativo para Android desenvolvido como solução para o case técnico de desenvolvimento mobile. O sistema integra-se a uma API REST para o **CRUD de dispositivos de vídeo (câmeras de segurança) e alarme (centrais de alarme)**, oferecendo uma experiência fluida, moderna e resiliente (Offline-First).

O projeto foi arquitetado pensando em escalabilidade e manutenibilidade, aplicando os mais altos padrões da indústria mobile e preparando a base de código para futura expansão em **Kotlin Multiplatform (KMP)** através do uso do **Koin** para Injeção de Dependência.

---

## Funcionalidades & Requisitos Atendidos

- **Dashboard Inteligente**:
  - Busca em tempo real por nome ou endereço IP do dispositivo.
  - Barra de chips de filtragem rápida: *Todos*, *Favoritos*, *Câmeras* e *Alarmes*.
- **Cards de Dispositivos**:
  - Ícone dinâmico diferenciando equipamentos de vídeo e alarme.
  - Menu Kebab (três pontos) abrindo uma `ModalBottomSheet` com opções: *Informações*, *Editar*, *Marcar/Desmarcar Favorito* e *Remover*.
- **Gerenciamento Completo (CRUD)**:
  - Adição e Edição de dispositivos com validação de campos obrigatórios e feedback visual via `Snackbar`.
- **Sistema de Favoritos Local**:
  - Favoritamento 100% local (sem dependência de endpoint no servidor).
  - **Preservação de Favoritos**: Ao sincronizar com a API, o estado local dos favoritos é preservado de forma inteligente.
- **Resiliência Offline-First (Single Source of Truth)**:
  - A interface observa o banco de dados local Room de forma reativa via `Flow`.
  - Sem conexão, o app exibe perfeitamente os últimos dispositivos sincronizados.

---

##️ Arquitetura e Decisões de Design

O aplicativo segue rigorosamente a **Clean Architecture** dividida em três camadas bem delimitadas:

```
📦 com.example.myapplication
 ┣ 📂 data           # Fontes de dados (Local Room & Remote Retrofit)
 ┃  ┣ 📂 local       # Database, DAOs e Entities (Single Source of Truth)
 ┃  ┣ 📂 remote      # Services, DTOs e Interceptors de Autenticação
 ┃  ┗ 📂 repository  # Implementação do Repositório e Sincronização
 ┣ 📂 domain         # Regras de Negócio Puras
 ┃  ┣ 📂 model       # Modelos de Domínio (Device, DeviceType)
 ┃  ┣ 📂 repository  # Interfaces de Repositório
 ┃  ┗ 📂 usecase     # Casos de Uso (Get, Save, Delete, ToggleFavorite)
 ┣ 📂 presentation   # Camada de UI (Jetpack Compose & MVVM)
 ┃  ┣ 📂 dashboard   # Dashboard Screen & ViewModel
 ┃  ┣ 📂 deviceform  # Formulário de Adição/Edição & ViewModel
 ┃  ┗ 📂 deviceinfo  # Tela de Detalhes & ViewModel
 ┗ 📂 di             # Módulos de Injeção de Dependência (Koin)
```

- **Single Source of Truth (SSOT)**: A UI nunca conversa diretamente com a rede; todas as leituras passam pelo Room através de `Flow`, garantindo reatividade instantânea.
- **Koin (KMP Readiness)**: Diferente de frameworks acoplados ao ciclo de vida Android, o Koin foi adotado por ser nativamente compatível com **Kotlin Multiplatform**, permitindo compartilhar lógica de Domínio e Dados facilmente no futuro.

---

## Stack Tecnológica

| Camada / Domínio | Tecnologia / Biblioteca |
| :--- | :--- |
| **Linguagem** | Kotlin 2.0.21 |
| **UI Declarativa** | Jetpack Compose & Material 3 |
| **Navegação** | Jetpack Navigation Compose |
| **Arquitetura** | MVVM + Clean Architecture + UDF |
| **Persistência Local** | Room Database (com suporte a Flow) |
| **Rede (API)** | Retrofit 2 + OkHttp 3 (com Logging Interceptor) |
| **Injeção de Dependência** | Koin 3.5.6 |
| **Testes Unitários** | JUnit 4, MockK, Coroutines Test, Turbine |

---

## Configuração e Execução

### 1. Configuração do Token da API
Por motivos de segurança, o token de acesso à API não é versionado no repositório.

Crie (ou certifique-se de que existe) o arquivo `local.properties` na raiz do projeto e adicione a seguinte linha com o seu token:
```properties
API_TOKEN=seu_token_aqui
```
O sistema de build do Gradle lê automaticamente esta propriedade e a injeta no `BuildConfig`.

### 2. Requisitos do Sistema
- **Android Studio** (Koala ou superior recomendado)
- **SDK Mínimo**: API 29 (Android 10)
- **SDK Alvo**: API 36
- **SDK de Compilação**: API 36

### 3. Rodando os Testes Unitários
Para executar a suíte de testes de negócio (ViewModels e regras de repositório):
```bash
./gradlew testDebugUnitTest
```

---

## Próximos Passos & Evoluções Futuras

1. **Módulo KMP (`shared`)**: Extrair as camadas `domain` e `data` para um módulo Kotlin Multiplatform para suportar iOS (`SwiftUI`).
2. **Fila de Mutação Offline (Outbox Pattern)**: Integrar `WorkManager` para enfileirar operações CRUD realizadas sem internet e executá-las automaticamente ao recuperar o sinal.
3. **Testes de UI**: Adicionar testes instrumentados com Compose UI Test (`createComposeRule`).

---

<div align="center">
  <p>Desenvolvido com foco em código limpo, robustez e arquitetura escalável.</p>
</div>

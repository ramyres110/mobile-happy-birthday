# Cartão de Aniversário

App para criação de cartão de aniversário!

## Avaliação

### Setup

1. Clone o repositório informado pelo professor
    * https://github.com/ramyres110/mobile-happy-birthday 
2. Abra o projeto no Android Studio
    * Identificar local do clone
    * Abrir e verificar as mensagens de alerta
3. Compile o App
    * Verificar se foi compilado com sucesso (BUILD SUCCESS)
4. Execute o App
    * Abrir o app em uma VM ou no dispositivo

### Atividades

#### Orientações
* Realize o commit por atividade. Ex:
1. Finalizou a atividade 1
2. Adicione os arquivos alterados no git
2. Realize o git commit do que foi feito com a mensagem: `Atividade 1 concluída`

#### Questões

1. (2,0) [Componente] Adicione um componente de Text no componente FormSettings acima do TextField que recebe o valor do **from**
    * Text(text = "From name:", fontSize = 20.sp)
2. (2,0) [Componente] A
3. (2,0) [Evento] Adicione a função `onClickBuildCard` no componente FormSettings no clique do botão `Build Birthday Card`
4. (2,0) [Estado] Crie um estado no metodo onCreate que seja boleano e altere no local que está fixo `if (false){`
5. (2,0) [Modificadores] Altere o componente de Texto com o texto Settings para ficar alinhado para a esquerda(atualmente no centro) e o espaço inferior para 40dp.

### Entrega

1. Realize o commit por tarefa com a mensagem: `Tafera X finalizada`
2. Ao final, feche o Android Studio e na pasta do repositório:
    - Apague a pasta "app\build" (pois nela tem os compilados)
    - Apague a pasta  "gradle" (pois há o .jar)
3. Compacte a "pasta do repositório" e envie por email 
    - A pasta ".git" deve estar no arquivo comprimido!


## Conteúdos

### Fluxo
```
o -> Componente -> Evento -> Estado -> *Recomposição(Componete) -.
        ^--------------------------------------------------------'
```

### Componentes
@Composable (anotação)

```kotlin
@Composable
def Funcao(...): //Definiçaõ do Componente
    ...
```
**Ex. de atividade:** Adicione um texto no final do componente GreetingImage para aparecer abaixo do GreetingText que recebe o texto from

### Eventos
on*** (inciado com on, são funções que executarão ao disparar o evento)

Ex: 
* onClick = {/* Função executada */}
* onValueChange = {/* Função executada */}

```kotlin
OutlinedButton(onClick = {/*Executa quando clicado no botão*/}) {
   Text("Clique aqui")
}
```

### Estados (varíavel)
Utiliza o `by remember`

"Variavel" com propriedades extras*

Utiliza o `mutableStateOf` para iniciar os valores.

```kotlin
val estadoComum: String by remember { mutableStateOf("") }
var estadoSalvavel: String by rememberSaveable {mutableStateOf("")}
```

### Modificador
Altera o estilo de um componente (`Modifier`)

```kotlin
Text(
    text = "Olá mundo",
    fontSize = 30.sp, // Estilo padrão do componente
    modifier = Modifier
        .padding(bottom = 30.dp, top = 90.dp) // Espaço interno com modificador
        .align(alignment = Alignment.CenterHorizontally) // Alinhamento com modificador
)
```

### Manifest

_Manifest ficará de fora_

Utilizado para informar ao Android o que o App é, utilizará e fará!

Arquivo `AndroidManifest.xml`
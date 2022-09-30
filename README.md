# AutomacaoMeLiMobile

Passo a passo para buildar a automação em sua maquina

#### Requisitos

* JDK 8 configurada na JAVA_HOME
* APPIUM instalado
* Android Studio instalado
* Emulador Android Studio
* Extensão Gherkin e Cucumber for Java instaladas na IDE utilizada
* Após clonar o projeto, criar uma pasta na raiz com o nome **Screenshot**

#### Link de recomendação para a instalação dos requisitos listados
https://support.smartbear.com/testcomplete/docs/app-testing/mobile/device-cloud/configure-appium/android-on-windows.html

### Como Rodar a automação???

#### Preparações:

Por meio do seu terminal de comando, rode o comando:

*appium* 

Após isso, caso não tenham ocorrido problemas durante a instalação dos requisitos, você deverá se deparar com uma
mensagem parecida com a abaixo:

*[Appium] Welcome to Appium v1.22.3*

*[Appium] Appium REST http interface listener started on 0.0.0.0:4723*

**Em seguida inicialize o seu emulador por meio do Android Studio.**

Por fim, acesse a feature valida_busca_produtos.feature localizada no caminho:

***src/test/resources/features/valida_busca_produtos.feature***

#### Execução

Com a extensão do Gherkin:

Basta clicar no botao play verde, ao lado do titulo da feature para iniciar a execução de todos os cenários

Pela linha de comando

*mvn test*

#### Visualização do Report

Após executar a automação, acesse a pasta ScreenShot na raiz do projeto, lá exisitirá todos os prints da execução 
com o nome de cada passo principal executado.

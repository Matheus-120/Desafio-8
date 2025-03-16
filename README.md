# Análise de Sentimentos com Language Studio no Azure AI

Este projeto demonstra como utilizar o **Azure AI Language Studio** para realizar Análise de Sentimentos em textos. Com a API de Análise de Texto do Azure, é possível determinar se um texto possui um tom **positivo, negativo ou neutro**.

## Tecnologias Utilizadas
- **Azure AI Language Studio**
- **Azure Cognitive Services**
- **Python** com biblioteca `requests`

## Funcionalidades do Projeto
1. Conexão com a API de **Análise de Sentimentos** do Azure.
2. Processamento de um texto e retorno da classificação (**positivo, negativo ou neutro**).
3. Implementação simples utilizando **requisições HTTP** para a API do Azure.

## Como Configurar e Executar
### 1. Configurar o Azure
Antes de iniciar, você precisa de uma conta no **Azure** e um **recurso do Azure AI Language Studio** configurado.
1. Acesse o [Portal do Azure](https://portal.azure.com/).
2. Crie um recurso **Cognitive Services** e habilite a opção de **Análise de Texto**.
3. Anote a **chave de API** e o **endpoint** do serviço.

### 2. Instalar Dependências
Instale as bibliotecas necessárias:
```sh
pip install requests
```

### 3. Executar o Script
Substitua `<seu-endpoint>` e `<sua-chave-api>` pelos valores reais do seu serviço no Azure e execute o seguinte código Python:
```python
import requests
import json

# Configuração do Azure
ENDPOINT = "<seu-endpoint>"
API_KEY = "<sua-chave-api>"

# URL da API de Análise de Sentimentos
detect_language_url = f"{ENDPOINT}/text/analytics/v3.1/sentiment"

# Texto para análise
data = {
    "documents": [
        {"id": "1", "language": "pt", "text": "Esse serviço é incrível!"}
    ]
}

headers = {
    "Ocp-Apim-Subscription-Key": API_KEY,
    "Content-Type": "application/json"
}

response = requests.post(detect_language_url, headers=headers, json=data)
result = response.json()

print(json.dumps(result, indent=2, ensure_ascii=False))
```

## Exemplo de Retorno da API
```json
{
  "documents": [
    {
      "id": "1",
      "sentiment": "positive",
      "confidenceScores": {
        "positive": 0.98,
        "neutral": 0.01,
        "negative": 0.01
      }
    }
  ]
}
```

## Conclusão
Este projeto é uma implementação básica de **Análise de Sentimentos** utilizando o **Azure AI Language Studio**. Ele permite integrar a Inteligência Artificial do Azure para interpretar o tom de textos, podendo ser aplicado em chatbots, atendimento ao cliente e monitoramento de opiniões em redes sociais.

---
### Apresentado por Matheus Ferreira
[Acesse meu GitHub](https://github.com/Matheus-120)


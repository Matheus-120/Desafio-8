import requestS
import json

# Configurações do serviço Azure AI Language
AZURE_ENDPOINT = "https://<seu-endpoint>.cognitiveservices.azure.com/"
AZURE_API_KEY = "<sua-chave-api>"
AZURE_ANALYSIS_URL = f"{AZURE_ENDPOINT}text/analytics/v3.1/sentiment"

HEADERS = {
        "Ocp-Apim-Subscription-Key": AZURE_API_KEY,
        "Content-Type": "application/json"
        }

def analisar_sentimento(texto):
dados = {
        "documents": [
        {"id": "1", "language": "pt", "text": texto}
        ]
        }
resposta = requests.post(AZURE_ANALYSIS_URL, headers=HEADERS, json=dados)
    return resposta.json()

if __name__ == "__main__":
texto_exemplo = "Estou muito feliz com o serviço oferecido!"
resultado = analisar_sentimento(texto_exemplo)
print(json.dumps(resultado, indent=4, ensure_ascii=False))

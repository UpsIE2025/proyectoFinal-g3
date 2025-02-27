import requests

def fetch_data_from_rest(message: str) -> str:
    url = "http://localhost:8081/api/producer/send"
    payload = {"message": message}  # Usa el parámetro como valor dinámico
    headers = {"Content-Type": "application/json"}

    try:
        response = requests.post(url, json=payload, headers=headers) 

        if response.status_code == 200:
            return response.json() 
        else:
            return f"Error {response.status_code}: {response.text}" 

    except requests.exceptions.RequestException as e:
        return f"Request failed: {str(e)}" 

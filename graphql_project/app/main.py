from fastapi import FastAPI, HTTPException
from strawberry.fastapi import GraphQLRouter
from app.graphql_schema import schema
from app.rest_client import fetch_data_from_rest
from app.grpc_client import fetch_data_from_grpc
from pydantic import BaseModel

app = FastAPI()

# Integración de GraphQL
graphql_app = GraphQLRouter(schema)
app.include_router(graphql_app, prefix="/graphql")

# Modelo de datos para la solicitud POST
class RequestData(BaseModel):
    message: str
    request_type: str  # "rest" o "grpc"

# Servicio POST para manejar REST o gRPC
@app.post("/send-message")
async def send_message(data: RequestData):
    if data.request_type.lower() == "rest":
        response = fetch_data_from_rest(data.message)
    elif data.request_type.lower() == "grpc":
        response = fetch_data_from_grpc(data.message)
    else:
        raise HTTPException(status_code=400, detail="Invalid request_type. Use 'rest' or 'grpc'.")

    return {"status": "success", "response": response}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000, reload=True)

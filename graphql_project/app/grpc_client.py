import grpc
from app import service_pb2_grpc
from app import service_pb2 as auto_pb2

def fetch_data_from_grpc(auto_id: int):
    channel = grpc.insecure_channel("localhost:9090")  # Ajusta si el puerto es diferente
    stub = service_pb2_grpc.AutoServiceStub(channel)
    
    request = auto_pb2.AutoRequest(autoId=auto_id)
    response = stub.ObtenerAuto(request)
    
    return {
        "autoId": response.autoId,
        "autoMarca": response.autoMarca,
        "autoModelo": response.autoModelo,
        "autoAnio": response.autoAnio
    }

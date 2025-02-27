import grpc
from app import service_pb2_grpc
from . import service_pb2 as service__pb2

def fetch_data_from_grpc() -> str:
    channel = grpc.insecure_channel("localhost:50051")
    stub = service_pb2_grpc.ExampleServiceStub(channel)
    response = stub.GetData(service__pb2.Empty())
    return response.message

import strawberry
from app.rest_client import fetch_data_from_rest
from app.grpc_client import fetch_data_from_grpc

@strawberry.type
class Auto:
    autoId: int
    autoMarca: str
    autoModelo: str
    autoAnio: str

@strawberry.type
class Query:
    rest_data: str = strawberry.field(resolver=fetch_data_from_rest)
    
    @strawberry.field
    def grpc_auto(self, auto_id: int) -> Auto:
        auto_data = fetch_data_from_grpc(auto_id)
        return Auto(**auto_data)

schema = strawberry.Schema(query=Query)

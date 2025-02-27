import strawberry
from app.rest_client import fetch_data_from_rest
from app.grpc_client import fetch_data_from_grpc

@strawberry.type
class Query:
    rest_data: str = strawberry.field(resolver=fetch_data_from_rest)
    grpc_data: str = strawberry.field(resolver=fetch_data_from_grpc)

schema = strawberry.Schema(query=Query)

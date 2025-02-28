package com.grupo3.grpc.service;


import com.grupo3.grpc.Auto;
import com.grupo3.grpc.AutoServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GrpcService
public class AutoServiceImpl extends AutoServiceGrpc.AutoServiceImplBase {

    private final List<Auto.AutoResponse> autos = new ArrayList<>();

    @Override
    public void createAuto(Auto.CreateAutoRequest request, StreamObserver<Auto.AutoResponse> responseObserver) {
        Auto.AutoResponse auto = Auto.AutoResponse.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setMarca(request.getMarca())
                .setModelo(request.getModelo())
                .setAnio(request.getAnio())
                .build();

        autos.add(auto);

        responseObserver.onNext(auto);
        responseObserver.onCompleted();
    }

    @Override
    public void updateAuto(Auto.UpdateAutoRequest request, StreamObserver<Auto.AutoResponse> responseObserver) {
        for (int i = 0; i < autos.size(); i++) {
            if (autos.get(i).getId().equals(request.getId())) {
                Auto.AutoResponse updatedAuto = Auto.AutoResponse.newBuilder()
                        .setId(request.getId())
                        .setMarca(request.getMarca())
                        .setModelo(request.getModelo())
                        .setAnio(request.getAnio())
                        .build();

                autos.set(i, updatedAuto);

                responseObserver.onNext(updatedAuto);
                responseObserver.onCompleted();
                return;
            }
        }
        responseObserver.onError(new RuntimeException("Auto no encontrado"));
    }

    @Override
    public void getAuto(Auto.AutoRequest request, StreamObserver<Auto.AutoResponse> responseObserver) {
        for (Auto.AutoResponse auto : autos) {
            if (auto.getId().equals(request.getId())) {
                responseObserver.onNext(auto);
                responseObserver.onCompleted();
                return;
            }
        }
        responseObserver.onError(new RuntimeException("Auto no encontrado"));
    }

    @Override
    public void listAutos(Auto.AutoListRequest request, StreamObserver<Auto.AutoList> responseObserver) {
        Auto.AutoList autoList = Auto.AutoList.newBuilder().addAllAutos(autos).build();
        responseObserver.onNext(autoList);
        responseObserver.onCompleted();
    }
}

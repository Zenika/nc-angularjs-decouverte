package com.zenika.nc.angular.mybottles.rest;

import com.google.common.base.Optional;
import com.zenika.nc.angular.mybottles.domain.Bottle;
import com.zenika.nc.angular.mybottles.persistence.BottleRepository;
import restx.annotations.DELETE;
import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.security.PermitAll;

import javax.inject.Named;
import java.util.Collection;

@Component
@RestxResource
public class BottleResource {
    private BottleRepository bottleRepository;

    public BottleResource(@Named("bottleRepository") BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    @GET("/bottle")
    @PermitAll
    public Collection<Bottle> getAll() {
        return bottleRepository.getAll();
    }

    @GET("/bottle/:bottleId")
     @PermitAll
     public Optional<Bottle> get(int bottleId) {
        return Optional.fromNullable(bottleRepository.get(bottleId));
    }

    @POST("/bottle")
    @PermitAll
    public Optional<Bottle> save(Bottle bottle) {
        bottle.setId(-1);
        return Optional.fromNullable(bottleRepository.save(bottle));
    }

    @POST("/bottle/:bottleId")
    @PermitAll
    public Optional<Bottle> save(int bottleId, Bottle bottle) {
        bottle.setId(bottleId);
        return Optional.fromNullable(bottleRepository.edit(bottle));
    }

    @DELETE("/bottle/:bottleId")
    @PermitAll
    public Optional<Bottle> delete(int bottleId) {
        return Optional.fromNullable(bottleRepository.remove(bottleId));
    }
}

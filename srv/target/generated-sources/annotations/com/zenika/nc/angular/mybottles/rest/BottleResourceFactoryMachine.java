package com.zenika.nc.angular.mybottles.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import com.zenika.nc.angular.mybottles.rest.BottleResource;

@Machine
public class BottleResourceFactoryMachine extends SingleNameFactoryMachine<BottleResource> {
    public static final Name<BottleResource> NAME = Name.of(BottleResource.class, "BottleResource");

    public BottleResourceFactoryMachine() {
        super(0, new StdMachineEngine<BottleResource>(NAME, BoundlessComponentBox.FACTORY) {
private final Factory.Query<com.zenika.nc.angular.mybottles.persistence.BottleRepository> bottleRepository = Factory.Query.byName(Name.of(com.zenika.nc.angular.mybottles.persistence.BottleRepository.class, "bottleRepository")).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
bottleRepository
                ));
            }

            @Override
            protected BottleResource doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new BottleResource(
satisfiedBOM.getOne(bottleRepository).get().getComponent()
                );
            }
        });
    }

}

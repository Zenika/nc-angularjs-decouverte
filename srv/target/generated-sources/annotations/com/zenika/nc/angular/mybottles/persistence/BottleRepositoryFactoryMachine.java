package com.zenika.nc.angular.mybottles.persistence;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import com.zenika.nc.angular.mybottles.persistence.BottleRepository;

@Machine
public class BottleRepositoryFactoryMachine extends SingleNameFactoryMachine<BottleRepository> {
    public static final Name<BottleRepository> NAME = Name.of(BottleRepository.class, "bottleRepository");

    public BottleRepositoryFactoryMachine() {
        super(0, new StdMachineEngine<BottleRepository>(NAME, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected BottleRepository doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new BottleRepository(

                );
            }
        });
    }

}

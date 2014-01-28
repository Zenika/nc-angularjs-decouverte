package com.zenika.nc.angular.mybottles.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import com.zenika.nc.angular.mybottles.rest.BottleResourceRouter;

@Machine
public class BottleResourceRouterFactoryMachine extends SingleNameFactoryMachine<BottleResourceRouter> {
    public static final Name<BottleResourceRouter> NAME = Name.of(BottleResourceRouter.class, "BottleResourceRouter");

    public BottleResourceRouterFactoryMachine() {
        super(0, new StdMachineEngine<BottleResourceRouter>(NAME, BoundlessComponentBox.FACTORY) {
private final Factory.Query<com.zenika.nc.angular.mybottles.rest.BottleResource> resource = Factory.Query.byClass(com.zenika.nc.angular.mybottles.rest.BottleResource.class).mandatory();
private final Factory.Query<restx.entity.EntityRequestBodyReaderRegistry> readerRegistry = Factory.Query.byClass(restx.entity.EntityRequestBodyReaderRegistry.class).mandatory();
private final Factory.Query<restx.entity.EntityResponseWriterRegistry> writerRegistry = Factory.Query.byClass(restx.entity.EntityResponseWriterRegistry.class).mandatory();
private final Factory.Query<restx.converters.MainStringConverter> converter = Factory.Query.byClass(restx.converters.MainStringConverter.class).mandatory();
private final Factory.Query<javax.validation.Validator> validator = Factory.Query.byClass(javax.validation.Validator.class).mandatory();
private final Factory.Query<restx.security.RestxSecurityManager> securityManager = Factory.Query.byClass(restx.security.RestxSecurityManager.class).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
resource,
readerRegistry,
writerRegistry,
converter,
validator,
securityManager
                ));
            }

            @Override
            protected BottleResourceRouter doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new BottleResourceRouter(
satisfiedBOM.getOne(resource).get().getComponent(),
satisfiedBOM.getOne(readerRegistry).get().getComponent(),
satisfiedBOM.getOne(writerRegistry).get().getComponent(),
satisfiedBOM.getOne(converter).get().getComponent(),
satisfiedBOM.getOne(validator).get().getComponent(),
satisfiedBOM.getOne(securityManager).get().getComponent()
                );
            }
        });
    }

}

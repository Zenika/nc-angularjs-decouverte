package com.zenika.nc.angular.mybottles.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.base.Optional;
import static com.google.common.base.Preconditions.checkNotNull;

import restx.common.Types;
import restx.*;
import restx.entity.*;
import restx.http.*;
import restx.factory.*;
import restx.security.*;
import static restx.security.Permissions.*;
import restx.description.*;
import restx.converters.MainStringConverter;
import static restx.common.MorePreconditions.checkPresent;

import javax.validation.Validator;
import static restx.validation.Validations.checkValid;

import java.io.IOException;
import java.io.PrintWriter;

@Component(priority = 0)

public class BottleResourceRouter extends RestxRouter {

    public BottleResourceRouter(
                    final BottleResource resource,
                    final EntityRequestBodyReaderRegistry readerRegistry,
                    final EntityResponseWriterRegistry writerRegistry,
                    final MainStringConverter converter,
                    final Validator validator,
                    final RestxSecurityManager securityManager) {
        super(
            "default", "BottleResourceRouter", new RestxRoute[] {
        new StdEntityRoute<Void, java.util.Collection<com.zenika.nc.angular.mybottles.domain.Bottle>>("default#BottleResource#getAll",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<java.util.Collection<com.zenika.nc.angular.mybottles.domain.Bottle>>build(Types.newParameterizedType(java.util.Collection.class, com.zenika.nc.angular.mybottles.domain.Bottle.class), Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/bottle"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<java.util.Collection<com.zenika.nc.angular.mybottles.domain.Bottle>> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.getAll(
                        
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                

                operation.responseClass = "Bottle>";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "";
                operation.sourceLocation = "com.zenika.nc.angular.mybottles.rest.BottleResource#getAll()";
            }
        },
        new StdEntityRoute<Void, com.zenika.nc.angular.mybottles.domain.Bottle>("default#BottleResource#get",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<com.zenika.nc.angular.mybottles.domain.Bottle>build(com.zenika.nc.angular.mybottles.domain.Bottle.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/bottle/:bottleId"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<com.zenika.nc.angular.mybottles.domain.Bottle> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return resource.get(
                        /* [PATH] bottleId */ converter.convert(match.getPathParam("bottleId"), int.class)
                );
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription bottleId = new OperationParameterDescription();
                bottleId.name = "bottleId";
                bottleId.paramType = OperationParameterDescription.ParamType.path;
                bottleId.dataType = "int";
                bottleId.schemaKey = "int";
                bottleId.required = true;
                operation.parameters.add(bottleId);


                operation.responseClass = "Bottle";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                operation.sourceLocation = "com.zenika.nc.angular.mybottles.rest.BottleResource#get(int)";
            }
        },
        new StdEntityRoute<com.zenika.nc.angular.mybottles.domain.Bottle, com.zenika.nc.angular.mybottles.domain.Bottle>("default#BottleResource#save",
                readerRegistry.<com.zenika.nc.angular.mybottles.domain.Bottle>build(com.zenika.nc.angular.mybottles.domain.Bottle.class, Optional.<String>absent()),
                writerRegistry.<com.zenika.nc.angular.mybottles.domain.Bottle>build(com.zenika.nc.angular.mybottles.domain.Bottle.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("POST", "/bottle"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<com.zenika.nc.angular.mybottles.domain.Bottle> doRoute(RestxRequest request, RestxRequestMatch match, com.zenika.nc.angular.mybottles.domain.Bottle body) throws IOException {
                securityManager.check(request, open());
                return resource.save(
                        /* [BODY] bottle */ checkValid(validator, body)
                );
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription bottle = new OperationParameterDescription();
                bottle.name = "bottle";
                bottle.paramType = OperationParameterDescription.ParamType.body;
                bottle.dataType = "Bottle";
                bottle.schemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                bottle.required = true;
                operation.parameters.add(bottle);


                operation.responseClass = "Bottle";
                operation.inEntitySchemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                operation.outEntitySchemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                operation.sourceLocation = "com.zenika.nc.angular.mybottles.rest.BottleResource#save(com.zenika.nc.angular.mybottles.domain.Bottle)";
            }
        },
        new StdEntityRoute<com.zenika.nc.angular.mybottles.domain.Bottle, com.zenika.nc.angular.mybottles.domain.Bottle>("default#BottleResource#save",
                readerRegistry.<com.zenika.nc.angular.mybottles.domain.Bottle>build(com.zenika.nc.angular.mybottles.domain.Bottle.class, Optional.<String>absent()),
                writerRegistry.<com.zenika.nc.angular.mybottles.domain.Bottle>build(com.zenika.nc.angular.mybottles.domain.Bottle.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("POST", "/bottle/:bottleId"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<com.zenika.nc.angular.mybottles.domain.Bottle> doRoute(RestxRequest request, RestxRequestMatch match, com.zenika.nc.angular.mybottles.domain.Bottle body) throws IOException {
                securityManager.check(request, open());
                return resource.save(
                        /* [PATH] bottleId */ converter.convert(match.getPathParam("bottleId"), int.class),
                        /* [BODY] bottle */ checkValid(validator, body)
                );
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription bottleId = new OperationParameterDescription();
                bottleId.name = "bottleId";
                bottleId.paramType = OperationParameterDescription.ParamType.path;
                bottleId.dataType = "int";
                bottleId.schemaKey = "int";
                bottleId.required = true;
                operation.parameters.add(bottleId);

                OperationParameterDescription bottle = new OperationParameterDescription();
                bottle.name = "bottle";
                bottle.paramType = OperationParameterDescription.ParamType.body;
                bottle.dataType = "Bottle";
                bottle.schemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                bottle.required = true;
                operation.parameters.add(bottle);


                operation.responseClass = "Bottle";
                operation.inEntitySchemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                operation.outEntitySchemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                operation.sourceLocation = "com.zenika.nc.angular.mybottles.rest.BottleResource#save(int,com.zenika.nc.angular.mybottles.domain.Bottle)";
            }
        },
        new StdEntityRoute<Void, com.zenika.nc.angular.mybottles.domain.Bottle>("default#BottleResource#delete",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<com.zenika.nc.angular.mybottles.domain.Bottle>build(com.zenika.nc.angular.mybottles.domain.Bottle.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("DELETE", "/bottle/:bottleId"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<com.zenika.nc.angular.mybottles.domain.Bottle> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return resource.delete(
                        /* [PATH] bottleId */ converter.convert(match.getPathParam("bottleId"), int.class)
                );
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription bottleId = new OperationParameterDescription();
                bottleId.name = "bottleId";
                bottleId.paramType = OperationParameterDescription.ParamType.path;
                bottleId.dataType = "int";
                bottleId.schemaKey = "int";
                bottleId.required = true;
                operation.parameters.add(bottleId);


                operation.responseClass = "Bottle";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "com.zenika.nc.angular.mybottles.domain.Bottle";
                operation.sourceLocation = "com.zenika.nc.angular.mybottles.rest.BottleResource#delete(int)";
            }
        },
        });
    }

}

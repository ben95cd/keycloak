/*
 * Copyright 2023 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keycloak.protocol.saml.attributeQuery.server;

import org.keycloak.Config;
import org.keycloak.common.Profile;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.EnvironmentDependentProviderFactory;

/**
 * @author Ben Cresitello-Dittmar
 *
 * Factory to create instances of {@link DefaultSamlAttributeQueryServerProvider}.
 */
public class DefaultSamlAttributeQueryServerProviderFactory implements AttributeQueryServerProviderFactory, EnvironmentDependentProviderFactory {

    @Override
    public DefaultSamlAttributeQueryServerProvider create(KeycloakSession session) {
        return new DefaultSamlAttributeQueryServerProvider();
    }

    @Override
    public void init(Config.Scope config) {}

    @Override
    public void postInit(KeycloakSessionFactory factory) {}

    @Override
    public boolean isSupported(Config.Scope config) {
        return Profile.isFeatureEnabled(Profile.Feature.ATTRIBUTE_STORE);
    }

    @Override
    public void close() {}

    @Override
    public String getId() {
        return "default";
    }

}

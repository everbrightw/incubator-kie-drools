/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.compiler.lang.descr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.drools.drl.ast.dsl.PackageDescrBuilder;
import org.drools.drl.ast.dsl.impl.PackageDescrBuilderImpl;
import org.drools.drl.ast.descr.PackageDescr;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PackageDescrTest {

    @Test
    public void createPackageDescrWithTypeDeclarationDescr() throws IOException {
        PackageDescrBuilder builder = PackageDescrBuilderImpl.newPackage();
        builder.newDeclare().type().name("java.lang.String");
        PackageDescr descr = builder.getDescr();
        OutputStream os = new ByteArrayOutputStream();
        ObjectOutput oo = new ObjectOutputStream(os);
        descr.writeExternal(oo);
        assertNotNull(os.toString());
    }

}
/*
    Foilen Infra Resource Machine
    https://github.com/foilen/foilen-infra-resource-machine
    Copyright (c) 2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.machine;

import java.util.Arrays;

import com.foilen.infra.plugin.v1.core.context.CommonServicesContext;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionProvider;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionV1;

public class FoilenMachinePluginDefinitionProvider implements IPPluginDefinitionProvider {

    @Override
    public IPPluginDefinitionV1 getIPPluginDefinition() {
        IPPluginDefinitionV1 pluginDefinitionV1 = new IPPluginDefinitionV1("Foilen", "Machine", "To manage machines", "1.0.0");

        pluginDefinitionV1.addCustomResource(Machine.class, "Machine", //
                Arrays.asList(Machine.PROPERTY_NAME), //
                Arrays.asList( //
                        Machine.PROPERTY_NAME, //
                        Machine.PROPERTY_PUBLIC_IP //
                ));

        pluginDefinitionV1.addTranslations("/com/foilen/infra/resource/machine/messages");
        pluginDefinitionV1.addResourceEditor(new MachineEditor(), MachineEditor.EDITOR_NAME);

        return pluginDefinitionV1;
    }

    @Override
    public void initialize(CommonServicesContext commonServicesContext) {
    }

}

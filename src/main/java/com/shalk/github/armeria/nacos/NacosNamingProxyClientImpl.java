/*
 * Copyright (C) 2024 shalk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shalk.github.armeria.nacos;

import com.shalk.github.armeria.nacos.model.ModelInstance;
import com.shalk.github.armeria.nacos.param.SubscribeParam;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class NacosNamingProxyClientImpl implements NacosNamingProxyClient {

  @Override
  public boolean registerInstance(String service, String groupName, ModelInstance instance) {

    return false;
  }

  @Override
  public boolean deregisterInstance(String service, String groupName, ModelInstance instance) {
    return false;
  }

  @Override
  public List<ModelInstance> selectAllInstances(String service, String groupName, String clusters) {
    return Collections.emptyList();
  }

  @Override
  public void subscribe(SubscribeParam param) {}

  @Override
  public void unsubscribe(SubscribeParam param) {}

  @Override
  public void close() throws IOException {}
}

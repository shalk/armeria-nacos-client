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

import com.shalk.github.armeria.nacos.grpc.NacosNamingProxyGrpcClient;
import com.shalk.github.armeria.nacos.model.ModelInstance;
import com.shalk.github.armeria.nacos.param.DeregisterInstanceParam;
import com.shalk.github.armeria.nacos.param.RegisterInstanceParam;
import com.shalk.github.armeria.nacos.param.SelectAllInstancesParam;
import com.shalk.github.armeria.nacos.param.SubscribeParam;
import java.util.Collections;
import java.util.List;

public class NacosNamingClientImpl implements NacosNamingClient {
  NacosNamingProxyGrpcClient grpcClient;

  public NacosNamingClientImpl(String address, String namespace) {
    grpcClient = new NacosNamingProxyGrpcClient(address, namespace);
  }
  //  NacosNamingProxyHttpClient httpClient;
  //  NacosNamingCache cache;

  @Override
  public boolean registerInstance(RegisterInstanceParam param) {
    String serviceName = param.getServiceName();
    String groupName = param.getGroupName();
    ModelInstance instance = new ModelInstance();
    instance.setServiceName(param.getServiceName());
    instance.setIp(param.getIp());
    instance.setPort(param.getPort());
    instance.setWeight(param.getWeight());
    instance.setClusterName(param.getClusterName());
    instance.setMetadata(param.getMetadata());
    return grpcClient.registerInstance(serviceName, groupName, instance);
  }

  @Override
  public boolean deregisterInstance(DeregisterInstanceParam param) {
    return false;
  }

  @Override
  public List<ModelInstance> selectAllInstances(SelectAllInstancesParam param) {
    return Collections.emptyList();
  }

  @Override
  public void subscribe(SubscribeParam param) {}

  @Override
  public void unsubscribe(SubscribeParam param) {}

  @Override
  public void close() {}
}

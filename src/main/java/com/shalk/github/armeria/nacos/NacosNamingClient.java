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
import com.shalk.github.armeria.nacos.param.DeregisterInstanceParam;
import com.shalk.github.armeria.nacos.param.RegisterInstanceParam;
import com.shalk.github.armeria.nacos.param.SelectAllInstancesParam;
import com.shalk.github.armeria.nacos.param.SubscribeParam;
import java.io.Closeable;
import java.util.List;

public interface NacosNamingClient extends Closeable {

  // RegisterInstance use to register instance
  // Ip  require
  // Port  require
  // Weight  require,it must be lager than 0
  // Enable  require,the instance can be access or not
  // Healthy  require,the instance is health or not
  // Metadata  optional
  // ClusterName  optional,default:DEFAULT
  // ServiceName require
  // GroupName optional,default:DEFAULT_GROUP
  // Ephemeral optional
  boolean registerInstance(RegisterInstanceParam param);

  // DeregisterInstance use to deregister instance
  // Ip required
  // Port required
  // Tenant optional
  // Cluster optional,default:DEFAULT
  // ServiceName  require
  // GroupName  optional,default:DEFAULT_GROUP
  // Ephemeral optional
  boolean deregisterInstance(DeregisterInstanceParam param);

  // SelectAllInstances return all instances,include healthy=false,enable=false,weight<=0
  // ServiceName require
  // Clusters optional,default:DEFAULT
  // GroupName optional,default:DEFAULT_GROUP
  List<ModelInstance> selectAllInstances(SelectAllInstancesParam param);

  // Subscribe use to subscribe service change event
  // ServiceName require
  // Clusters optional,default:DEFAULT
  // GroupName optional,default:DEFAULT_GROUP
  // SubscribeCallback require
  void subscribe(SubscribeParam param);

  // Unsubscribe use to unsubscribe service change event
  // ServiceName require
  // Clusters optional,default:DEFAULT
  // GroupName optional,default:DEFAULT_GROUP
  // SubscribeCallback require
  void unsubscribe(SubscribeParam param);

  // CloseClient close the GRPC client
  void close();
}

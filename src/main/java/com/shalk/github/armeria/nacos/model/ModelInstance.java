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
package com.shalk.github.armeria.nacos.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

// @JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ModelInstance {
  private String ip;
  private int port;
  private double weight = 1.0D;

  private boolean healthy = true;
  private boolean enabled = true;
  private boolean ephemeral = true;

  private String clusterName;
  private String serviceName;

  private Map<String, String> metadata = new HashMap<>();

  private String instanceId;
  private int instanceHeartBeatInterval;
  private int ipDeleteTimeout;
  private int instanceHeartBeatTimeOut;
}

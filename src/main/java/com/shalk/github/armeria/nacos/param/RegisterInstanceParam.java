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
package com.shalk.github.armeria.nacos.param;

import java.util.Map;
import lombok.Data;

@Data
public class RegisterInstanceParam {
  String ip; // required
  int port; // required
  double weight = 1.0D; // required
  String serviceName; // required
  Map<String, String> metadata;
  String clusterName;
  String groupName = "DEFAULT_GROUP"; // default:DEFAULT_GROUP

  //    boolean ephemeral; //
  //    boolean enabled; //
  //    boolean healthy; //
}

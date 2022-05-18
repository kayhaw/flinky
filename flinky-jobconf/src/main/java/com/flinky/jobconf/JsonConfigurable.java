/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flinky.jobconf;

/**
 * A configuration class implementing {@link JsonConfigurable}
 * interface means that it can be converted to JSON string.
 * @author He Ke
 * @version 0.0.1, 2022/5/15
 * @since 0.0.1
 */
public interface JsonConfigurable {

    /**
     * Convert configuration object to json string.
     * @return Json string of configuration.
     */
    String toJson();

}

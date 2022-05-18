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
 * This abstract class contains basic configuration items for all Flinky
 * source operators, but when setting or getting configuration, use its
 * subclass like {@link com.flinky.jobconf.jdbc.JdbcSourceConf}.
 *
 * @author He Ke
 * @version 0.0.1, 2022/5/14
 * @since 0.0.1
 */
public abstract class SourceConf implements JsonConfigurable {

    /**
     * Name of source operator.
     */
    private String name;

    /**
     * URL of source data.
     */
    private String url;

    /**
     * Limit of error records when reading source data,
     * overwritten by {@link EnvConf} if not set.
     */
    private Integer errorLimit;

    public SourceConf(String name, String url, Integer errorLimit) {
        this.name = name;
        this.url = url;
        this.errorLimit = errorLimit;
    }

    /* Getters start */
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Integer getErrorLimit() {
        return errorLimit;
    }
    /* Getters end */

    /* Setters start */
    public void setErrorLimit(Integer errorLimit) {
        this.errorLimit = errorLimit;
    }
    /* Setters end */

}

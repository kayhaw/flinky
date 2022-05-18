/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.flinky.jobconf;

import com.google.gson.Gson;

import java.util.Objects;

/**
 * Flinky job configuration is composed of three sub-items: source operator configuration,
 * sink operator configuration and environment configuration.
 * @param <SOURCE> Type of source operator configuration, inherited from {@link SourceConf}.
 * @param <SINK> Type of sink operator configuration, inherited from {@link SinkConf}.
 * @param <ENV> Type of execution environment, inherited from {@link EnvConf}.
 *
 * @author He Ke
 * @version 0.0.1, 2022/5/4
 * @since 0.0.1
 */
public abstract class JobConf<SOURCE extends SourceConf, SINK extends SinkConf, ENV extends EnvConf>
    implements JsonConfigurable {

    /**
     * Configuration for source operator.
     */
    private SOURCE sourceConf;

    /**
     * Configuration for sink operator.
     */
    private SINK sinkConf;

    /**
     * Configuration for execution environment.
     */
    private ENV envConf;

    /**
     * Take and set configurations. Note that if error limit in source/sink configuration
     * is not set (is null), the error limit in environment configuration will cover it.
     * @param sourceConf Source operator configuration.
     * @param sinkConf Sink operator configuration.
     * @param envConf Execution environment configuration.
     */
    protected JobConf(SOURCE sourceConf, SINK sinkConf, ENV envConf) {
        // Overwrite error limit in source/sink operator if not set.
        // FIXME Check parameters are not null
        if(Objects.isNull(sourceConf.getErrorLimit())) {
            sourceConf.setErrorLimit(envConf.errorLimit);
        }
        if(Objects.isNull(sinkConf.getErrorLimit())) {
            sinkConf.setErrorLimit(envConf.errorLimit);
        }

        this.sourceConf = sourceConf;
        this.sinkConf = sinkConf;
        this.envConf = envConf;
    }

    /**
     * Get source operator configuration.
     * @return A {@link SourceConf} subclass instance.
     */
    public SOURCE getSourceConf() {
        return this.sourceConf;
    }

    /**
     * Get sink operator configuration.
     * @return A {@link SinkConf} subclass instance.
     */
    public SINK getSinkConf() {
        return this.sinkConf;
    }

    /**
     * Get environment operator configuration.
     * @return A {@link EnvConf} subclass instance.
     */
    public ENV getEnvConf() {
        return this.envConf;
    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}

/*
 * Copyright 2004-present Facebook. All Rights Reserved.
 */
package com.facebook.presto.split;

import com.facebook.presto.metadata.DataSourceType;
import com.facebook.presto.tuple.TupleInfo;
import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URI;
import java.util.List;

public class ExchangeSplit
        implements Split
{
    private final String taskId;
    private final URI location;
    private final String outputId;
    private final List<TupleInfo> tupleInfos;

    @JsonCreator
    public ExchangeSplit(
            @JsonProperty("taskId") String taskId,
            @JsonProperty("location") URI location,
            @JsonProperty("outputId") String outputId,
            @JsonProperty("tupleInfos") List<TupleInfo> tupleInfos)
    {
        this.taskId = taskId;
        this.location = location;
        this.outputId = outputId;
        this.tupleInfos = tupleInfos;
    }

    @JsonProperty
    public String getTaskId()
    {
        return taskId;
    }

    @JsonProperty
    public URI getLocation()
    {
        return location;
    }

    @JsonProperty
    public String getOutputId()
    {
        return outputId;
    }

    @JsonProperty
    public List<TupleInfo> getTupleInfos()
    {
        return tupleInfos;
    }

    @Override
    public DataSourceType getDataSourceType()
    {
        return DataSourceType.EXCHANGE;
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this)
                .add("taskId", taskId)
                .add("location", location)
                .add("outputId", outputId)
                .add("tupleInfos", tupleInfos)
                .toString();
    }
}
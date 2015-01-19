package org.oasis_open.contextserver.api.conditions;

import org.oasis_open.contextserver.api.Parameter;
import org.oasis_open.contextserver.api.PluginType;
import org.oasis_open.contextserver.api.Tag;
import org.oasis_open.contextserver.api.rules.Rule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.*;

/**
 * Represents a node in the segment definition expression tree
 */
@XmlRootElement
public class ConditionType implements PluginType, Serializable {
    private String id;
    private String nameKey;
    private String descriptionKey;
    private long pluginId;
    private String conditionEvaluator;
    private String queryBuilderFilter;
    private Condition parentCondition;
    private Set<Tag> tags = new TreeSet<Tag>();
    private Set<String> tagIDs = new LinkedHashSet<String>();
    private List<Parameter> parameters = new ArrayList<Parameter>();
    private Rule autoCreateRule;

    public ConditionType() {
    }

    public ConditionType(String id, String nameKey) {
        this.id = id;
        this.nameKey = nameKey;
    }

    public String getId() {
        return id;
    }

    public String getNameKey() {
        if (nameKey == null) {
            nameKey = "condition." + id + ".name";
        }
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getDescriptionKey() {
        if (descriptionKey == null) {
            descriptionKey = "condition." + id + ".label";
        }
        return descriptionKey;
    }

    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    @XmlTransient
    public long getPluginId() {
        return pluginId;
    }

    public void setPluginId(long pluginId) {
        this.pluginId = pluginId;
    }

    public String getConditionEvaluator() {
        return conditionEvaluator;
    }

    public void setConditionEvaluator(String conditionEvaluator) {
        this.conditionEvaluator = conditionEvaluator;
    }

    public String getQueryBuilderFilter() {
        return queryBuilderFilter;
    }

    public void setQueryBuilderFilter(String queryBuilderFilter) {
        this.queryBuilderFilter = queryBuilderFilter;
    }

    public Condition getParentCondition() {
        return parentCondition;
    }

    public void setParentCondition(Condition parentCondition) {
        this.parentCondition = parentCondition;
    }

    @XmlElement(name = "tags")
    public Set<String> getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(Set<String> tagIDs) {
        this.tagIDs = tagIDs;
    }

    @XmlTransient
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @XmlElement(name = "parameters")
    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Rule getAutoCreateRule() {
        return autoCreateRule;
    }

    public void setAutoCreateRule(Rule autoCreateRule) {
        this.autoCreateRule = autoCreateRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConditionType that = (ConditionType) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

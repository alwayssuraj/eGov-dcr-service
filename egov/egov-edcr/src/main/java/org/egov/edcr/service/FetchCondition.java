package org.egov.edcr.service;

import java.util.Map;

import ar.com.fdvs.dj.domain.CustomExpression;
import ar.com.fdvs.dj.domain.entities.conditionalStyle.ConditionStyleExpression;

public class FetchCondition extends ConditionStyleExpression implements CustomExpression {

    private static final long serialVersionUID = 1L;
    private String fieldName;
    private String colorValue;

    public FetchCondition(String fieldName, String colorValue) {
        this.fieldName = fieldName;
        this.colorValue = colorValue;
    }

    public Object evaluate(Map fields, Map variables, Map parameters) {
        boolean condition = false;
        try {

            Object currentValue = fields.get(fieldName);
            if (currentValue instanceof String) {
                String s = (String) currentValue;
                if (s != null) {
                    condition = colorValue.equals(currentValue);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.valueOf(condition);
    }

    public String getClassName() {
        return Boolean.class.getName();
    }

}

package com.example.SpringBackend_InstagramClone.dto;

public class FilterDTO
{
    private String columnName;

    private Object columnValue;




    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(Object columnValue) {
        this.columnValue = columnValue;
    }
}
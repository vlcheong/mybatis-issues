package com.mapper.model;

public class TestHeader {

    private final int id;

    private String field1;

    private String field2;

    private String field3;

    public TestHeader(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        TestHeader other = (TestHeader) obj;
        return (id == other.id);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ']';
    }
}
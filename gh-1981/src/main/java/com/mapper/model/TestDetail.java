package com.mapper.model;

public class TestDetail {

    private final int id;

    private final int seq;

    private String field1;

    private String field2;

    private String field3;

    public TestDetail(int id, int seq) {
        this.id = id;
        this.seq = seq;
    }

    public int getId() {
        return id;
    }

    public int getSeq() {
        return seq;
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
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + seq;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        TestDetail other = (TestDetail) obj;
        return (id == other.id && seq == other.seq);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + ", seq=" + seq + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ']';
    }
}
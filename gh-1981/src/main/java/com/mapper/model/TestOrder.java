package com.mapper.model;

import java.util.List;

public class TestOrder {

    private final TestHeader header;

    private List<TestDetail> details;

    public TestOrder(TestHeader header) {
        this.header = header;
    }

    public TestHeader getHeader() {
        return header;
    }

    public List<TestDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TestDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[header=" + header + ", details=" + details + ']';
    }
}
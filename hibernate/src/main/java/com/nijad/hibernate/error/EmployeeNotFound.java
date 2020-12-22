package com.nijad.hibernate.error;


public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super();
    }

    public EmployeeNotFound(String s) {
        super(s);
    }

    public EmployeeNotFound(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EmployeeNotFound(Throwable throwable) {
        super(throwable);
    }

    public EmployeeNotFound(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}

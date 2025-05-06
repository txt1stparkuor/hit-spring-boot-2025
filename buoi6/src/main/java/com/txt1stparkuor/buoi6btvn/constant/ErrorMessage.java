package com.txt1stparkuor.buoi6btvn.constant;

public final class ErrorMessage {

    public static final String DUPLICATE_RESOURCE = "exception.duplicate.resource";

    public static final class Validation {
        public static final String NOT_NULL = "{validation.general.notnull}";
        public static final String NOT_BLANK = "{validation.general.notblank}";
        public static final String SIZE = "{validation.general.size}";
        public static final String EMAIL = "{validation.general.email}";
        public static final String POSITIVE_OR_ZERO = "{validation.general.positiveorzero}";
    }

    public static final class User {
        public static final String ERR_NOT_FOUND_ID = "exception.user.not.found.id";
    }

    public static final class Department {
        public static final String ERR_NOT_FOUND_ID = "exception.department.not.found.id";
    }

    public static final class Employee {
        public static final String ERR_NOT_FOUND_ID = "exception.employee.not.found.id";
    }

    public static final class Position {
        public static final String ERR_NOT_FOUND_ID = "exception.position.not.found.id";
    }

}
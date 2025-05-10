package com.txt1stparkuor.buoi7.constant;

public final class ErrorMessage {

    public static final String DUPLICATE_RESOURCE = "exception.duplicate.resource";

    public static final class Validation {
        public static final String NOT_NULL = "{validation.general.notnull}";
        public static final String POSITIVE = "{validation.general.positive}";
    }

    public static final class Author {
        public static final String ERR_NOT_FOUND_ID = "exception.author.not.found.id";
    }


    public static final class Book {
        public static final String ERR_NOT_FOUND_ID = "exception.book.not.found.id";
    }

    public static final class Category {
        public static final String ERR_NOT_FOUND_ID = "exception.category.not.found.id";
    }

}
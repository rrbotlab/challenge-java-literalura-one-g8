package com.arbly.literalura.service;

import java.util.List;

public interface IConvertsData {
    <T> T jsonToClass(String json, Class<T> tClass);
    <T> List<T> jsonToListClass(String json, Class<T> tClass);
}

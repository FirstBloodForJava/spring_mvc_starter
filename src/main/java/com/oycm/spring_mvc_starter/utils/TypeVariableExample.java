package com.oycm.spring_mvc_starter.utils;

import com.oycm.spring_mvc_starter.dto.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.*;

public class TypeVariableExample<T extends Object> {

    public static void main(String[] args) {
        // 返回类或接口声明的方法,包括: public protected 缺省的 private,但是不包括继承的
        Method[] declaredMethods = TypeVariableExample.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals("genericType")){
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("class parameterType: " + parameterType.getName());
                }

                // 获取方法的所有参数
                Parameter[] parameters = declaredMethod.getParameters();
                for (Parameter parameter : parameters) {
                    if (parameter.getAnnotation(RequestBody.class) != null){
                        // 方法参数的类型
                        Type parameterizedType = parameter.getParameterizedType();
                        if (parameterizedType instanceof TypeVariable){
                            System.out.println("is TypeVariable");
                        }
                        if (parameter.getParameterizedType() instanceof ParameterizedType){
                            System.out.println("is ParameterizedType");
                        }

                    }
                }

            }
        }

        // 测试同一个类下的泛型是否相等
        TypeVariableExample<String> stringType = new TypeVariableExample<>();
        TypeVariableExample<User> userType = new TypeVariableExample<>();

        Type stringParameterType = getParameterType(stringType);
        Type userParameterType = getParameterType(userType);
        if (stringParameterType != null && userParameterType != null){
            System.out.println(stringParameterType.equals(userParameterType));
        }

    }

    public void genericType(@RequestBody T t){

    }

    private static Type getParameterType(TypeVariableExample<?> example){
        Method[] methods = example.getClass().getMethods();
        for (Method method : methods) {
            for (Parameter parameter : method.getParameters()) {
                if (parameter.getAnnotation(RequestBody.class) != null){
                    return parameter.getParameterizedType();
                }
            }
        }
        return null;
    }

}

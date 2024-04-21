package org.example.operations;

public class Sum implements MathOperation {

    @Override
    public float result(float a, float b) {
        return a + b;
    }
}
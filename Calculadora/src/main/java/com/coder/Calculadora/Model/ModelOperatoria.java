package com.coder.Calculadora.Model;

public class ModelOperatoria {
    private float operandoA;
    private float operandoB;
    private float resultado;

    public ModelOperatoria(float operando1, float operando2){
        this.operandoA = operando1;
        this.operandoB = operando2;
    }
    public float getOperandoA() {
        return operandoA;
    }

    public void setOperandoA(float operandoA) {
        this.operandoA = operandoA;
    }

    public float getOperandoB() {
        return operandoB;
    }

    public void setOperandoB(float operandoB) {
        this.operandoB = operandoB;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
}
